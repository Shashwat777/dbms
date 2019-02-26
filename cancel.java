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
	public void  comp() {
		
		fl.bookings.remove(psng);
		
		   
		
	   }
public void run() {
		
		psng.Locktable.add(Thread.currentThread());
		fl.Locktable.add(Thread.currentThread());

		while(fl.lock || psng.lock || fl.slock || psng.slock || psng.Locktable.contains(Thread.currentThread())==false ||fl.Locktable.contains(Thread.currentThread())==false) {try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		   fl.lock=true;
		   psng.lock=true;
		   psng.Locktable.remove(Thread.currentThread());
			fl.Locktable.remove(Thread.currentThread());
		   fl.bookings.remove(psng);
		   fl.lock=false;
		   psng.lock=false; 
		   
	   }
	   
		
		   
		
	   
	
	

}
