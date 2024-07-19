import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void ticketbook(Passenger p)
    {
        Booking book=new Booking();
        if(p.pref.equals("L") && Booking.availLow>=1)
        {
            System.out.println("Booking confirm");
            book.ticketbooking(p);
            Booking.availLow--;

        }
        else if(p.pref.equals("M") && Booking.availmid>=1)
        {
            System.out.println("Booking confirm");
            book.ticketbooking(p);
            Booking.availmid--;

        }
        else if(p.pref.equals("U") && Booking.availup>=1)
        {
            System.out.println("Booking confirm");
            book.ticketbooking(p);
            Booking.availup--;

        }
        else if(Booking.availLow>=1)
        {
            System.out.println("Booking confirm in low");
            book.ticketbooking(p);
            Booking.availLow--;

        }
        else if(Booking.availmid>=1)
        {
            System.out.println("Booking confirm in Mid");
            book.ticketbooking(p);
            Booking.availmid--;

        }
        else if(Booking.availup>=1)
        {
            System.out.println("Booking confirm in upper");
            book.ticketbooking(p);
            Booking.availup--;

        }
        else if (Booking.wl.size()<=2){
            book.addToWl(p);

        }
        else{
            System.out.println("no ticket");
        }
    }


    public static void main(String[] args) {
        System.out.println(Booking.wl.size());
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("1.book ticket /n 2.cancel /n 3.print");
            int n = sc.nextInt();
            switch(n)
            {
                case 1: {
                    System.out.println("enter the values1");
                    String name = sc.next();
                    String pref = sc.next();
                    int id=sc.nextInt();
                    Passenger p = new Passenger(name, pref,id);
                    ticketbook(p);
                }
                    break;

                case 2: {
                    Booking book = new Booking();
                    System.out.println("enter the id");
                    int id = sc.nextInt();
                    book.cancelTicket(id);
                }
                    break;
                case 3:{
                    Booking book = new Booking();
                    book.printBooking();
                }
            }

        }
    }
}