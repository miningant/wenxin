package cn.shhuifu.analyse.controller;

import cn.shhuifu.analyse.beans.ResMap;
import cn.shhuifu.analyse.service.OpenApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by ailin on 2016/7/16.
 */
@Controller
@RequestMapping("/api")
@Scope("prototype")
public class OpenApiController {
    @Autowired
    private OpenApiService openApiService;

    @RequestMapping(value="/getShare", method= RequestMethod.GET)
    @ResponseBody
    public Map getShareDataByShareTime(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.MILLISECOND,0);
        long timestamp=(long)(cal.getTimeInMillis()/1000);
        List result =openApiService.getShareDataByShareTime(timestamp);
        return ResMap.resultMap(result==null?ResMap.ERROR:ResMap.SUCCESS,result);
    }
}
