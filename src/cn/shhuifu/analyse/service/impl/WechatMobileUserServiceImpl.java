package cn.shhuifu.analyse.service.impl;

import cn.shhuifu.analyse.beans.CswebDataMobileUsersEntity;
import cn.shhuifu.analyse.dao.WechatMobileUserDao;
import cn.shhuifu.analyse.service.WechatMobileUserService;
import com.csvreader.CsvReader;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class WechatMobileUserServiceImpl implements WechatMobileUserService {
    private WechatMobileUserDao wechatMobileUserDao;

    public void setWechatMobileUserDao(WechatMobileUserDao wechatMobileUserDao) {
        this.wechatMobileUserDao = wechatMobileUserDao;
    }

    @Override
    public List<HashMap<?, ?>> find_mobile_user(CswebDataMobileUsersEntity cswebDataMobileUsersEntity) {
        return this.wechatMobileUserDao.find_mobile_user(cswebDataMobileUsersEntity);
    }

    @Override
    public long find_total(CswebDataMobileUsersEntity cswebDataMobileUsersEntity) {
        return this.wechatMobileUserDao.find_total(cswebDataMobileUsersEntity);
    }

    @Override
    public String file_upload(MultipartFile file) {
        try {
            String directory_relative_path = "data/csv/";  //目录相对路径
            String directory_absolute_path = System.getProperty("wechatplatform.root") + directory_relative_path;   //目录绝对路径
            String file_name = new SimpleDateFormat("yyyyMMddHHmmssSS").format(Calendar.getInstance().getTime()) + ".csv"; //文件名
            String file_relative_path = directory_relative_path + file_name;   //文件相对路径
            String file_absolute_path = directory_absolute_path + file_name;   //文件绝对路径

            File directory = new File(directory_absolute_path);
            if (!directory.exists())
                if (!directory.mkdirs())
                    return null;

            File absolute = new File(file_absolute_path);
            file.transferTo(absolute);
            return file_relative_path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean file_import(String path) {
        try {
            CsvReader csvReader = new CsvReader(new FileReader(new File(path)));
            Object[] params = new Object[12];
            Integer[] unnullable={0,1,3,6,9};
            csvReader.readHeaders();
            while (csvReader.readRecord()) {
                params[0] = csvReader.get("APP_ID");
                params[1] = csvReader.get("PHONE_NO");
                params[2] = csvReader.get("USER_NAME");
                params[3] = csvReader.get("USER_SEX");
                params[4] = csvReader.get("USER_BIRTHDAY");
                params[5] = csvReader.get("USER_EMAIL");
                params[6] = csvReader.get("CITY_NODE_ID");
                params[7] = csvReader.get("USER_ADDRESS");
                params[8] = csvReader.get("ZIP_CODE");
                params[9] = csvReader.get("WEIXIN_VERIFY");
                params[10] = csvReader.get("UPDATE_TIME");
                params[11] = csvReader.get("CREATE_TIME");

                for (Integer i:unnullable) {    //若必须不为空的column为空，返回false
                    if (params[i].toString().equals(""))
                        return false;
                }

                if (params[10].toString().equals(""))   //若时间column没有值，使用当前时间
                    params[10]=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
                if (params[11].toString().equals(""))
                    params[11]=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());

                for (int i = 0; i < params.length; i++) {
                    if (params[i].toString().equals("")) {
                        params[i] = null;
                    }
                }

                this.wechatMobileUserDao.create_mobile_user(params);
            }
            csvReader.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
