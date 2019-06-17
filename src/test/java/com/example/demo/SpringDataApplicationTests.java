package com.example.demo;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.example.demo.Excelprocess.ExcelListener;
import com.example.demo.pojo.user;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataApplicationTests {

	@Test
	public void contextLoads() {

		InputStream inputStream = null;
		ExcelListener excelListener = new ExcelListener();
		List<Object> datas = null;

		try {
//            inputStream = file.getInputStream();
			inputStream=new FileInputStream(new File("D://userdata.xlsx"));
			ExcelReader reader = new ExcelReader(inputStream, user.class,excelListener);
			reader.read(new Sheet(1, 2, null));
			datas = excelListener.getDatas();
		} catch (Exception e) {
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println(datas);
		}


	}

}
