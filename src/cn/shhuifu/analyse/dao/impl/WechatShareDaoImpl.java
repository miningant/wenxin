package cn.shhuifu.analyse.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import net.sf.json.JSONObject;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareDataEntity;
import cn.shhuifu.analyse.beans.RequestParams;
import cn.shhuifu.analyse.dao.WechatShareDao;
import cn.shhuifu.analyse.handler.ShareMapListHandler;
import cn.shhuifu.analyse.util.DbutilsTemplate;

public class WechatShareDaoImpl implements WechatShareDao {
	private DbutilsTemplate dbutilsTemplate;
	
	public DbutilsTemplate getDbutilsTemplate() {
		return dbutilsTemplate;
	}

	public void setDbutilsTemplate(DbutilsTemplate dbutilsTemplate) {
			this.dbutilsTemplate = dbutilsTemplate;
	}

	@Override
	public List<HashMap<?, ?>> getShareDataByShareTime(long timestamp) {
		String sql="select * FROM data_weixin_user.csweb_tencent_weixin_share_data  where UNIX_TIMESTAMP(SHARE_TIME)- ? <="+1000*60*60*24+" and UNIX_TIMESTAMP(SHARE_TIME)- ? >0";
		Object [] params={timestamp,timestamp};
		return (List<HashMap<?, ?>>) this.dbutilsTemplate.find(sql, params, new MapListHandler());
	}

	@Override
	public List<HashMap<?, ?>> getShareDataByShareTime(long timestamp, int page, int size) {
		String sql="select * FROM data_weixin_user.csweb_tencent_weixin_share_data  where UNIX_TIMESTAMP(SHARE_TIME)- ? <="+1000*60*60*24+" and UNIX_TIMESTAMP(SHARE_TIME)- ? >0 limit ?,?";
		Object [] params={timestamp,timestamp,(page-1)*size,size};
		return (List<HashMap<?, ?>>) this.dbutilsTemplate.find(sql, params, new MapListHandler());
	}
	public void createShare(Object[] params) {
		String sql = "INSERT INTO `data_weixin_user`.`csweb_tencent_weixin_share_data` (`APP_ID`, `SHARE_STATUS`, `SHARE_TYPE`, `SHARE_URL`, `SHARE_TITLE`, `SHARE_INFO01`, `SHARE_INFO02`, `SHARE_INFO03`, `SHARE_INFO04`, `SHARE_PIC_01`, `SHARE_PIC_02`, `SHARE_PIC_03`, `SHARE_PIC_04`, `SHARE_PIC_05`, `SHARE_PIC_06`, `SHARE_PIC_07`, `SHARE_PIC_08`, `SHARE_PIC_09`, `SHARE_TIME`, `CREATE_TIME`, `CREATE_USER`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		this.getDbutilsTemplate().insert(sql, params);
	}

