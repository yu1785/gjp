package cn.itcast.gip.controller;

import cn.itcast.gip.domain.ZhangWu;
import cn.itcast.gip.service.ZhangWuService;

import java.util.List;

/*
    控制器层
    接收视图层的数据，数据传递给service层
    成员位置，创建service对象
 */
public class ZhangWuController {
    private ZhangWuService service = new ZhangWuService();

    /*
        定义方法，实现添加账务
        方法由视图层调用，方法调用service层
     */
    public void addZhangWu(ZhangWu zw){
        service.addZhangWu(zw);
    }

    /*
        定义方法，实现编辑账务
        方法由视图层调用，方法调用service层
     */
    public void editZhangWu(ZhangWu zw){
        service.editZhangWu(zw);
    }

    /*
        定义方法，实现删除账务
        方法由视图层调用，方法调用service层
     */
    public void deleteZhangWu(int zwid) {
        service.deleteZhangWu(zwid);
    }

    /*
        控制层定义方法，实现查询所有账户数据
        方法由视图层调用，方法调用service层
     */
    public List<ZhangWu> selectALL(){
        return service.selectALL();
    }
    /*
        定义方法，实现条件查询账务数据
        方法由视图层调用，传递两个日期
        调用service层的方法，传递两个日期，获取结果集
        将结果集返回给视图层
     */
    public List<ZhangWu> select(String startDate,String endDate){
        return service.select(startDate,endDate);
    }

}
