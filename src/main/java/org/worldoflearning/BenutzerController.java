package org.worldoflearning;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

	@RequestMapping(value = "/benutzer/list", method = RequestMethod.GET)
	public String listBenutzers(Model model) {
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
	public String editbenutzer() {
		return "benutzer/benutzerprofil";
	}

	@RequestMapping(value = "/benutzerprofil/edit", method = RequestMethod.POST)
	public String editbenutzer(@Valid Benutzer benutzer, String benutzername,
			BindingResult result, Model model) {
		benutzerService.updateBenutzer(benutzer);
		return "redirect:/benutzerprofil";

	}

	// @RequestMapping("/benutzerinfo/edit")
	// public String editbenutzer(
	// @PathVariable("benutzername") String benutzername, Model model) {
	// benutzername = request.getRemoteUser();
	// model.addAttribute("benutzer",
	// this.benutzerService.findeBenutzerNachName(benutzername));
	// model.addAttribute("listbenutzers", this.benutzerService.listBenutzer());
	// return "benutzer/benutzerprofil";
	// }

}