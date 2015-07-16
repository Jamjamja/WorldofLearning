package org.worldoflearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.worldoflearning.hibernate.model.Thema;
import org.worldoflearning.hibernate.service.ThemaService;

@Controller
@SessionAttributes("beitrag")
public class ThemaController {

	private ThemaService themaService;

	@ModelAttribute("thema")
	public Thema getThema() {
		return new Thema();
	}

	@Autowired(required = true)
	@Qualifier(value = "themaService")
	public void setThemaService(ThemaService themaservice) {
		this.themaService = themaservice;
	}

	@RequestMapping(value = "/thema", method = RequestMethod.GET)
	public String listBeitrag(Model model) {
		model.addAttribute("listThema", new Thema());
		model.addAttribute("listThema", this.themaService.listThema());
		return "forum/thema";
	}

	// For add Beitrag
	@RequestMapping(value = "/thema/add", method = RequestMethod.POST)
	public String beitrag(
			@ModelAttribute("thema") Thema thema,
			BindingResult result, Model model) {
		themaService.erstelleThema(thema);
		return "redirect:";
	}

}