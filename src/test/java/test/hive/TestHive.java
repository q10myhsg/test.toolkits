package test.hive;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.fc.hive.HiveDb;

public class TestHive {
	private static final Logger logger = LoggerFactory.getLogger(TestHive.class);

	@Test
	public void testConnection() {

		logger.debug("start");
		Connection conn = HiveDb.getConn();
		Statement st;
		logger.debug("1");
		try {
			st = conn.createStatement();
			String tableName = "hive_dianping";// 表名
			ResultSet rs = st.executeQuery("select  count(*) from " + tableName + " ");// 求平均数,会转成MapReduce作业运行
			while (rs.next()) {
				logger.debug(rs.getString(1) + "  ~~~~~~~~~ ");
			}
			logger.debug("2");
			HiveDb.close(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		logger.debug("end");

	}


}
