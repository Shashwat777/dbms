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
		 while(flight1.lock || flight2.lock ||p.lock) {
			 
			 try {
				Thread.sleep(1);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 flight1.lock=true;
		 flight2.lock=true;
		 p.lock=true;
		 
		 if(flight1.bookings.contains(p)==false || flight2.bookings.size()==flight2.seats) {}
		 else {
			 flight1.bookings.remove(p);
			 flight2.bookings.add(p);
			 
		 }
		 
		 flight1.lock=false;
		 flight2.lock=false;
		 p.lock=false;
		 
		 
	 }
	 public void compute() {
		 if(flight1.bookings.contains(p)==false || flight2.bookings.size()==flight2.seats) {}
		 else {
			 flight1.bookings.remove(p);
			 flight2.bookings.add(p);
			 
		 }
		 
		 
		 
	 }


}
