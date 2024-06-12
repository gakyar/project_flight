import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        /*Customer customer = new Customer();
        customer.signIn();
        customer.updatePassword();

        Scanner scan = new Scanner(System.in);
        System.out.println("Nereden ucacaksiniz?");
        String nereden = scan.next();
        System.out.println("Nereye ucacaksiniz?");
        String nereye = scan.next();
        System.out.println("Hangi tarihte ucacaksiniz?");
        String tarih = scan.next();
        System.out.println(customer.setFlightNo(nereden, nereye, tarih));*/

        Flights flights = new Flights();
        flights.selectFlight();


    }
}
