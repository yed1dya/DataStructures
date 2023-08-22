package week4;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashTable {
    int size;
    LinkedList<Node>[] students;
    public MyHashTable(int size){
        this.size = size;
        this.students = new LinkedList[size];
    }
    public MyHashTable(MyHashTable ht){
        this.size = ht.size;
        this.students = new LinkedList[size];
        for(int i=0; i<size; i++){
            if(ht.students[i] == null) continue;
            this.students[i] =  new LinkedList<>(ht.students[i]);
        }
    }
    public Integer insert(Student data){
        Integer index = hash(data.ID());
        Node newNode = new Node(data);
        if(this.students[index] == null){
            this.students[index] = new LinkedList<>();
        }
        LinkedList<Node> list = this.students[index];
        boolean added = false;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).ID.equals(newNode.ID)){
                list.set(i, newNode);
                added = true;
            }
        }
        if(!added){
            list.add(newNode);
        }
        return index;
    }
    private Integer hash(Integer key){
        return key%size;
    }
    public Student remove(String key){
        Integer keyInt = null;
        try {
            keyInt = Integer.parseInt(key);
        }catch (NumberFormatException ignored){}
        Integer index = hash(keyInt);
        LinkedList<Node> list = this.students[index];
        int i=0;
        for(Node node : list){
            if(node.ID.equals(keyInt)){
                return list.remove(i).data;
            }
            i++;
        }
        return null;
    }
    public Student get(String key){
        Integer keyInt = null;
        try {
            keyInt = Integer.parseInt(key);
        }catch (NumberFormatException ignored){}
        Integer index = hash(keyInt);
        LinkedList<Node> list = this.students[index];
        int i=0;
        for(Node node : list){
            if(node.ID.equals(keyInt)){
                return list.get(i).data;
            }
            i++;
        }
        return null;
    }
    public String toString(){
        StringBuilder ans = new StringBuilder();
        for(LinkedList<Node> list : students){
            if(list==null) continue;
            for(Node node : list){
                if(node==null) continue;
                Student s = node.data;
                ans.append("ID: ").append(s.ID())
                        .append(", Name: ").append(s.name())
                        .append(", age: ").append(s.age())
                        .append("\n");
            }
        }
        return ans.toString();
    }
}

class Node{
    Integer ID;
    Student data;
    public Node(Student student){
        ID = student.ID();
        data = new Student(student);
    }
}