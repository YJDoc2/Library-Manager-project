package library_management;

public class User {
	
	long id;
	String name;
	String course;
	String year;
	String sem;
	int booksIssued;
	
	public User(long id, String name,String course,String year,String sem,int booksIssued) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.year=year;
		this.sem=sem;
		this.booksIssued = booksIssued;
	}
}
