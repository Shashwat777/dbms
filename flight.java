package dbms_ccm;

import java.util.ArrayList;

public class flight {
    ArrayList<passenger> bookings=new ArrayList<passenger>() ;
    int seats;
    boolean lock=false; // xlock
    boolean slock=false; // shared lock
    ArrayList<Thread> LockTable=new ArrayList<Thread>();
    
    

}
