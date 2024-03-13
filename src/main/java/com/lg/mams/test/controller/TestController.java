package com.lg.mams.test.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.lg.mams.test.service.TestService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService service;
	
	@Autowired
	MessageSource ms;
	

    @GetMapping("/view")
    public String view(HttpServletRequest request){
    	
    	String requestUrl = request.getRequestURI();
        // 또는
        // String requestUrl = request.getRequestURL().toString();
    	
        System.out.println("Request URL: " + requestUrl);
        return "test/testView";
    }
    
    @GetMapping("/hello")
    @ResponseBody
    public String hello(HttpServletRequest request){
    	
    	String requestUrl = request.getRequestURI();

    	System.out.println("가나다라 마바사");
        // 또는
        // String requestUrl = request.getRequestURL().toString();
    	
        System.out.println("Request URL: " + requestUrl);
        return "dddddd";
        
    }
    
   
    
    @GetMapping("/help")
    public String help(HttpServletRequest request){
    	
    	String requestUrl = request.getRequestURI();

    	System.out.println("가나다라 마바사");
        // 또는
        // String requestUrl = request.getRequestURL().toString();
    	
        System.out.println("Request URL: " + requestUrl);
        return "help";
        
    }
    
    //public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
    //    ResponseCookie cookie = ResponseCookie.from(name, value)
    //        .path("/")
    //        .sameSite("None")
    //        .httpOnly(false)
    //        .secure(true) -> secure 옵션을 true로 변경한다.
    //        .maxAge(maxAge)
    //        .build();
    //
    //    response.addHeader("Set-Cookie", cookie.toString());
    //}

 
    @RequestMapping("/th")
   public String thymeleafTest(Model model) {
       
       List<String> testList = new ArrayList<String>();
       testList.add("a");
       testList.add("b");
       testList.add("c");

       model.addAttribute("attr1", "������");
       model.addAttribute("attr2", testList);
      
       return "thymeleaf/testThymeleaf"; 
   }

    /**
   	 * 목록을 조회한다.
   	 * @param Map<String, Object> paramMap
   	 * @return List<Map<String, Object>>
   	 *
   	 */
    @GetMapping(value = "/selectList")
    @ResponseBody
    public List<Map<String, Object>> selectList(@RequestParam Map<String, Object> paramMap) throws Exception {
     List<Map<String, Object>> list = service.selectList(paramMap);
          
      String lang = (String) list.get(0).get("LANG");
      list.add(paramMap);
        
      return list;
    }
	
    
	@GetMapping("/uuid")
    @ResponseBody
    public String uuid() {
		 String uuid = UUID.randomUUID().toString();
    	return uuid;
    }

}