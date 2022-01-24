package com.zsp.test_excel.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//启动类，也可以不用这个，把工具包拿去在测试类里用就可以
public class AutoTest {
    private final static Logger Log = LoggerFactory.getLogger(ExcelUtils.class);
    public static void main(String[] args) {
        ExcelUtils.getExcel();
    }
}
