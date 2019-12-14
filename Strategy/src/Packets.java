import java.math.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Packets {

    ArrayList<Integer> packets;

    public Packets(int num){
        packets = new ArrayList<Integer>();
        randomizePackets(num);
    }

    public ArrayList<Integer> getPackets(){
        return packets;
    }
    public void randomizePackets(int num){
        for(int i = 0; i < num; i++){
            int value = (int) (Math.random() * num) + 1;
            if(!packets.contains(value)) packets.add(value);
        }
    }

    @Override
    public String toString() {
        String s = "Packets in Queue : ";
        for (Integer packet: packets) {
            s += packet + ", ";
        }
        return s;
    }

    public static void main(String[] args){
        Packets queue = new Packets(20);
        System.out.print("Our queue: ");
        System.out.println(queue);
        FIFO fifo = new FIFO(queue);
        PriorityQueuing priorityQueuing = new PriorityQueuing(queue);
        fifo.sortQueue();
        System.out.println(fifo);
        priorityQueuing.sortQueue();
        System.out.println(priorityQueuing);
    }
}
