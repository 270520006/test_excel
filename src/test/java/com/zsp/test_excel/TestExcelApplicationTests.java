package com.zsp.test_excel;

import com.alibaba.fastjson.JSONObject;
import com.zsp.test_excel.utils.RestClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestExcelApplicationTests {

    @Test
    void contextLoads() {
        JSONObject post = RestClient.post("http://localhost:8080/test/post", "Y");
        System.out.println(post);

    }

}
