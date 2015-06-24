package org.worldoflearning;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String home() {
		return "index";
	}

	@RequestMapping(method = RequestMethod.GET)
	public Model navigation(
			@RequestParam(value = "link", required = true, defaultValue = "/") String link,
			Model model) {
		return model.addAttribute("link", link);  
		
	}
}