package cn.shhuifu.analyse.dao;

import cn.shhuifu.analyse.beans.CswebAdminApplicationsEntity;

import java.util.HashMap;
import java.util.List;

public interface AdminApplicationDao {
    public List<HashMap<?, ?>> find_app(CswebAdminApplicationsEntity cswebAdminApplicationsEntity);
}
