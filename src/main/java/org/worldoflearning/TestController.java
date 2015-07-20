package org.worldoflearning;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.worldoflearning.hibernate.model.Frage;
import org.worldoflearning.hibernate.model.Test;
import org.worldoflearning.hibernate.service.FrageService;
import org.worldoflearning.hibernate.service.TestService;

@Controller
@SessionAttributes("test") //diese Zeile ist optional
public class TestController {

	private TestService testService;
	
	//diese  Methode kommt an den Anfang
	@ModelAttribute("test")
    public Test getTest() {
        return new Test();
	}
	
	//nimmt Anfrage von Navigation entgegen
	@RequestMapping(value = "/test")
	public String test() {
		return "test/test";
	}
	

	
	@Autowired(required = true)
	@Qualifier(value = "test")
	public void setTestService(Test test) {
		this.testService = testService;
	}
 
	// For add and update Chatbeitrag both
	@RequestMapping(value = "/test/add", method = RequestMethod.POST)
	public String test(@ModelAttribute("test") Test test, BindingResult result,
			Model model) {
		testService.erstelleTest(test);
        return "redirect:";
    }

}