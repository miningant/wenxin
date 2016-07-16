package cn.shhuifu.analyse.handler;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbutils.handlers.MapListHandler;

public class ShareMapListHandler extends MapListHandler {
    protected Map<String, Object> handleRow(ResultSet rs) throws SQLException {
        Map<String, Object> result = new HashMap<String, Object>();
        ResultSetMetaData rsmd = rs.getMetaData();
        ArrayList<Object> pics = new ArrayList<Object>();
        ArrayList<Object> agrees = new ArrayList<Object>();
        ArrayList<HashMap<String, Object>> comments = new ArrayList<HashMap<String, Object>>();
        int cols = rsmd.getColumnCount();
        for (int i = 1; i <= cols; i++) {
            String columnName = rsmd.getColumnName(i);
            Object o = rs.getObject(i);
            if (columnName.equals("SHARE_PIC_01") ||
                    columnName.equals("SHARE_PIC_02") ||
                    columnName.equals("SHARE_PIC_03") ||
                    columnName.equals("SHARE_PIC_04") ||
                    columnName.equals("SHARE_PIC_05") ||
                    columnName.equals("SHARE_PIC_06") ||
                    columnName.equals("SHARE_PIC_07") ||
                    columnName.equals("SHARE_PIC_08") ||
                    columnName.equals("SHARE_PIC_09")) {
                if (o != null) {
                    pics.add(o);
                }
            } else if (columnName.equals("AGREE_USERS")) {//点赞
                if (o != null) {
                    String[] users = o.toString().split("\\|\\|\\|\\|");
                    for (String user : users) {
                        agrees.add(user);
                    }
                }
            } else if (columnName.equals("COMMENT_USERS")) {//点评
                if (o != null) {
                    String[] users = o.toString().split("\\|\\|\\|\\|");
                    String[] usercomments = rs.getObject("COMMENTS").toString().split("\\|\\|\\|\\|");
                    String[] usercommentsids = rs.getObject("COMMENT_IDS").toString().split("\\|\\|\\|\\|");
                    int length = users.length;
                    for (int index = 0; index < length; index++) {
                        HashMap<String, Object> comment = new HashMap<String, Object>();
                        comment.put("COMMENT_USER", users[index]);
                        comment.put("COMMENT", usercomments[index]);
                        comment.put("COMMENT_ID", usercommentsids[index]);
                        comments.add(comment);
                    }
                }
            } else if (columnName.equals("COMMENTS")) {
            } else if (columnName.equals("COMMENT_IDS")) {
            } else {
                result.put(rsmd.getColumnName(i), rs.getObject(i));
            }
        }
        result.put("pics", pics);
        result.put("agrees", agrees);
        result.put("comments", comments);
        return result;
    }
}
