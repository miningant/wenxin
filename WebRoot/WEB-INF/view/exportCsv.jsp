<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
 response.setHeader("Content-type","application/octet-stream");
 response.setHeader("Content-Disposition","attachment; filename=\"my-data.csv\"");

 //���ɵ�csv��Ϊmy-data.csv
 String data = request.getParameter("CSV_TEXT");
 out.println(data);//������д�뵽������������صķ�ʽ
%>