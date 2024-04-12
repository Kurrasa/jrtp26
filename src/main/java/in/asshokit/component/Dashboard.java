package in.asshokit.component;

import org.springframework.stereotype.Component;

@Component
public class Dashboard 
{
	private long totalEnquires;
	private long enrolledEnquires;
	private long openEnquires;
	private long lostEnquires;
	public long getTotalEnquires() {
		return totalEnquires;
	}
	public void setTotalEnquires(long studententity) {
		this.totalEnquires = studententity;
	}
	public long getEnrolledEnquires() {
		return enrolledEnquires;
	}
	public void setEnrolledEnquires(long enrolledEnquires) {
		this.enrolledEnquires = enrolledEnquires;
	}
	public long getOpenEnquires() {
		return openEnquires;
	}
	public void setOpenEnquires(long openEnquires) {
		this.openEnquires = openEnquires;
	}
	public long getLostEnquires() {
		return lostEnquires;
	}
	public void setLostEnquires(long lostEnquires) {
		this.lostEnquires = lostEnquires;
	}
	
	

}
