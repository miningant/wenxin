package cn.shhuifu.analyse.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DbutilsTemplate {
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void update(String sql, Object[] params) {
        QueryRunner qr = new QueryRunner(this.getDataSource());
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object find(String sql, ResultSetHandler<?> rsh) {
        QueryRunner qr = new QueryRunner(this.getDataSource());
        try {
            return qr.query(sql, rsh);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object find(String sql, Object[] params, ResultSetHandler<?> rsh) {
        QueryRunner qr = new QueryRunner(this.getDataSource());
        try {
            return qr.query(sql, rsh, params);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
