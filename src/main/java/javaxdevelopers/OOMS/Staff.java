package javaxdevelopers.OOMS;

import javaxdevelopers.exceptionhandlers.InvalidContactNumberException;
import javaxdevelopers.exceptionhandlers.NoNegativeValueException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff extends Person implements Serializable {

    private String contact;
    private String role;
    private double pay;

    public Staff(){}
    /*no arg const. is preferred over fully parametrized one because input data
     method is divided in two parts one in parent class and one in child so it is easy to
    set values after creating empty object
     */

    public static void writeStaffToFile(ArrayList<Staff> staff) {
        try (ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("staffData.ser"))) {
            // Check if the file is already created and not empty
            //boolean append = new File("staffData.ser").length() > 0;
            //ObjectOutputStream oos = append ? new AppendingObjectOutputStream(fos) : new ObjectOutputStream(fos);
            oos.writeObject(staff);
            oos.close(); // Close the stream
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void addStaff(OOM organization){
    //checks if there is room for more staff and then calls inputData method to set values
    //of staff object and then store it in staffList in management class
    int id = organization.getStaffList().size() + 1;
    if (id<=15) {
        Staff employee = new Staff();
        employee.inputData();
        employee.setId(id);
        organization.getStaffList().add(employee);
        writeStaffToFile(organization.getStaffList());
        System.out.println("Staff added successfully! ");

    }
    else
        System.out.println("No more space for staff!");
}

@Override
public void inputData() {
    //sets values for staff object taken from user
    //values of attributes of parent class are set using method in parent class
    System.out.println("---Staff---");
    super.inputData();
    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    System.out.print("Enter role of staff: ");
    this.setRole(inputString.nextLine());

    while(true) {
        System.out.print("Enter pay of staff: ");
        try {
            this.setPay(input.nextDouble());
            break;
        }catch (NoNegativeValueException e){
            System.out.println(e.getMessage());
        }
    }

    boolean validContact = false;
    System.out.print("Enter contact of staff: ");
    do {
        try {
            this.setContact(inputString.nextLine());
            validContact = true;
        } catch (InvalidContactNumberException e) {
            System.out.println(e.getMessage());
        }
    }while(!validContact);

}

public  static void removeStaff(OOM organization){
    //checks if specified staff is present and removes it after ensuring form user
    System.out.print("Enter staff id to remove: ");
    Scanner input=new Scanner(System.in);
    int id= input.nextInt();
    boolean flag=false;
    for(Staff employee: organization.getStaffList()) {
        if (employee.getId() == id) {
            flag = true;
            employee.displayData();
            System.out.print("Are you sure you want to delete this staff?\n\"Enter 1 to continue\": ");
            int choice = input.nextInt();
            if (choice == 1) {
                organization.getStaffList().remove(employee);
                System.out.println("Staff removed successfully!");
                return;
            }
        }
    }
    if (!flag){
        System.out.println("Staff not found!");
    }
}
public static void updateRecordOptions(OOM organization){
    //takes choice from user and calls method to update data
    Scanner input=new Scanner(System.in);

    System.out.print("Enter staff ID to update record: ");
    int id = input.nextInt();
    boolean flag=false;

    for(Staff staff: organization.getStaffList()){
        if(staff.getId()==id){
            flag=true;
            System.out.println("Enter attribute to update record: ");
            System.out.println("1: Name");
            System.out.println("2: age");
            System.out.println("3: Education");
            System.out.println("4: Role");
            System.out.println("5: Pay");
            System.out.println("6: Contact");
            int choice= input.nextInt();
            staff.updateData(choice);

        }
        if (!flag){
            System.out.println("No such employee found");
        }
    }
    //updateFile(organization.getStaffList());
    writeStaffToFile(organization.getStaffList());
}

@Override
public void updateData(int choice) {
    //common attributes are updated in parent class others in this class
    Scanner input=new Scanner(System.in);
    Scanner inputString=new Scanner(System.in);
    super.updateData(choice);
    switch(choice) {
        //empty cases ensure default statement is not hit if one of these choices
        //are worked in parent class
        case 1:
        case 2:
        case 3:
            break;
        case 4:
            System.out.println("Previous role is: " + this.getRole());
            System.out.print("Enter new role: ");
            this.setRole(inputString.nextLine());
            break;
        case 5:
            boolean validPay = false;
            System.out.println("Previous pay is: " + this.getPay());
            System.out.print("Enter new pay of staff: ");
            do
            {
                try {
                    this.setPay(input.nextDouble());
                    validPay = true;
                } catch (NoNegativeValueException e) {
                    System.out.println(e.getMessage());
                }
            }while(!validPay);
            break;
        case 6:
            boolean validContact = false;
            System.out.println("Previous contact is: " + this.getContact());
            System.out.print("Enter new contact: ");
            do {
                try {
                    this.setContact(inputString.nextLine());
                    validContact = true;
                } catch (InvalidContactNumberException e) {
                    System.out.println(e.getMessage());
                }
            }while(!validContact);
            break;
        default:
            System.out.println("Please make a valid choice");
    }
}
//remaining methods are with same functionality as in donation class
@Override
public void displayData() {
    System.out.println("---Printing Data for staff "+(this.getId())+"---");
    super.displayData();
    System.out.println("Role: "+this.getRole());
    System.out.println("Pay: "+this.getPay());
    System.out.println("Contact: "+this.getContact());
}

public static void viewStaff(OOM organization){
    boolean flag=false;
    Scanner input=new Scanner(System.in);
    System.out.print("Enter staff id to view: ");
    int id= input.nextInt();
    for(Staff employee: organization.getStaffList()){
        if(employee.getId()==id) {
            System.out.println("Employee found!");
            flag=true;
            employee.displayData();
        }
    }
    if (!flag){
        System.out.println("No such staff found!");
    }


}
public String getContact() {
    return contact;
}

public void setContact(String contact) throws InvalidContactNumberException{
    if(contact.matches("[0-9]+"))
        this.contact = contact;
    else
        throw new InvalidContactNumberException("Exception: Contact Number should only contain digits!");
}

public String getRole() {
    return role;
}

public void setRole(String role) {
    this.role = role;
}

public double getPay() {
    return pay;
}

public void setPay(double pay) throws NoNegativeValueException {
    if( pay > 0)
        this.pay = pay;
    else
        throw new NoNegativeValueException("Exception: Pay cannot be less than zero!");
}
}