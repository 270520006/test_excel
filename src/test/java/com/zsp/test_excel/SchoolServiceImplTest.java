package com.zsp.test_excel;

import com.zsp.test_excel.entity.School;
import com.zsp.test_excel.service.SchoolService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * 一点教程网： http://www.yiidian.com
 */
public class SchoolServiceImplTest { 
    private SchoolService schoolService;
    School school;
       
    /**
     * This method initialize all domain objects required for test methods.
     */
    @Before
    public final void setUp() throws Exception {

        // Instantiates a School instance;
        school = new School();
        school.setName("BVB School");
        school.setAddress("BVB School");
        school.setContactNo(60);

    }
  
    @Test
    public final void testAddSchool() throws Exception {
        System.out.println(school);
    }

   





}