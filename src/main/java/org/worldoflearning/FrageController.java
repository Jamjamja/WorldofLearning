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
import org.worldoflearning.hibernate.model.Frage;
import org.worldoflearning.hibernate.service.FrageService;

@Controller
@SessionAttributes("frage") //diese Zeile ist optional
public class FrageController {

	@Autowired
	private FrageService frageService;
	
	
	//diese  Methode kommt an den Anfang
	@ModelAttribute("frage")
    public Frage getFrage() {
        return new Frage();
	}
	
	//nimmt Anfrage von Navigation entgegen
	@RequestMapping(value = "/frage")
	public String frage() {
		return "test/frage";
	}
	

	
	@Autowired(required = true)
	@Qualifier(value = "frageService")
	public void setFrageService(FrageService frageService) {
		this.frageService = frageService;
	}
 
	// For add and update Chatbeitrag both
	@RequestMapping(value = "/frage/add", method = RequestMethod.POST)
	public String frage(@ModelAttribute("frage") Frage frage, BindingResult result,
			Model model) {
		frageService.erstelleFrage(frage);
        return "redirect:";
    }

}