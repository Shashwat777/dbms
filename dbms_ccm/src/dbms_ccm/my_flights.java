package dbms_ccm;

import java.util.ArrayList;

public class my_flights implements Runnable {
	passenger psng;
	database mydb;
    ArrayList<flight> myflights=new ArrayList<flight> () ;

	my_flights(int  p,database db){
		mydb=db;
		psng=mydb.psngrs.get(p);
	}
	 public void run() {
		 ArrayList<flight> flights=mydb.flights;
		 for(int it=0;it<flights.size();it++) {
			 if(flights.get(it).bookings.contains(psng)) {
				 myflights.add(flights.get(it));
				 
			 }
		 }
		 returner();
	 }
	 ArrayList<flight>  returner(){
		 return myflights;
		 
	 }

}
