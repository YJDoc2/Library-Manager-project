package library_management;


import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yatharth
 */
abstract public class SQL_Feed {
    static final String issueTable = "`issue`";
    static final String studentTable = "`students`";
    static final String bookTable = "`books`";
    public String fetchBook(String bookID){
        return "SELECT * FROM "+issueTable+" WHERE BOOK_ID = '"+bookID+"';";
    };
    abstract public String feedBook(String bookID,String studentID);
}


class Return extends SQL_Feed {
    public String feedBook(String studentID,String bookID){
        return "DELETE FROM "+issueTable+" WHERE BOOK_ID = '"+bookID+"' && STUDENT_ID = '"+studentID+"';";
    }
    public static String returnBookStudentTable(String studentId) {
	return "UPDATE "+studentTable+" SET BOOKSISSUED = BOOKSISSUED - 1 WHERE STUDENT_ID = '"+studentId+"';";
    }
    public static String returnBookTable(String bookID) {
	return "UPDATE "+bookTable+" SET AVAILIBILITY = 'AVAILABLE' WHERE BOOK_ID = '"+bookID+"';";
    }
}


class Renew extends SQL_Feed {
    public String feedBook(String bookID,String studentID){
        return "UPDATE issue SET DATEOFISSUE='"+ LocalDate.now()   +"' where BOOK_ID='"+bookID+"'";
    }
}