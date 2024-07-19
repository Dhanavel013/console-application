import java.util.*;

public class Booking {
    static int k=1;
    static ArrayList<Integer> ac= new ArrayList<>();
    static Queue<Passenger> wl= new LinkedList<>();
    static ArrayList<Integer>low=new ArrayList<>(2);
    static ArrayList<Integer>mid=new ArrayList<>(2);
    static ArrayList<Integer>up=new ArrayList<>(2);
    static ArrayList<Integer>booked=new ArrayList<>(2);
    static int availLow=2;
    static int availmid=2;
    static int availup=2;

    static Map<Integer, Passenger> passengers = new HashMap<>();

 public void ticketbooking(Passenger p)
 {      k+=1;
        passengers.put(k,p);
        booked.add(p.id);
 }
 public void cancelTicket(int id)
 {


    if(passengers.containsKey(id)){
        //booked.remove(0);
        passengers.remove(id);
        System.out.println("booking cancelled");

        if(wl.size()>1){
            Passenger p = wl.poll();
            Main.ticketbook(p);
            System.out.println("booking success for waiting list");
        }

    }
    else{
        System.out.println("not available");
    }

 }
 public void addToWl(Passenger p)
 {
     wl.add(p);
     System.out.printf("added to waiting list");
 }
 public void printBooking()
 {
     System.out.println(passengers.values());
     for(Passenger p :passengers.values()){
         System.out.println(p.name);
         System.out.println(p.id);
         System.out.println(p.pref);
         System.out.println(passengers.size());
     }
     }
 }