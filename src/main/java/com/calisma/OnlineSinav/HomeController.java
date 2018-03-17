package com.calisma.OnlineSinav;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
	
		
		return "home";
	}
	
	@RequestMapping(value = "/sinavDuzenle", method = RequestMethod.POST)
	public String sinavDuzenle() {
	
		
		return "SinavDuzenle";
	}
	
	
}