package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.CounsellorEntity;
@Repository
public interface Counsellorepo extends JpaRepository<CounsellorEntity,Integer>
{
	public CounsellorEntity findByEmailAndPassword(String email,String password);

}
