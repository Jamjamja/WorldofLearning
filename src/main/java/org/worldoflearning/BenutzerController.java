package org.worldoflearning;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.worldoflearning.hibernate.model.Benutzer;
import org.worldoflearning.hibernate.service.BenutzerService;

@Controller
@SessionAttributes("benutzer")
public class BenutzerController {

	private BenutzerService benutzerService;

	@Autowired(required = true)
	@Qualifier(value = "benutzerService")
	public void setBenutzerService(BenutzerService bs) {
		this.benutzerService = bs;
	}

	@RequestMapping(value = "/benutzer", method = RequestMethod.GET)
	public String listBenutzers(Model model) {
		model.addAttribute("benutzer", new Benutzer());
		model.addAttribute("listbenutzers", this.benutzerService.listBenutzer());
		return "benutzer";
	}

	@RequestMapping(value = "/registrieren", method = RequestMethod.GET)
	public String registrieren(Model model) {
		Benutzer benutzer = new Benutzer();
		model.addAttribute("benutzer", benutzer);
		return "registrieren/registrieren";
	}

	// For add and update benutzer both
	@RequestMapping(value = "/registrieren", method = RequestMethod.POST)
	public String registreiern(@ModelAttribute("benutzer") Benutzer b, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "registrieren";
    } else if(benutzerService.findeBenutzerNachName(b.getName())) {
        model.addAttribute("message", "User Name exists. Try another user name");
        return "registrierung";
    } else {
        benutzerService.hinzufuegenBenutzer(b);
        model.addAttribute("message", "Saved student details");
        return "redirect:anmelden/anmelden";
    }
	}

	@RequestMapping("/remove/{id}")
	public String loescheBenutzer(@PathVariable("id") int id) {

		this.benutzerService.loescheBenutzer(id);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public String editbenutzer(@PathVariable("id") int id, Model model) {
		model.addAttribute("benutzer",
				this.benutzerService.findeBenutzerNachId(id));
		model.addAttribute("listbenutzers", this.benutzerService.listBenutzer());
		return "/";
	}

}
