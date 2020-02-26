package in.nit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.model.OrderMethod;

@Controller
@RequestMapping("/order")
public class OrderMethodController {
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("OrderMethod",new OrderMethod());
		return "OrderMethodRegister";
	}

}
