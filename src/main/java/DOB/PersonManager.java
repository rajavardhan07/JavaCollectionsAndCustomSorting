package DOB;

import java.util.*;

public class PersonManager {
    List<Person> li = new ArrayList<>();
    PersonManager(List<Person> p) {
        this.li = p;
    }
        public void addPerson(Person p) {
            li.add(p);
        }
        public void removeByName(String name) {
            li.removeIf(p -> p.getName().equals(name));
        }
        public void sortByDob() {
            Collections.sort(li, (p2, p1) -> {
                String[] dob1 = p1.getDob().split("-");
                String[] dob2 = p2.getDob().split("-");
                int p1Year = Integer.parseInt(dob1[0]);
                int p2Year = Integer.parseInt(dob2[0]);
                if (p1Year != p2Year) {
                    return Integer.compare(p1Year, p2Year);
                } else {
                    int p1Month = Integer.parseInt(dob1[1]);
                    int p2Month = Integer.parseInt(dob2[1]);
                    if (p1Month != p2Month) {
                        return Integer.compare(p1Month, p2Month);
                    } else {
                        int p1Day = Integer.parseInt(dob1[2]);
                        int p2Day = Integer.parseInt(dob2[2]);
                        return Integer.compare(p1Day, p2Day);
                    }
                }
            });
        }
        public void displayPersons() {
            for (Person p : li) {
                System.out.println("Name: " + p.getName() + ", DOB: " + p.getDob());
            }
        }
}
