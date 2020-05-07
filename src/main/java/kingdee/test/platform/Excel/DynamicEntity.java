package kingdee.test.platform.Excel;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data  //简化get set方法
public class DynamicEntity implements Serializable {

    private static final long serialVersionUID = 5954091726694179317L;
    private Map<Integer,List<ColumnInfo>> cols = new HashMap<>();
    private Map<Integer ,List<RowData>> rowDatas = new HashMap<>();

    /**
     * 添加行数据到map集合中
     * @param sheetno
     * @param rowData
     */
    public void addRowData( int sheetno,RowData rowData) {
//        if (!rowDatas.containsKey(sheetno)) {
////            datas.add(object);
//            rowDatas.put(sheetno, new ArrayList<Object>());  //第一次的时候，先添加
//        }
//            rowDatas.get(sheetno).add(object);//第二次直接添加

        if (!rowDatas.containsKey(sheetno)){
            rowDatas.put(sheetno,new ArrayList<RowData>());
        }
        rowDatas.get(sheetno).add(rowData);
    }


}
