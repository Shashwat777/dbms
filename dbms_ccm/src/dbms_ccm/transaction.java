package dbms_ccm;

import java.util.ArrayList;
import java.util.Random;

public class transaction implements Runnable {
	database mydb;
	transaction(database db){
		mydb=db;
	}
	public void run() {
		int flsz=mydb.flights.size()-1;
		int psize=mydb.psngrs.size()-1;
		
		


			
				Thread t=new Thread();
				Random rand = new Random(); 

				ArrayList<Integer> transaction =new  ArrayList<Integer>() ;
				int type=new Random().nextInt(5);
				mydb.ttype.add(type);
				if(type==0) { // reserve
					int pid=0;
					passenger ps=null;
					int fl= rand.nextInt(flsz); 
					flight tf=mydb.flights.get(fl);
					while(true) {
						pid=rand.nextInt(psize); 
						 ps=mydb.psngrs.get(pid);
						if(tf.bookings.contains(ps)) {
							
						}
						else {break;}
					}
					reserve rsv=new reserve(fl,pid,mydb);
					rsv.run();
					
					
					
					
					
					

					
					
				
				}
				else if(type==1) { // cancel
					passenger ps=null;
					int pid=0;
					int fl= rand.nextInt(flsz);
					
					flight tf=mydb.flights.get(fl);
					
					if(tf.bookings.size()!=0){
					int q=rand.nextInt(tf.bookings.size());
					passenger atq=tf.bookings.get(q);
					
					 pid=mydb.psngrs.indexOf(atq);
					}
					else {
						pid=rand.nextInt(psize); 
						ps=mydb.psngrs.get(pid);
		
					}
					cancel rsv=new cancel(fl,pid,mydb);
					rsv.run();
					
					

					
					
				}
				
			
			else if(type==2) { //my flights
				int pid=rand.nextInt(psize); 
				 passenger ps=mydb.psngrs.get(pid);
					transaction.add(pid);
			}
			
		
			else if(type==3) { // TRANSFER
				int fl1= rand.nextInt(flsz);
				int fl2=0;
				while(true) {
					 fl2= rand.nextInt(flsz);
					if(fl1!=fl2) {
						break;
					}

				}
				flight tf1=mydb.flights.get(fl1);
				flight tf2=mydb.flights.get(fl2);
				passenger ps=null;
				int pid=0;

				
					
					pid= rand.nextInt(psize);
					ps=mydb.psngrs.get(pid);
					 
				     trnfr rsv=new trnfr(fl1,fl2,pid,mydb);
					rsv.run();
				
				
			}



		
	
	else if(type==4) { // total reservations 
		
		total_rsvns rsv=new total_rsvns(mydb);
		rsv.run();
	
		
	}
		

}
	
	
}
