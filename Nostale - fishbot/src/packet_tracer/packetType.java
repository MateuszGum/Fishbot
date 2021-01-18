package packet_tracer;

public enum packetType {
	RECEIVE(0),
    SEND(1);

    int value;

    packetType(int value) {
        this.value = value;
    }
}
