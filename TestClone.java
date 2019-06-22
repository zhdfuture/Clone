public class TestClone {
    public static void main(String[] args) {
        Teacher teacher=new Teacher("zhang",22,"Java");
        students student=new students("xiao",1640,teacher);
        students Clonestudent=student.Clone();
        System.out.println(teacher);
        System.out.println(student);
        System.out.println(Clonestudent);
//        System.out.println(Clonestudent.getName());
//        System.out.println(Clonestudent.getId());
        System.out.println(Clonestudent.getTeacher());
        System.out.println(teacher==Clonestudent.getTeacher());
    }
}
class Teacher{
private String name;
private int age;
private String direction;
public Teacher(String name,int age,String direction){
    this.name=name;
    this.age=age;
    this.direction=direction;
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", direction='" + direction + '\'' +
                '}';
    }
}
class students implements Cloneable{
    private String name;
    private int id;
    private Teacher teacher;
    public students Clone(){
        students student=null;
        try {
            student=(students)super.clone();//一定要调super的clone,然后进行强制类型转化
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return student;
    }
    public students(String name,int id,Teacher teacher){
        this.name=name;
        this.id=id;
        this.teacher=teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "students{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", teacher=" + teacher +
                '}';
    }
}
