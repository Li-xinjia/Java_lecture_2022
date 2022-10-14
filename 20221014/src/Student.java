public class Student extends Person {
    private String school;
    private int grade;
    private String number;

    public void setSchool(String school) {
        this.school = school;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSchool() {
        return school;
    }

    public int getGrade() {
        return grade;
    }

    public String getNumber() {
        return number;
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Taro Yamada");
        student.setAddress("Sakyoku, Kyoto");
        student.setSchool("KIT");
        student.setGrade(2);
        student.setNumber("0123456");

        student.print();
        System.out.println("School: " + student.getSchool());
        System.out.println("Grade: " + student.getGrade());
        System.out.println("Student number: " + student.getNumber());
    }
}
