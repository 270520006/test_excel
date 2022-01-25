package com.zsp.test_excel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.testng.annotations.IFactoryAnnotation;

@RestController
@RequestMapping("/test")
public class TestController {
    @PostMapping("/post")
    public JSON testPost()
    {
        String json = "{abc:1,hahah:2}";
        return JSONObject.parseObject(json);
    }

    @GetMapping("/select/{userId}")
    public JSON selectByUserId(@PathVariable(value = "userId") Long userId){
        return JSONObject.parseObject("{responseCode:200}");
    }

}
