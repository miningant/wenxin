package cn.shhuifu.analyse.controller;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareData;
import cn.shhuifu.analyse.beans.CswebTencentWeixinShareDataEntity;
import cn.shhuifu.analyse.beans.RequestParams;
import cn.shhuifu.analyse.beans.ResMap;
import cn.shhuifu.analyse.service.WechatShareService;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    public void setWechatShareService(
            WechatShareService wechatShareService) {
        this.wechatShareService = wechatShareService;
    }

    /**
     * 发朋友圈
     *
     * @param cswebTencentWeixinShareData
     * @return
     */
    @RequestMapping(value = "/share", method = RequestMethod.POST)
    @ResponseBody
    public Object addShare(@RequestBody CswebTencentWeixinShareData cswebTencentWeixinShareData) {
        try {
            // ios表情保存异常\xF0\x9F\x98\x8F\xF0\x9F...
            this.wechatShareService.createShare(cswebTencentWeixinShareData);
            return ResMap.resultMap(ResMap.SUCCESS, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResMap.resultMap(ResMap.ERROR, null);
        }
    }

    /**
     * 朋友圈查询
     *
     * @param requestParams
     * @return
     */
    @RequestMapping(value = "/share", method = RequestMethod.GET)
    @ResponseBody
    public Map<?, ?> queryShares(RequestParams requestParams) {
        if (requestParams == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            List<HashMap<?, ?>> result = this.wechatShareService.findShare(requestParams);
            long total = this.wechatShareService.find_total(requestParams);
            return ResMap.resultMap(result == null ? ResMap.ERROR : ResMap.SUCCESS, result, total);
        }
    }

    /**
     * 朋友圈点评
     *
     * @param shareCustId
     * @param params
     * @return
     */
    @RequestMapping(value = "share/{shareCustId}/comment", method = RequestMethod.POST)
    @ResponseBody
    public Object addComment(@PathVariable("shareCustId") int shareCustId, @RequestBody JSONObject params) {
        try {
            this.wechatShareService.addComment(params);
            return ResMap.resultMap(ResMap.SUCCESS, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResMap.resultMap(ResMap.ERROR, null);
        }
    }

    /**
     * 朋友圈点赞
     *
     * @param shareCustId
     * @param params
     * @return
     */
    @RequestMapping(value = "share/{shareCustId}/agree", method = RequestMethod.POST)
    @ResponseBody
    public Object addAgree(@PathVariable("shareCustId") int shareCustId, @RequestBody JSONObject params) {
        try {
            this.wechatShareService.addAgree(params);
            return ResMap.resultMap(ResMap.SUCCESS, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResMap.resultMap(ResMap.ERROR, null);
        }
    }

    /**
     * 朋友圈审核
     *
     * @param shareCustId
     * @param params
     * @return
     */
    @RequestMapping(value = "share/{shareCustId}/review", method = RequestMethod.PUT)
    @ResponseBody
    public Object reviewShare(@PathVariable("shareCustId") int shareCustId, @RequestBody JSONObject params) {
        try {
            this.wechatShareService.reviewShare(params);
            return ResMap.resultMap(ResMap.SUCCESS, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResMap.resultMap(ResMap.ERROR, null);
        }
    }

    /**
     * 朋友圈修改
     *
     * @param shareCustId
     * @param cswebTencentWeixinShareData
     * @return
     */
    @RequestMapping(value = "/share/{shareCustId}", method = RequestMethod.PUT)
    @ResponseBody
    public Object editShare(@PathVariable("shareCustId") int shareCustId, @RequestBody CswebTencentWeixinShareData cswebTencentWeixinShareData) {
        try {
            // ios表情保存异常\xF0\x9F\x98\x8F\xF0\x9F...
            this.wechatShareService.editShare(cswebTencentWeixinShareData);
            return ResMap.resultMap(ResMap.SUCCESS, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResMap.resultMap(ResMap.ERROR, null);
        }
    }

    /**
     * 朋友圈删除
     *
     * @param shareCustId
     * @return
     */
    @RequestMapping(value = "/share/{shareCustId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteShareAgreeComment(@PathVariable("shareCustId") int shareCustId) {
        try {
            this.wechatShareService.deleteShareAgreeComment(shareCustId);
            return ResMap.resultMap(ResMap.SUCCESS, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResMap.resultMap(ResMap.ERROR, null);
        }
    }

    /**
     * 点评删除
     *
     * @param commentId
     * @return
     */
    @RequestMapping(value = "share/{shareCustId}/comment/{commentId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object addComment(@PathVariable("commentId") int commentId) {
        try {
            this.wechatShareService.deleteComment(commentId);
            return ResMap.resultMap(ResMap.SUCCESS, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResMap.resultMap(ResMap.ERROR, null);
        }
    }

    /**
     * 分享数据添加
     *
     * @param cswebTencentWeixinShareDataEntity
     * @return
     */
    @RequestMapping(value = "/sharenit", method = RequestMethod.POST)
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
    @RequestMapping(value = "/sharenit", method = RequestMethod.PUT)
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
    @RequestMapping(value = "/sharenit", method = RequestMethod.PATCH)
    @ResponseBody
    public Object changeShareStatus(String status, String list) {
        try {
            this.wechatShareService.changeShareStatus(status, list);
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
    @RequestMapping(value = "/sharenit", method = RequestMethod.DELETE)
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
        if (file == null) return ResMap.resultMap(ResMap.ERROR, "No file uploaded");
        else {
            String result = wechatShareService.file_upload(file);  //返回路径
            if (result == null)
                return ResMap.resultMap(ResMap.ERROR, "Failed to upload the file");
            else
                return ResMap.resultMap(ResMap.SUCCESS, result);
        }
    }
}
