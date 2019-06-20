package com.example.demo.Excel;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class DynamicEntity implements Serializable {

    private static final long serialVersionUID = 5954091726694179317L;
    private List<ColumnInfo> columns=new ArrayList<>();
    private Map<Integer,List> rowDatas = new HashMap<>();


    public List<ColumnInfo> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnInfo> columns) {
        this.columns = columns;
    }

    public void addRowData( int sheetno,Object object) {
        if (!rowDatas.containsKey(sheetno)) {
//            datas.add(object);
            rowDatas.put(sheetno, new ArrayList<Object>());  //第一次的时候，先添加
        }
            rowDatas.get(sheetno).add(object);//第二次直接添加

    }



    public Map<Integer, List> getRowDatas() {
        return rowDatas;
    }

    public void setRowDatas(Map<Integer, List> rowDatas) {
        this.rowDatas = rowDatas;
    }
}
