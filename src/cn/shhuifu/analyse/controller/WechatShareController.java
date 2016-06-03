package cn.shhuifu.analyse.controller;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareDataEntity;
import cn.shhuifu.analyse.beans.ResMap;
import cn.shhuifu.analyse.service.WechatShareService;
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
public class WechatShareController {
    private WechatShareService wechatShareService;

    @Autowired
    public void setWechatShareService(WechatShareService wechatShareService) {
        this.wechatShareService = wechatShareService;
    }

    /**
     * 分享数据查询
     *
     * @param cswebTencentWeixinShareDataEntity
     * @return
     */
    @RequestMapping(value = "/share", method = RequestMethod.GET)
    @ResponseBody
    public Map<?, ?> queryShares(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity) {
        if (cswebTencentWeixinShareDataEntity == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            List<HashMap<?, ?>> result = this.wechatShareService.findShare(cswebTencentWeixinShareDataEntity);
            long total = this.wechatShareService.find_total(cswebTencentWeixinShareDataEntity);
            return ResMap.resultMap(result == null ? ResMap.ERROR : ResMap.SUCCESS, result, total);
        }
    }

    /**
     * 分享数据添加
     *
     * @param cswebTencentWeixinShareDataEntity
     * @return
     */
    @RequestMapping(value = "/share", method = RequestMethod.POST)
    @ResponseBody
    public Object createShare(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity) {
        try {
            this.wechatShareService.createShare(cswebTencentWeixinShareDataEntity);
            return ResMap.resultMap(ResMap.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResMap.resultMap(ResMap.ERROR);
        }
    }

    /**
     * 分享数据修改
     *
     * @param cswebTencentWeixinShareDataEntity
     * @return
     */
    @RequestMapping(value = "/share", method = RequestMethod.PUT)
    @ResponseBody
    public Object editShare(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity) {
        try {
            this.wechatShareService.editShare(cswebTencentWeixinShareDataEntity);
            return ResMap.resultMap(ResMap.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResMap.resultMap(ResMap.ERROR);
        }
    }

    /**
     * 分享数据状态修改
     *
     * @param list
     * @return
     */
    @RequestMapping(value = "/share", method = RequestMethod.PATCH)
    @ResponseBody
    public Object changeShareStatus(String status,String list) {
        try {
            this.wechatShareService.changeShareStatus(status,list);
            return ResMap.resultMap(ResMap.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResMap.resultMap(ResMap.ERROR);
        }
    }

    /**
     * 分享数据删除
     *
     * @param list
     * @return
     */
    @RequestMapping(value = "/share", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteShare(String list) {
        try {
            this.wechatShareService.deleteShare(list);
            return ResMap.resultMap(ResMap.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResMap.resultMap(ResMap.ERROR);
        }
    }

    /**
     * 属性-上传文件
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/share_upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<?, ?> fileUpload(@RequestBody MultipartFile file) {
        if (file == null) {
            return ResMap.resultMap(ResMap.ERROR, "No file uploaded");
        } else {
            String result = wechatShareService.file_upload(file);  //返回路径
            if (result == null)
                return ResMap.resultMap(ResMap.ERROR, "Failed to upload the file");
            else
                return ResMap.resultMap(ResMap.SUCCESS, result);
        }
    }
}
