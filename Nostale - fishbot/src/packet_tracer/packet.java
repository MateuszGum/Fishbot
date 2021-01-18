package packet_tracer;

import java.util.ArrayList;
import java.util.List;


public class packet {
	private final String packet;
    private int argumentsAmount;
    private final List<String> packetFields;
    private packetType packetType;
   
    
    public packet(String packet) {
        this.packet = packet;
        packetFields = new ArrayList<>();
        serializeArguments(packet);
    }

    private void serializeArguments(String packet) {
        StringBuilder args = new StringBuilder();
        int argumentCounter = 0;

        packetType = packet.charAt(0) == '0' ? packetType.RECEIVE : packetType.SEND;
        
        for (int i = 2; i < packet.length(); i++) {
            if (packet.charAt(i) == ' ') {
                packetFields.add(args.toString());
                args = new StringBuilder();
                argumentCounter++;
            } else {
                args.append(packet.charAt(i));
            }
        }

        if(args.length() != 0) {
            packetFields.add(args.toString());
            argumentCounter++;
        }

        argumentsAmount = argumentCounter;
    }

    public String getRawPacket() { return packet; }

    public int getArgumentsAmount() { return argumentsAmount; }

    public List<String> getPacketFields() { return packetFields; }

    public packetType getPacketType() { return packetType; }

    public String getHeader() { return packetFields.get(0); }

  
    
    public String getArgument(int index) {
        if(index < argumentsAmount) {
            return packetFields.get(index);
        }

        return "";
    }
}
