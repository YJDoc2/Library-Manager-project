package library_management;

import java.time.LocalTime;

public class SQLQuery {
	
	static final String bookTable = "`books`";	
	static final String issueTable = "`issue`";
	static final String studentTable ="studentlogin";

	public SQLQuery() {
		// TODO Auto-generated constructor stub
	}
	
	public static String searchBookById(String id) {
		//TODO Implement
		return "SELECT * FROM "+bookTable+" WHERE BOOK_ID = '"+id+"';";
	}
	public static String searchBookByName(String name) {
		//TODO Implement
		return "SELECT * FROM "+bookTable+" WHERE NAME REGEXP '"+name+"';";
	}
	public static String addBook(String id,String name,String author,String publisher,int price,boolean type) {
		//TODO Implement
		//!!!! NO AUTHOR FIELD
		return "INSERT INTO "+bookTable+"(`BOOK_ID`,`NAME`,`TYPE`,`AUTHOR`,`PUBLISHER`,`PRICE`) VLAUES("+id+","+name+","+type+","+author+","+publisher+","+price+");";
	}
	public static String deleteBook(String bookId) {
		return "DELETE FROM "+bookTable+"WHERE BOOK_ID = '"+bookId+"';";
	}
	
	public  static String getUser(long userId) {
		return "SELECT * FROM "+studentTable+" WHERE STUDENT_ID = '"+userId+"';";
	}
	//To GET BOOK DATA FROM ISSUE TABLE
	public static String getIssuedBook(String bookId) {
		
		return "SELECT * FROM "+issueTable+" WHERE BOOK_ID = '"+bookId+"';";
		
	}
	
	public static String returnBookIssuedTable(String bookId) {
		
		return "DELETE FROM "+issueTable+" WHERE BOOK_ID = '"+bookId+"';";
	}
	public static String returnBookStudentTable(long studentId) {
		
		return "UPDATE "+studentTable+" SET BOOKSISSUED = BOOKSISSUED - 1 WHERE STUDENT_ID = "+studentId+" and field > 0;";
	}
	
	public static String renewBook(String bookId) {
		return "UPDATE "+issueTable+" SET DATEOFISSUE = "+LocalTime.now() +"WHERE BOOK_ID = "+bookId+";";
	}
	//-----IMPLEMENT
	public static String issueBook() {
		//TODO Implement
		return "";
	}
	
	
	public static String getPasswordByUserId(long studentId) {
		return "SELECT password from "+studentTable+"WHERE student_id ="+studentId+";";
	}
	public static String addStudent(long studentId,String name,String course,String year,String sem) {
		//TODO Implement
		return "INSERT INTO `students`(`STUDENT_ID`, `NAME`, `COURSE`, `YEAR`, `SEMESTER`) VALUES ("+studentId+","+name+","+course+","+year+","+sem+");";
	}

}
