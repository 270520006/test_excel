package com.zsp.test_excel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {

    private String name;
    private String address;
    private int contactNo=100;

}
