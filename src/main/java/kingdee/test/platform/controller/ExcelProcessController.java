package kingdee.test.platform.controller;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import kingdee.test.platform.Excelprocess.ExcelListener;
import kingdee.test.platform.pojo.user;
import kingdee.test.platform.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@RestController
public class ExcelProcessController {

    @Autowired
    private userService userService;


    //此方法只是将文件写入到了指定的文件，但是不会用附件的方式下载
    @RequestMapping("/writeExcel")
    public String exportExcel(){
        //调用service查询方法返回结果集
        List<user> users = userService.findUsers();
        OutputStream out=null;
        //定义输出流的位置：
        try {
            out = new FileOutputStream(ClassUtils.getDefaultClassLoader().getResource("File/test.xlsx").getPath());
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX,true);
            // 写仅有一个 Sheet 的 Excel 文件, 此场景较为通用
            Sheet sheet1 = new Sheet(1, 0, user.class);
            // 第一个 sheet 名称
            sheet1.setSheetName("第一个sheet");
            writer.write(users,sheet1);
            writer.finish();
        }catch (FileNotFoundException e){
            e.printStackTrace();

        }finally {
            try {
                // 关闭流
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                return "false";
            }
        }
        return "success";

    }


/**
 * 格式说明：
 * content-disposition = "Content-Disposition" ":" disposition-type *( ";" disposition-parm ) 　
 *
 * 字段说明：
 * Content-Disposition为属性名
 * disposition-type是以什么方式下载，如attachment为以附件方式下载
 * disposition-parm为默认保存时的文件名
 */
@RequestMapping("/exportExcel")
public void exportExcel(HttpServletResponse response,String param) throws Exception{
    //调用service查询方法返回结果集
    String fileName = "userdata";
//    response.setContentType("multipart/form-data");
    response.setCharacterEncoding("utf-8");
    //通知浏览器以附件的形式下载处理
    response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
    List<user> users = userService.findUsers();
    ServletOutputStream out = response.getOutputStream();
    ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);

    Sheet sheet = new Sheet(1, 0,user.class);
    //设置自适应宽度
    sheet.setAutoWidth(Boolean.TRUE);
    writer.write(users, sheet);
    writer.finish();
    // 设置输出的格式，二进制

    out.flush();
}
    @RequestMapping("/importExcel")
    @ResponseBody
    public  List<Object>  importfile(MultipartFile file) throws Exception {

        InputStream inputStream = file.getInputStream();;

        List<Object> datas = null;

        try {
            ExcelListener excelListener = new ExcelListener();
//            inputStream=new FileInputStream(new File("D://userdata.xlsx"));
//            ExcelReader reader = new ExcelReader(inputStream, null,excelListener);
             datas= EasyExcelFactory.read(inputStream,new Sheet(1, 2, null));
//            reader.read(new Sheet(1, 2, null));
//            datas = excelListener.getDatas();
        } catch (Exception e) {
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return datas;
        }
    }


}
