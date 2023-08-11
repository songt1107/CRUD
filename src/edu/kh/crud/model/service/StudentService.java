package edu.kh.crud.model.service;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.crud.model.vo.Student.Student;


public class StudentService {
	
	private Scanner sc = new Scanner(System.in);

	private List<Student> studentList = new LinkedList<Student>();
	
	public StudentService() {
		
		studentList.add( new Student("홍길동", 15, 'M', "서울시 중구", "2020-09-21", "010-0000-0000", "010-1111-1111") );
		studentList.add( new Student("고영희", 14, 'F', "경기도 안산시", "2019-08-15", "010-2222-2222", "010-3333-3333") );
		studentList.add( new Student("강아지", 17, 'M', "서울시 강남구", "2018-07-05", "010-4444-4444", "010-5555-5555") );
		studentList.add( new Student("오미나", 14, 'F', "충북 청주시", "2019-11-11", "010-6666-6666", "010-7777-7777") );
		studentList.add( new Student("박주희", 18, 'F', "서울시 중구", "2017-04-20", "010-8888-8888", "010-9999-9999") );
		
	}
	
	
	public void ex() {
		
		studentList.add(new Student()); 
		
		if( studentList.get(0) instanceof Student ) {
			System.out.println( ( (Student)studentList.get(0) ).getName() );
		}
		
		System.out.println( studentList.get(0).getName() );
	}
	
	
	public void displayMenu() {
		
		int menuNum = 0;
		
		do {
			
			System.out.println("\n===========학원생 관리 프로그램===========\n");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 제거");
			System.out.println("5. 이름으로 검색(일치)");
			System.out.println("6. 주소로 검색(포함)");
			System.out.println("7. 성별검색(M/F)");
						
			System.out.println("0. 프로그램 종료");
			
			System.out.println("\n메뉴 번호 선택 >>");
			
			try {
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum){
				case 1 : System.out.println( addStudent() ); break;
				case 2 : selectAll(); break;
				case 3 : System.out.println( updateStudent() ); break;
				case 4 : System.out.println( removeStudent() ); break;
				case 5 : searchName(); break;
				case 6 : searchHome(); break;
				case 7 : searchGender(); break;
				case 0 : System.out.println("프로그램 종료..."); break;
				default : System.out.println("메뉴에 작성된 번호만 입력해주세요.");
				
				}
				
			} catch(InputMismatchException e) {
				System.out.println("\nerror : 입력형식이 유효하지 않습니다. 다시 시도해주세요.");
				
				sc.nextLine(); 
				
				menuNum = -1; 
			}
			
		} while(menuNum != 0);
		
	}
	
	
	public String addStudent() throws InputMismatchException{
		System.out.println("=========학생 정보 추가=========");
		
		System.out.println("이름 : ");
		String Name = sc.next();
		
		System.out.println("나이 : ");
		int Age = sc.nextInt();
		sc.nextLine();
		
		System.out.println("성별(M/F) : ");
		char Gender = sc.next().charAt(0);
		
		System.out.println("주소 : ");
		String Home = sc.nextLine();
		
		System.out.println("등록일 : ");
		String Enroll = sc.nextLine();
		
		System.out.println("연락처 : ");
		String Phone = sc.nextLine();
		
		System.out.println("보호자 연락처 : ");
		String parentsPhone = sc.nextLine();
		
		if( studentList.add( new Student(Name, Age, Gender, Home, Enroll, Phone, parentsPhone) ) ) {
			
			return "성공";
		} else {
			return "실패";
		}
		
	}
	
	public void selectAll() {
	
		
		System.out.println("======= 학생 전체 조회 =======");
		
		
		if( studentList.isEmpty() ) {
			System.out.println("학생 정보가 없습니다");
		
			return; 
		} 
		
		int index = 0;
		for( Student std : studentList ) {
			System.out.print((index++) + "번 : ");
			System.out.println(std);
		}
		
	}
	
	
	
	public String updateStudent() throws InputMismatchException {
		
		System.out.println("=======학생 정보 수정=======");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다";
		
		} else if( index < 0 ){
			return "음수는 입력할 수 없습니다";
		
		} else if( index >= studentList.size() ) {
			return "범위를 넘어선 값을 입력할 수 없습니다";
		
		} else {
			
			System.out.println(index + "번째 인덱스에 저장된 학생 정보");
			System.out.println(studentList.get(index));
			
			System.out.println("이름 : ");
			String Name = sc.next();
			
			System.out.println("나이 : ");
			int Age = sc.nextInt();
			sc.nextLine();
			
			System.out.println("성별(M/F) : ");
			char Gender = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.println("주소 : ");
			String Home = sc.nextLine();
			
			System.out.println("등록일 : ");
			String Enroll = sc.nextLine();
			
			System.out.println("연락처 : ");
			String Phone = sc.nextLine();
			
			System.out.println("보호자 연락처 : ");
			String parentsPhone = sc.nextLine();
			
			Student temp = studentList.set(index, new Student(Name, Age, Gender, Home, Enroll, Phone, parentsPhone));
			
			return temp.getName() + "의 정보가 변경되었습니다.";
		}
		
	}
	
	
	public String removeStudent() throws InputMismatchException {
		
		System.out.println("=======학생 정보 제거=======");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다";
		
		} else if( index < 0 ){
			return "음수는 입력할 수 없습니다";
		
		} else if( index >= studentList.size() ) {
			return "범위를 넘어선 값을 입력할 수 없습니다";
		
		} else {
			
			System.out.println("정말 삭제 하시겠습니까? (Y/N) : ");
			char ch = sc.next().toUpperCase().charAt(0);
			
			if(ch == 'Y') {
				Student temp = studentList.remove(index);
				return temp.getName() + "의 정보가 제거되었습니다.";
				
			} else {
				return "취소";
			}
	
		}
		
	}
	public void searchName() {
		
		System.out.println("======학생 검색(이름 일치)======");
		
		System.out.println("검색할 이름 입력 : ");
		String input = sc.next();
		
		boolean flag = true;
		
		for( Student std : studentList ) {
			if ( std.getName().equals(input) ) { 
			System.out.println(std);
			flag = false ; 
			} 
		}
			if (flag) {
			 System.out.println("검색 결과가 없습니다.");
			}
		
	}
	
	public void searchHome() {

		System.out.println("======학생 검색(주소 포함)======");
		
		System.out.println("주소에 포함되는 문자열 입력 : ");
		String input = sc.next();
		
		boolean flag = true;
		
		for( Student std : studentList ) {
			
			if ( std.getHome().contains(input) ) { 
			System.out.println(std);
			flag = false ;
			}
		}
			if (flag) {
			 System.out.println("검색 결과가 없습니다.");
			}
	
	}
	
	public void searchGender() {

		System.out.println("======학생 검색(성별별)======");
		
		System.out.println("성별입력(M/F) : ");
		char input = sc.next().charAt(0);
		
		boolean flag = true;
		
		for( Student std : studentList ) {
			
			if ( std.getGender()== input ) { 
			System.out.println(std);
			flag = false ;
			}
		}
			if (flag) {
			 System.out.println("M/F 중 하나를 입력해주세요.");
			}
	
	}
	
	
}