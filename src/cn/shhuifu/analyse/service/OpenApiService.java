package cn.shhuifu.analyse.service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yang on 2016/7/16.
 */
public interface OpenApiService {
    List<HashMap<?,?>>getShareDataByShareTime(long timestamp);
    List<HashMap<?,?>> getShareDataByShareTime(long timestamp,int page,int size);
}
