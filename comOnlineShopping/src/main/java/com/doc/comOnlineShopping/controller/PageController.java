package com.doc.comOnlineShopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = {"/","/home","/page"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickHome" , true);
		mv.addObject("title" , "Home");
		return mv;
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAbout" , true);
		mv.addObject("title" , "About-Us");
		return mv;
	}
	
	@RequestMapping(value = {"/contactUs"})
	public ModelAndView contactUs() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickContact" , true);
		mv.addObject("title" , "Contact-Us");
		return mv;
	}
}
