package com.shenzp.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.fastjson.JSON;
import com.shenzp.easyexcel.entity.ExcelDemo;
import com.shenzp.listener.ExcelDemoListener;
import com.shenzp.listener.PageReadListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: shenzp
 * @Date: 2022/2/17
 */
@Slf4j
public class ExcelEasyTest {

    final String FILE_PATH = "F:\\javaProject\\springbootjson\\exceltest";

    private List<ExcelDemo> data() {
        List<ExcelDemo> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            ExcelDemo data = new ExcelDemo();
            data.setName("字符串" + i);
            data.setBirthDay(new Date());
            data.setAge(56);
            list.add(data);
        }
        return list;
    }

    /**
     * easyExcel简单写
     */
    @Test
    public void testEasy() {
        String fileName = FILE_PATH + "EasyTest.xlsx";
        EasyExcel.write(fileName, ExcelDemo.class).sheet("sheet2").doWrite(data());
    }

    /**
     * 最简单的读
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link ExcelDemo}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link ExcelDemoListener}
     * <p>
     * 3. 直接读即可
     */
    @Test
    public void simpleRead() {
        // 写法1：JDK8+ ,不用额外写一个ExcelDemoListener
        // since: 3.0.0-beta1
        String fileName = FILE_PATH + "EasyTest.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
//        EasyExcel.read(fileName, ExcelDemo.class, new PageReadListener<ExcelDemo>(dataList -> {
//            for (ExcelDemo ExcelDemo : dataList) {
////                System.out.println("读取到一条数据{}"+JSON.toJSONString(ExcelDemo));
//                log.info("读取到一条数据{}", JSON.toJSONString(ExcelDemo));
//            }
//        })).sheet().doRead();

        EasyExcel.read(fileName, ExcelDemo.class, new ExcelDemoListener()).sheet().doRead();

        // 写法2：
        // 匿名内部类 不用额外写一个ExcelDemoListener
//        fileName = FILE_PATH + "EasyTest.xlsx";
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        EasyExcel.read(fileName, ExcelDemo.class, new ReadListener<ExcelDemo>() {
//            /**
//             * 单次缓存的数据量
//             * */
//            public static final int BATCH_COUNT = 100;
//
//            /**
//             *临时存储
//             * */
//            private List<ExcelDemo> cachedDataList = new ArrayList(BATCH_COUNT);
//
//            @Override
//            public void onException(Exception e, AnalysisContext analysisContext) throws Exception {
//
//            }
//
//            @Override
//            public void invokeHead(Map<Integer, CellData> map, AnalysisContext analysisContext) {
//
//            }
//
//            @Override
//            public void invoke(ExcelDemo data, AnalysisContext context) {
//                log.info("解析到一条数据:{}", JSON.toJSONString(data));
//                cachedDataList.add(data);
//                if (cachedDataList.size() >= BATCH_COUNT) {
//                    saveData();
//                    // 存储完成清理 list
//                    cachedDataList = new ArrayList(BATCH_COUNT);
//                }
//            }
//
//            @Override
//            public void extra(CellExtra cellExtra, AnalysisContext analysisContext) {
//
//            }
//
//            @Override
//            public void doAfterAllAnalysed(AnalysisContext context) {
//                saveData();
//            }
//
//            @Override
//            public boolean hasNext(AnalysisContext analysisContext) {
//                return true;
//            }
//
//            /**
//             * 加上存储数据库
//             * */
//            private void saveData() {
//                log.info("{}条数据，开始存储数据库！", cachedDataList.size());
//                log.info("存储数据库成功！");
//            }
//        }).sheet().doRead();

        // 有个很重要的点 ExcelDemoListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法3：
//        fileName = FILE_PATH + "EasyTest.xlsx";
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        EasyExcel.read(fileName, ExcelDemo.class, new ExcelDemoListener()).sheet().doRead();

        // 写法4：
//        fileName = FILE_PATH + "EasyTest.xlsx";
//        // 一个文件一个reader
//        ExcelReader excelReader = null;
//        try {
//            excelReader = EasyExcel.read(fileName, ExcelDemo.class, new ExcelDemoListener()).build();
//            // 构建一个sheet 这里可以指定名字或者no
//            ReadSheet readSheet = EasyExcel.readSheet(0).build();
//            // 读取一个sheet
//            excelReader.read(readSheet);
//        } finally {
//            if (excelReader != null) {
//                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
//                excelReader.finish();
//            }
//        }
    }
}
