package dashboard.main;

public class SuspectTable {
	
	int sid;
	String fname,lname,gen;
	int age,mobile,case_id,crime_id;
	public SuspectTable(int sid, String fname, String lname, String gen, int age, int mobile, int case_id,
			int crime_id) {
		super();
		this.sid = sid;
		this.fname = fname;
		this.lname = lname;
		this.gen = gen;
		this.age = age;
		this.mobile = mobile;
		this.case_id = case_id;
		this.crime_id = crime_id;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public int getCase_id() {
		return case_id;
	}
	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}
	public int getCrime_id() {
		return crime_id;
	}
	public void setCrime_id(int crime_id) {
		this.crime_id = crime_id;
	};

}
