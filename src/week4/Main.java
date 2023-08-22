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
    }
}
