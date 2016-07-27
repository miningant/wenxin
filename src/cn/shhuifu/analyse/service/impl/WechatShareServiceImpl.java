package cn.shhuifu.analyse.service.impl;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareData;
import cn.shhuifu.analyse.beans.CswebTencentWeixinShareDataEntity;
import cn.shhuifu.analyse.beans.RequestParams;
import cn.shhuifu.analyse.dao.WechatShareDao;
import cn.shhuifu.analyse.service.WechatShareService;
import cn.shhuifu.analyse.util.FileHelp;
import cn.shhuifu.analyse.util.ImageHelp;
import cn.shhuifu.analyse.util.StringSpiltByByteHelp;

public class WechatShareServiceImpl implements WechatShareService {
	private WechatShareDao wechatShareDao;

	public void setWechatShareDao(WechatShareDao wechatShareDao) {
		this.wechatShareDao = wechatShareDao;
	}

	@Override
	public List<HashMap<?, ?>> getShareDataByShareTime(long timestamp) {
		return wechatShareDao.getShareDataByShareTime(timestamp);
	}

	@Override
	public List<HashMap<?, ?>> getShareDataByShareTime(long timestamp, int page, int size) {
		return wechatShareDao.getShareDataByShareTime(timestamp,page,size);
	}

	public void createShare(CswebTencentWeixinShareData cswebTencentWeixinShareData) throws Exception {
		if(cswebTencentWeixinShareData.getShareTime() == null || cswebTencentWeixinShareData.getShareTime().equals("")){
			if(cswebTencentWeixinShareData.getShareStatus().equals("开始投放")){
				Calendar c = Calendar.getInstance();
				c.add(Calendar.DAY_OF_MONTH, 1);
				cswebTencentWeixinShareData.setShareTime(new SimpleDateFormat("YYYY-MM-dd HH:mm").format(c.getTime()));
			}
		}else{
				try {
					cswebTencentWeixinShareData.setShareTime(new SimpleDateFormat("YYYY-MM-dd HH:mm").format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z").parse(cswebTencentWeixinShareData.getShareTime().replace("Z", " UTC"))));
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		Object[] params = new Object[21];
		params[0] = cswebTencentWeixinShareData.getAppId();
		params[1] = cswebTencentWeixinShareData.getShareStatus();
		params[2] = cswebTencentWeixinShareData.getShareType();
		params[3] = cswebTencentWeixinShareData.getShareUrl();
		params[4] = cswebTencentWeixinShareData.getShareTitle().getBytes().length<30?cswebTencentWeixinShareData.getShareTitle():StringSpiltByByteHelp.subString(cswebTencentWeixinShareData.getShareTitle(), 30);
		params[5] = cswebTencentWeixinShareData.getShareInfo01();
		params[6] = cswebTencentWeixinShareData.getShareInfo02();
		params[7] = cswebTencentWeixinShareData.getShareInfo03();
		params[8] = cswebTencentWeixinShareData.getShareInfo04();
		params[18] = cswebTencentWeixinShareData.getShareTime();
		params[19] = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
		params[20] = cswebTencentWeixinShareData.getCreateUser();
		
		String path = System.getProperty("wechatplatform.root")+"/";
		for(int i=1;i<=9;i++){
			Class<?> clazz = Class.forName("cn.shhuifu.analyse.beans.CswebTencentWeixinShareData");
			String sharePic = (String) clazz.getMethod("getSharePic0"+String.valueOf(i)).invoke(cswebTencentWeixinShareData);
			String sharePicBase64 = (String) clazz.getMethod("getSharePic0"+String.valueOf(i)+"Base64").invoke(cswebTencentWeixinShareData);
			if(sharePic==null || sharePicBase64==null){
				params[i+8] = null;
				continue;
			}
			String filename = FileHelp.rename(FileHelp.fileExt(sharePic));
			params[i+8] = filename;
			ImageHelp.GenerateImage(path,filename,sharePicBase64.replace("data:image/png;base64,", ""));
		}
		
		this.wechatShareDao.createShare(params);
	}

	public List<HashMap<?, ?>> findShare(RequestParams requestParams) {
		return this.wechatShareDao.findShare(requestParams);
	}

	public void addComment(JSONObject params) throws Exception {
		Object[] comment = {Integer.parseInt(params.get("shareCustId").toString()),params.get("comment"),params.get("createUserId"),new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date())};
		this.wechatShareDao.addComment(comment);
	}

	public void addAgree(JSONObject params) throws Exception {
		Object[] agree = {Integer.parseInt(params.get("shareCustId").toString()),params.get("agree"),params.get("createUserId"),new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()),Integer.parseInt(params.get("shareCustId").toString()),params.get("createUserId")};
		this.wechatShareDao.addAgree(agree);
	}
	
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
        params[19] = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
        params[20] = cswebTencentWeixinShareDataEntity.getCreateUser();

        for (int i = 0; i < params.length; i++) {
            if (params[i] != null && params[i].toString().equals(""))
                params[i] = null;
        }

        this.wechatShareDao.createShare(params);
    }


