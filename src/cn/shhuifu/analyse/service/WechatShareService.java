package cn.shhuifu.analyse.service;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareDataEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

public interface WechatShareService {
    public List<HashMap<?, ?>> findShare(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity);

    public void createShare(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity) throws Exception;

    public void editShare(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity) throws Exception;

    public void changeShareStatus(String status,String list) throws Exception;

    public void deleteShare(String list) throws Exception;

    public long find_total(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity);

    public String file_upload(MultipartFile file);
}