	@SuppressWarnings("unchecked")
	public List<HashMap<?, ?>> findShare(RequestParams requestParams) {
		boolean appId = (null == requestParams.getAppId()||requestParams.getAppId().equals(""))?true:false;
		boolean createUser = (null == requestParams.getCreateUser()||requestParams.getCreateUser().equals(""))?true:false;
		boolean shareType = (null == requestParams.getShareType()||requestParams.getShareType().equals(""))?true:false;
		boolean shareStatus = (null == requestParams.getShareStatus()||requestParams.getShareStatus().equals(""))?true:false;
		boolean custId=(null == requestParams.getCustId()||requestParams.getCustId().equals(""))?true:false;
//		String sql = "SELECT t1.CUST_ID,t1.APP_ID,t1.SHARE_STATUS,t1.SHARE_TYPE,t1.SHARE_URL,t1.SHARE_TITLE,t1.SHARE_INFO01,t1.SHARE_INFO02,t1.SHARE_INFO03,t1.SHARE_INFO04,t1.SHARE_PIC_01,t1.SHARE_PIC_02,t1.SHARE_PIC_03,t1.SHARE_PIC_04,t1.SHARE_PIC_05,t1.SHARE_PIC_06,t1.SHARE_PIC_07,t1.SHARE_PIC_08,t1.SHARE_PIC_09,t1.SHARE_TIME,t1.CREATE_TIME,t1.CREATE_USER,t2.USER_NAME FROM `data_weixin_user`.csweb_tencent_weixin_share_data AS t1,`data_csweb_dmp`.csweb_admin_users AS t2 WHERE t1.CREATE_USER = t2.USER_ID AND EXISTS (SELECT APP_ID FROM data_csweb_dmp.csweb_admin_applications AS t3 WHERE NODE_ID = ? AND t1.APP_ID = t3.APP_ID) "+(createUser?" AND 1 = ? ":" AND t2.USER_NAME = ? ")+(shareStatus?" AND 1 = ? ":" AND t1.SHARE_STATUS = ? ")+" ORDER BY CREATE_TIME DESC LIMIT ?,?";
		String sql = "SELECT t1.*,t2.* FROM (SELECT a.*,b.AGREE_USERS FROM (SELECT t1.CUST_ID,t1.APP_ID,t1.SHARE_STATUS,t1.SHARE_TYPE,t1.SHARE_URL,t1.SHARE_TITLE,t1.SHARE_INFO01,t1.SHARE_INFO02,t1.SHARE_INFO03,t1.SHARE_INFO04,t1.SHARE_PIC_01,t1.SHARE_PIC_02,t1.SHARE_PIC_03,t1.SHARE_PIC_04,t1.SHARE_PIC_05,t1.SHARE_PIC_06,t1.SHARE_PIC_07,t1.SHARE_PIC_08,t1.SHARE_PIC_09,t1.SHARE_TIME,t1.CREATE_TIME,t1.CREATE_USER,t2.USER_NAME FROM `data_weixin_user`.csweb_tencent_weixin_share_data AS t1,`data_csweb_dmp`.csweb_admin_users AS t2 WHERE t1.CREATE_USER = t2.USER_ID AND EXISTS (SELECT APP_ID FROM data_csweb_dmp.csweb_admin_applications AS t3 WHERE NODE_ID LIKE ? AND t1.APP_ID = t3.APP_ID) "+(appId?" AND 1 = ? ":" AND t1.APP_ID = ? ")+(createUser?" AND 1 = ? ":" AND t2.USER_NAME = ? ")+(shareType?" AND 1 = ? ":" AND t1.SHARE_TYPE = ? ")+(shareStatus?" AND 1 = ? ":" AND t1.SHARE_STATUS = ? ")+(custId?" AND 1 = ? ":" AND t1.CUST_ID = ? ")+" ORDER BY CREATE_TIME DESC LIMIT ?,?) AS a LEFT JOIN (SELECT group_concat(t1.USER_NAME SEPARATOR '||||') AS AGREE_USERS,t2.Share_CUST_ID FROM data_csweb_dmp.csweb_admin_users AS t1 RIGHT JOIN (SELECT * FROM data_weixin_user.csweb_tencent_weixin_agree WHERE agree = 1) AS t2 ON(t1.USER_ID = t2.CREATE_USER_ID) GROUP BY t2.Share_CUST_ID) AS b ON(a.CUST_ID = b.Share_CUST_ID)) AS t1 LEFT JOIN (SELECT t2.Share_CUST_ID,group_concat(t2.`CUST_ID` SEPARATOR '||||') AS COMMENT_IDS,group_concat(t1.USER_NAME SEPARATOR '||||') AS COMMENT_USERS,group_concat(t2.`Comment` SEPARATOR '||||') AS COMMENTS FROM data_csweb_dmp.csweb_admin_users AS t1 RIGHT JOIN data_weixin_user.csweb_tencent_weixin_comment AS t2 ON(t1.USER_ID = t2.CREATE_USER_ID) GROUP BY t2.Share_CUST_ID) AS t2 ON(t1.CUST_ID = t2.Share_CUST_ID) ORDER BY CREATE_TIME DESC";
		Object[] params = {requestParams.getNodeId()+"%",(appId?1:requestParams.getAppId()),(createUser?1:requestParams.getCreateUser()),(shareType?1:requestParams.getShareType()),(shareStatus?1:requestParams.getShareStatus()),(custId?1:requestParams.getCustId()),(requestParams.getPage()-1)*requestParams.getSize(),requestParams.getSize()};
        return (List<HashMap<?, ?>>) this.getDbutilsTemplate().find(sql, params, new ShareMapListHandler());
	}

	public void addComment(Object[] params) {
		String sql = "INSERT INTO `data_weixin_user`.`csweb_tencent_weixin_comment` (`Share_CUST_ID`, `Comment`, `CREATE_USER_ID`, `CREATE_TIME`) VALUES (?, ?, ?, ?)";
		this.getDbutilsTemplate().insert(sql, params);
	}

