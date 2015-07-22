package org.worldoflearning;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.worldoflearning.hibernate.model.Thema;
import org.worldoflearning.hibernate.serviceinterface.ThemaService;

@Controller
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

	@RequestMapping(value = "/forum", method = RequestMethod.GET)
	public String listThema(Model model) {
		model.addAttribute("listThema", new Thema());
		model.addAttribute("listThema", this.themaService.listThema());
		return "forum/forum";
	}

	// For add Thema
	@RequestMapping(value = "/forum/add", method = RequestMethod.POST)
	public String beitrag(@Valid Thema thema, BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			return "forum/forum";
		} else {
			themaService.erstelleThema(thema);
			return "redirect:";
		}
	}

}