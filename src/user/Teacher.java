package user;

import java.util.ArrayList;

public class Teacher extends User {
    private double salary;
    private final int MAX_COURSES = 3;
    private ArrayList<Course> courses;

    public Teacher(){

    }

    public Teacher(String name, String userName, String password, String gender, int age, double salary) {
        super(name, userName, password, gender, "teacher", age);
        this.salary = salary;
        courses = new ArrayList<>();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void addCourse(String name, int hours, int ID) {
        if (courses.size() < MAX_COURSES) {
            if (!findCourse(name)) {
                courses.add(new Course(name, hours, ID));
            }
        }
    }

    public int getCoursesNumber () {
        return courses.size();
    }

    public int getMaxCourses () {
        return MAX_COURSES;
    }

    public String getCourses() {
        String result = "";
        for (Course course: courses) {
            result += course.toString() + "\n";
        }
        return result;
    }

    @Override
    public String toString() {
        return
                "Teacher{" + super.toString() +
                "salary=" + salary +
                ", courses=" + courses.toString() +
                '}';
    }

    private boolean findCourse(String name) {
        for (Course checkedCourse : courses){
            if (checkedCourse.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

}
