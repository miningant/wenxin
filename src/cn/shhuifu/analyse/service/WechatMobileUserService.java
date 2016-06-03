package cn.shhuifu.analyse.service;

import cn.shhuifu.analyse.beans.CswebDataMobileUsersEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

public interface WechatMobileUserService {
    public List<HashMap<?, ?>> find_mobile_user(CswebDataMobileUsersEntity cswebDataMobileUsersEntity);

    public long find_total(CswebDataMobileUsersEntity cswebDataMobileUsersEntity);

    public String file_upload(MultipartFile file);

    public boolean file_import(String path);
}
