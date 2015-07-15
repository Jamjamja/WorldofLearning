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
import org.worldoflearning.hibernate.model.Benutzer;
import org.worldoflearning.hibernate.model.Chatbeitrag;
import org.worldoflearning.hibernate.service.ChatbeitragService;

@Controller
@SessionAttributes("chatbeitrag")
public class ChatController {

	private ChatbeitragService chatbeitragService;
	
	@ModelAttribute("chatbeitrag")
    public Chatbeitrag getChatbeitrag() {
        return new Chatbeitrag();
	}
	
	@Autowired(required = true)
	@Qualifier(value = "chatbeitragService")
	public void setChatbeitragService(ChatbeitragService chatbeitragservice) {
		this.chatbeitragService = chatbeitragservice;
	}

	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String listChat(Model model) {
		 model.addAttribute("listChat", new Chatbeitrag());
		 model.addAttribute("listChat",
		 this.chatbeitragService.listChat());
		return "home/chat";
	}

 
	
	// For add and update Chatbeitrag both
	@RequestMapping(value = "/chat/add", method = RequestMethod.POST)
	public String chatbeitrag(@ModelAttribute("chatbeitrag") Chatbeitrag chatbeitrag, BindingResult result,
			Model model) {
		chatbeitragService.erstelleChatbeitrag(chatbeitrag);
        return "redirect:";
    }

}