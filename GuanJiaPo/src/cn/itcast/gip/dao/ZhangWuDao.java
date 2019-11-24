package cn.itcast.gip.dao;

import cn.itcast.gip.domain.ZhangWu;
import cn.itcast.gip.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/*
    实现对数据表gjp_zhangwu数据 增删改查
    dbuils工具类完成
    类成员创建QueryRunner对象，指定数据源
 */
public class ZhangWuDao {
    private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    /*
        定义方法，添加账户
        由业务层调用，传递ZhangWu对象
        将ZhangWu对象中的数据，添加到数据表
     */
    public void addZhangWu(ZhangWu zw){
        try {
            //sql语句
            String sql = "INSERT  INTO gjp_zhangwu(flname,money,zhangHu,createtime,description) VALUES (?,?,?,?,?)";
            Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
            qr.update(sql,params);
        }catch(SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("添加账户失败！");
        }
    }

    /*
        定义方法，编辑账户
        由业务层调用，传递ZhangWu对象
        将ZhangWu对象中的数据，更新到数据表
     */
    public void editZhangWu(ZhangWu zw){
        try {
            //sql语句
            String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhangHu=?," +
                    "createtime=?,description=? WHERE zwid=?";
            Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),
                    zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
            qr.update(sql,params);
        }catch(SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("编辑账户失败！");
        }
    }

    /*
        定义方法，删除账户
        由业务层调用，传递zwid
        将zwid对应的ZhangWu对象中的数据，从数据表删除
     */
    public void deleteZhangWu(int zwid) {
        try {
            String sql = "DELETE FROM gjp_zhangwu WHERE zwid = "+zwid;
            qr.update(sql);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("删除账务失败！");
        }
    }

    /*
        定义方法，查询数据库，获取所有账务信息
        由业务层调用
        结果集，将所有的账务数据，存储到Bean对象中，存储到集合中
     */
    public List<ZhangWu> selectALL(){
        try{
            //查询账务数据的sql语句
            String sql = "SELECT * FROM gjp_zhangwu";
            //调用qr对象的方法，query方法，结果集BeanListHandler
            List<ZhangWu> list = qr.query(sql,new BeanListHandler<>(ZhangWu.class));
            return list;
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("查询所有账户信息失败！");
        }
    }

    /*
        定义方法，实现条件查询账务数据
        方法由service层调用，传递两个日期
        查询结果集存储在Bean对象，存储到list集合
     */
    public List<ZhangWu> select(String startDate,String endDate){
        try{
            //sql查询语句
            String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
            //定义数组对象，存储？占位符
            Object[] params = {startDate,endDate};
            return qr.query(sql,new BeanListHandler<>(ZhangWu.class),params);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("条件查询账户信息失败！");
        }

    }

}
