package edu.kh.crud.model.service;

import java.util.Scanner;

import edu.kh.crud.model.vo.Student.Student;

public class StudentService {
	private Scanner sc = new Scanner(System.in);
	
	private Student[] studentArr = new Student[9];
	
	private Student loginStudent = null;
	
	public StudentService() {
		studentArr[0] = new Student("ABC", "123", "홍길동", "고3", "서울 강남구", 
				"2022-09-13", "010-0000-0000", "010-1111-1111");

		studentArr[1] = new Student("DEF", "456", "김둘리", "중2", "서울 강남구", 
				"2021-01-22", "010-4567-4567", "010-7894-7894");

		studentArr[2] = new Student("GHI", "789", "박또치", "초6", "경기 이천시", 
				"2020-11-05", "010-1234-1234", "010-2222-2222");
		
		
	}
	
	public void displayMenu() {
		int menuNum = 0;
		do {
			
			System.out.println("=====학생 관리 프로그램=====");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 학생 정보 조회");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 검색(주소)");
			System.out.println("0. 프로그램 종료");
			
			System.out.println("메뉴 입력 : ");
			menuNum = sc.nextInt();
			sc.nextLine(); // 입력 버퍼에 남은 개행문자 제거용
			
			switch(menuNum) {
			case 1 : System.out.println(signUp()); break;
			case 2 : System.out.println(login()); break;
			case 3 : System.out.println(selectMember()); break;
			case 4 : 
				int result = updateMember();
				
				if(result == -1) {
					System.out.println("로그인 후 이용해주세요.");
				} else if(result == 0) {
					System.out.println("학생 정보 수정 실패 (비밀번호 불일치)");	
				} else { // result == 1
					System.out.println("학생 정보가 수정되었습니다.");
				}
				
				break;
			case 5: searchHome(); break;
			case 0 : System.out.println("프로그램 종료"); break;
			default : System.out.println("잘못 입력하셨습니다.. 다시 입력해주세요");
			
			}
						
		} while(menuNum != 0);
		
	}
	
	
	public int emptyIndex() {
		for(int i = 0; i < studentArr.length; i++) {
			if(studentArr[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	
public String signUp() {
		
		System.out.println("\n=========회원가입=========");
		
		int index = emptyIndex(); 
		
		if(index == -1) { 
			return "회원가입이 불가능합니다(인원 수 초과)";
		}
		System.out.print("아이디 : ");
		String studentId = sc.next();
		
		System.out.print("비밀번호 : ");
		String studentPw = sc.next();
		
		System.out.print("비밀번호 확인 : ");
		String studentPw2 = sc.next();
		
		System.out.print("이름 : ");
		String studentName = sc.next();
		
		System.out.print("학년 : ");
		String studentGrade = sc.nextLine();
		
		System.out.println("주소 : ");
		String studentHome = sc.nextLine();
		
		System.out.println("등록 날짜 : ");
		String studentEnroll = sc.nextLine();
		
		System.out.println("연락처 : ");
		String studentPhone = sc.nextLine();
		
		System.out.println("보호자 연락처 : ");
		String parentsPhone = sc.nextLine();
		
		
		
		if(studentPw.equals(studentPw2)) {
			
			studentArr[index] = new Student(studentId, studentPw, studentName, studentGrade, studentHome, studentEnroll, studentPhone, parentsPhone);
			
			return "회원가입 성공!!";
			
		} else { 
			
			return "회원가입 실패!! (비밀번호 불일치)";
			
		}
		
	}


private String login() {
	
	System.out.println("\n********로그인********");
	
	System.out.println("아이디 입력 : ");
	String studentId = sc.next();
	
	System.out.println("비밀번호 입력 : ");
	String studentPw = sc.next();
	
	
	for(int i = 0; i < studentArr.length; i++) {
		
		if(studentArr[i] != null) { 
			
		
			if(studentArr[i].getStudentId().equals(studentId) 
					&& studentArr[i].getStudentPw().equals(studentPw)) {
				
				loginStudent = studentArr[i];
				break; 
			}
		} 
	}
		if(loginStudent == null) {
		return "로그인 실패";
		} else { 
	
	return loginStudent.getStudentName() + "님 환영합니다.";
	}
}

private String selectMember() {
	
	System.out.println("\n ***** 회원 정보 ***** ");
	if(loginStudent == null) {
		return "로그인 먼저 해주세요.";
	}
	String str = "이름 : " + loginStudent.getStudentName();
	str += "\n아이디 : " + loginStudent.getStudentId();
	str += "\n학년 : " + loginStudent.getStudentGrade();
	str += "\n주소 : " + loginStudent.getStudentHome();
	
	return str;
}


private int updateMember() {
	
	System.out.println("\n****** 회원정보 수정 ******");
	if(loginStudent == null) {
		return -1;
	}
	System.out.println("수정할 이름 : ");
	String inputName = sc.next();
	System.out.println("수정할 학년 : ");
	String inputGrade = sc.next();
	sc.nextLine(); // int 다음에 오는 문자열 받을 시 nextLing 넣기!
	System.out.println("수정할 주소 : ");
	String inputHome = sc.next();
	
	System.out.println("비밀번호 입력 : ");
	String inputPw = sc.next();
	if(inputPw.equals(loginStudent.getStudentPw())) {
		loginStudent.setStudentName(inputName);
		loginStudent.setStudentGrade(inputGrade);
		loginStudent.setStudentHome(inputHome);
		
		return 1;
	} else {
		return 0;
	}
}


public void searchHome() {
	
	System.out.println("\n******회원 검색(지역)******");
	
	System.out.print("검색할 주소을 입력하세요 : ");
	String inputHome = sc.next();
	
	boolean flag = false; 
	
	for(int i = 0; i < studentArr.length; i++) {
		
		if(studentArr[i] == null) {
			break;
		}
		
		if(studentArr[i].getStudentHome().equals(inputHome)) {
			System.out.printf("아이디 : %s, 이름 : %s\n",
							studentArr[i].getStudentId(), studentArr[i].getStudentName());
			
			flag = true;
		}
	}
	
	if(!flag) {
		System.out.println("일치하는 검색 결과 없음");
	}
	
}
	
}
