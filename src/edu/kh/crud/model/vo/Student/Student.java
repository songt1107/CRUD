package edu.kh.crud.model.vo.Student;

public class Student {

	private String studentId; 
	private String studentPw;
	private String studentName;
	private String studentGrade;
	private String studentHome;
	private String studentEnroll;
	private String studentPhone;
	private String parentsPhone;
	
	public Student() {}
	
	public Student(String studentId, String studentPw, String studentName, String studentGrade,
					String studentHome, String studentEnroll, String studentPhone, String parentsPhone) {
		this.studentId = studentId;
		this.studentPw = studentPw;
		this.studentName = studentName;
		this.studentGrade = studentGrade;
		this.studentHome = studentHome;
		this.studentEnroll = studentEnroll;
		this.studentPhone = studentPhone;
		this.parentsPhone = parentsPhone;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentPw() {
		return studentPw;
	}

	public void setStudentPw(String studentPw) {
		this.studentPw = studentPw;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}

	public String getStudentHome() {
		return studentHome;
	}

	public void setStudentHome(String studentHome) {
		this.studentHome = studentHome;
	}

	public String getStudentEnroll() {
		return studentEnroll;
	}

	public void setStudentEnroll(String studentEnroll) {
		this.studentEnroll = studentEnroll;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getParentsPhone() {
		return parentsPhone;
	}

	public void setParentsPhone(String parentsPhone) {
		this.parentsPhone = parentsPhone;
	}

	
	
}
