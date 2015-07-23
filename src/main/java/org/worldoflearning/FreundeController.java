package org.worldoflearning;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.worldoflearning.hibernate.model.Benutzer;
import org.worldoflearning.hibernate.serviceinterface.BenutzerService;

@Controller
public class FreundeController {

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

	@RequestMapping(value = "/freunde/add/{freundename}", method = RequestMethod.GET)
	public String hinzufuegenfreunde(Benutzer benutzer, Benutzer freund,
			@PathVariable("freundename") String freundename) {
		benutzer = benutzerService.findeBenutzerNachName(request
				.getRemoteUser());
		freund = benutzerService.findeBenutzerNachName(freundename);
		benutzer.getFreunde().add(freund);
		freund.getFreundeVon().add(benutzer);
		benutzerService.updateBenutzer(benutzer);
		benutzerService.updateBenutzer(freund);
		return "benutzer/freundeliste";
	}

	@RequestMapping(value = "/freunde/undo/{freundename}", method = RequestMethod.GET)
	public String loeschenfreunde(Benutzer benutzer, Benutzer freund,
			@PathVariable("freundename") String freundename) {
		benutzer = benutzerService.findeBenutzerNachName(request
				.getRemoteUser());
		freund = benutzerService.findeBenutzerNachName(freundename);
		benutzer.getFreunde().remove(freund);
		freund.getFreundeVon().remove(benutzer);
		benutzerService.updateBenutzer(benutzer);
		benutzerService.updateBenutzer(freund);
		return "benutzer/freundeliste";
	}

	@RequestMapping(value = "/freunde", method = RequestMethod.GET)
	public String registrieren(Model model, Benutzer benutzer) {
		listFreunde(model, benutzer);
		listkeineFreunde(model, benutzer);
		listBenutzer(model);
		return "benutzer/freundeliste";
	}

	public Model listBenutzer(Model model) {
		model.addAttribute("listBenuzter", new Benutzer());
		model.addAttribute("listBenuzter", this.benutzerService.listBenutzer());
		return model;
	}

	public Model listFreunde(Model model, Benutzer benutzer) {
		benutzer = benutzerService.findeBenutzerNachName(request
				.getRemoteUser());
		model.addAttribute("listFreunde", new Benutzer());
		model.addAttribute("listFreunde",
				this.benutzerService.listBenutzer(benutzer));
		return model;
	}

	public Model listkeineFreunde(Model model, Benutzer benutzer) {
		benutzer = benutzerService.findeBenutzerNachName(request
				.getRemoteUser());
		model.addAttribute("listkeineFreunde", new Benutzer());
		model.addAttribute("listkeineFreunde",
				this.benutzerService.listnichtBenutzer(benutzer));
		return model;
	}

}