	@Override
	public boolean reviewShare(JSONObject params) {
		return this.wechatShareDao.reviewShare(params)==0?false:true;
	}

	@Override
	public void editShare(CswebTencentWeixinShareData cswebTencentWeixinShareData) throws Exception {
		if(cswebTencentWeixinShareData.getShareTime() == null || cswebTencentWeixinShareData.getShareTime().equals("")){
			if(cswebTencentWeixinShareData.getShareStatus().equals("开始投放")){
				Calendar c = Calendar.getInstance();
				c.add(Calendar.DAY_OF_MONTH, 1);
				cswebTencentWeixinShareData.setShareTime(new SimpleDateFormat("YYYY-MM-dd HH:mm").format(c.getTime()));
			}
		}else{
				try {
					cswebTencentWeixinShareData.setShareTime(new SimpleDateFormat("YYYY-MM-dd HH:mm").format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z").parse(cswebTencentWeixinShareData.getShareTime().replace("Z", " UTC"))));
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		Object[] params = new Object[19];
		params[0] = cswebTencentWeixinShareData.getShareStatus();
		params[1] = cswebTencentWeixinShareData.getShareType();
		params[2] = cswebTencentWeixinShareData.getShareUrl();
		params[3] = cswebTencentWeixinShareData.getShareTitle().getBytes().length<30?cswebTencentWeixinShareData.getShareTitle():StringSpiltByByteHelp.subString(cswebTencentWeixinShareData.getShareTitle(), 30);
		params[4] = cswebTencentWeixinShareData.getShareInfo01();
		params[5] = cswebTencentWeixinShareData.getShareInfo02();
		params[6] = cswebTencentWeixinShareData.getShareInfo03();
		params[7] = cswebTencentWeixinShareData.getShareInfo04();
		params[17] = cswebTencentWeixinShareData.getShareTime();
		params[18] = cswebTencentWeixinShareData.getCustId();
		
		String path = System.getProperty("wechatplatform.root")+"/";
		for(int i=1;i<=9;i++){
			Class<?> clazz = Class.forName("cn.shhuifu.analyse.beans.CswebTencentWeixinShareData");
			String sharePic = (String) clazz.getMethod("getSharePic0"+String.valueOf(i)).invoke(cswebTencentWeixinShareData);
			String sharePicBase64 = (String) clazz.getMethod("getSharePic0"+String.valueOf(i)+"Base64").invoke(cswebTencentWeixinShareData);
			if(sharePic==null || sharePicBase64==null){
				params[i+7] = null;
				continue;
			}
			if(sharePicBase64.equals("LOCAL_IMAGE")){
				params[i+7] = sharePic;
			}else{
				String filename = FileHelp.rename(FileHelp.fileExt(sharePic));
				params[i+7] = filename;
				ImageHelp.GenerateImage(path,filename,sharePicBase64.replace("data:image/png;base64,", ""));
			}
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

	@Override
	public void deleteShareAgreeComment(int shareCustId) throws Exception {
		this.wechatShareDao.deleteShare(shareCustId);
		this.wechatShareDao.deleteAgree(shareCustId);
		this.wechatShareDao.deleteComment(shareCustId);
	}

	@Override
	public void deleteComment(int commentId) throws Exception {
		this.wechatShareDao.deleteCommentById(commentId);
	}

	@Override
	public long find_total(RequestParams requestParams) {
		return this.wechatShareDao.find_total(requestParams);
	}
}
