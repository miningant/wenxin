package cn.shhuifu.analyse.controller;

import cn.shhuifu.analyse.beans.CswebDataMobileUsersEntity;
import cn.shhuifu.analyse.beans.ResMap;
import cn.shhuifu.analyse.service.WechatMobileUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
@Scope("prototype")
public class WechatMobileUserController {
    private WechatMobileUserService wechatMobileUserService;

    @Autowired
    public void setWechatMobileUserService(WechatMobileUserService wechatMobileUserService) {
        this.wechatMobileUserService = wechatMobileUserService;
    }

    /**
     * 手机用户查询
     *
     * @param cswebDataMobileUsersEntity
     * @return
     */
    @RequestMapping(value = "/mobile_user", method = RequestMethod.GET)
    @ResponseBody
    public Map<?, ?> queryMobileUser(CswebDataMobileUsersEntity cswebDataMobileUsersEntity) {
        if (cswebDataMobileUsersEntity == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            List<HashMap<?, ?>> result = this.wechatMobileUserService.find_mobile_user(cswebDataMobileUsersEntity);
            long total = this.wechatMobileUserService.find_total(cswebDataMobileUsersEntity);
            return ResMap.resultMap(result == null ? ResMap.ERROR : ResMap.SUCCESS, result, total);
        }
    }

    /**
     * 导入-上传文件
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/mobile_user_upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<?, ?> fileUpload(@RequestBody MultipartFile file) {
        if (file == null) {
            return ResMap.resultMap(ResMap.ERROR, "No file uploaded");
        } else {
            String result = wechatMobileUserService.file_upload(file);  //返回路径
            if (result == null)
                return ResMap.resultMap(ResMap.ERROR, "Failed to upload the file");
            else
                return ResMap.resultMap(ResMap.SUCCESS, result);
        }
    }

    /**
     * 导入-提交
     *
     * @param path
     * @return
     */
    @RequestMapping(value = "/mobile_user", params = {"action=import"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<?, ?> fileImport(String path) {  //相对路径
        if (path == null || path.equals("")) {
            return ResMap.resultMap(ResMap.ERROR, "No file selected");
        } else {
            boolean result = wechatMobileUserService.file_import(System.getProperty("wechatplatform.root") + path);   //绝对路径
            return ResMap.resultMap(!result ? ResMap.ERROR : ResMap.SUCCESS);
        }
    }
}
