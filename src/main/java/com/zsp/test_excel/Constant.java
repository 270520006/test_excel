package com.zsp.test_excel.utils;

import java.util.ArrayList;
import java.util.List;

//常量
public class Constant {
 
 
//public static final String URL = "http://mail.qq.com";
 
//测试数据EXCEL路径
public static final String FilePath = "D:\\接口自动化测试.xlsx";
 
// EXCEL测试数据sheet名称
public static final String FileSheet = "测试用例";
 
public static final String ResponseSheet = "response";

public static List<List<String>> head() {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<String>();
        head0.add("行号");
        List<String> head1 = new ArrayList<String>();
        head1.add("测试用例编号");
        List<String> head2 = new ArrayList<String>();
        head2.add("测试用例名称");
        List<String> head3 = new ArrayList<String>();
        head3.add("优先级");
        List<String> head4 = new ArrayList<String>();
        head4.add("接口名");
        List<String> head5 = new ArrayList<String>();
        head5.add("接口地址URL");
        List<String> head6 = new ArrayList<String>();
        head6.add("接口请求方法");
        List<String> head7 = new ArrayList<String>();
        head7.add("请求数据类型");
        List<String> head8 = new ArrayList<String>();
        head8.add("请求参数");
        List<String> head9 = new ArrayList<String>();
        head9.add("请求结果");
        List<String> head10 = new ArrayList<String>();
        head10.add("测试执行结果");
        list.add(head0);
        list.add(head1);list.add(head2);list.add(head3);
        list.add(head4);list.add(head5);list.add(head6);
        list.add(head7);list.add(head8);list.add(head9);
        list.add(head10);
        return list;
    }
 
}