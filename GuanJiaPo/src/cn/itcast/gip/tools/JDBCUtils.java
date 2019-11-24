package cn.itcast.gip.tools;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/*
    获取数据库连接的工具类
    实现连接池，dbcp连接池
 */
public class JDBCUtils {
    //创建BasicDataSource对象
    private static BasicDataSource dataSource = new BasicDataSource();
    //静态代码块，实现必要参数设置
    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/gjp");
        dataSource.setUsername("root");
        dataSource.setPassword("199785");
        dataSource.setMaxActive(10);
        dataSource.setMaxIdle(5);
        dataSource.setMinIdle(2);
        dataSource.setInitialSize(10);
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}