	public void addAgree(Object[] params) {
		String sql = "INSERT INTO `data_weixin_user`.`csweb_tencent_weixin_agree` (`Share_CUST_ID`, `agree`, `CREATE_USER_ID`, `CREATE_TIME`) SELECT ?,?,?,? FROM DUAL WHERE NOT EXISTS (SELECT CUST_ID FROM `data_weixin_user`.`csweb_tencent_weixin_agree` WHERE Share_CUST_ID = ? AND CREATE_USER_ID = ?)";
		int row = this.getDbutilsTemplate().update(sql, params);
		if(row == 0){
			String newSql = "UPDATE `data_weixin_user`.`csweb_tencent_weixin_agree` SET `agree`=abs(`agree`-1),`CREATE_TIME` = ? WHERE Share_CUST_ID = ? AND CREATE_USER_ID = ?";
			Object[] newParams = {new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()),params[4],params[5]};
			this.getDbutilsTemplate().update(newSql, newParams);
		}
	}
	
	@Override
	public int reviewShare(JSONObject params) {
		if(params.get("shareTime") == null || params.get("shareTime").equals("")){
			if(params.get("shareStatus").toString().equals("开始投放")){
				Calendar c = Calendar.getInstance();
				c.add(Calendar.DAY_OF_MONTH, 1);
				params.put("shareTime", new SimpleDateFormat("YYYY-MM-dd HH:mm").format(c.getTime()));
			}
		}else{
				try {
					params.put("shareTime", new SimpleDateFormat("YYYY-MM-dd HH:mm").format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z").parse(params.get("shareTime").toString().replace("Z", " UTC"))));
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		String sql = "UPDATE data_weixin_user.csweb_tencent_weixin_share_data SET SHARE_STATUS = ?,SHARE_TIME = ? WHERE CUST_ID = ?";
		Object[] share = {params.get("shareStatus"),params.get("shareTime"),Integer.parseInt(params.get("shareCustId").toString())};
		return this.getDbutilsTemplate().update(sql, share);
	}
	


    @Override
    public long find_total(RequestParams requestParams) {
		boolean appId = (null == requestParams.getAppId()||requestParams.getAppId().equals(""))?true:false;
		boolean createUser = (null == requestParams.getCreateUser()||requestParams.getCreateUser().equals(""))?true:false;
		boolean shareType = (null == requestParams.getShareType()||requestParams.getShareType().equals(""))?true:false;
		boolean shareStatus = (null == requestParams.getShareStatus()||requestParams.getShareStatus().equals(""))?true:false;
		boolean custId=(null == requestParams.getCustId()||requestParams.getCustId().equals(""))?true:false;
		String sql = "SELECT count(*) as total FROM (SELECT a.*,b.AGREE_USERS FROM (SELECT t1.CUST_ID,t1.APP_ID,t1.SHARE_STATUS,t1.SHARE_TYPE,t1.SHARE_URL,t1.SHARE_TITLE,t1.SHARE_INFO01,t1.SHARE_INFO02,t1.SHARE_INFO03,t1.SHARE_INFO04,t1.SHARE_PIC_01,t1.SHARE_PIC_02,t1.SHARE_PIC_03,t1.SHARE_PIC_04,t1.SHARE_PIC_05,t1.SHARE_PIC_06,t1.SHARE_PIC_07,t1.SHARE_PIC_08,t1.SHARE_PIC_09,t1.SHARE_TIME,t1.CREATE_TIME,t1.CREATE_USER,t2.USER_NAME FROM `data_weixin_user`.csweb_tencent_weixin_share_data AS t1,`data_csweb_dmp`.csweb_admin_users AS t2 WHERE t1.CREATE_USER = t2.USER_ID AND EXISTS (SELECT APP_ID FROM data_csweb_dmp.csweb_admin_applications AS t3 WHERE NODE_ID LIKE ? AND t1.APP_ID = t3.APP_ID) "+(appId?" AND 1 = ? ":" AND t1.APP_ID = ? ")+(createUser?" AND 1 = ? ":" AND t2.USER_NAME = ? ")+(shareType?" AND 1 = ? ":" AND t1.SHARE_TYPE = ? ")+(shareStatus?" AND 1 = ? ":" AND t1.SHARE_STATUS = ? ")+(custId?" AND 1 = ? ":" AND t1.CUST_ID = ? ")+" ORDER BY CREATE_TIME DESC ) AS a LEFT JOIN (SELECT group_concat(t1.USER_NAME SEPARATOR '||||') AS AGREE_USERS,t2.Share_CUST_ID FROM data_csweb_dmp.csweb_admin_users AS t1 RIGHT JOIN (SELECT * FROM data_weixin_user.csweb_tencent_weixin_agree WHERE agree = 1) AS t2 ON(t1.USER_ID = t2.CREATE_USER_ID) GROUP BY t2.Share_CUST_ID) AS b ON(a.CUST_ID = b.Share_CUST_ID)) AS t1 LEFT JOIN (SELECT t2.Share_CUST_ID,group_concat(t2.`CUST_ID` SEPARATOR '||||') AS COMMENT_IDS,group_concat(t1.USER_NAME SEPARATOR '||||') AS COMMENT_USERS,group_concat(t2.`Comment` SEPARATOR '||||') AS COMMENTS FROM data_csweb_dmp.csweb_admin_users AS t1 RIGHT JOIN data_weixin_user.csweb_tencent_weixin_comment AS t2 ON(t1.USER_ID = t2.CREATE_USER_ID) GROUP BY t2.Share_CUST_ID) AS t2 ON(t1.CUST_ID = t2.Share_CUST_ID) ORDER BY CREATE_TIME DESC";
		Object[] params = {requestParams.getNodeId()+"%",(appId?1:requestParams.getAppId()),(createUser?1:requestParams.getCreateUser()),(shareType?1:requestParams.getShareType()),(shareStatus?1:requestParams.getShareStatus()),(custId?1:requestParams.getCustId())};
        return (long)this.getDbutilsTemplate().find(sql, params, new ScalarHandler<>());

    }

    @Override
    public void editShare(Object[] params) {
        String sql = "UPDATE data_weixin_user.csweb_tencent_weixin_share_data SET SHARE_STATUS = ? , SHARE_TYPE = ? , SHARE_URL = ? , SHARE_TITLE = ? , SHARE_INFO01 = ? , SHARE_INFO02 = ? , SHARE_INFO03 = ? , SHARE_INFO04 = ? , SHARE_PIC_01 = ? , SHARE_PIC_02 = ? , SHARE_PIC_03 = ? , SHARE_PIC_04 = ? , SHARE_PIC_05 = ? , SHARE_PIC_06 = ? , SHARE_PIC_07 = ? , SHARE_PIC_08 = ? , SHARE_PIC_09 = ? , SHARE_TIME = ? WHERE CUST_ID = ?";
        this.getDbutilsTemplate().update(sql, params);
    }


    @Override
    public void changeShareStatus(String status,String custId) {
        String sql="UPDATE data_weixin_user.csweb_tencent_weixin_share_data SET SHARE_STATUS = ? WHERE CUST_ID = ?";
        Object[] params={status,custId};
        this.getDbutilsTemplate().update(sql,params);
    }

    @Override
    public void deleteShare(String custId) {
        String sql = "DELETE FROM data_weixin_user.csweb_tencent_weixin_share_data WHERE CUST_ID = ? ";
        Object[] params = {custId};
        this.getDbutilsTemplate().update(sql, params);
    }

	@Override
	public void deleteAgree(int shareCustId) {
		String sql = "DELETE FROM data_weixin_user.csweb_tencent_weixin_agree WHERE Share_CUST_ID = ? ";
        Object[] params = {shareCustId};
        this.getDbutilsTemplate().update(sql, params);
	}

	@Override
	public void deleteComment(int shareCustId) {
		String sql = "DELETE FROM data_weixin_user.csweb_tencent_weixin_comment WHERE Share_CUST_ID = ? ";
        Object[] params = {shareCustId};
        this.getDbutilsTemplate().update(sql, params);
	}

	@Override
	public void deleteShare(int shareCustId) {
		String sql = "DELETE FROM data_weixin_user.csweb_tencent_weixin_share_data WHERE CUST_ID = ? ";
        Object[] params = {shareCustId};
        this.getDbutilsTemplate().update(sql, params);
	}

	@Override
	public void deleteCommentById(int commentId) {
		String sql = "DELETE FROM data_weixin_user.csweb_tencent_weixin_comment WHERE CUST_ID = ? ";
        Object[] params = {commentId};
        this.getDbutilsTemplate().update(sql, params);
	}

}
