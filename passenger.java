package dbms_ccm;

import java.util.ArrayList;

public class passenger {
    boolean lock; //x-lock
    boolean slock;// shared lock

    ArrayList<flight> flights=new ArrayList<flight>() ;
<<<<<<< HEAD
    ArrayList<Thread> Locktable=new ArrayList<Thread>() ;

=======
    ArrayList<Thread> LockTable=new ArrayList<Thread>();
>>>>>>> 9be3f247b73d7962699a6a26e858c5f2d9b1f18f
    int id;
    passenger(){
   slock=false ;

    lock=false;}


}
