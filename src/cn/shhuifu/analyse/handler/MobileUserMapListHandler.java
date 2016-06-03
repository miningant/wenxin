package cn.shhuifu.analyse.handler;

import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MobileUserMapListHandler extends MapListHandler {
    protected Map<String, Object> handleRow(ResultSet rs) throws SQLException {
        Map<String, Object> result = new HashMap<String, Object>();
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = resultSetMetaData.getColumnName(i);
            if (columnName.equals("WEIXIN_VERIFY")) {
                String weixin_verify_id = rs.getString(i).trim();
                String weixin_verify_str = "";
                switch (weixin_verify_id) {
                    case "0":
                        weixin_verify_str = "未加队列";
                        break;
                    case "1":
                        weixin_verify_str = "准备验证";
                        break;
                    case "2":
                        weixin_verify_str = "正在验证";
                        break;
                    case "N":
                        weixin_verify_str = "完成验证";
                        break;
                    case "8":
                        weixin_verify_str = "微信帐号";
                        break;
                    case "9":
                        weixin_verify_str = "没有申请";
                        break;
                }
                result.put(resultSetMetaData.getColumnName(i), weixin_verify_str);
            } else {
                result.put(resultSetMetaData.getColumnName(i), rs.getObject(i));
            }
        }
        return result;
    }
}
