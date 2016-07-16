package cn.shhuifu.analyse.service.impl;

import cn.shhuifu.analyse.beans.CswebAdminApplicationsEntity;
import cn.shhuifu.analyse.dao.AdminApplicationDao;
import cn.shhuifu.analyse.service.AdminApplicationService;

import java.util.HashMap;
import java.util.List;

public class AdminApplicationServiceImpl implements AdminApplicationService {
    private AdminApplicationDao adminApplicationDao;

    public void setAdminApplicationDao(AdminApplicationDao adminApplicationDao) {
        this.adminApplicationDao = adminApplicationDao;
    }

    @Override
    public List<HashMap<?, ?>> find_app(CswebAdminApplicationsEntity cswebAdminApplicationsEntity) {
        return this.adminApplicationDao.find_app(cswebAdminApplicationsEntity);
    }
}
