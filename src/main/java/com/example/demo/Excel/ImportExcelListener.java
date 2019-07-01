package com.example.demo.Excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
//    private List<Object> datas ;
    @Override
    public void invoke(Object list, AnalysisContext context) {
        // TODO Auto-generated method stub
        int sheetno = context.getCurrentSheet().getSheetNo();  //获取当前的sheet编码
        if (dynamicEntity == null) {
            dynamicEntity = new DynamicEntity();
        }
//        //防止重复添加sheetno，需要加判断
//        if (!rowDatas.containsKey(sheetno)) {
//            datas = new ArrayList<Object>();
//            datas.add(object);
//            rowDatas.put(sheetno, datas);  //第一次的时候，先添加
//        } else {
//            rowDatas.get(sheetno).add(object);//第二次直接添加
//        }
        //封装列数据，获取表头
        if (context.getCurrentRowNum()==0){
             if (list instanceof List){
                 List<ColumnInfo> cols = ((List<String>) list).stream().map(s -> ColumnInfo.builder().columnName(s).build()).collect(Collectors.toList());//生成columninfo列表
                 dynamicEntity.getCols().put(sheetno,cols);
                 }
             }else {
            //遍历数据
            Map<String,String> data=new HashMap<>();
            for (int i = 0; i < dynamicEntity.getCols().get(sheetno).size(); i++) {  //获取有几列
                data.put(dynamicEntity.getCols().get(sheetno).get(i).getColumnName(),((List<String>)list).get(i));  //列名跟行的数据拼接
            }
            dynamicEntity.addRowData(sheetno,RowData.builder().data(data).rowIndex(context.getCurrentRowNum()).build());

        }


    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // TODO Auto-generated method stub
        
    }


}
