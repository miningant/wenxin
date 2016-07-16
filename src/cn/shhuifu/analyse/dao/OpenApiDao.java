package cn.shhuifu.analyse.dao;

import cn.shhuifu.analyse.beans.CswebTencentWeixinShareData;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yang on 2016/7/16.
 */
public interface OpenApiDao {
    List<HashMap<?,?>> getShareDataByShareTime(long timestamp);
    List<HashMap<?,?>> getShareDataByShareTime(long timestamp,int page,int size);
}
