package unit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Any;
import com.sun.xml.internal.ws.api.pipe.Tube;

public class DBTool {

	  // JDBC 驱动名及数据库 URL
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost:3306/penghui";
  
  // 数据库的用户名与密码，需要根据自己的设置
  static final String USER = "root";
  static final String PASS = "feng666368"; 
  Connection  conn;
  
	
    public  ResultSet query(String sql) throws SQLException {
        if (connect()) {
        	
                Statement stmt        = null;
				stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
	            return  rs; 
		}else {
			return null;
		}
    	// 执行 SQL 查询
			
	}
    private Boolean connect() {
    	try {
			// 注册 JDBC 驱动器
			Class.forName(JDBC_DRIVER);
			// 打开一个连接
			conn = DriverManager.getConnection(DB_URL, USER, PASS);		
			System.out.println("lianjie_chenggong");
			
			return true;
		} catch (Exception e) {
			
			System.out.println("lianjie_shibai");
			// TODO: handle exception
			return false;
		}	
	}
	public DBTool() {
		
		// TODO Auto-generated constructor stub
	}

	
	
}
