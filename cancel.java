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
		
		
		while(fl.lock || psng.lock || fl.slock || psng.slock) {try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		   fl.lock=true;
		   psng.lock=true;
		   fl.bookings.remove(psng);
		   fl.lock=false;
		   psng.lock=false; 
		   
	   }
	   
		
		   
		
	   
	
	

}
