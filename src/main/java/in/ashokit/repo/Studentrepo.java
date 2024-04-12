package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import in.ashokit.entity.StudentEntity;
import in.asshokit.component.Dashboard;

public interface Studentrepo extends JpaRepository<StudentEntity, Integer>
{
	@Query(value="select count(*)from stud_tbl where cid=:cid",nativeQuery=true)
	public long getStudentenity(Integer cid);
	@Query(value="select count(*)from stud_tbl where cid=:cid and status=:status",nativeQuery=true)
	public long getenquires(Integer cid,String status);
	
	
	//public List<StudentEntity> getAllDetailsByCid(Integer cid);
	
	
	//public String editById(Integer sid);
  
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
