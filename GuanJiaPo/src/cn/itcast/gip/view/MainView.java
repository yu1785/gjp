package cn.itcast.gip.view;

import cn.itcast.gip.controller.ZhangWuController;

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

                    break;
                case 2:
                    //选择编辑账务，调用编辑账务的方
                    break;
                case 3:
                    //选择删除账务，调用删除账务的方
                    break;
                case 4:
                    //选择查询账务，调用查询账务的方
                    break;
                case 5:
                    //退出
                    System.exit(0);
                    break;
            }
        }
    }
}
