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
	   psng.Locktable.add(Thread.currentThread());
		fl.Locktable.add(Thread.currentThread());
	   
		   while(fl.lock || psng.lock || fl.slock || psng.slock) {try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		   fl.lock=true;
		   psng.lock=true;
		   psng.Locktable.remove(Thread.currentThread());
			fl.Locktable.remove(Thread.currentThread());
		   if(this.fl.bookings.size()<this.fl.seats) {
			   fl.bookings.add(psng);
		   }
	   fl.lock=false;
	   psng.lock=false;
	   }
	   
	   
	   
	   
   
   }
  
