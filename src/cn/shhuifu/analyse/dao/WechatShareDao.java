package cn.shhuifu.analyse.dao;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareDataEntity;
import java.util.HashMap;
import java.util.List;
import net.sf.json.JSONObject;
import cn.shhuifu.analyse.beans.RequestParams;

public interface WechatShareDao {
	public void createShare(Object[] params);
	public List<HashMap<?, ?>> findShare(RequestParams requestParams);
	public void addComment(Object[] params);
	public void addAgree(Object[] params);
	public int reviewShare(JSONObject params);
	public void editShare(Object[] params);
	public void changeShareStatus(String status,String custId);
    public void deleteShare(String custId);
	long find_total(RequestParams requestParams);
    public void deleteShare(int shareCustId);
    public void deleteAgree(int shareCustId);
    public void deleteComment(int shareCustId);
    public void deleteCommentById(int commentId);
	List<HashMap<?,?>> getShareDataByShareTime(long timestamp);
	List<HashMap<?,?>> getShareDataByShareTime(long timestamp,int page,int size);
}
