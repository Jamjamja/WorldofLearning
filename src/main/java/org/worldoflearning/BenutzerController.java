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

	@RequestMapping("/benutzer/loeschen/{id}")
	public String loescheBenutzer(@PathVariable("id") int id) {

		this.benutzerService.loescheBenutzer(id);
		return "redirect:/";
	}

	@RequestMapping("/benutzer/bearbeiten/{id}")
	public String editbenutzer(@PathVariable("id") int id, Model model) {
		model.addAttribute("benutzer", this.benutzerService.findeBenutzerNachId(id));
		model.addAttribute("listbenutzers", this.benutzerService.listBenutzer());
		return "/";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		model.addAttribute("title", "Admin");
		model.addAttribute("message", "Admin Page - This is protected page!");
		return "login/admin";
	}

	@RequestMapping(value = "/anmelden", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("title", "Login");
		model.addAttribute("message", "Enter your username/password:");
		return "login/anmelden";
	}

	@RequestMapping(value = "/abmeldenErfolg", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "login/abmeldenErfolg";
	}

	@RequestMapping(value = "/BenutzerInfo", method = RequestMethod.GET)
	public String loginPage(Model model, Benutzer benutzer) {
		model.addAttribute("title", "User Info");

		String benuzterName = benutzer.getBenutzername();

		model.addAttribute("message", "User Info - This is protected page!. Hello " + benuzterName);

		return "benutzer/BenutzerInfo";
	}

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