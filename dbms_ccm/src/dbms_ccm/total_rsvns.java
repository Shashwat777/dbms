package dbms_ccm;

import java.util.ArrayList;

public class total_rsvns implements Runnable {
	database db;
	int bookings=0;
	total_rsvns(database mydb){
		db=mydb;
	}
	 public void compute() {
		 ArrayList<flight> flights=db.flights;
		 for(int it=0;it<flights.size();it++) 
		 {
			 bookings=bookings+flights.get(it).bookings.size();
			
		 }
		 
	 }
	 public void run() {
		 ArrayList<flight> flights=db.flights;
		 int q=-1;
		 while(flights.get(0).lock ||flights.get(1).lock ||flights.get(2).lock ||flights.get(3).lock ||flights.get(4).lock ) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 flights.get(0).lock=true;
		 flights.get(1).lock=true;
		 flights.get(2).lock=true;
		 flights.get(3).lock=true;
		 flights.get(4).lock=true;
		 
		 
		 for(int it=0;it<flights.size();it++) 
		 {
			 bookings=bookings+flights.get(it).bookings.size();
			
		 }
		 flights.get(0).lock=false;
		 flights.get(1).lock=false;
		 flights.get(2).lock=false;
		 flights.get(3).lock=false;
		 flights.get(4).lock=false;

		 
		 
	 }
	 int returner() {
		 return bookings;
	 }

}
