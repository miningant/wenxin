package cn.shhuifu.analyse.service;

import cn.shhuifu.analyse.beans.CswebAdminApplicationsEntity;

import java.util.HashMap;
import java.util.List;

public interface AdminApplicationService {
    public List<HashMap<?, ?>> find_app(CswebAdminApplicationsEntity cswebAdminApplicationsEntity);
}
