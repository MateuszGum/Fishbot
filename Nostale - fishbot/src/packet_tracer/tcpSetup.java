package packet_tracer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import packet_tracer.tcpClient; 

public class tcpSetup {

	 tcpClient tcpClient;

	    public tcpSetup(){
	        while(true) {
	            try {
	                tcpClient = new tcpClient();
	             
	                break;
	            } catch (Exception e) {
	                System.out.println('\n' + e.toString());
	                System.out.println("Retry in 3seconds... \n");

	                try {
	                    Thread.sleep(3000);
	                } catch (InterruptedException interruptedException) {
	                    interruptedException.printStackTrace();
	                }
	            }
	        }
	    }

	    public tcpClient getTcpClient() { return tcpClient; }
	
}
