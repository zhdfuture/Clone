import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

public class CloneTest {
    public static void main(String[] args) throws Exception {
        Teacher1 teacher = new Teacher1("zhang","python");
        Student student=new Student("xin",22,teacher);
        Student studentclone=student.Clone();
        System.out.println(student);
        System.out.println(studentclone);
        System.out.println("=========>");
        System.out.println(studentclone.getAge());
        System.out.println(studentclone.getName());
        System.out.println(studentclone.getTeacher1());
        System.out.println(teacher==studentclone.getTeacher1());
    }
}
//使用序列化进行深拷贝
class Teacher1 implements Serializable{
private String name;
private String skills;
public  Teacher1(String name,String skills){
    this.name=name;
    this.skills=skills;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Teacher1{" +
                "name='" + name + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}
class Student implements Serializable{
    private String name;
    private int age;
    private Teacher1 teacher1;       //序列化后变为字节流
    public Student Clone() throws Exception {             //使用内存流进行序列化操作
        ByteOutputStream byteOutputStream=new ByteOutputStream();
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(byteOutputStream);
        objectOutputStream.writeObject(this);
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(byteOutputStream.getBytes());
        ObjectInputStream objectInputStream=new ObjectInputStream(byteArrayInputStream);
        return (Student)objectInputStream.readObject();  //强转
        }
    public Student(String name,int age,Teacher1 teacher1){
        this.name=name;
        this.age=age;
        this.teacher1=teacher1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher1 getTeacher1() {
        return teacher1;
    }

    public void setTeacher1(Teacher1 teacher1) {
        this.teacher1 = teacher1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher1=" + teacher1 +
                '}';
    }
}