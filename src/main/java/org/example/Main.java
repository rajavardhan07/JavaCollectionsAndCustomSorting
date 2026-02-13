package  org.example;
import java.util.*;
import java.lang.*;
import java.io.*;

class Phone {
    int id;
    String name;
    String brand;
    double price;

    Phone(int id, String name, String brand, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }
}
class PhoneManager {
    List<Phone> phones = new ArrayList<>();
    PhoneManager(List<Phone> p){
        this.phones = p;
    }
    public void addPhone(Phone p){
        phones.add(p);
    }
    public void removeByPhoneId(int id){
        phones.removeIf(p -> p.id == id);
    }
    // sort using local inner class

    public void sortPhonesByName(){
        class NameComparator implements Comparator<Phone>{
            @Override
            public int compare(Phone p1,Phone p2){
                return  p1.name.compareTo(p2.name);
            }
        }
        Collections.sort(phones, new NameComparator());
    }
    // sort using anonymous class
    public void sortPhonesByprice(){
        Collections.sort(phones, new Comparator<Phone>(){
            @Override
            public int compare(Phone p1,Phone p2){
                return Double.compare(p1.price, p2.price);
            }
        });
    }
    // sort using lambda expression
    public void sortPhonesByBrand(){
        Collections.sort(phones,(p1,p2) ->{
            return p1.brand.compareTo(p2.brand);
        });
    }
    public void displayPhones(){ for(Phone p : phones){ System.out.println("ID: " + p.id + ", Name: " + p.name + ", Brand: " + p.brand + ", Price: " + p.price); } }
}
class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        List<Phone> li = new ArrayList<>();
        PhoneManager pm = new PhoneManager(li);
        pm.addPhone(new Phone(100, "IPhone 13", "Apple", 99999));
        pm.addPhone(new Phone(101, "Galaxy S21", "Samsung", 79999));
        pm.addPhone(new Phone(102, "Pixel 6", "Google", 59999));
        System.out.println("After sorting by name:");
        pm.displayPhones();
        System.out.println("------------------------------");
        pm.sortPhonesByprice();
        System.out.println("After sorting by price:");
        pm.displayPhones();
        System.out.println("------------------------------");
        pm.sortPhonesByBrand();
        System.out.println("After sorting by brand:");
        pm.displayPhones();
    }
}