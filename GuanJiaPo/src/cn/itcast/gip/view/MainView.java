package cn.itcast.gip.view;

import cn.itcast.gip.controller.ZhangWuController;
import cn.itcast.gip.domain.ZhangWu;

import java.util.List;
import java.util.Scanner;

/*
    视图层，用户看到和操作的界面
    数据传递给controller层实现
    成员位置，创建controller对象
 */
public class MainView {
    private ZhangWuController controller = new ZhangWuController();
    /*
        实现界面效果
        接收用户的输入
        根据数据，调用不同的功能方法
     */
    public void run(){
        //创建Scanner类的对象，反复进行键盘输入
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("---------------管家婆家庭记账软件---------------");
            System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
            System.out.println("请输入要操作的功能序号[1-5]:");
            //接收用户的菜单选择
            int choose = sc.nextInt();
            //对选择的菜单判断，调用不同的功能
            switch (choose){
                case 1:
                    //选择添加账务，调用添加账务的方法
                    addZhangWu();
                    break;
                case 2:
                    //选择编辑账务，调用编辑账务的方法
                    editZhangWu();
                    break;
                case 3:
                    //选择删除账务，调用删除账务的方法
                    deleteZhangWu();
                    break;
                case 4:
                    //选择查询账务，调用查询账务的方法
                    selectZhangWu();
                    break;
                case 5:
                    //退出
                    System.exit(0);
                    break;
            }
        }
    }
    /*
        定义方法addZhangWu()
        接收键盘输入，调用controller方法
     */
    public void addZhangWu(){
        System.out.println("选择为添加账务功能，请输入以下内容：");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入分类名称：");
        String flname = sc.next();
        System.out.print("请输入金额：");
        Double money = sc.nextDouble();
        System.out.print("请输入账户：");
        String zhanghu = sc.next();
        System.out.print("请输入日期（格式为XXXX-XX-XX）：");
        String createtime = sc.next();
        System.out.print("请输入具体描述：");
        String description = sc.next();
        //调用controller的方法
        ZhangWu zw = new ZhangWu(0,flname,money,zhanghu,createtime,description);
        controller.addZhangWu(zw);
        System.out.println("添加账务成功！");
    }

    /*
        定义方法editZhangWu()
        接收用户的输入
     */
    public void editZhangWu(){
        //调用显示所有数据功能，对其中某项数据进行修改
        selectAll();
        System.out.println("选择为编辑账务功能，请输入以下内容：");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入需要编辑的账务ID：");
        int zwid = sc.nextInt();
        System.out.print("请输入新的类别：");
        String flname = sc.next();
        System.out.print("请输入新的金额：");
        Double money = sc.nextDouble();
        System.out.print("请输入新的账户：");
        String zhanghu = sc.next();
        System.out.print("请输入新的日期（格式为XXXX-XX-XX）：");
        String createtime = sc.next();
        System.out.print("请输入新的说明：");
        String description = sc.next();
        //调用controller的方法
        ZhangWu zw = new ZhangWu(zwid,flname,money,zhanghu,createtime,description);
        controller.editZhangWu(zw);
        System.out.println("编辑账务成功！");
    }

    /*
        定义方法deleteZhangWu()
        接收用户的输入
        选择要删除账务的ID
     */
    public void deleteZhangWu(){
        //调用显示所有数据功能，对其中某项数据进行修改
        selectAll();
        System.out.println("选择为删除账务功能，请输入以下内容：");
        System.out.print("请输入要删除的账务ID：");
        int zwid = new Scanner(System.in).nextInt();
        //调用controller的方法
        controller.deleteZhangWu(zwid);
        System.out.println("删除账务成功！");
    }

    /*
        定义方法selectZhangWu()
        显示查询的方式 1所有查询  2条件查询
        接收用户的选择
     */
    public void selectZhangWu(){
        System.out.println("1.查询所有　2.按条件查询");
        Scanner sc = new Scanner(System.in);
        int selectChooser = sc.nextInt();
        //根据用户选择，调用不同功能
        switch (selectChooser){
            case 1:
                //调用查询所有的方法
                selectAll();
                break;
            case 2:
                //调用条件查询的方法
                select();
                break;
        }
    }

    /*
        定义方法，实现所有查询
     */
    public void selectAll(){
        //调用控制层中的方法，查询所有账务数据
        List<ZhangWu> list = controller.selectALL();
        print(list);
    }

    /*
        定义方法，实现条件查询账务数据
        提供用户的输入日期 开始 截止
        将2个日期传递到controller层
        调用controller层的方法，传递两个日期参数
        获取controller查询结果集，打印出来
     */
    public void select(){
        System.out.println("选择条件查询，输入日期格式为：xxxx-xx-xx");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入起始日期：");
        String startDate = sc.nextLine();
        System.out.print("请输入截止日期：");
        String endDate = sc.nextLine();
        //调用控制层中的方法，条件查询账务数据
        List<ZhangWu> list = controller.select(startDate,endDate);
        if (list.size()!= 0)
            print(list);
        else
            System.out.println("没有查询到数据");
    }

    private void print(List<ZhangWu> list) {
        //输出表头信息
        System.out.println("ID\t\t类别\t\t\t账户\t\t\t金额\t\t\t创建时间\t\t\t说明");
        //增强for循环，遍历list集合，输出结果
        for (ZhangWu zw : list){
            System.out.println(zw.getZwid()+"\t\t"+zw.getFlname()+"\t\t"+zw.getZhanghu()+"\t\t\t"+
                    zw.getMoney()+"\t\t\t"+zw.getCreatetime()+"\t\t\t"+zw.getDescription());
        }
    }
}
