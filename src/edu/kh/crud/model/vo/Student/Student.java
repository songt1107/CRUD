package edu.kh.crud.model.vo.Student;

public class Student {

	private String Name;
	private int Age;
	private char Gender;
	private String Home;
	private String Enroll;
	private String Phone;
	private String parentsPhone;
	
	public Student() {}
	
	public Student(String Name, int Age, char Gender,
					String Home, String Enroll, String Phone, String parentsPhone) {
		this.Name = Name;
		this.Age = Age;
		this.Gender = Gender;
		this.Home = Home;
		this.Enroll = Enroll;
		this.Phone = Phone;
		this.parentsPhone = parentsPhone;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public char getGender() {
		return Gender;
	}

	public void setGender(char gender) {
		Gender = gender;
	}

	public String getHome() {
		return Home;
	}

	public void setHome(String home) {
		Home = home;
	}

	public String getEnroll() {
		return Enroll;
	}

	public void setEnroll(String enroll) {
		Enroll = enroll;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getParentsPhone() {
		return parentsPhone;
	}

	public void setParentsPhone(String parentsPhone) {
		this.parentsPhone = parentsPhone;
	}

	@Override
	public String toString() {
		return "Student [Name=" + Name + ", Age=" + Age + ", Gender=" + Gender + ", Home="
				+ Home + ", Enroll=" + Enroll + ", Phone=" + Phone + ", parentsPhone=" + parentsPhone + "]";
	}

	
	
	
}
