package week4;

public class HashTable2 {
    int size;
    Node2[] students;
    public HashTable2(int size){
        this.size = size;
        this.students = new Node2[size];
    }
    public HashTable2(HashTable2 ht){
        this.size = ht.size;
        this.students = new Node2[this.size];
        System.arraycopy(ht.students, 0, this.students, 0, ht.students.length);
    }
    public Integer insert(Student student){
        Integer index = hash(student.ID());
        Node2 newNode = new Node2(student);
        if(this.students[index]==null){
            this.students[index] = newNode;
        }
        else{
            Node2 node = this.students[index];
            while(node!=null){
                if(node.ID==student.ID()){
                    node.student = student;
                    break;
                }
                if(node.next==null){
                    node.next = newNode;
                    break;
                }
                node=node.next;
            }
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
        Student ans = null;
        Node2 s = students[index];
        while (s!=null){
            if(s.ID.equals(keyInt)){
                ans = s.student;
                // if node is first in list:
                if(s.prev==null) students[index] = s.next;
                // if node is last in list:
                else if(s.next==null) s.prev.next = null;
                // if node is in the middle of the list:
                else s.prev.next = s.next;
                break;
            }
            s = s.next;
        }
        return ans;
    }
    public Student get(String key){
        Integer keyInt = null;
        try {
            keyInt = Integer.parseInt(key);
        }catch (NumberFormatException ignored){}
        Integer index = hash(keyInt);
        Node2 s = students[index];
        while (s!=null){
            if(s.ID.equals(keyInt)){
                return s.student;
            }
            s = s.next;
        }
        return null;
    }
    public String toString(){
        StringBuilder ans = new StringBuilder();
        for(Node2 node : students){
            if(node==null) continue;
            Node2 s = node;
            while(s != null){
                Student student = node.student;
                ans.append("ID: ").append(student.ID())
                        .append(", Name: ").append(student.name())
                        .append(", age: ").append(student.age())
                        .append("\n");
                s = s.next;
            }
        }
        return ans.toString();
    }
}

class Node2{
    Integer ID;
    Student student;
    Node2 next, prev;
    public Node2(Student student){
        ID = student.ID();
        this.student = new Student(student);
    }
}