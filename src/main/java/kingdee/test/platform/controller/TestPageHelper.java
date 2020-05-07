package kingdee.test.platform.controller;
import	java.util.HashMap;

import kingdee.test.platform.pojo.user;
import kingdee.test.platform.service.userService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TestPageHelper {
    @Autowired
    private userService userService;
    //开始分页显示
//    @GetMapping("/selectByPageHelper/{currPage}")   //从缓存中查数据不会分页
//    public String  selectByPageTest(Model model, @PathVariable("currPage") int currPage ){
//
////        int totalcount=userService.findUsers().size(); //获取数据的总长度即可
//        int pageSize=5;
//        PageHelper.startPage(currPage,pageSize);
//        //紧跟着的第一个select方法会被分页
//        List<user> users=userService.findUsers();
//        //用PageInfo对结果进行包装
//        PageInfo<user> p=new PageInfo<>(users);
//
//        model.addAttribute("users",users);
//        model.addAttribute("page",p);
//////        model.addAttribute("users",userService.findUsers());
//
//        return "itemslisthelper"; //forward,地址不变化
//    }

    @GetMapping("/selectByPageHelper/{currPage}")   //从缓存中查数据不会分页
    @ResponseBody
    public  Map selectByPageTest(Model model, @PathVariable("currPage") int currPage ){

//        int totalcount=userService.findUsers().size(); //获取数据的总长度即可
        int pageSize=5;
        PageHelper.startPage(currPage,pageSize);
        //紧跟着的第一个select方法会被分页
        List<user> users=userService.findUsers();
        //用PageInfo对结果进行包装
        PageInfo<user> p=new PageInfo<>(users);
        //返回分页结果和人员信息
        Map resultMap=new HashMap();
        resultMap.put("result",p);
        return  resultMap;



    }
}
