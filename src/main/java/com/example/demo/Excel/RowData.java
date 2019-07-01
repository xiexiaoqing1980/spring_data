package com.example.demo.Excel;


import lombok.Builder;
import lombok.Data;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * 封装行数据，一行数据就是一个对象
 * rowindex:行的索引
 * data:每一行的数据，string类型
 */
@Data
@Builder
public class RowData {
    private int  rowIndex;
    private Map<String,String> data;

}
