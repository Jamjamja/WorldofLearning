package org.worldoflearning;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.worldoflearning.hibernate.model.Test;
import org.worldoflearning.hibernate.serviceinterface.TestService;

@Controller
@SessionAttributes("test") //diese Zeile ist optional
public class TestController {

	@Autowired
	private TestService testService;
	
	@Autowired(required = true)
	@Qualifier(value = "testService")
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
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
	
 
	// For add and update Chatbeitrag both
	@RequestMapping(value = "/test/add", method = RequestMethod.POST)
	public String test(@ModelAttribute("test") Test test, BindingResult result) {
		testService.erstelleTest(test);
        return "redirect:";
    }
	
	
	

}