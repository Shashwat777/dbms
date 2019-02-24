package dbms_ccm;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
public class main {
	static void computation1(database mydb ) throws InterruptedException  {
		ArrayList<Integer> ttype=mydb.ttype;// transaction type
	ArrayList<    ArrayList<Integer>> transac = mydb.transac;
	for(int it=0;it<ttype.size();it++) {
		int type =ttype.get(it);
		ArrayList<Integer> transaction =mydb.transac.get(it);
		
		if(type==0) {
			int f=transaction.get(0);
			int p=transaction.get(1);
			reserve rsv=new reserve(f,p,mydb);
			Thread t=new Thread(rsv);
			t.start();
			
			t.join();// sequential
		
			
			
			
			
		}
		else if(type==1) {
			int f=transaction.get(0);
			int p=transaction.get(1);
			cancel cncl=new cancel(f,p,mydb);
			Thread t=new Thread(cncl);
			t.start();
	
			t.join();// sequential
			
		}
		else if(type==2) {
			int p=transaction.get(0);
			my_flights rsv=new my_flights(p,mydb);
			Thread t=new Thread(rsv);
			t.start();
	
			t.join();// sequential
	
		}
		else if(type==3) {
			int f1=transaction.get(0);
			int f2=transaction.get(1);
			int p=transaction.get(2);
			trnfr  transfer=new trnfr(f1,f2,p,mydb);
			Thread t=new Thread(transfer);
			t.start();
		
			t.join();// sequential
		
		}
		else if(type==4) {
			
			total_rsvns  total=new total_rsvns(mydb);
			Thread t=new Thread(total);
			t.start();
			t.join();// sequential
		}
	}
       		
		 
	}
	static void computation2(database mydb ) throws InterruptedException  {
		ArrayList<Integer> ttype=mydb.ttype;// transaction type
	ArrayList<    ArrayList<Integer>> transac = mydb.transac;
	for(int it=0;it<ttype.size();it++) {
		int type =ttype.get(it);
		ArrayList<Integer> transaction =mydb.transac.get(it);
		
		if(type==0) {
			int f=transaction.get(0);
			int p=transaction.get(1);
			reserve rsv=new reserve(f,p,mydb);
			Thread t=new Thread(rsv);
			t.start();
			
			t.join();// sequential
		
			
			
			
			
		}
		else if(type==1) {
			int f=transaction.get(0);
			int p=transaction.get(1);
			cancel cncl=new cancel(f,p,mydb);
			Thread t=new Thread(cncl);
			t.start();
	
			t.join();// sequential
			
		}
		else if(type==2) {
			int p=transaction.get(0);
			my_flights rsv=new my_flights(p,mydb);
			Thread t=new Thread(rsv);
			t.start();
	
			t.join();// sequential
	
		}
		else if(type==3) {
			int f1=transaction.get(0);
			int f2=transaction.get(1);
			int p=transaction.get(2);
			trnfr  transfer=new trnfr(f1,f2,p,mydb);
			Thread t=new Thread(transfer);
			t.start();
		
			t.join();// sequential
		
		}
		else if(type==4) {
			
			total_rsvns  total=new total_rsvns(mydb);
			Thread t=new Thread(total);
			t.start();
			t.join();// sequential
		}
	}}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		database mydb=new database();
		mydb.transaction_gen(10000);
		long startTime = System.currentTimeMillis();

		computation1(mydb);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		startTime = System.currentTimeMillis();
		mydb.concurrency(10000);
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);


	}

}
