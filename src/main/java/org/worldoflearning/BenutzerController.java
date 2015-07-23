package org.worldoflearning;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.worldoflearning.hibernate.model.Benutzer;
import org.worldoflearning.hibernate.serviceinterface.BenutzerService;

@Controller
@SessionAttributes("benutzer")
public class BenutzerController {

	@Autowired
	private BenutzerService benutzerService;

	@Autowired
	private HttpServletRequest request;

	@ModelAttribute("benutzer")
	public Benutzer getBenutzer() {
		return new Benutzer();
	}

	@Autowired(required = true)
	@Qualifier(value = "benutzerService")
	public void setBenutzerService(BenutzerService benutzerservice) {
		this.benutzerService = benutzerservice;
	}

	@RequestMapping(value = "listbenutzer", method = RequestMethod.GET)
	public String listBenutzer(Model model) {
		model.addAttribute("listbenutzer", new Benutzer());
		model.addAttribute("listbenutzer", this.benutzerService.listBenutzer());
		return "listbenutzer";
	}

	@RequestMapping(value = "/registrieren", method = RequestMethod.GET)
	public String registrieren() {
		return "login/registrieren";
	}

	// For add benutzer
	@RequestMapping(value = "/registrieren", method = RequestMethod.POST)
	public String registrieren(@Valid Benutzer benutzer,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasFieldErrors()) {
			return "login/registrieren";
		} else if (benutzerService.findeBenutzerNachName(benutzer
				.getBenutzername()) != null) {
			model.addAttribute("message",
					"User Name exists. Try another user name");
			return "login/registrieren";
		} else {
			benutzerService.hinzufuegenBenutzer(benutzer);
			model.addAttribute("success", "");
			return "redirect:anmelden";
		}

	}

	@RequestMapping("/benutzer/loeschen/{benutzername}")
	public String loescheBenutzer(
			@PathVariable("benutzername") String benutzername) {

		this.benutzerService.loescheBenutzer(benutzername);
		return "redirect:/";
	}

	@RequestMapping("/benutzerinfo")
	public Model benutzerinfo(String benutzer, Model model) {
		benutzer = request.getRemoteUser();
		model.addAttribute("benutzer/");
		model.addAttribute(benutzer);
		return model;
	}

	@RequestMapping(value = "/benutzerprofil", method = RequestMethod.GET)
	public String editbenutzer(Model model) {
        model.addAttribute("benutzer", this.benutzerService.findeBenutzerNachName(request.getRemoteUser()));
		return "benutzer/benutzerprofil";
	}

	@RequestMapping(value = "/benutzerprofil/edit", method = RequestMethod.POST)
	public String editbenutzer(@Valid Benutzer benutzer, BindingResult result) {
		if (result.hasFieldErrors()) {
			return "benutzer/benutzerprofil";
		}
		else {
		benutzerService.updateBenutzer(benutzer);
		return "benutzer/benutzerprofil";
		}
	}
}