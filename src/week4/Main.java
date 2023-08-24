package week4;

public class Main {
    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(100);
        hashTable.insert(new Student(207404997, "Yedidya1", 24));
        hashTable.insert(new Student(374974637, "asdf", 20));
        hashTable.insert(new Student(484639843, "1234", 19));
        hashTable.insert(new Student(207208932, "*%*  ^%jgf kt", 24));
        hashTable.insert(new Student(311284647, "guy F^  \n&U  Y^t8u", 22));
        MyHashTable hashTable1 = new MyHashTable(hashTable);
        System.out.println("0\n"+hashTable);
        System.out.println("1\n"+hashTable1);
        hashTable1.insert(new Student(484639843, "vsv", 23));
        System.out.println("1\n"+hashTable1);
        System.out.println("0\n"+hashTable);
        hashTable.insert(new Student(207404997, "Yedidya", 24));
        System.out.println("0\n"+hashTable);
        System.out.println("------------------------------------\n\n\n\n\n");
        HashTable2 hashtable2 = new HashTable2(100);
        hashtable2.insert(new Student(207404997, "Yedidya1", 24));
        hashtable2.insert(new Student(374974637, "asdf", 20));
        hashtable2.insert(new Student(484639843, "1234", 19));
        hashtable2.insert(new Student(207208932, "*%*  ^%jgf kt", 24));
        hashtable2.insert(new Student(311284647, "guy F^  \n&U  Y^t8u", 22));
        HashTable2 hashtable21 = new HashTable2(hashtable2);
        System.out.println("0\n"+hashtable2);
        System.out.println("1\n"+hashtable21);
        hashtable21.insert(new Student(484639843, "vsv", 23));
        System.out.println("1\n"+hashtable21);
        System.out.println("0\n"+hashtable2);
        hashtable2.insert(new Student(207404997, "Yedidya", 24));
        System.out.println("0\n"+hashtable2);
        hashtable2.remove("207404997");
        hashtable2.remove("374974637");
        hashtable2.remove("207404997");
        hashtable2.remove("484639843");
        hashtable2.remove("311284647");
        System.out.println("0\n"+hashtable2);
        hashtable2.remove("207208932");
        System.out.println("0\n"+hashtable2);
    }
}
