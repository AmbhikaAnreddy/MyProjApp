package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;
import in.nit.view.OrderMethodExcelView;
import in.nit.view.OrderMethodPdfView;

@Controller
@RequestMapping("/order")
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("OrderMethod",new OrderMethod());
		return "OrderMethodRegister";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	private String saveOrder(@ModelAttribute OrderMethod orderMethod,Model model) {
		Integer id=service.saveOrderMethod(orderMethod);
		String message="order method'"+id+"'saved";
		model.addAttribute("message",message);
		model.addAttribute("OrderMethod",new OrderMethod());
		return "OrderMethodRegister";
	}
     @RequestMapping("/all")
	public String getAllOrderMethodTypes(Model model) {
		List<OrderMethod> list=service.getAllOrderMethodTypes();
		model.addAttribute("list",list);
		return "OrderMethodData";
	}
     @RequestMapping("/delete")
     public String deleteOrder(@RequestParam("oid")Integer id,Model model) {
    	 service.deleteOrderMethod(id);
    	 String message="order'"+id+"'deleted";
    	 model.addAttribute("message",message);
    	 //fetch new data
 		List<OrderMethod> list=service.getAllOrderMethodTypes();
 		model.addAttribute("list",list);
 		return "OrderMethodData";
    }
     @RequestMapping("/edit")
     public String showEditPage(@RequestParam("oid")Integer id,Model model) {
    	 OrderMethod om=service.getOneOrderMethod(id);
    	 model.addAttribute("OrderMethod",om);
    	 return "OrderMethodEdit";
     }
     @RequestMapping(value="/update",method=RequestMethod.POST)
     public String updateOrderMethod(@ModelAttribute OrderMethod orderMethod,Model model) {
    	 service.updateOrderMethod(orderMethod);
    	 String message="OrderMethod'"+orderMethod.getOrderId()+"'updated";
    	 model.addAttribute("message",message);
    	 List<OrderMethod> list=service.getAllOrderMethodTypes();
    	 model.addAttribute("list",list);
    	 return "OrderMethodData";
     }
     @RequestMapping("/view")
     public String showOneOrder(@RequestParam("oid")Integer id,Model model) {
    	 OrderMethod om=service.getOneOrderMethod(id);
    	 model.addAttribute("ob",om);
    	 return "OrderMethodView";
     }
     @RequestMapping("/excel")
     public ModelAndView showExcel(@RequestParam(value="id",required=false)Integer id) {
    	 ModelAndView m=new ModelAndView();
    	 m.setView(new OrderMethodExcelView());
    	 if(id==null) {
    		 List<OrderMethod> list=service.getAllOrderMethodTypes();
    		 m.addObject("list",list);
    	 }
    	 else {
    		 OrderMethod om=service.getOneOrderMethod(id);
    	 m.addObject("list",Arrays.asList(om));
     }
     return m;
     } 
     @RequestMapping("/pdf")
     public ModelAndView showPdf(@RequestParam(value="id",required=false)Integer id) {
    	 ModelAndView m=new ModelAndView();
    	 m.setView(new OrderMethodPdfView());
    	 if(id==null) {
    		 List<OrderMethod> list=service.getAllOrderMethodTypes();
    		 m.addObject("list",list);
    	 }
    	 else {
    		 OrderMethod om=service.getOneOrderMethod(id);
    	 m.addObject("list",Arrays.asList(om));
     }
     return m;
     } 

}
