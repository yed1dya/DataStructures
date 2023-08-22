package week4;

public class Student {
    private int ID, age;
    private String name;
    public Student(int id, String name, int age){
        ID = id;
        this.name = name;
        this.age = age;
    }
    public Student(Student s){
        this.ID = s.ID;
        this.name = s.name;
        this.age = s.age;
    }
    public int ID(){
        return ID;
    }
    public String name(){
        return name;
    }
    public int age(){
        return age;
    }
}
