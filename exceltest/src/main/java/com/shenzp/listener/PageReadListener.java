package com.shenzp.listener;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
 
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.ReadListener;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.CollectionUtils;
 
/**
 * page read listener
 *
 * @author Jiaju Zhuang
 */
public class PageReadListener<T> implements ReadListener<T> {
    /**
     * Single handle the amount of data
     */
    public static int BATCH_COUNT = 100;
    /**
     * Temporary storage of data
     */
    private List<T> cachedDataList = new ArrayList(BATCH_COUNT);
    /**
     * consumer
     */
    private final Consumer<List<T>> consumer;
 
    public PageReadListener(Consumer<List<T>> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void onException(Exception e, AnalysisContext analysisContext) throws Exception {

    }

    @Override
    public void invokeHead(Map<Integer, CellData> map, AnalysisContext analysisContext) {

    }

    @Override
    public void invoke(T data, AnalysisContext context) {
        System.out.println(JSON.toJSONString(data));
        cachedDataList.add(data);
        if (cachedDataList.size() >= BATCH_COUNT) {
            consumer.accept(cachedDataList);
            cachedDataList = new ArrayList(BATCH_COUNT);
        }
    }

    @Override
    public void extra(CellExtra cellExtra, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        if (CollectionUtils.isNotEmpty(cachedDataList)) {
            consumer.accept(cachedDataList);
        }
    }

    @Override
    public boolean hasNext(AnalysisContext analysisContext) {
        return false;
    }

}