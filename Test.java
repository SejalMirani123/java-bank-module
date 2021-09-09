import java.util.Scanner;

class Bank {
    private String accno;
    private String name;
    private long balance;

    Scanner KB = new Scanner(System.in);

    
    void openAccount() {
        System.out.print("Enter Account No: ");
        accno = KB.next();
        System.out.print("Enter Name: ");
        name = KB.next();
        System.out.print("Enter Balance: ");
        balance = KB.nextLong();
    }

    
    void showAccount() {
        System.out.println(accno + "," + name + "," + balance);
    }

    
    void deposit() {
        long amt;
        System.out.println("Enter Amount U Want to Deposit : ");
        amt = KB.nextLong();
        balance = balance + amt;
    }

    
    void withdrawal() {
        long amt;
        System.out.println("Enter Amount U Want to withdraw : ");
        amt = KB.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
        } else {
            System.out.println("Less Balance..Transaction Failed..");
        }
    }

    
    boolean search(String acn) {
        if (accno.equals(acn)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}

public class Test {
    public static void main(String arg[]) {
        Scanner KB = new Scanner(System.in);

        
        System.out.print("How Many Customer U Want to Input : ");
        int n = KB.nextInt();
        Bank C[] = new Bank[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new Bank();
            C[i].openAccount();
        }

        
        int ch;
        do {
            System.out.println("Main Menu\n1. Display All\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5.Purchase \n6.Exit ");
                System.out.println("Ur Choice :"); ch = KB.nextInt();
                switch (ch) {
                    case 1:
                        for (int i = 0; i < C.length; i++) {
                            C[i].showAccount();
                        }
                        break;

                    case 2:
                        System.out.print("Enter Account No U Want to Search...: ");
                        String acn = KB.next();
                        boolean found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Account No : ");
                        acn = KB.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].deposit();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Account No : ");
                        acn = KB.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].withdrawal();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;
                        case 5:
                             System.out.println("original price");
            double originalprice=KB.nextDouble();
            double discountrate;
            if(originalprice<128){
                discountrate=0.92;
            }
            else{
                discountrate=0.84;
            }
            double discountprice=discountrate*originalprice;
            System.out.println("discount price"+discountprice);
            break;

                    case 6:
                        System.out.println("Good Bye..");
                        break;
                }
            }
            while (ch != 6);
           
        }
    }