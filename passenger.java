package dbms_ccm;

import java.util.ArrayList;

public class passenger {
    boolean lock; //x-lock
    boolean slock;// shared lock

    ArrayList<flight> flights=new ArrayList<flight>() ;
    int id;
    passenger(){
   slock=false ;

    lock=false;}


}
