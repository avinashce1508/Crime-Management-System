package dashboard.main;

import java.sql.Date;

public class CaseTable {

	int act,case_id,victim,suspect;
	String area,desc,status;
	Date date;
	public CaseTable(int case_id, String area, String desc, int act,int victim, int suspect,Date date,  String status
			) {
		super();
		this.case_id = case_id;
		this.victim = victim;
		this.suspect = suspect;
		this.area = area;
		this.desc = desc;
		this.act = act;
		this.status = status;
		this.date = date;
	}
	public int getCase_id() {
		return case_id;
	}
	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}
	public int getVictim() {
		return victim;
	}
	public void setVictim(int victim) {
		this.victim = victim;
	}
	public int getSuspect() {
		return suspect;
	}
	public void setSuspect(int suspect) {
		this.suspect = suspect;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getAct() {
		return act;
	}
	public void setAct(int act) {
		this.act = act;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
