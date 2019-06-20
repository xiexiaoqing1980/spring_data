package com.example.demo.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Override
    public DynamicEntity importExcel(String fileName) {
        
        DynamicEntity dynamicEntity = new DynamicEntity();
        File file = new File(fileName);
        List<Object> datas = null;
        try{
            InputStream inputStream = new FileInputStream(file);
            ImportExcelListener excelListener = new ImportExcelListener(dynamicEntity);
            ExcelReader excelReader = EasyExcelFactory.getReader(inputStream, excelListener);
            List<Sheet> sheets = excelReader.getSheets();
            for(Sheet sheet : sheets) {
                excelReader.read(sheet);
//                datas=excelListener.getDatas();

            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dynamicEntity;
    }
}
