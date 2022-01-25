package com.zsp.test_excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class EasyExcelTest {
    String Path ="";
    /**
     * 不创建对象的写
     */
    @Test
    public void noModleWrite() {

        // 写法1
        String fileName =Path+"noModleWrite.xlsx";

            EasyExcel.write(fileName).head(head()).sheet("模板").doWrite(dataList());


        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭

    }

    private List<List<String>> head() {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<String>();
        head0.add("字符串" + System.currentTimeMillis());
        List<String> head1 = new ArrayList<String>();
        head1.add("数字" + System.currentTimeMillis());
        List<String> head2 = new ArrayList<String>();
        head2.add("日期" + System.currentTimeMillis());
        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;
    }

    private List<List<Object>> dataList() {
        List<List<Object>> list = new ArrayList<List<Object>>();
        for (int i = 0; i < 10; i++) {
            List<Object> data = new ArrayList<Object>();
            data.add("字符串" + i);
            data.add(new Date());
            data.add(0.56);
            list.add(data);
        }
        return list;
    }

    /**
     * 不创建对象的读，不是特别推荐使用，都用String接收对日期的支持不是很好
     */
    @Test
    public void noModleRead() {
        String fileName = Path+"noModleWrite.xlsx";
        // 这里 只要，然后读取第一个sheet 同步读取会自动finish
        EasyExcel.read(fileName, new NoModleDataListener()).sheet().doRead();
    }

    /**
     * 直接用map接收数据
     *
     * @author Jiaju Zhuang
     */
    public class NoModleDataListener extends AnalysisEventListener<Map<Integer, String>> {
        private final Logger LOGGER = LoggerFactory.getLogger(NoModleDataListener.class);
        /**
         * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
         */
        private static final int BATCH_COUNT = 5;
        List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();

        @Override
        public void invoke(Map<Integer, String> data, AnalysisContext context) {
            LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
            list.add(data);
            if (list.size() >= BATCH_COUNT) {
                saveData();
                list.clear();
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
        }
    }
}
