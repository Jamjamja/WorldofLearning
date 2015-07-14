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

	@RequestMapping(value = "impressum")
	public String impressum() {
		return "home/impressum";
	}
	
	
	@RequestMapping(value = "chat")
	public String chat() {
		return "home/chat";
	}

	@RequestMapping(value = "anmelden", method = RequestMethod.GET)
	public ModelAndView anmelden(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "abmelden", required = false) String abmelden, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (abmelden != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("home/anmelden");

		return model;

	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

			String error = "Invalid username and password!";

		return error;
	}

}