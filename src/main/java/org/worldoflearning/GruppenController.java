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
import org.worldoflearning.hibernate.serviceinterface.BenutzerService;
import org.worldoflearning.hibernate.serviceinterface.GruppeService;

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
		} else if (benutzer.getGruppe() != null) {
			gruppe = benutzer.getGruppe();
			return "gruppe/gruppenprofil";
		} else {
			return "gruppe/gruppe";
		}
	}

	// For add Gruppe
	@RequestMapping(value = "/gruppe", method = RequestMethod.POST)
	public String registrieren(@Valid Gruppe gruppe, Benutzer benutzer, BindingResult bindingResult, Model model) {

		benutzer = benutzerService.findeBenutzerNachName(httpServletRequest
				.getRemoteUser());
		if (bindingResult.hasFieldErrors()) {
			return "gruppe/gruppe";
		} else if (gruppeService.findeGruppeNachName(gruppe.getGruppenname()) != null) {
			model.addAttribute("message", "Gruppenname bereits vergeben.");
			return "gruppe/gruppe";
		} else if (benutzer.getGruppe() != null) {
			gruppe = benutzer.getGruppe();
			return "gruppe/gruppenprofil";
		} else {
			gruppe.setModerator(benutzer);
			gruppeService.hinzufuegenGruppe(gruppe);

			benutzer.setGruppe(gruppe);
			benutzerService.updateBenutzer(benutzer);
			return "gruppe/gruppenprofil";
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
		return "gruppe/gruppenprofil";
	}
	
	@RequestMapping(value = "listGruppeBenutzer", method = RequestMethod.GET)
	public String listGruppeBenutzer(Model model, String gruppenname, Benutzer benutzer) {
		benutzer = benutzerService.findeBenutzerNachName(request.getRemoteUser());
		gruppenname = benutzer.getGruppe().getGruppenname();
		
		model.addAttribute("listGruppeBenutzer", new Benutzer());
		model.addAttribute("listGruppeBenutzer", this.gruppeService.findeGruppeNachName(gruppenname));
		return "listGruppeBenutzer";
	}
	
	@RequestMapping(value = "listbenutzer", method = RequestMethod.GET)
	public String listBenutzers(Model model) {
		model.addAttribute("listbenutzer", new Benutzer());
		model.addAttribute("listbenutzer", this.benutzerService.listBenutzer());
		return "listbenutzer";
	}
	
}
