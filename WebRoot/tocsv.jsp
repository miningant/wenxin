<%@ page contentType="application/vnd.ms-excel; charset=utf-8" %>
<%@ page language="java" import="cn.shhuifu.analyse.util.Base64Help" %>
<%response.addHeader("Content-Disposition", "filename=" + "data" + ".csv");%><%=Base64Help.getFromBase64(request.getParameter("exportdata").replaceAll("\\s", "+"))%>
