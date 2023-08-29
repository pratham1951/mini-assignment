package com.nagarro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AddController {
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("t1") int i,@RequestParam("t2") int j) 
//	HttpServletRequest request,HttpServletResponse response
	{
//		int i=Integer.parseInt(request.getParameter("t1"));
//		int j=Integer.parseInt(request.getParameter("t2"));
		
		int k=i+j;
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",k);
		
		return mv;
	}
	
	@RequestMapping("/sub")
	public ModelAndView sub(@RequestParam("t1") int i,@RequestParam("t2") int j) 
//	HttpServletRequest request,HttpServletResponse response
	{
//		int i=Integer.parseInt(request.getParameter("t1"));
//		int j=Integer.parseInt(request.getParameter("t2"));
		
		int k=i-j;
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",k);
		
		return mv;
	}
	@RequestMapping("/mul")
	public ModelAndView mul(@RequestParam("t1") int i,@RequestParam("t2") int j) 
//	HttpServletRequest request,HttpServletResponse response
	{
//		int i=Integer.parseInt(request.getParameter("t1"));
//		int j=Integer.parseInt(request.getParameter("t2"));
		
		int k=i*j;
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",k);
		
		return mv;
	}
	@RequestMapping("/divi")
	public ModelAndView divi(@RequestParam("t1") int i,@RequestParam("t2") int j) 
//	HttpServletRequest request,HttpServletResponse response
	{
//		int i=Integer.parseInt(request.getParameter("t1"));
//		int j=Integer.parseInt(request.getParameter("t2"));
		
		int k=i/j;
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",k);
		
		return mv;
	}
	

}
