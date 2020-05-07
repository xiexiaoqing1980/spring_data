package kingdee.test.platform.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//public class LoginInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //请求登录页面时直接放行
////        if (request.getRequestURL().indexOf("login")>=0){
////            return  true;
////        }
//        if (request.getSession().getAttribute("login_user")!=null){
//            return true;
//        }else{
//            //otherwise redirect to login page
//            response.sendRedirect("/login.html");
//            return  false;
//        }
//
//
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//}
