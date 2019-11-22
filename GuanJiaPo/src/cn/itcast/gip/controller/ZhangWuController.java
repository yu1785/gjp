package cn.itcast.gip.controller;

import cn.itcast.gip.service.ZhangWuService;

/*
    控制器层
    接收视图层的数据，数据传递给service层
    成员位置，创建service对象
 */
public class ZhangWuController {
    private ZhangWuService service = new ZhangWuService();
}
