package kingdee.test.platform.controller;

import kingdee.test.platform.dao.userMapper;
import kingdee.test.platform.pojo.PageBean;
import kingdee.test.platform.pojo.user;
import kingdee.test.platform.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class data_controller {


    @Autowired
    private userService userService;

    @Autowired
    private userMapper userMapper;

    @GetMapping("/user/{id}")
    @ResponseBody
    public user selectUsers(@PathVariable("id") Integer id){
        user user=userService.findUserById(id);
        return user;
        
    }
//    @GetMapping("/userlist")
//    public String  selectUsers(Model model){
//
//        model.addAttribute("users",userService.findUsers());
//        return "itemslist"; //forward
//    }

    @GetMapping("/userlist")
    @ResponseBody
    public List<user>  selectUsers(Model model){

        List<user> users=userService.findUsers();

       return  users;
    }
    @GetMapping("/adduser")
    public String  adduser (user user){
        userService.adduser(user);
        return "redirect:/selectByPageTest";

    }

    @GetMapping("/deleteuser")  //
    public String  deleteuser (Integer id){
//        userService.adduser(user);
        userService.deleteUser(id);
        return "redirect:/selectByPageTest";
    }
    //开始分页显示
    @GetMapping("/selectByPageTest")
    public String  selectByPageTest(Model model,@RequestParam(value = "currPage",defaultValue = "1") int currPage ){
        int totalcount=userService.findUsers().size(); //获取数据的总长度即可
        int pageSize=5;
        PageBean pageBean=new PageBean(currPage,5,totalcount);//封装数据后方便写出
        List<user> users=userMapper.findByPage(currPage*pageSize-pageSize,pageSize);//获取当页的数据
        model.addAttribute("users",users);
        model.addAttribute("pagebean",pageBean);
//        model.addAttribute("users",userService.findUsers());
        return "itemslist"; //forward,地址不变化
    }

    @PostMapping ("/login")
    public  String login(user user, Model model, HttpSession session){
//        if (user!=null&&user.getId()!=null){
//            user user2=userService.findUserById(user.getId());
//            if (user2!=null){
//                model.addAttribute("user2",user2);
//                session.setAttribute("login_user",user2);
//                return "redirect:/userlist";
////                return "/userlist";这样是直接
//            }else {
//
//                return "redirect:/login.html";
//            }
//        }else {
//            return "redirect:/login.html";
//        }
        return "redirect:/userlist";




    }

}
