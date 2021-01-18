package packet_tracer;

import packet_tracer.tcpClient;
import packet_tracer.portParser;
import packet_tracer.tcpSetup;
import packet_tracer.packet;
import packet_tracer.packetType;

import java.io.IOException;
import java.net.SocketException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class program {
	private boolean isFrozen;
	private boolean last;
	public program() {
		isFrozen = false;
	}
public static void main(String[] args) {
	
	System.out.println("Fishbot for NosTale. \n");
	
	program program = new program();
	tcpSetup tcpSetup = new tcpSetup();
	
	packet packet;
	
	for(;;) {
		try {
		String line;
		
		if((line = tcpSetup.getTcpClient().readDataLine()) != null) {
			packet = new packet(line);
			if(packet.getPacketType() == packetType.RECEIVE && !program.isFrozen) {
                program.handleReceive(packet, tcpSetup.getTcpClient());
            } else if(packet.getPacketType() == packetType.SEND){
                program.handlerSend(packet);
                               
            }
		}
		} catch (SocketException e) {
            System.out.println(e.toString());
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
		//System.out.println("zarzuæ wêdkê");
		
		//System.out.println("zaczekaj a¿ bêdzie bra³o");
		
		
        
}
	
	}
private void handlerSend(packet packet) throws IOException{
	String packetSend = packet.getRawPacket();
	if(packetSend.equals("")) {
		System.out.println("elo");
	}
	
	
}
private void handleReceive(packet packet, tcpClient tcpClient) {
	
	String packetRecived = packet.getRawPacket();
	if(packetRecived.contains("guri 6 1 2142534 ")&& !packetRecived.contains("guri 6 1 2142534 0") ) {//odczytywanie pakietu z gry (jest ryba)
		//&& !packetRecived.contains("guri 6 1 2142534 0")&& !packetRecived.contains("guri 6 1 2142534 44")&& !packetRecived.contains("guri 6 1 2142534 26")
		System.out.println(packetRecived);
		
		
		tcpClient.sendMessage("1 u_s 2 1 2142534");// wyci¹gnij rybe
			try {
			Thread.sleep(7200);
			tcpClient.sendMessage("1 u_s 9 1 2142534");
			Thread.sleep(1100);
			tcpClient.sendMessage("1 u_s 8 1 2142534");
			Thread.sleep(1100);
			
				tcpClient.sendMessage("1 u_s 3 1 2142534");
			
			
			Thread.sleep(1600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (last == true) {
			tcpClient.sendMessage("1 u_s 10 1 2142534");
			last = false;
		}
		else {
			tcpClient.sendMessage("1 u_s 1 1 2142534");
		}
		}
	if(packetRecived.contains("sr 10")){
		last = true;
	}
}
}
