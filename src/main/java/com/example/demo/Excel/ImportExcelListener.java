package com.example.demo.Excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

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
    private List<Object> datas = new ArrayList<Object>();
    @Override
    public void invoke(Object object, AnalysisContext context) {
        // TODO Auto-generated method stub
        datas.add(object);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // TODO Auto-generated method stub
        
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
}
