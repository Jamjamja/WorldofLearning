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

	@RequestMapping(value = "/benutzer/list", method = RequestMethod.GET)
	public String listBenutzers(Model model) {
		model.addAttribute("listbenutzer", new Benutzer());
		model.addAttribute("listbenutzer", this.benutzerService.listBenutzer());
		return "listbenutzer";
	}

	@RequestMapping(value = "/registrieren", method = RequestMethod.GET)
	public String registrieren(Model model) {
		model.addAttribute(new Benutzer());
		return "login/registrieren";
	}

	// For add and update benutzer both
	@RequestMapping(value = "/registrieren", method = RequestMethod.POST)
	public String registrieren(@Valid @ModelAttribute("benutzer") Benutzer benutzer, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "login/registrieren";
		} else if (benutzerService.findeBenutzerNachName(benutzer.getBenutzername()) != null) {
			model.addAttribute("message", "User Name exists. Try another user name");
			return "login/registrieren";
		} else {
			benutzerService.hinzufuegenBenutzer(benutzer);
			return "redirect:anmelden";
		}

	}

	@RequestMapping("/benutzer/loeschen/{benutzername}")
	public String loescheBenutzer(@PathVariable("benutzername") String benutzername) {

		this.benutzerService.loescheBenutzer(benutzername);
		return "redirect:/";
	}

	@RequestMapping("/benutzer/bearbeiten/{benutzername}")
	public String editbenutzer(@PathVariable("benutzername") String benutzername, Model model) {
		model.addAttribute("benutzer", this.benutzerService.findeBenutzerNachName(benutzername));
		model.addAttribute("listbenutzers", this.benutzerService.listBenutzer());
		return "/";
	}

}