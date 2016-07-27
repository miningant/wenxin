package cn.shhuifu.analyse.service;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.web.multipart.MultipartFile;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareData;
import cn.shhuifu.analyse.beans.CswebTencentWeixinShareDataEntity;
import cn.shhuifu.analyse.beans.RequestParams;

public interface WechatShareService {
	public void createShare(CswebTencentWeixinShareData cswebTencentWeixinShareData) throws Exception;
	public List<HashMap<?, ?>> findShare(RequestParams requestParams);
	public void addComment(JSONObject params) throws Exception;
	public void addAgree(JSONObject params) throws Exception;
	public boolean reviewShare(JSONObject params);
	public void editShare(CswebTencentWeixinShareData cswebTencentWeixinShareData) throws Exception;
	public void deleteShareAgreeComment(int shareCustId) throws Exception;
    public void editShare(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity) throws Exception;
    public void deleteComment(int commentId) throws Exception;
    long find_total(RequestParams requestParams);
    public void createShare(CswebTencentWeixinShareDataEntity cswebTencentWeixinShareDataEntity) throws Exception;

    public void changeShareStatus(String status,String list) throws Exception;

    public void deleteShare(String list) throws Exception;

    public String file_upload(MultipartFile file);
    List<HashMap<?,?>>getShareDataByShareTime(long timestamp);
    List<HashMap<?,?>> getShareDataByShareTime(long timestamp,int page,int size);
}
