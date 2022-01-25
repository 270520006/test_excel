package com.zsp.test_excel.utils;

import com.alibaba.excel.EasyExcel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Excel工具包，全部的操作都靠它
public class ExcelUtils {
    private final static Logger Log = LoggerFactory.getLogger(ExcelUtils.class);

    public static boolean getExcel(){
        if (checkExcel()){
            Log.info("检测到Excel文件已存在，准备读取文件...");
            EasyExcel.read(Constant.FilePath, new NoModleDataListener()).registerConverter(new FloatStringConverter()).sheet().doRead();
            return true;
        }else {
            mkdirExcel();
        }
        return false;
    }



    public static boolean checkExcel(){
        File file = new File(Constant.FilePath);
        return file.exists()?true:false;
    }

    public static void mkdirExcel(){
        // 写法1


        try {
            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
            Log.info("Excel文件不存在，正在生成文件中...");
            EasyExcel.write(Constant.FilePath).head(Constant.head()).sheet(Constant.FileSheet).doWrite(new ArrayList<List<Object>>());
            Log.info("生成路径："+Constant.FilePath);
            Log.info("认真填写生成的Excel表后，再次启动，开始测试");
        } catch (Exception e) {
            Log.error("不仅该文件没有创建，甚至连目录都没有");
            Log.error("先创建目录");
            e.printStackTrace();
        }

    }





}
