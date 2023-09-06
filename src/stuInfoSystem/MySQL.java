package stuInfoSystem;
import java.sql.*;

public class MySQL {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static String DB_URL = "jdbc:mysql://localhost:3306/example_database?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    
    static final String USER = "root";
    static final String PASS = "root";
    
    private Connection connection;
    private Statement statement;
    private String database;
    private String sql;
    
    public MySQL(String db) {
    		connection = null;
    		statement = null;
    		database = db;
    }
    
    public void init() {
        DB_URL = "jdbc:mysql://localhost:3306/" + database + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        
    		try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
        
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        }

    }
    
    public void close() {
    		try {
            if (statement != null) statement.close();
        } catch (SQLException se2) {
        }// 什么都不做
        try {
            if (connection != null) connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        System.out.println("Goodbye!");
    }
    
    public void setsql(String statement) {
    		sql = statement;
    }
    
    public String getsql() {
    		return sql;
    }
    
    public Connection getConnection() {
    		return connection;
    }
    
    public void setStatement() {
    		try {
    			System.out.println("实例化Statement对象...");
    			statement = connection.createStatement();
    		} catch (Exception e) {
    			e.printStackTrace();
    			System.out.println("Statement对象创建失败");
    		}
    }
    
    public Statement getStatement() {
    		return statement;
    }
    
    public void closeStatement() {
    		try {
    			if (statement != null) statement.close();
    		} catch (SQLException se2) {}// 什么都不做
    }
    
    public void findAll() {
    		sql = "SELECT id, name, url FROM websites";
    		try {
    			ResultSet resultSet = statement.executeQuery(sql);
    			while (resultSet.next()) {
                    // 通过字段检索
                    int id  = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String url = resultSet.getString("url");
        
                    // 输出数据
                    System.out.print("ID: " + id);
                    System.out.print(", 站点名称: " + name);
                    System.out.print(", 站点 URL: " + url);
                    System.out.print("\n");
            }
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    }
    
    public static void main(String[] args) {
    		MySQL db = new MySQL("java_database");
    		db.init();
    		db.findAll();
    		db.close();
    }
}
