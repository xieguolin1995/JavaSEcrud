package utils;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {
	// 数据库基本信息
	private static String USERNAME = "root";
	private static String PASSWORD = "XIAOyu0615!";
	private static String URL = "jdbc:mysql://localhost:3307/xiaoyu?useUnicode=true&characterEncoding=utf8";
	private static String DRIVER ="com.mysql.jdbc.Driver";
	
	private static Connection conn;
	public static Connection getConnection() throws Exception {
		// 加载驱动类
		Class.forName(DRIVER);
		// 获取一个连接
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return conn;
	}
}
