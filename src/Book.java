package library_management;

import java.util.*;
import java.time.*;
import java.time.temporal.TemporalAccessor;
class Book{
	String id;
	boolean isIssued, isReference;			//Im not sure what to initialise isReference
	String name;					//String is an object so capitalizing N in Name
	String author;
	int price;
	long issuedBy;
	Date issueDate;
	int pendingFine =0;
	static int fineAmtMultiplier=10;		//Update this later
	
	Book(String id,String name ,String author,int price,boolean IsRef){
		isIssued=false;
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	int calcFine(){												//int because it should return value of fine
		if (isIssued==false){
				System.out.println("Book isnt issued");
			return 0;
		}
		else{
			LocalDate issueLocalDate = issueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate currentDate = LocalDate.now();
			int daysIssuedFor = Period.between(issueLocalDate,currentDate).getDays();		//Stores the number of days
			if (daysIssuedFor<=7){
				System.out.println("Book has been issued for less than 7 days hence Fine amount is not applicable");
				return 0;
			}
			else
				return ((daysIssuedFor-7)*fineAmtMultiplier);
		}
	}
	void showDetails(){
		
	}
	void returnBook(){
		if (isIssued){
			int fine = calcFine();
			if (fine>0)
				System.out.println("Kindly Deposit Fine of Rs"+fine);
			else
				isIssued = false;
				issuedBy = 0;
				issueDate = null;
				System.out.println("Book Returned.");
		}
		else
			System.out.println("This Book is not issued.");
	}
	/*void payFine(){
		if (isIssued){
			int fine = calcFine();
			if (fine>0){
				issueDate=
				System.out.println("Fine of Rs"+ fine +" for the above user has been cleared and the Book issueDate has been renewed.");
			}
		}
		else
			System.out.println("This book is not Issued");
	}
	void renewBook(){
		int fine = calcFine();
		if (isIssued){
			if (fine==0){
				issueDate=LocalDate.now();
				System.out.println("Renew Successful");
			}
			else{
				System.out.println("Kindly Pay a fine of " + fine);
			}
		}
	}*/
}