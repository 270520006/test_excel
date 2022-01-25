package com.zsp.test_excel.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//用于Excel读取文件
//并写入测试结果
public class NoModleDataListener extends AnalysisEventListener<Map<Integer, String>> {
        private final Logger LOGGER = LoggerFactory.getLogger(NoModleDataListener.class);
        /**
         * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
         */
        private static final int BATCH_COUNT = 5;
        List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();
        List<List<Object>> writeList = new ArrayList<List<Object>>();

    @Override
        public void invoke(Map<Integer, String> data, AnalysisContext context) {
            LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
            JSONObject send = RestClient.send(data.get(5), data.get(8), data.get(6));
            data.put(10,"FAIL");
            data.put(9,"error");
            if (null!=send) {
                data.put(9,send.toJSONString());
                data.put(10, "SUCCESS");
            }
            writeList.add(data.entrySet().stream().map(en -> en.getValue()).collect(Collectors.toList()));


        System.out.println(send);

            this.list.add(data);
            if (this.list.size() >= BATCH_COUNT) {
                saveData();
                this.list.clear();
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {

            saveData();
            LOGGER.info("所有数据解析完成！");
        }

        /**
         * 加上存储数据库
         */
        private void saveData() {
            LOGGER.info("{}条数据，开始存储数据库！", list.size());
            LOGGER.info("存储数据库成功！");
            EasyExcel.write(Constant.FilePath).head(Constant.head()).sheet(Constant.FileSheet).doWrite(writeList);
            System.out.println(list);
        }
    }