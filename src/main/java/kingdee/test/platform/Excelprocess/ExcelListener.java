package kingdee.test.platform.Excelprocess;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;


/* 解析监听器，
 * 每解析一行会回调invoke()方法。
 * 整个excel解析结束会执行doAfterAllAnalysed()方法
  */
public class ExcelListener extends AnalysisEventListener {
     //自定义用于暂时存储data。
     //可以通过实例获取该值
     private List<Object> datas = new ArrayList<Object>();
    @Override
    public void invoke(Object object, AnalysisContext context) {
        datas.add(object);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
        List<String> stringList= (List<String>) object;
        System.out.println("当前sheet"+context.getCurrentSheet().getSheetNo()+ " 当前行：" + context.getCurrentRowNum()
                + " data:" + stringList.get(0));

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
    public List<Object> getDatas() {
        return datas;
    }
    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
}
