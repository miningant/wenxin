package cn.shhuifu.analyse.service.impl;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareDataEntity;
import cn.shhuifu.analyse.dao.WechatShareDao;
import cn.shhuifu.analyse.service.WechatShareService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class WechatShareServiceImpl implements WechatShareService {
    private WechatShareDao wechatShareDao;

    public void setWechatShareDao(WechatShareDao wechatShareDao) {
        this.wechatShareDao = wechatShareDao;
    }

    @Override
    public List<HashMap<?, ?>> findShare(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity) {
        return this.wechatShareDao.findShare(cswebTencentWeixinShareDataEntity);
    }

    @Override
    public void createShare(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity) throws Exception {
        Object[] params = new Object[21];
        params[0] = cswebTencentWeixinShareDataEntity.getAppId();
        params[1] = cswebTencentWeixinShareDataEntity.getShareStatus();
        params[2] = cswebTencentWeixinShareDataEntity.getShareType();
        params[3] = cswebTencentWeixinShareDataEntity.getShareUrl();
        params[4] = cswebTencentWeixinShareDataEntity.getShareTitle();
        params[5] = cswebTencentWeixinShareDataEntity.getShareInfo01();
        params[6] = cswebTencentWeixinShareDataEntity.getShareInfo02();
        params[7] = cswebTencentWeixinShareDataEntity.getShareInfo03();
        params[8] = cswebTencentWeixinShareDataEntity.getShareInfo04();
        params[9] = cswebTencentWeixinShareDataEntity.getSharePic01();
        params[10] = cswebTencentWeixinShareDataEntity.getSharePic02();
        params[11] = cswebTencentWeixinShareDataEntity.getSharePic03();
        params[12] = cswebTencentWeixinShareDataEntity.getSharePic04();
        params[13] = cswebTencentWeixinShareDataEntity.getSharePic05();
        params[14] = cswebTencentWeixinShareDataEntity.getSharePic06();
        params[15] = cswebTencentWeixinShareDataEntity.getSharePic07();
        params[16] = cswebTencentWeixinShareDataEntity.getSharePic08();
        params[17] = cswebTencentWeixinShareDataEntity.getSharePic09();
        params[18] = cswebTencentWeixinShareDataEntity.getShareTime();
        params[19] = new Date();
        params[20] = cswebTencentWeixinShareDataEntity.getCreateUser();

        for (int i = 0; i < params.length; i++) {
            if (params[i] != null && params[i].toString().equals(""))
                params[i] = null;
        }

        this.wechatShareDao.createShare(params);
    }

    @Override
    public void editShare(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity) throws Exception {
        Object[] params = new Object[19];
        params[0] = cswebTencentWeixinShareDataEntity.getShareStatus();
        params[1] = cswebTencentWeixinShareDataEntity.getShareType();
        params[2] = cswebTencentWeixinShareDataEntity.getShareUrl();
        params[3] = cswebTencentWeixinShareDataEntity.getShareTitle();
        params[4] = cswebTencentWeixinShareDataEntity.getShareInfo01();
        params[5] = cswebTencentWeixinShareDataEntity.getShareInfo02();
        params[6] = cswebTencentWeixinShareDataEntity.getShareInfo03();
        params[7] = cswebTencentWeixinShareDataEntity.getShareInfo04();
        params[8] = cswebTencentWeixinShareDataEntity.getSharePic01();
        params[9] = cswebTencentWeixinShareDataEntity.getSharePic02();
        params[10] = cswebTencentWeixinShareDataEntity.getSharePic03();
        params[11] = cswebTencentWeixinShareDataEntity.getSharePic04();
        params[12] = cswebTencentWeixinShareDataEntity.getSharePic05();
        params[13] = cswebTencentWeixinShareDataEntity.getSharePic06();
        params[14] = cswebTencentWeixinShareDataEntity.getSharePic07();
        params[15] = cswebTencentWeixinShareDataEntity.getSharePic08();
        params[16] = cswebTencentWeixinShareDataEntity.getSharePic09();
        params[17] = cswebTencentWeixinShareDataEntity.getShareTime();
        params[18] = cswebTencentWeixinShareDataEntity.getCustId();

        for (int i = 0; i < params.length; i++) {
            if (params[i] != null && params[i].toString().equals(""))
                params[i] = null;
        }

        this.wechatShareDao.editShare(params);
    }

    public void changeShareStatus(String status,String list) {
        String[] custIds=list.split(",");
        for (String custId:custIds) {
            this.wechatShareDao.changeShareStatus(status,custId);
        }
    }

    @Override
    public void deleteShare(String list) throws Exception{
        String[] custIds=list.split(",");
        for (String custId:custIds) {
            this.wechatShareDao.deleteShare(custId);
        }
    }

    @Override
    public long find_total(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity) {
        return this.wechatShareDao.find_total(cswebTencentWeixinShareDataEntity);
    }

    @Override
    public String file_upload(MultipartFile file) {
        try {
            String postfix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));   //获取后缀
            String directory_relative_path = "data/share/1000/" + new SimpleDateFormat("yyyy/MM/dd/").format(Calendar.getInstance().getTime());  //目录相对路径
            String directory_absolute_path = System.getProperty("wechatplatform.root") + directory_relative_path;   //目录绝对路径
            String file_name = "K" + new SimpleDateFormat("yyyyMMddHHmmssSS").format(Calendar.getInstance().getTime()) + postfix; //文件名
            String file_relative_path = directory_relative_path + file_name;   //文件相对路径
            String file_absolute_path = directory_absolute_path + file_name;   //文件绝对路径

            File directory = new File(directory_absolute_path);
            if (!directory.exists())
                if (!directory.mkdirs())    //创建目录
                    return null;

            File absolute = new File(file_absolute_path);   //创建文件
            file.transferTo(absolute);
            return file_relative_path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
