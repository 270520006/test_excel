package com.zsp.test_excel;

import com.alibaba.fastjson.JSONObject;
import com.zsp.test_excel.utils.RestClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestExcelApplicationTests {



    @Test
    void testGet() {
        JSONObject get = RestClient.get("http://localhost:8080/test/select/","200" );
        System.out.println(get);
    }
    @Test
    void testPost() {
        JSONObject post = RestClient.post("http://localhost:8080/test/post", "Y");
        System.out.println(post);
    }

}
