import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer {

    private String name;
    private String customerId;
    private static int customerPassword = 3000;
    private static int id = 1000;
    private static int flightNo = 9000;

    Scanner scan = new Scanner(System.in);
    HashMap<String, String> nameId = new HashMap<>();
    HashMap<String, Integer> namePwd = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        id++;
        String arr[] = getName().split(" ");
        this.customerId = "" + arr[0].charAt(0) + arr[1].charAt(0) + id;
    }

    public static int getCustomerPassword() {
        return customerPassword;
    }

    public static void setCustomerPassword(int customerPassword) {
        Customer.customerPassword = customerPassword;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Customer.id = id;
    }

    public static int getFlightNo() {
        return flightNo;
    }

    public static void setFlightNo(int flightNo) {
        Customer.flightNo = flightNo;
    }

    public void addCustomer() {
        nameId.put(getName(), getCustomerId());
        namePwd.put(getName(), getCustomerPassword());
    }

    public void signIn() {
        do {
            System.out.println("Musteri eklemek ister misiniz? (E/H)");
            char onay = scan.next().toLowerCase().charAt(0);

            if (onay == 'h') {
                break;
            } else if (onay == 'e') {
                System.out.print("Lutfen tam isminizi giriniz: ");
                scan.nextLine();
                setName(scan.nextLine());
                try {
                    setCustomerId(customerId);
                    setCustomerPassword(++customerPassword);
                    addCustomer();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Soy isminizi de girmelisiniz");
                }


            } else {
                System.out.println("Lutfen 'E' veya 'H' harflerinden birini giriniz. ");
            }

        } while (true);
        System.out.println(nameId);
        System.out.println(namePwd);
    }

    public void updatePassword() {

        int newPwd;
        String customerId = "";
        String name = "";
        int varolanPassword = 0;

        do {
            System.out.println("Password olusturmak icin isminizi giriniz ");
            System.out.println("Password olusturmayi sonlandirmak icin q'ya basiniz");
            scan.nextLine();
            name = scan.nextLine();

            if (name.equalsIgnoreCase("q")) {
                System.out.println("Password degismemistir.");
                break;
            }
            System.out.println("Eski passwordu giriniz");
            int oldPwd = 0;
            try {
                oldPwd = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Password rakamlardan olusmali");

            }


            try {
                varolanPassword = namePwd.get(name);

            } catch (NullPointerException e) {
                varolanPassword = -1;
            }
            if (!(oldPwd == varolanPassword)) {

                System.out.println("Passwordunuz gecersizdir");

            } else {
                System.out.println("Yeni passwordu giriniz");
                newPwd = scan.nextInt();
                scan.nextLine();
                namePwd.put(name, newPwd);
                break;
            }
        } while (true);
        if (!(varolanPassword == -1)) {
            System.out.println(name + " Password: " + namePwd.get(name));
        }


    }

    public String setFlightNo(String nereden, String nereye, String tarih) {
        String flightNo = "" + nereden.charAt(0) + nereye.charAt(0) + tarih.substring(2, 4) + tarih.substring(5, 7) + tarih.substring(8);
        return flightNo;
    }

}
