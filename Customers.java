import java.io.*;
import java.util.Scanner;

public class Customers {
    Customer customerList[] = new Customer[100];
    public static int customerCount = 0;

    public Customers() {
        try {
            File file = new File("Files/customerList.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String name = sc.nextLine();
                String number = sc.nextLine();
				String address = sc.nextLine();
                String password = sc.nextLine();

                Customer customer = new Customer(name, number, address, password);
                customerList[customerCount] = customer;
                customerCount++;
            }
            sc.close();
        } catch (Exception ex) {
            System.out.println("File not found.");
        }
    }

    public void addCustomer(Customer c) {
        try {
            customerList[customerCount] = c;
            customerCount++;
        } catch (Exception ex) {
            System.out.println("Array full");
        }

        String customerDetails = c.getName() + "\n" + c.getNumber() + "\n" + c.getAddress() +  "\n" + c.getPassword() + "\n";
        try {
            FileWriter fw = new FileWriter("Files/customerList.txt", true);
            fw.write(customerDetails);
            fw.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public int customerExists(String name) {
        for (int i = 0; i < customerCount; i++) {
            if (customerList[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Customer checkPassword(int index, String pass) {
        if (customerList[index].getPassword().equals(pass)) {
            return customerList[index];
        }
        return null;
    }
	public boolean checkNumber(int index, String num) {
        if (customerList[index].getNumber().equals(num)) {
            return true;
        }
        return false;
    }

    public Customer getCustomer(int index) {
        return customerList[index];
    } 
	
	
	
	
}
