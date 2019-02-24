package dbms_ccm;

public class reserve implements Runnable {
	 flight fl;
	 database mydb;
	 passenger psng;
	 int seq=0;
   reserve(int  f , int p, database db){
	    mydb=db;
	  fl=mydb.flights.get(f);
	    psng=mydb.psngrs.get(p);
	   
   }
   public void compute() {
		   if(this.fl.bookings.size()<this.fl.seats) {
			   fl.bookings.add(psng);
		
   }}
   public void run() {
	   
	   
		   while(fl.lock || psng.lock) {try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		   fl.lock=true;
		   psng.lock=true;
		   if(this.fl.bookings.size()<this.fl.seats) {
			   fl.bookings.add(psng);
		   }
	   fl.lock=false;
	   psng.lock=false;
	   }
	   
	   
	   
	   
   
   }
  
