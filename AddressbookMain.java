package AddressBookMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressbookMain {
    private List<personDetails> addressbook = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    private void addPerson() {
        personDetails person = new personDetails();
        System.out.println("Enter First Name");
        String firstName = sc.nextLine();
        System.out.println("Enter Last Name");
        String lastName = sc.nextLine();
        System.out.println("Enter Address");
        String address = sc.nextLine();
        System.out.println("Enter City");
        String city = sc.nextLine();
        System.out.println("Enter State");
        String state = sc.nextLine();
        System.out.println("Enter Zip code");
        int zipcode = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Phone Number");
        long phoneNumber = Long.parseLong(sc.nextLine());

        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAddress(address);
        person.setCity(city);
        person.setState(city);
        person.setZipCode(zipcode);
        person.setPhoneNumber(phoneNumber);

        addressbook.add(person);
    }

    private void editPerson() {
        System.out.println("Enter the Name");
        String personName = sc.nextLine();
        personDetails personDetails = null;
        for (int i = 0; i < addressbook.size(); i++) {
            if (personName.equals(addressbook.get(i).getFirstName()) || personName.equals(addressbook.get(i).getLastName())) {
                personDetails = addressbook.get(i);
                break;
            }
        }
            if (personDetails != null) {
                System.out.println("Enter Address");
                String address = sc.nextLine();
                System.out.println("Enter City");
                String city = sc.nextLine();
                System.out.println("Enter State");
                String state = sc.nextLine();
                System.out.println("Enter Zip code");
                int zipcode = Integer.parseInt(sc.nextLine());
                System.out.println("Enter Phone Number");
                long phoneNumber = Long.parseLong(sc.nextLine());
                personDetails.setAddress(address);
                personDetails.setCity(city);
                personDetails.setState(state);
                personDetails.setZipCode(zipcode);
                personDetails.setPhoneNumber(phoneNumber);
            } else {
                System.out.println("No contacts details found" + personName);
            }
        }

    private void deletePerson() {
        System.out.println("Enter the Name");
        String personName = sc.nextLine();
        for (int i = 0; i < addressbook.size(); i++) {
            if (personName.equals(addressbook.get(i).getFirstName()) || personName.equals(addressbook.get(i).getLastName())) {
                addressbook.remove(i);
            } else {
                System.out.println("No contact found");
            }
        }
    }

    private void showaddressbook() {
        for (int i = 0; i < addressbook.size(); i++) {
            System.out.println(addressbook.get(i));
        }
    }


    public static void main(String[] args) {
        boolean isExit = false;
        AddressbookMain addressbookMain = new AddressbookMain();

        while (!isExit) {
            System.out.println(" Select option" +
                    "\n1. Add Person details" +
                    "\n2. Edit person" +
                    "\n3. Delete Person" +
                    "\n4. show Address book" +
                    "\n5. Exit");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addressbookMain.addPerson();
                    break;
                case 2:
                    addressbookMain.editPerson();
                    break;
                case 3:
                    addressbookMain.deletePerson();
                    break;
                case 4:
                    addressbookMain.showaddressbook();
                    break;
                case 5:
                    isExit = true;
                    break;
                default:
                    System.out.println("Please enter valid details");
            }
        }
    }
}
