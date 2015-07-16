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
import org.worldoflearning.hibernate.model.Beitrag;
import org.worldoflearning.hibernate.service.BeitragService;

@Controller
@SessionAttributes("beitrag")
public class BeitragController {

	private BeitragService beitragService;

	@ModelAttribute("beitrag")
	public Beitrag getBeitrag() {
		return new Beitrag();
	}

	@Autowired(required = true)
	@Qualifier(value = "beitragService")
	public void setBeitragService(BeitragService beitragservice) {
		this.beitragService = beitragservice;
	}

	@RequestMapping(value = "/beitrag", method = RequestMethod.GET)
	public String listBeitrag(Model model) {
		model.addAttribute("listBeitrag", new Beitrag());
		model.addAttribute("listBeitrag", this.beitragService.listBeitrag());
		return "forum/beitrag";
	}

	// For add Beitrag
	@RequestMapping(value = "/beitrag/add", method = RequestMethod.POST)
	public String beitrag(
			@ModelAttribute("beitrag") Beitrag beitrag,
			BindingResult result, Model model) {
		beitragService.erstelleBeitrag(beitrag);
		return "redirect:";
	}

}