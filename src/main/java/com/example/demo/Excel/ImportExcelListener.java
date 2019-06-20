package com.example.demo.Excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImportExcelListener extends AnalysisEventListener<Object> {

    private DynamicEntity dynamicEntity;
    
    public DynamicEntity getDynamicEntity() {
        return dynamicEntity;
    }

    public void setDynamicEntity(DynamicEntity dynamicEntity) {
        this.dynamicEntity = dynamicEntity;
    }

    public ImportExcelListener(DynamicEntity dynamicEntity) {
        this.dynamicEntity = dynamicEntity;
    }
    private List<Object> datas ;
    @Override
    public void invoke(Object object, AnalysisContext context) {
        // TODO Auto-generated method stub
        int sheetno = context.getCurrentSheet().getSheetNo();
        if (dynamicEntity == null) {
            dynamicEntity = new DynamicEntity();
        }
        //防止重复添加sheetno，需要加判断

        Map<Integer, List> rowDatas = dynamicEntity.getRowDatas();
        if (!rowDatas.containsKey(sheetno)) {
            datas = new ArrayList<Object>();
            datas.add(object);
            rowDatas.put(sheetno, datas);  //第一次的时候，先添加
        } else {
            rowDatas.get(sheetno).add(object);//第二次直接添加
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // TODO Auto-generated method stub
        
    }


}
