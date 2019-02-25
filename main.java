package dbms_ccm;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
public class main {
	@SuppressWarnings("deprecation")
	static void join(database mydb) throws InterruptedException {


	}
	/*static void simulate(int tno , database mydb ) throws InterruptedException {
		System.out.println("TRANSACTION:"+tno);

		 long  startTime = System.currentTimeMillis();

		mydb.concurrency(tno,1);



		for(int t=0;t<1;t++) {
			mydb.thrds.get(t).join();


			//System.out.println("yo"+transaction.k+"yo");
		}
		long  endTime = System.currentTimeMillis();
		System.out.println("1 threads:"+(endTime-startTime));
		 startTime = System.currentTimeMillis();
		mydb.concurrency(tno,4);

		for(int t=0;t<4;t++) {
			mydb.thrds.get(t).join();


			//System.out.println("yo"+transaction.k+"yo");
		}
		 endTime = System.currentTimeMillis();
		System.out.println("4 threads:"+(endTime-startTime));
		//System.out.println(transaction.k+"k");
		 startTime = System.currentTimeMillis();
mydb.concurrency(tno,7);

		for(int t=0;t<7;t++) {
			mydb.thrds.get(t).join();


			//System.out.println("yo"+transaction.k+"yo");
		}
		 endTime = System.currentTimeMillis();
		System.out.println("7 threads:"+(endTime-startTime));


	startTime = System.currentTimeMillis();
	mydb.concurrency(tno,11);

			for(int t=0;t<11;t++) {
				mydb.thrds.get(t).join();


				//System.out.println("yo"+transaction.k+"yo");
			}
			 endTime = System.currentTimeMillis();
			System.out.println("11 threads:"+(endTime-startTime));
			//System.out.println("yo"+transaction.k+"yo");
}


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
*/
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		database mydb=new database();
		/*long startTime = System.currentTimeMillis();
		mydb.transaction_gen(1000);


		computation1(mydb);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		*/
		long startTime = System.currentTimeMillis();
		int tno=30000; // we can change here number of transactions
		System.out.println("Time taken for 50ms");
		mydb.concurrency(1);

		Thread.sleep(50);
		System.out.println("Number of threads 1:"+transaction.k);
		join(mydb);
		mydb.concurrency(20);
		Thread.sleep(50);
		System.out.println("number of threads 20:"+transaction.k);
		join(mydb);
		mydb.concurrency(300);
		Thread.sleep(50);
		System.out.println("number of threads 300:"+transaction.k);

		System.out.println("Time taken for 100ms");
		mydb.concurrency(1);
		Thread.sleep(100);
		System.out.println("Number of threads 1:"+transaction.k);
		join(mydb);
		mydb.concurrency(20);
		Thread.sleep(100);
		System.out.println("number of threads 20:"+transaction.k);
		join(mydb);
		mydb.concurrency(50);
		Thread.sleep(100);
		System.out.println("number of threads 50:"+transaction.k);
		System.out.println("Time taken for 300ms");
		join(mydb);
		mydb.concurrency(1);
		Thread.sleep(300);
		System.out.println("Number of threads 1:"+transaction.k);
		join(mydb);
		mydb.concurrency(20);
		Thread.sleep(300);
		System.out.println("number of threads 20:"+transaction.k);
		join(mydb);
		mydb.concurrency(30);
		Thread.sleep(300);
		System.out.println("number of threads 30:"+transaction.k);

		System.out.println("Time taken for 400ms");
		join(mydb);
		mydb.concurrency(1);
		Thread.sleep(400);
		System.out.println("Number of threads 1:"+transaction.k);
		join(mydb);
		mydb.concurrency(2);
		Thread.sleep(400);
		System.out.println("number of threads 2:"+transaction.k);
		join(mydb);
		mydb.concurrency(3);
		Thread.sleep(400);
		System.out.println("number of threads 3:"+transaction.k);

		System.out.println("Time taken for 500ms");
		join(mydb);
		mydb.concurrency(1);
		Thread.sleep(500);
		System.out.println("Number of threads 1:"+transaction.k);
		join(mydb);
		mydb.concurrency(50);
		Thread.sleep(500);
		System.out.println("number of threads 50:"+transaction.k);
		join(mydb);
		mydb.concurrency(80);
		Thread.sleep(500);
		System.out.println("number of threads 100:"+transaction.k);
		System.exit(0);


		
	}

}
