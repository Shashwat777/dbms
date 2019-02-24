package dbms_ccm;

public class trnfr implements Runnable {
	flight flight1;
	database mydb;
	
	flight flight2;
	passenger p;
	trnfr(int f1, int f2 , int  psg,database db) {
	  mydb=db;
	  flight1=mydb.flights.get(f1);
	  flight2=mydb.flights.get(f2);
	  p=mydb.psngrs.get(psg);
	  
		
	
		
	}
	 public void run() {
		 if(flight1.bookings.contains(p)==false || flight2.bookings.size()==flight2.seats) {}
		 else {
			 flight1.bookings.remove(p);
			 flight2.bookings.add(p);
			 
		 }
		 
		 
		 
	 }

}
