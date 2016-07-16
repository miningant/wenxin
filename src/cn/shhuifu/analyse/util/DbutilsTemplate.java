package cn.shhuifu.analyse.util;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class DbutilsTemplate {
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(String sql,Object[] params){
		QueryRunner qr = new QueryRunner(this.getDataSource());
		try {
			qr.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int update(String sql,Object[] params){
		QueryRunner qr = new QueryRunner(this.getDataSource());
		try {
			return qr.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
    public long find(String sql, ScalarHandler<Long> rsh) {
        QueryRunner qr = new QueryRunner(this.getDataSource());
        try {
            return qr.query(sql, rsh);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }	
	
	public Object find(String sql,Object[] params,ResultSetHandler<?> rsh){
		QueryRunner qr = new QueryRunner(this.getDataSource());
		try {
			return qr.query(sql, rsh, params);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
