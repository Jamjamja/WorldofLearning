package org.worldoflearning;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.worldoflearning.hibernate.model.Benutzer;

@Controller
public class AnmeldenController {

	@ModelAttribute("benutzer")
	public Benutzer getBenutzer() {
		return new Benutzer();
	}

	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		model.addAttribute("title", "Admin");
		model.addAttribute("message", "Admin Page - This is protected page!");
		return "login/admin";
	}

	@RequestMapping(value = "/anmelden", method = RequestMethod.GET)
	public String anmelden() {
		return "login/anmelden";
	}

	
	@RequestMapping(value = "/benutzerinfo", method = RequestMethod.GET)
	public String loginPage(Model model, HttpServletRequest request) {
		model.addAttribute("title", "User Info");

		String benuzterName = request.getUserPrincipal().getName();

		model.addAttribute("message", "User Info - This is protected page!. Hello " + benuzterName);

		return "benutzer/benutzerinfo";
	}

	// for 403 access denied page
	@RequestMapping(value = "/error/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Benutzer benutzer) {
		model.addAttribute("title", "Access Denied!");

		if (benutzer != null) {
			model.addAttribute("message",
					"Hi " + benutzer.getBenutzername() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		return "error/403";
	}

}
