package dbms_ccm;

import java.util.*;

public class database {
     ArrayList<flight> flights=new  ArrayList<flight>() ; // list of all flights 
    ArrayList<passenger> psngrs =new  ArrayList<passenger>() ; ;
    ArrayList<Integer> ttype =new  ArrayList<Integer>() ;
 passenger[]  mapping =new passenger[100000]; 

   ArrayList<    ArrayList<Integer>> transac = new ArrayList<ArrayList<Integer>>(); 

	database(){
		passenger random=new passenger();
		 for(int h=0;h<1000;h++) {
			 mapping[h]=random;
		 }

	    

		for(int k=0;k<5;k++) { // number of flights 5 
			flight fl=new flight();
			int id=0;
			int seats=new Random().nextInt(10);  // random number of seats 
			fl.seats=seats;
		   
			flights.add(k,fl);
			
			
			for(int p=0;p<seats;p++) {
				int chk=0;
				while(chk==0) {
					
				 id=new Random().nextInt(150);
				
				if((mapping[id]!=random) ) {
					
					if(mapping[id].flights.contains(fl)) {
					
				}
					else {
						fl.bookings.add(mapping[id]);
						mapping[id].flights.add(fl);
						chk=1;
						
					}
						
				}
					
				
				else {
					passenger psng=new passenger();
					psng.flights.add(fl);
					psngrs.add(psng);
					mapping[id]=psng;
					chk=1;
				}
					}
				
				
			}
			}
			
		
		
		
				}
	void transaction_gen(int tno){
	int flsz=flights.size()-1;
	int psize=psngrs.size()-1;
	
	


		for(int t=0;t<tno;t++) {
			Random rand = new Random(); 

			ArrayList<Integer> transaction =new  ArrayList<Integer>() ;
			int type=new Random().nextInt(5);
			ttype.add(type);
			if(type==0) { // reserve
				int pid=0;
				passenger ps=null;
				int fl= rand.nextInt(flsz); 
				flight tf=flights.get(fl);
				while(true) {
					pid=rand.nextInt(psize); 
					 ps=psngrs.get(pid);
					if(tf.bookings.contains(ps)) {
						
					}
					else {break;}
				}	
				transaction.add(fl);
				transaction.add(pid);
				
				
				
				
				

				
				
			
			}
			else if(type==1) { // cancel
				passenger ps=null;
				int pid=0;
				int fl= rand.nextInt(flsz);
				
				flight tf=flights.get(fl);
				
				if(tf.bookings.size()!=0){
				int q=rand.nextInt(tf.bookings.size());
				passenger atq=tf.bookings.get(q);
				
				 pid=psngrs.indexOf(atq);
				}
				else {
					pid=rand.nextInt(psize); 
					ps=psngrs.get(pid);
	
				}
				transaction.add(fl);
				transaction.add(pid);
				

				
				
			}
			
		
		else if(type==2) { //my flights
			int pid=rand.nextInt(psize); 
			 passenger ps=psngrs.get(pid);
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
			flight tf1=flights.get(fl1);
			flight tf2=flights.get(fl2);
			passenger ps=null;
			int pid=0;

			
				
				pid= rand.nextInt(psize);
				ps=psngrs.get(pid);
				 
				
			transaction.add(fl1);
			transaction.add(fl2);
			transaction.add(pid);
			
			



			
		}
		
		else if(type==4) { // total reservations 
		
			
			
		}
			
	
			transac.add(transaction);
	}
		
	


	}}
