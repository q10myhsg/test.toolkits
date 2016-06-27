package test.fc.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class HiveDb {

	private static final String driverName ="org.apache.hadoop.hive.jdbc.HiveDriver";
	private static final Logger logger = Logger.getLogger(HiveDb.class.getName());//写控制台
	private static HiveDb ins = null;

	public static void hiveConn(Connection con,Statement stmt){
		try {
			//链接hive数据库
			con = HiveDb.getConn();
			stmt = con.createStatement();
			//设定reduce任务的个数
			stmt.executeQuery("SET hive.exec.compress.output=true");
			stmt.executeQuery("SET mapred.output.compress=true");
			stmt.executeQuery("SET mapred.output.compression.codec=org.apache.hadoop.io.compress.GzipCodec");
			stmt.executeQuery("SET mapred.reduce.tasks="+1);
		} catch (SQLException e) {
			e.printStackTrace();
			StringBuffer error=new StringBuffer();
		   	StackTraceElement [] messages=e.getStackTrace();
		   	int length=messages.length;
		   	for(int i=0;i<length;i++){
		   		error.append(messages[i]);
		   	}
		   	logger.info("异常信息："+error);
		}
	}	
	public static HiveDb getInstance() {
		
		if (ins == null) {
			synchronized (HiveDb.class) {
				if (ins == null) {
					ins = new HiveDb();
				}
			}
		}
		return ins;
	}
	/**
	 * 获取hive数据库链接
	 */
		
	public static Connection getConn() {
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection("jdbc:hive://192.168.1.64:10000/default", "", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			StringBuffer error=new StringBuffer();
		   	StackTraceElement [] messages=e.getStackTrace();
		   	int length=messages.length;
		   	for(int i=0;i<length;i++){
		   		error.append(messages[i]);
		   	}
		   	logger.info("异常信息："+error);
		} catch (SQLException e) {
			e.printStackTrace();
			StringBuffer error=new StringBuffer();
		   	StackTraceElement [] messages=e.getStackTrace();
		   	int length=messages.length;
		   	for(int i=0;i<length;i++){
		   		error.append(messages[i]);
		   	}
		   	logger.info("异常信息："+error);
		}
		return con;
	}
	/**
	 * 关闭数据库连接
	 * 
	 * @param con
	 */
	public static void close(Connection con){
		close(null, null, con);
	}
	
	/**
	 * 关闭数据库连接
	 * 
	 * @param stmt
	 * @param con
	 */
	public static void close(Statement stmt, Connection con){
		close(null, stmt, con);
	}
	/**
	 * 关闭数据库连接:这是最安全的关闭连接方法.
	 * 
	 * @param rs
	 *            ResultSet
	 * @param stmt
	 *            Statement
	 * @param con
	 *            Connection
	 */
	public static void close(ResultSet rs, Statement stmt, Connection con){
		if (rs != null){
			try{
				rs.close();
				rs = null;
			}
			catch (SQLException e){
			    e.printStackTrace();
			}
		}
		if (stmt != null){
			try{
				stmt.close();
				stmt = null;
			}
			catch (SQLException e1){
			    e1.printStackTrace();

			}
		}
		if (con != null){
			try{
				con.close();
				con = null;
			}
			catch (SQLException e2){
			    e2.printStackTrace();
			    
			}
		}
	}
	
	public static void close(ResultSet rs){
		if (rs != null){
			try{
				rs.close();
				rs = null;
			}
			catch (SQLException e){
			    e.printStackTrace();
			}
		}
	}
	
}
