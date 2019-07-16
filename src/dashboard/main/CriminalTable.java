package dashboard.main;
import java.util.Date;
public class CriminalTable {
	
	int age,mobile;
	int criminal_id,case_id;
	String fname, lname,gender, status;      
	Date release_date;
	public CriminalTable(int criminal_id, String fname,String lname,int mobile,int age, int case_id,String gender,
			 Date release_date,String status) {
		super();
		this.criminal_id = criminal_id;
		this.age = age;
		this.case_id = case_id;
		this.mobile = mobile;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.status = status;
		this.release_date = release_date;
	}
	public  int getCriminal_id() {
		return criminal_id;
	}
	public void setCriminal_id(int criminal_id) {
		this.criminal_id = criminal_id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCase_id() {
		return case_id;
	}
	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	

}