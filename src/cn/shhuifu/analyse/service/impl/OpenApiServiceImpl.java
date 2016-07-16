package cn.shhuifu.analyse.service.impl;

import cn.shhuifu.analyse.dao.OpenApiDao;
import cn.shhuifu.analyse.service.OpenApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ailin on 2016/7/16.
 */
@Service
public class OpenApiServiceImpl implements OpenApiService {
    @Autowired
    private OpenApiDao openApiDao;

    @Override
    public List<HashMap<?, ?>> getShareDataByShareTime(long timestamp) {
        return openApiDao.getShareDataByShareTime(timestamp);
    }

    @Override
    public List<HashMap<?, ?>> getShareDataByShareTime(long timestamp, int page, int size) {
        return null;
    }
}
