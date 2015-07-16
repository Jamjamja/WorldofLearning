package org.worldoflearning;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String home() {
		return "home/index";
	}

	@RequestMapping(value = "/impressum")
	public String impressum() {
		return "home/impressum";
	}
	
	
	@RequestMapping(value = "/chat")
	public String chat() {
		return "home/chat";
	}


	
}