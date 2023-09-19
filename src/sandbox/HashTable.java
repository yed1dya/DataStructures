package sandbox;

import java.util.Hashtable;

class Person{
    String name;
    int grade;
    int grade2;
    boolean happy;
    boolean madmach;
    int taz;
    public Person(boolean madmach, String name, int taz){
        this.name = name;
        if(madmach){
            happy = false;
            name = "roni";
        }
        this.taz = taz;
    }
}
public class HashTable {
    public static void main(String[] args) {
        Person roni = new Person(true, "roni", 2071);
        Hashtable<String, Person> table = new Hashtable<>(10);
        table.put("2071", roni);

        Hashtable<Integer, String> tableInt = new Hashtable<>(10);
        tableInt.put(1537432, "bob");
        tableInt.put(123, "pat");
        tableInt.put(123, "avebrbrbr");
        tableInt.put(321, "sand");
        tableInt.put(555, "squid");
        tableInt.put(777, "gary");

        for(String k : table.keySet()){
            System.out.println(k + "\t" + k.hashCode() + "\t" + k.hashCode()%10 + "\t" + table.get(k));
        }
        for(Integer k : tableInt.keySet()){
            System.out.println(k + "\t" + k.hashCode() + "\t" + k.hashCode()%10 + "\t" + tableInt.get(k));
        }
    }
}
