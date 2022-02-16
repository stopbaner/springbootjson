package com.shenzp.poi;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description:
 * @Author: shenzp
 * @Date: 2022/2/14
 */
@Slf4j
public class ExcelPOITest {

    final String POI_PATH = "F:\\javaProject\\springbootjson\\exceltest";

    /**
     * 03版Excel处理
     * @throws IOException
     */
    @Test
    public void poiWrite() throws IOException {
        //1、创建工作簿
        Workbook workbook = new HSSFWorkbook();
        //2.创建工作表
        Sheet table1 = workbook.createSheet("工作表1");
        //3.创建行
        Row row1 = table1.createRow(0);
        //4.创建列(1,1)
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("姓名");
        //(1,2)
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue("shen");
        //(2,1)
        Row row2 = table1.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间");
        //(2,2)
        Cell cell22 = row2.createCell(1);
        cell22.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        //文件流写出
        FileOutputStream fileOutputStream = new FileOutputStream(POI_PATH + "人员统计表03.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        log.info("人员统计表生成完毕");
    }

    /**
     * 07版Excel处理
     * @throws IOException
     */
    @Test
    public void poiWrite07() throws IOException {
        //1、创建工作簿
        Workbook workbook = new XSSFWorkbook();
        //2.创建工作表
        Sheet table1 = workbook.createSheet("工作表1");
        //3.创建行
        Row row1 = table1.createRow(0);
        //4.创建列(1,1)
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("姓名");
        //(1,2)
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue("shen");
        //(2,1)
        Row row2 = table1.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间");
        //(2,2)
        Cell cell22 = row2.createCell(1);
        cell22.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        //文件流写出
        FileOutputStream fileOutputStream = new FileOutputStream(POI_PATH + "人员统计表07.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        log.info("人员统计表生成完毕");
    }

    /**
     * 07版Excel处理
     * @throws IOException
     */
    @Test
    public void poiRead07() throws IOException {
        //0.获取文件输入流
        FileInputStream fileInputStream=new FileInputStream(POI_PATH+"人员统计表07.xlsx");
        //1、创建工作簿
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        //2.创建工作表
        Sheet table1 = workbook.getSheet("工作表1");
        //3.得到行
        Row row1 = table1.getRow(0);
        Cell cell1 = row1.getCell(0);
        log.info(cell1.getStringCellValue());
    }
}
