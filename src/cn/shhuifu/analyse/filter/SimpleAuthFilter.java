package cn.shhuifu.analyse.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shhuifu.analyse.util.DbutilsTemplate;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.lang.StringUtils;

import cn.shhuifu.analyse.util.CalendarHelp;
import org.springframework.beans.factory.annotation.Autowired;

public class SimpleAuthFilter implements Filter {
	private String appkey;
	private String secret;
	private DbutilsTemplate dbutilsTemplate;

	public void setDbutilsTemplate(DbutilsTemplate dbutilsTemplate) {
		this.dbutilsTemplate = dbutilsTemplate;
	}

	public void doFilter(ServletRequest req, ServletResponse res,
						 FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String reqAppkey = request.getParameter("appkey") == null?"":request.getParameter("appkey").trim();
		String reqToken = request.getParameter("token") == null?"":request.getParameter("token").trim();
		String reqTimestamp = request.getParameter("timestamp") == null?"":request.getParameter("timestamp").trim();
		if(reqAppkey.equals("")||reqToken.equals("")||reqTimestamp.equals("")){
			this.deniedHandler(response);
		}else{
			appkey=reqAppkey;
			secret=getSecretByAppkey(appkey);
			if(CalendarHelp.timeCheck(reqTimestamp, 3)&&this.appkey.equals(reqAppkey)){//时间有效期以及appkey验证
				String[] keys = new String[]{reqAppkey,this.secret,reqTimestamp}; 
				Arrays.sort(keys);
				List<String> keysList = Arrays.asList(keys);
				if(reqToken.equals(DigestUtils.sha1Hex(StringUtils.join(keysList, "")).toUpperCase())){//token验证
					chain.doFilter(req, res);
				}else{
					this.deniedHandler(response);
				}
			}else{
				this.deniedHandler(response);
			}
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	public void deniedHandler(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		String jsonObject = "[{\"statusCode\":\"403\",\"message\":\"AUTHORIZATION_FAILURE\"}]";  
		response.setContentType("application/json");  
		PrintWriter out = response.getWriter();  
		out.print(jsonObject);  
		out.flush();  
		out.close();  
	}
	//根据appky从数据库获取secret
	public String getSecretByAppkey( String appkey){
		String sql="select secret from data_csweb_dmp.csweb_admin_auth where APPKEY = ? and valid=1";
		Object[] params={this.appkey};
		Map map=(Map)this.dbutilsTemplate.find(sql,params,new MapHandler());
		return (String) map.get("secret");
	}
}
