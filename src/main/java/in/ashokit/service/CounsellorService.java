package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CounsellorEntity;
import in.ashokit.repo.Counsellorepo;
import in.asshokit.component.Dashboard;

@Service
public class CounsellorService
{
	@Autowired
	private Counsellorepo repo;
	
	public boolean savedetalis(CounsellorEntity counsellorEntity)
	{
		CounsellorEntity save = repo.save(counsellorEntity);
		return save.getCid()!=null;
	}
	public CounsellorEntity detalis(String email,String password)
	{
		return repo.findByEmailAndPassword(email, password);
	}
	
	
	

}
