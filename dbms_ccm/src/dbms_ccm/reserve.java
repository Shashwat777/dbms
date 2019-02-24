package dbms_ccm;

public class reserve implements Runnable {
	 flight fl;
	 database mydb;
	 passenger psng;
   reserve(int  f , int p, database db){
	    mydb=db;
	  fl=mydb.flights.get(f);
	    psng=mydb.psngrs.get(p);
	   
   }
   public void run() {
	   if(this.fl.bookings.size()<this.fl.seats) {
		   fl.bookings.add(psng);
	   }
	   
	   
	   
   }
}
