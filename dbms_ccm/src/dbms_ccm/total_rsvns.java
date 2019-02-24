package dbms_ccm;

import java.util.ArrayList;

public class total_rsvns implements Runnable {
	database db;
	int bookings=0;
	total_rsvns(database mydb){
		db=mydb;
	}
	 public void run() {
		 ArrayList<flight> flights=db.flights;
		 for(int it=0;it<flights.size();it++) 
		 {
			 bookings=bookings+flights.get(it).bookings.size();
			 returner();
		 }
		 
	 }
	 int returner() {
		 return bookings;
	 }

}
