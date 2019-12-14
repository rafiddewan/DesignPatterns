import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueuing implements PacketQueueing {
    private PriorityQueue<Integer> packets;
    private ArrayList<Integer> unorderedPackets;

    public PriorityQueuing(Packets randomizedPackets){
        packets = new PriorityQueue<Integer>();
        unorderedPackets = new ArrayList<Integer>(randomizedPackets.getPackets());
    }

    @Override
    public void sortQueue() {
        for(Integer packet : unorderedPackets){
            packets.add(packet);
        }
    }

    @Override
    public int totalTransmissionTime() {
        int sum = 0;
        for(Integer  packet: packets){
            sum += packet;
        }
        return sum/packets.size();
    }

    @Override
    public String toString() {
        String s = "Packets Transmitting in order : ";
        for (Integer packet: packets) {
            s += packet + ", ";
        }
        s += "\nTotal Transmission Time: " + totalTransmissionTime();
        return s;
    }
}
