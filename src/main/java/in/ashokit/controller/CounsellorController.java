package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.CounsellorEntity;
import in.ashokit.service.CounsellorService;
import in.ashokit.service.StudentService;
import in.asshokit.component.Dashboard;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@Controller
public class CounsellorController 
{
	@Autowired
	private CounsellorService sevice;
	@Autowired
	private StudentService service;
	
	@GetMapping("/loginform")
	public String Login(Model model)
	{
		model.addAttribute("entit", new CounsellorEntity());
		return "loginform";
	}
	@PostMapping("/loginform")
	public String loginHolder(CounsellorEntity entity, Model model,HttpServletRequest req) 
	{
		
	    CounsellorEntity details = sevice.detalis(entity.getEmail(), entity.getPassword());
	    if (details == null) {
	        model.addAttribute("erm", "Invalid details");
	        return "loginform";
	    } else {
	    	HttpSession session = req.getSession(true);
			session.setAttribute("cid", details.getCid());
			
			Dashboard dashboard = service.getDashboard(details.getCid());
			model.addAttribute("dashboard", dashboard);

	        model.addAttribute("entit", new CounsellorEntity());
	        model.addAttribute("details", details);
	        return "dashboard";
	    }
	}

	
	
	@GetMapping("/register")
	public String register(Model model)
	{
		model.addAttribute("entity", new CounsellorEntity());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerhandel(CounsellorEntity entity ,Model model)
	{
		boolean savedetalis = sevice.savedetalis(entity);
		if(savedetalis)
		{
			model.addAttribute("msg1", "registeration sucessful");
		}
		else
		{
			model.addAttribute("emsg2", "user registertionfail");
		}
		model.addAttribute("entity", new CounsellorEntity());
		return "register";
	}	
}
