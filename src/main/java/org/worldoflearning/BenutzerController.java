package org.worldoflearning;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.worldoflearning.hibernate.model.Benutzer;
import org.worldoflearning.hibernate.model.Chatbeitrag;
import org.worldoflearning.hibernate.service.BenutzerService;

@Controller
@SessionAttributes("benutzer")
public class BenutzerController {

	private BenutzerService benutzerService;

	@ModelAttribute("benutzer")
	public Benutzer getBenutzer() {
		return new Benutzer();
	}

	@Autowired(required = true)
	@Qualifier(value = "benutzerService")
	public void setBenutzerService(BenutzerService benutzerservice) {
		this.benutzerService = benutzerservice;
	}

	@RequestMapping(value = "benutzer/list", method = RequestMethod.GET)
	public String listBenutzers(Model model) {
		model.addAttribute("listbenutzer", new Benutzer());
		model.addAttribute("listbenutzer", this.benutzerService.listBenutzer());
		return "listbenutzer";
	}

	@RequestMapping(value = "registrieren", method = RequestMethod.GET)
	public String registrieren(Model model) {
		model.addAttribute(new Benutzer());
		return "login/registrieren";
	}

	// For add and update benutzer both
	@RequestMapping(value = "registrieren", method = RequestMethod.POST)
	public String registrieren(@Valid @ModelAttribute("benutzer") Benutzer benutzer, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "registrieren";
		}

		/*
		 * else
		 * if(benutzerService.findeBenutzerNachName(benutzer.getBenutzername()))
		 * { model.addAttribute("message",
		 * "User Name exists. Try another user name"); return "registrierung";}
		 */ else {
			benutzerService.hinzufuegenBenutzer(benutzer);
			return "redirect:anmelden";
		}
	}

	@RequestMapping("benutzer/loeschen/{id}")
	public String loescheBenutzer(@PathVariable("id") int id) {

		this.benutzerService.loescheBenutzer(id);
		return "redirect:/";
	}

	@RequestMapping("benutzer/bearbeiten/{id}")
	public String editbenutzer(@PathVariable("id") int id, Model model) {
		model.addAttribute("benutzer", this.benutzerService.findeBenutzerNachId(id));
		model.addAttribute("listbenutzers", this.benutzerService.listBenutzer());
		return "/";
	}

	
	@RequestMapping(value = "anmelden", method = RequestMethod.GET)
	public String anmelden(Model model) {
		model.addAttribute(new Benutzer());
		return "login/anmelden";
	}
	
	@RequestMapping(value = "anmelden", method = RequestMethod.POST)
	public ModelAndView anmelden(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "abmelden", required = false) String abmelden, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (abmelden != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login/anmelden");

		return model;

	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "Invalid username and password!";

		return error;
	}

}