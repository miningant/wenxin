<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
 response.setHeader("Content-type","application/octet-stream");
 response.setHeader("Content-Disposition","attachment; filename=\"my-data.csv\"");

 //生成的csv名为my-data.csv
 String data = request.getParameter("CSV_TEXT");
 out.println(data);//把数据写入到浏览器，以下载的方式
%>