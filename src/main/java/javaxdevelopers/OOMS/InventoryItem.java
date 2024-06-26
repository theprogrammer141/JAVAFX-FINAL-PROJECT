package javaxdevelopers.OOMS;

import javaxdevelopers.exceptionhandlers.NoNegativeValueException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
//methods with similar working as in donation class
public class InventoryItem implements Serializable {
    private int itemID;
    private String itemName;
    private double itemPrice;
    private int quantity;
    private String itemType;


    public static void writeItemToFile(ArrayList<InventoryItem> item) {
        try (ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("itemData.ser"))) {
            // Check if the file is already created and not empty
           // boolean append = new File("itemData.ser").length() > 0;
            //ObjectOutputStream oos = append ? new AppendingObjectOutputStream(fos) : new ObjectOutputStream(fos);
            oos.writeObject(item);
            oos.close(); // Close the stream
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addItem(OOM organization){
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        System.out.println("---Enter Item details---");

        InventoryItem item=new InventoryItem();
        item.setItemID(organization.getItemsList().size()+1);

        System.out.print("Enter item name: ");
        item.setItemName(inputString.nextLine());

        while(true) {
            System.out.print("Enter item Price: ");
            try {
                item.setItemPrice(input.nextDouble());
                break;
            }catch (NoNegativeValueException e){
                System.out.println(e.getMessage());
            }
        }

        while(true) {
            System.out.print("Enter Quantity: ");
            try {
                item.setQuantity(input.nextInt());
                break;
            }catch (NoNegativeValueException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Enter item type: ");
        item.setItemType(inputString.nextLine());

        organization.getItemsList().add(item);
        writeItemToFile(organization.getItemsList());
        System.out.println("Item added successfully!");

    }
    public static void removeItem(OOM organization){
        System.out.print("Enter Item id to remove: ");
        Scanner input=new Scanner(System.in);
        int id= input.nextInt();
        boolean flag=false;
        for(InventoryItem item: organization.getItemsList()) {
            if (item.getItemID() == id) {
                flag = true;
                item.displayData();
                System.out.print("Are you sure you want to delete this Item?\n\"Enter 1 to continue\": ");
                int choice = input.nextInt();
                if (choice == 1) {
                    organization.getItemsList().remove(item);
                    System.out.println("Item removed successfully!");
                    return;
                }
            }
        }
        if (!flag){
            System.out.println("Item not found!");
        }
    }
    public static void updateRecord(OOM organization) {
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        System.out.print("Enter Item ID to update record: ");
        int id = input.nextInt();

        boolean flag = false;
        for (InventoryItem item : organization.getItemsList()) {
            if (item.getItemID() == id) {
                flag = true;
                System.out.println("Enter attribute to update record: ");
                System.out.println("1: Name");
                System.out.println("2: Price");
                System.out.println("3: Quantity");
                System.out.println("4: Item type");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Previous name is: "+item.getItemName());
                        System.out.print("Enter new name: ");
                        item.setItemName(inputString.nextLine());
                        break;
                    case 2:
                        System.out.println("Previous Price is: " + item.getItemPrice());
                        while(true) {
                            System.out.print("Enter new item Price: ");
                            try {
                                item.setItemPrice(input.nextDouble());
                                break;
                            }catch (NoNegativeValueException e){
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Previous Quantity is: " + item.getQuantity());
                        while(true) {
                            System.out.print("Enter New Quantity: ");
                            try {
                                item.setQuantity(input.nextInt());
                                break;
                            }catch (NoNegativeValueException e){
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Previous item type is: "+item.getItemType());
                        System.out.print("Enter new type: ");
                        item.setItemType(inputString.nextLine());
                        break;
                    default:
                        System.out.println("Make a valid choice!");
                }
            }
        }
        writeItemToFile(organization.getItemsList());
        if (!flag)
            writeItemToFile(organization.getItemsList());

    }
    public void displayData(){
        System.out.printf("---Printing details for item %d---\n",this.getItemID());
        System.out.println("Item Name: "+this.getItemName());
        System.out.println("Item Price: "+this.getItemPrice());
        System.out.println("Item Quantity: "+this.getQuantity());
        System.out.println("Item type: "+this.getItemType());
    }
    public static void viewItem(OOM organization){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter ID to view item: ");
        int id= input.nextInt();
        boolean flag=false;
        for(InventoryItem item: organization.getItemsList()){
            if(item.getItemID()==id){
                flag=true;
                item.displayData();
            }
        }
        if (!flag){
            System.out.println("Item not found!");
        }
    }


    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) throws NoNegativeValueException {
        if(itemPrice > 0)
            this.itemPrice = itemPrice;
        else
            throw new NoNegativeValueException("Item price cannot be negative!");
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) throws NoNegativeValueException{
        if(quantity>0)
            this.quantity = quantity;
        else
            throw new NoNegativeValueException("Quantity must be a positive number");
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

}
