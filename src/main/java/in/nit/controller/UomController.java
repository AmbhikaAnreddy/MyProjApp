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

import in.nit.model.Uom;
import in.nit.service.IUomService;
import in.nit.view.UomExcelView;
import in.nit.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;
	@RequestMapping("/register")
		public String showRegPage(Model model) {
		model.addAttribute("Uom",new Uom());
		return "UomRegister";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUom(@ModelAttribute Uom uom,Model model) {
		Integer id=service.saveUom(uom);
		String message="Uom'"+id+"'saved";
		model.addAttribute("message",message);
		model.addAttribute("Uom",new Uom());
		return "UomRegister";
	}
	@RequestMapping("/all")
	public String getAllUoms(Model model) {
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list",list);
		return "UomData";
	}
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("uid")Integer id,Model model) {
		service.deleteUom(id);
		String message="Uom'"+id+"'deleted";
		model.addAttribute("message",message);
		//fetch new data
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list",list);
		return "UomData";
	}
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("uid")Integer id,Model model) {
		Uom uom=service.getOneUom(id);
		model.addAttribute("Uom",uom);
		return "UomEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateUom(@ModelAttribute Uom uom,Model model) {
		service.updateUom(uom);
		String message="uom'"+uom.getUomId()+"'updated";
		model.addAttribute("message",message);
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list",list);
		return "UomData";
		
	}
	@RequestMapping("/view")
	public String showOneUom(@RequestParam("uid")Integer id,Model model) {
		Uom um=service.getOneUom(id);
		model.addAttribute("ob",um);
		return "UomView";
	}
     
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="id",required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new UomExcelView());
		if(id==null) {
			//export all rows
		List<Uom> list=service.getAllUoms();
		m.addObject("list",list);
		}
		else {
			//one row by id
			Uom um=service.getOneUom(id);
			m.addObject("list",Arrays.asList(um));
		}
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="id",required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new UomPdfView());
		if(id==null) {
			//export all rows
		List<Uom> list=service.getAllUoms();
		m.addObject("list",list);
		}
		else {
			//one row by id
			Uom um=service.getOneUom(id);
			m.addObject("list",Arrays.asList(um));
		}
		return m;
	}
	

	
}
