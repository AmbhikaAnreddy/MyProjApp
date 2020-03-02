package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.WhUserType;
import in.nit.service.IWhUserTypeService;

@Controller
@RequestMapping("/user")
public class WhUserTypeController {
	@Autowired
	private IWhUserTypeService service;
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("WhUserType",new WhUserType());
		return "WhUserTypeRegister";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveWhUser(@ModelAttribute WhUserType whUserType,Model model) {
		Integer id=service.saveWhUserType(whUserType);
		String message="WhUserType'"+id+"'saved";
		model.addAttribute("message",message);
		model.addAttribute("WhUserType",new WhUserType());
		return "WhUserTypeRegister";
		
	}
	@RequestMapping("/all")
	public String getAllWhUserTypes(Model model) {
		List<WhUserType> list=service.getAllWhUserTypes();
		model.addAttribute("list",list);
		return "WhUserTypeData";
	}
	@RequestMapping("/delete")
	public String deleteWhUser(@RequestParam("uid")Integer id,Model model){
		service.deleteWhUserType(id);
		String message="WhUser'"+id+"'deleted";
		model.addAttribute("message",message);
		//fetch new data
		List<WhUserType> list=service.getAllWhUserTypes();
		model.addAttribute("list",list);
		return "WhUserTypeData";
	}
	   @RequestMapping("/edit")
	  public String showEditPage(@RequestParam("uid")Integer id,Model model) {
		  WhUserType wh=service.getOneWhUserType(id);
		  model.addAttribute("WhUserType",wh);
		  return "WhUserTypeEdit";
	  }
	   @RequestMapping(value="/update",method=RequestMethod.POST)
	   public String updateWhUserType(@ModelAttribute WhUserType whUserType,Model model) {
		   service.updateWhUserType(whUserType);
		   String message="WhUserType'"+whUserType.getUserId()+"'updated";
		   model.addAttribute("message",message);
		   List<WhUserType> list=service.getAllWhUserTypes();
		   model.addAttribute("list",list);
		   return "WhUserTypeData";
	   }
	   @RequestMapping("/view")
	   public String showOneShipment(@RequestParam("uid")Integer id,Model model) {
		   WhUserType wh=service.getOneWhUserType(id);
		   model.addAttribute("ob",wh);
		   return "WhUserTypeView";
	   }

}
