package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class fileprocesscontroller {

    @GetMapping("/upload")
    public String upload() {
        return "importExcel";
    }

    @PostMapping("/uploadfile")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        if (!file.isEmpty()) {

            // 构建上传文件的存放路径
            String path = request.getServletContext().getRealPath("/upload/");
            System.out.println("path = " + path);

            // 获取上传的文件名称，并结合存放路径，构建新的文件名称
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);

            // 判断路径是否存在，不存在则新创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }

            // 将上传文件保存到目标文件目录
            file.transferTo(new File(path + filename));
            return "success";
        } else {
            return "error";
        }
    }
}
