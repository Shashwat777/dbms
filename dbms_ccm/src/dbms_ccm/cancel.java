package dbms_ccm;

public class cancel implements Runnable{
	 flight fl;
	 database mydb;
	 passenger psng;
	cancel(int f , int p,database db){
		 mydb=db;
		  fl=mydb.flights.get(f);
		    psng=mydb.psngrs.get(p);
	}
	public void run() {
		fl.bookings.remove(psng);
		
		   
	   }

}
