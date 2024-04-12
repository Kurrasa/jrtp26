package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="stud_tbl")
public class StudentEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sid;
	private String name;
	private Integer phone;
	private String coursename;
	private String classmode;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="cid")
	private CounsellorEntity counsellorEntity;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getClassmode() {
		return classmode;
	}

	public void setClassmode(String classmode) {
		this.classmode = classmode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CounsellorEntity getCounsellorEntity() {
		return counsellorEntity;
	}

	public void setCounsellorEntity(CounsellorEntity counsellorEntity) {
		this.counsellorEntity = counsellorEntity;
	}

	
	
}