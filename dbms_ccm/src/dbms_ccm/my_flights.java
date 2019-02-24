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
	 public void compute() {
		 ArrayList<flight> flights=mydb.flights;
		 for(int it=0;it<flights.size();it++) {
			 if(flights.get(it).bookings.contains(psng)) {
				 myflights.add(flights.get(it));
				 
			 }
		 }
		 returner();
	 }
	 public void run() {
		 while(psng.lock) {
			 try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 psng.lock=true;
		 ArrayList<flight> flights=mydb.flights;
		 for(int it=0;it<flights.size();it++) {
			 if(flights.get(it).bookings.contains(psng)) {
				 myflights.add(flights.get(it));
				 
			 }
		 }
		 returner();
		 psng.lock=false;
	 }
	 
	 ArrayList<flight>  returner(){
		 return myflights;
		 
	 }

}
