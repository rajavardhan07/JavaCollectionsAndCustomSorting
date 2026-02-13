package DOB;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> li = new ArrayList<>();
        PersonManager pm = new PersonManager(li);
        pm.addPerson(new Person("Raja", "2005-02-15"));
        pm.addPerson(new Person("JP", "2002-05-15"));
        pm.addPerson(new Person("Sharath", "1995-08-20"));
        pm.addPerson(new Person("Suresh", "2002-12-10"));
        pm.addPerson(new Person("Charan", "2005-02-16"));
        System.out.println("------------------------------");
        System.out.println("Before sorting:");
        pm.displayPersons();
        System.out.println("------------------------------");
        pm.sortByDob();
        System.out.println("\nAfter sorting by DOB:");
        pm.displayPersons();
        System.out.println("------------------------------");
    }
}
