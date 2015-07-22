package org.worldoflearning;

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
import org.worldoflearning.hibernate.model.Beitrag;
import org.worldoflearning.hibernate.model.Thema;
import org.worldoflearning.hibernate.serviceinterface.BeitragService;
import org.worldoflearning.hibernate.serviceinterface.ThemaService;

@Controller
public class BeitragController {

	@Autowired
	private BeitragService beitragService;
	@Autowired
	private ThemaService themaService;

	@ModelAttribute("beitrag")
	public Beitrag getBeitrag() {
		return new Beitrag();
	}

	@ModelAttribute("thema")
	public Thema getThema() {
		return new Thema();
	}

	@Autowired(required = true)
	@Qualifier(value = "beitragService")
	public void setBeitragService(BeitragService beitragservice) {
		this.beitragService = beitragservice;
	}

	@RequestMapping(value = "/thema/{thema_id}/beitrag", method = RequestMethod.GET)
	public String listBeitrag(@PathVariable("thema_id") int thema_id, Thema thema, Model model) {
		thema = themaService.findeThemanachID(thema_id);
		model.addAttribute("listBeitrag", new Beitrag());
		model.addAttribute("listBeitrag",
				this.beitragService.listBeitrag(thema));
		return "forum/thema";
	}

	// For add Beitrag
	@RequestMapping(value = "/thema/{thema_id}/beitrag/add", method = RequestMethod.POST)
	public String beitrag(@PathVariable("thema_id") int thema_id,
			@Valid Beitrag beitrag, Thema thema, BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			return "/thema/{thema_id}/beitrag/";
		} else {
			thema = themaService.findeThemanachID(thema_id);
			beitrag.setThema(thema);
			beitragService.erstelleBeitrag(beitrag);
			return "redirect:";
		}
	}

}