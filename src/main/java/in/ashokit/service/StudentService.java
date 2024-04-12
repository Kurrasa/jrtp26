package in.ashokit.service;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import in.ashokit.entity.CounsellorEntity;
import in.ashokit.entity.StudentEntity;
import in.ashokit.repo.Counsellorepo;
import in.ashokit.repo.Studentrepo;
import in.asshokit.component.Dashboard;
import jakarta.persistence.EntityNotFoundException;


@Service
public class StudentService 
{
	@Autowired
    private Studentrepo repo;
	@Autowired
	private Counsellorepo repo1;
	
	public boolean savedetalis(StudentEntity entity,Integer cid)
	{
		CounsellorEntity counsellorEntity = repo1.findById(cid).orElseThrow();
		entity.setCounsellorEntity(counsellorEntity);
		StudentEntity save = repo.save(entity);
		if(save.getSid()!=null)
		{
			return true;
		}
		return false;
	}
	
	
	public List<StudentEntity>getalldetalis(StudentEntity entity, Integer cid)
	{
		
		Optional<CounsellorEntity> byId = repo1.findById(cid);
		if(byId.isPresent())
		{
			CounsellorEntity counsellorEntity = byId.get();
			entity.setCounsellorEntity(counsellorEntity);
			Example<StudentEntity> of = Example.of(entity);
		     List<StudentEntity> all = repo.findAll(of);
		     System.out.println(all);
		     return all;
		}
		else
		{
			return Collections.emptyList();
		}
		
	
	}
	
	 public StudentEntity getStudent(Integer cid){
	        return repo.findById(cid).orElse(null);
	    }
	

	public Dashboard getDashboard(Integer cid)
	{
		long TotalEnquires = repo.getStudentenity(cid);
		long OpenEnquires = repo.getenquires(cid, "open");
		long LostEnquires  = repo.getenquires(cid, "lost");
		long EnrolledEnquires = repo.getenquires(cid, "enrolled");
		Dashboard dashboard=new Dashboard();
		dashboard.setTotalEnquires(TotalEnquires);
		dashboard.setOpenEnquires(OpenEnquires);
		dashboard.setLostEnquires(LostEnquires);
		dashboard.setEnrolledEnquires(EnrolledEnquires);
		return dashboard;
	}
    
	
	public boolean filterbyoptions(StudentEntity entity)
	{
	
		StudentEntity save = repo.save(entity);
		if(save.getCoursename()!=null && save.getClassmode()!=null && save.getStatus()!=null)
		{
			return true;
		}
		
		return false;
		
	}
	
	public StudentEntity findById(Integer sid) 
	{
		  Optional<StudentEntity> studentOptional = repo.findById(sid);
		  if (studentOptional.isPresent()) 
		  {
		    return studentOptional.get();
		  } else 
		  {
		    
		    throw new EntityNotFoundException("Student with ID " + sid + " not found");
		  }
	}
	public boolean delete(Integer sid)
	{
	    Optional<StudentEntity> byId = repo.findById(sid);
	    if(byId.isPresent())
	    {
	    	repo.deleteById(sid);
	    	return true;
	    }
	    return false;
	}

}

