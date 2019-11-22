package cn.itcast.gip.dao;

import cn.itcast.gip.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

/*
    实现对数据表gjp_zhangwu数据 增删改查
    dbuils工具类完成
    类成员创建QueryRunner对象，指定数据源
 */
public class ZhangWuDao {
    private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
}
