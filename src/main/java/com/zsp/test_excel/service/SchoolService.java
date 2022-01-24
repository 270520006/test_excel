package com.zsp.test_excel.service;

import com.zsp.test_excel.entity.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    public School addSchool(School school){
        if (null!=school.getName()){
            System.out.println("写入学校成功");
            return school;
        }
        return school;
    }

    public School updateSchool(School school){
        return school;
    }
}
