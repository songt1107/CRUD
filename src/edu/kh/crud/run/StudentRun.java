package edu.kh.crud.run;

import edu.kh.crud.model.service.StudentService;

public class StudentRun {

	public static void main(String[] args) {
		StudentService ss = new StudentService();
		ss.displayMenu();
	}
	
}
