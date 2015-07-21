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
import org.worldoflearning.hibernate.model.Gruppe;
import org.worldoflearning.hibernate.service.BenutzerService;
import org.worldoflearning.hibernate.service.GruppeService;

@Controller
@SessionAttributes("gruppe")
public class GruppenController {

	@Autowired
	private GruppeService gruppeService;

	@Autowired
	private BenutzerService benutzerService;

	@Autowired
	private HttpServletRequest httpServletRequest;

	@Autowired
	private HttpServletRequest request;

	@ModelAttribute("gruppe")
	public Gruppe getGruppe() {
		return new Gruppe();
	}

	@Autowired(required = true)
	@Qualifier(value = "gruppeService")
	public void setGruppeService(GruppeService gruppeservice) {
		this.gruppeService = gruppeservice;
	}

	@RequestMapping(value = "/gruppe", method = RequestMethod.GET)
	public String listGruppe(Model model, Benutzer benutzer, Gruppe gruppe) {

		benutzer = benutzerService.findeBenutzerNachName(httpServletRequest
				.getRemoteUser());
		gruppe = benutzer.getGruppe();

		if (gruppe == null) {
			model.addAttribute("listGruppe", new Gruppe());
			model.addAttribute("listGruppe", this.gruppeService.listGruppe());
			return "gruppe/gruppe";
		} else {
			return "gruppe/gruppe";
		}
	}

	// For add benutzer
	@RequestMapping(value = "/gruppe", method = RequestMethod.POST)
	public String registrieren(@Valid @ModelAttribute("gruppe") Gruppe gruppe,
			Benutzer benutzer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "gruppe/gruppe";
		} else if (gruppeService.findeGruppeNachName(gruppe.getGruppenname()) != null) {
			model.addAttribute("message", "Gruppenname bereits vergeben.");
			return "gruppe/gruppe";
		} else {
			gruppeService.hinzufuegenGruppe(gruppe);
			benutzer = benutzerService.findeBenutzerNachName(httpServletRequest
					.getRemoteUser());
			benutzer.setGruppe(gruppe);
			benutzerService.updateBenutzer(benutzer);
			return "redirect:gruppe";
		}

	}

	@RequestMapping("/gruppe/loeschen/{gruppenname}")
	public String loescheBenutzer(
			@PathVariable("gruppenname") String gruppenname) {

		this.gruppeService.loescheGruppe(gruppenname);
		return "redirect:/";
	}

	@RequestMapping("/gruppe/{gruppenname}/beitreten")
	public String beitretenGruppe(
			@PathVariable("gruppenname") String gruppenname, Benutzer benutzer,
			Gruppe gruppe) {

		gruppe = gruppeService.findeGruppeNachName(gruppenname);
		benutzer = benutzerService.findeBenutzerNachName(httpServletRequest
				.getRemoteUser());
		benutzer.setGruppe(gruppe);
		benutzerService.updateBenutzer(benutzer);
		return "redirect:/gruppe/{gruppenname}";
	}

	// @RequestMapping("/gruppeninfo")
	// public Model benutzerinfo(String gruppe, Model model) {
	// gruppe = request.getRemoteUser();
	// model.addAttribute("gruppe/");
	// model.addAttribute(gruppe);
	// return model;
	// }
	//
	//
	// @RequestMapping(value = "/benutzerprofil", method = RequestMethod.GET)
	// public String editbenutzer(Model model) {
	// model.addAttribute(new Gruppe());
	// return "benutzer/benutzerprofil";
	// }
	//
	// @RequestMapping(value = "/benutzerprofil/edit", method =
	// RequestMethod.POST)
	// public String editbenutzer(
	// @Valid @ModelAttribute("benutzer") Gruppe benutzer,
	// String benutzername, BindingResult result, Model model) {
	// gruppeService.updateBenutzer(benutzer);
	// return "redirect:/benutzerprofil";
	//
	// }

}
