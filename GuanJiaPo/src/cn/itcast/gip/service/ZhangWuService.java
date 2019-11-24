package cn.itcast.gip.service;

import cn.itcast.gip.dao.ZhangWuDao;
import cn.itcast.gip.domain.ZhangWu;

import java.util.List;

/*
    业务层类
    接收上一层 控制层controller的数据
    经过计算，传递给dao层，操作数据库
    调用dao层中的类，类成员位置，创建Dao类的对象
 */
public class ZhangWuService {
    private ZhangWuDao dao = new ZhangWuDao();

    /*
        定义方法，实现添加账务
        此方法由控制层调用，去调用dao层的方法
     */
    public void addZhangWu(ZhangWu zw){
        dao.addZhangWu(zw);
    }

    /*
        定义方法，实现编辑账务
        此方法由控制层调用，去调用dao层的方法
     */
    public void editZhangWu(ZhangWu zw){
        dao.editZhangWu(zw);
    }

    /*
        定义方法，实现删除账务
        此方法由控制层调用，去调用dao层的方法
     */
    public void deleteZhangWu(int zwid) {
        dao.deleteZhangWu(zwid);
    }
    /*
        定义方法，实现查询所有的账务数据
        此方法由控制层调用，去调用dao层的方法
     */
    public List<ZhangWu> selectALL(){
        return dao.selectALL();
    }
    /*
        定义方法，实现条件查询账务数据
        方法由控制层调用，传递两个日期
        调用dao层的方法，传递两个日期，获取结果集
        将结果集返回给控制层
     */
    public List<ZhangWu> select(String startDate,String endDate){
        return dao.select(startDate,endDate);
    }

}
