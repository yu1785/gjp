package cn.itcast.gip.service;

import cn.itcast.gip.dao.ZhangWuDao;

/*
    业务层类
    接收上一层 控制层controller的数据
    经过计算，传递给dao层，操作数据库
    调用dao层中的类，类成员位置，创建Dao类的对象
 */
public class ZhangWuService {
    private ZhangWuDao dao = new ZhangWuDao();
}
