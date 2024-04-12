package in.ashokit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.entity.StudentEntity;
import in.ashokit.service.CounsellorService;
import in.ashokit.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @Autowired
    private CounsellorService service;

    @GetMapping("/addenquiry")
    public String showStudentForm(Model model) {
        model.addAttribute("eniqury", new StudentEntity());
        return "addenquiry";
    }
    @PostMapping("/addenquiry")
    public String saveStudentDetails(StudentEntity entity, Model model,  Integer cid ,HttpServletRequest req2) 
    {
    	HttpSession session = req2.getSession(false);
    	Integer cid1=(Integer)session.getAttribute("cid");
    	
    	
        boolean saved = studentService.savedetalis(entity, cid1);
        if (saved) {
            model.addAttribute("kmk", "Student details saved successfully");
        } else {
            model.addAttribute("emk", "Failed to save student details");
        }
        model.addAttribute("eniqury", new StudentEntity());
        return "addenquiry";
    }


    @GetMapping("/viewenquiry")
    public String getStudentDetails(Model model,HttpServletRequest req2) 
    {
    	HttpSession session = req2.getSession(false);
    	Integer cid=(Integer)session.getAttribute("cid");
        List<StudentEntity> studentList = studentService.getalldetalis(new StudentEntity(), cid);
        model.addAttribute("students", studentList);
        model.addAttribute("eniqury", new StudentEntity());
        return "viewenquiry";
    }
    
    @PostMapping("/viewenquiry")
    public String getByOptions(HttpServletRequest req2,Model model,StudentEntity entity)
    {
    	HttpSession session = req2.getSession(false);
    	Integer cid=(Integer)session.getAttribute("cid");
    	List<StudentEntity> studentList = studentService.getalldetalis(entity, cid);
    	if(studentList.isEmpty())
    	{
	         return null;
    	}
    	else
    	{
    	  model.addAttribute("eniqury", studentService.getalldetalis(entity, cid));
    	  model.addAttribute("students", studentList);
    	}
    	return "viewenquiry";
   }
    
    
//    @PostMapping("/viewenquiry")
//    public String getBySid(HttpServletRequest req2, Model model, StudentEntity entity) {
//        HttpSession session = req2.getSession(false);
//        Integer cid = (Integer) session.getAttribute("cid");
//        List<StudentEntity> filteredStudentList = studentService.getBySid(entity.getSid(), cid);
//        model.addAttribute("students", filteredStudentList);
//        return "viewenquiry";
//    }

   

   
//    @GetMapping("/edit")
//   public String editdetalis(@RequestParam("sid")Integer sid,Model model)
//   {
//	   StudentEntity student = studentService.getStudent(sid);
//	   model.addAttribute("studen", student);
//	   model.addAttribute("eniqury", new StudentEntity());
//	   return "addenquiry";
//   }
//    @GetMapping("/edit")
//    public String editDetails(@RequestParam("sid") Integer sid, Model model) {
//        StudentEntity student = studentService.getStudent(sid);
//        if (student == null) {
//           
//            return "error";
//        }
//        model.addAttribute("student", student);
//        return "addenquiry"; 
//    }
//    @GetMapping("/edit")
//    public String editStudent(Model model, Integer sid) {
//        StudentEntity student = studentService.editbyid(sid);
//        if (student == null) {
//            // Handle student not found case (e.g., return error view)
//            return "error";
//        }
//        model.addAttribute("editing", student);
//        return "addenquiry"; // Assuming the template view for editing
//    }
//   @GetMapping("/edit")
//    public String editStudentDetails( Integer sid, Model model) {
//        Optional<StudentEntity> studentOptional = Optional.ofNullable(studentService.findById(sid));
//        if (studentOptional.isPresent()) {
//            model.addAttribute("eniqury", studentOptional.get());
//            return "addenquiry";
//        } else {
//            
//            return "error"; 
//        }
//
//    
//    }
    
    @GetMapping("/edit")
    public String editStudentDetails(@RequestParam Integer sid, Model model) {
        try {
            StudentEntity student = studentService.findById(sid);
            model.addAttribute("eniqury", student); // Assuming it's "enquiry" not "eniqury"
            return "addenquiry";
        } catch (EntityNotFoundException e) {
            return "error"; 
        }
    }

    
    @GetMapping("/delete")
   public String deletedetalis(Integer sid,Model model)
   {
	   boolean delete = studentService.delete(sid);
	   if(delete)
	   {
		   return "viewenquiry";
	   }
	   return "error";
   }
   


    



     
}
