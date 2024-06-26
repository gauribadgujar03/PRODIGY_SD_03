import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

public class ContactManagementSystem {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    public ContactManagementSystem() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact() {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter contact email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    public void displayAllContacts() {
        System.out.println("List of Contacts:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void searchContactByName() {
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Contact found:");
                System.out.println(contact);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContactByName() {
        System.out.print("Enter name to delete: ");
        String deleteName = scanner.nextLine();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(deleteName)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\nContact Management System Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("3. Search Contact by Name");
            System.out.println("4. Delete Contact by Name");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    displayAllContacts();
                    break;
                case 3:
                    searchContactByName();
                    break;
                case 4:
                    deleteContactByName();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
                    break;
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        ContactManagementSystem system = new ContactManagementSystem();
        system.menu();
    }
}
