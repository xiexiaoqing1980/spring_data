package kingdee.test.platform.Excel;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
//@RequestMapping("excel/")
public class ExcelController {
    
    @Autowired
    private ExcelService excelService;
    
    
    @RequestMapping("import")
    public String importExcel(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        String filePath = "D:\\excelfilepath\\";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            e.getStackTrace();
            return "上传失败";
        }
    }
    
    @RequestMapping("/resolve")
    public DynamicEntity resolveExcel(String fileName) {
         return excelService.importExcel(fileName);
    }
}
