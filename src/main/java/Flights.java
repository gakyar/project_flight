import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Flights extends Customer {

    HashMap<String, String> flights = new HashMap<>();
    List<String> locations = new ArrayList<>();
    List<String> flightTimes = new ArrayList<>();

    public List setLocations() {
        locations.add("Ankara");
        locations.add("Van");
        locations.add("Urfa");
        return locations;
    }

    public List setTimes() {
        flightTimes.add("06:00");
        flightTimes.add("10:00");
        flightTimes.add("12:00");
        flightTimes.add("14:00");
        flightTimes.add("22:00");
        flightTimes.add("23:00");
        return flightTimes;
    }

    public HashMap setFlight() {
        setLocations();
        setTimes();
        flights.put(locations.get(0) + "==>" + locations.get(1), flightTimes.get(0));
        flights.put(locations.get(1) + "==>" + locations.get(0), flightTimes.get(1));
        flights.put(locations.get(0) + "==>" + locations.get(2), flightTimes.get(4));
        flights.put(locations.get(2) + "==>" + locations.get(0), flightTimes.get(3));
        flights.put(locations.get(2) + "==>" + locations.get(1), flightTimes.get(5));
        return flights;
    }

    public void selectFlight() {
        HashMap<String, String> approvedFlights = new HashMap<>();
        setFlight();
        Scanner scanner = new Scanner(System.in);
        char quit = ' ';
        String nereden = "";
        String nereye = "";
        String date = "";
        char tekYon = ' ';

        while (quit != 'q') {
            System.out.println("Lutfen tekyon icin '1', gidis donus icin '2' tusuna basiniz ");
            tekYon = scanner.next().charAt(0);
            System.out.print("Gidis nereden: ");
            nereden = scanner.next();
            System.out.print("Gidis nereye: ");
            nereye = scanner.next();
            System.out.println("Gidis tarihi: ");
            System.out.println("Gidis tarihi (2024/06/06)");
            date = scanner.next();

            if (flights.containsKey(nereden + "==>" + nereye)) {
                System.out.println("Gidis ucus bilgileriniz: " + nereden + "==>" + nereye + " Tarih:" + date +
                        " Saat:" + flights.get(nereden + "==>" + nereye));
                System.out.println("Onayliyor musunuz? (E/H)");
                char onay = scanner.next().toLowerCase().charAt(0);
                if (onay == 'e') {
                    System.out.println("Gidis ucus bilgileriniz: " + nereden + "==>" + nereye + "Tarih:" + date +
                            "Saat:" + flights.get(nereden + "==>" + nereye));
                    System.out.println("Ucus numaraniz: " + setFlightNo(nereden, nereye, date));
                    approvedFlights.put("Gidis Ucus No: ", setFlightNo(nereden, nereye, date));
                } else if (onay == 'h') {
                    System.out.println("Seciminizi guncelleyebilirsiniz...");
                } else {
                    System.out.println("E veya H den birini seciniz...");
                }
            }
            if (tekYon == '2') {
                String gecici = nereden;
                nereden = nereye;
                nereye = gecici;
                System.out.println("Donus Tarihi (yyyy/mm/dd)");
                date = scanner.next();
            }
            if (flights.containsKey(nereden + "==>" + nereye)) {
                System.out.println("Donus ucus bilgileriniz: " + nereden + "==>" + nereye + " Tarih:" + date +
                        " Saat:" + flights.get(nereden + "==>" + nereye));
                System.out.println("Onayliyor musunuz? (E/H)");
                char onay = scanner.next().toLowerCase().charAt(0);
                if (onay == 'e') {
                    System.out.println("Donus ucus bilgileriniz: " + nereden + "==>" + nereye + "Tarih:" + date +
                            "Saat:" + flights.get(nereden + "==>" + nereye));
                    System.out.println("Ucus numaraniz: " + setFlightNo(nereden, nereye, date));
                    approvedFlights.put("Donus Ucus No: ", setFlightNo(nereden, nereye, date));
                } else if (onay == 'h') {
                    System.out.println("Seciminizi guncelleyebilirsiniz...");
                } else {
                    System.out.println("E veya H den birini seciniz...");
                }
            }
            System.out.println("Ucus arama islemini durdurmak icin Q ya basiniz");
            System.out.println("Ucus arama islemini devam etmek icin  herhangi bir sayi giriniz");
            quit = scanner.next().toLowerCase().charAt(0);
        }
        System.out.println(approvedFlights);
    }
}
