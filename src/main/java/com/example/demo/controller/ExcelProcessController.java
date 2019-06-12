package com.example.demo.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.demo.pojo.user;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
public class ExcelProcessController {

    @Autowired
    private userService userService;

    @RequestMapping("/exportExcel")
    public void exportExcel(){
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
            }
        }


    }


}
