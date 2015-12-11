package com.maming.base.signal;

import org.apache.logging.log4j.Logger;

import com.maming.common.util.LogWriter;
import sun.misc.Signal;  
import sun.misc.SignalHandler;  
/*** 
* java信号捕获处理demo 
*/  
@SuppressWarnings("restriction")
public class SignalHandlerExample implements SignalHandler {  
	Logger otherLog = LogWriter.getOther();
      
    private boolean Running = true;  
       
    public SignalHandlerExample() {  
         this.setupHandler();  
     }  
       
    private void setupHandler() {  
         this.handleSignal("INT");  
         this.handleSignal("TERM");  
         this.handleSignal("HUP");  
     }  
       
    public void handleSignal(final String signalName) {  
         try {  
             Signal.handle(new Signal(signalName), this);  
         } catch (IllegalArgumentException e) {  
             // 可能这个信号,并不支持这个平台或JVM作为目前配置  
             e.printStackTrace();  
         }  
     }  
       
    /** 
     * 捕获信号 
     * @param signal The {@link sun.misc.Signal} that we received 
     **/  
     public synchronized void handle(Signal signal) {  
         // we are only interested in catching the "TERM" signal  
         if ( signal.getName().equals("TERM") ) {  
        	 otherLog.info(" TERM received " + signal.getName() );  
        	 otherLog.info("threadName" + Thread.currentThread().getName());  
             System.exit(-1);  
         } else if ( signal.getName().equals("INT") ||signal.getName().equals("HUP") ) {  
             setRunningStatus( false );  
             notifyAll(); //TODO - clarify if notify OR notifyall  
         }  
         otherLog.info( signal.getName() + " " + signal.getNumber() );  
         otherLog.info( getRunningStatus()+"" );  
     }  
       
    public void setRunningStatus( boolean Status ) {  
        this.Running = Status;  
    }  
       
    public boolean getRunningStatus() {  
        return Running;  
    }  
       
    /** 
     * General "clean up" method which is called when we receive a TERM 
     signal 
     * This will likely be superseeded by specific cleanup code 
     * 
     **/  
     public boolean cleanUp() {  
         // TODO - we need to decide what we are going to do one we trap a  
         //  TERMinate signal.  
         // We need to complete all our threads nicely.  
    	 otherLog.info("Cleaning up!");  
         return true;  
     }  
       
    public synchronized void myWait() {  
         try{  
             wait();  
         }catch (InterruptedException e){  
        	 otherLog.info( "myWait WOKEN UP" + e );  
         }  
    }  
       
    public static void main(final String[] args) {  
           
        SignalHandlerExample mySignalHandler = new SignalHandlerExample();  
       
        while ( mySignalHandler.getRunningStatus() ) {  
        	System.out.println("waiting");
            mySignalHandler.myWait();  
            System.out.println("woken up");
        }  
    }  
}  