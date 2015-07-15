package org.worldoflearning;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.worldoflearning.hibernate.model.Benutzer;
import org.worldoflearning.hibernate.service.BenutzerService;


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