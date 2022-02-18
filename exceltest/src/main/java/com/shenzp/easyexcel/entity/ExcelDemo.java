package com.shenzp.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: shenzp
 * @Date: 2022/2/17
 */
@Data
public class ExcelDemo {

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("年龄")
    private Integer age;

    @ExcelProperty("出生日期")
    private Date birthDay;

    @ExcelIgnore
    private String ignore;

}
