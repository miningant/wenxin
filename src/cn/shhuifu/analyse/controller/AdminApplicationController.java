package cn.shhuifu.analyse.controller;

import cn.shhuifu.analyse.beans.CswebAdminApplicationsEntity;
import cn.shhuifu.analyse.beans.ResMap;
import cn.shhuifu.analyse.service.AdminApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
@Scope("prototype")
public class AdminApplicationController {
    private AdminApplicationService adminApplicationService;

    @Autowired
    public void setAdminApplicationService(AdminApplicationService adminApplicationService) {
        this.adminApplicationService = adminApplicationService;
    }

    /**
     * appid查询
     *
     * @param cswebAdminApplicationsEntity
     * @return
     */
    @RequestMapping(value = "/application", method = RequestMethod.GET)
    @ResponseBody
    public Map<?, ?> queryApplication(CswebAdminApplicationsEntity cswebAdminApplicationsEntity) {
        if (cswebAdminApplicationsEntity == null) {
            return ResMap.resultMap(ResMap.ERROR, null);
        } else {
            List<HashMap<?, ?>> result = this.adminApplicationService.find_app(cswebAdminApplicationsEntity);
            return ResMap.resultMap(result == null ? ResMap.ERROR : ResMap.SUCCESS, result);
        }
    }
}
