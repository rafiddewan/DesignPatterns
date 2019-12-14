import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FIFO implements PacketQueueing {

    private LinkedList<Integer> packets;
    private ArrayList<Integer> unsortedpackets;

    public FIFO(Packets randomizedPackets){
        unsortedpackets = new ArrayList<Integer>(randomizedPackets.getPackets());
        packets = new LinkedList<Integer>();
    }

    @Override
    public void sortQueue() {
        packets = new LinkedList<Integer>(unsortedpackets);
    }

    @Override
    public int totalTransmissionTime() {
        int sum = 0;
        for(Integer packet : packets){
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
