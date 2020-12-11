package user;

import java.util.ArrayList;

public class Student extends User implements Comparable<Student> {
    private ArrayList<Course> courses;
    private boolean paidFees = false;
    private double GPA;
    private final static int MAX_COURSES = 5;

    public Student(String name, String userName, String password, String gender, int age) {
        super(name, userName, password, gender, "student", age);
    }

    public void setGPA(double grade) {
        this.GPA = grade;
        System.out.println("The student " + this.getName() + " grade is " +
                this.GPA + ".");
    }

    // Pay
    public void payFees() {
        paidFees = true;
    }

    public boolean isPaidFees() {

        return paidFees;
    }

    public String getCourses() {
        String result = "";
        for (Course course: courses) {
            result += course.toString() + "\n";
        }
        return result;
    }

    public void addCourse(String name, int hours, int ID) {
        if (courses.size() < MAX_COURSES) {
            if (!findCourse(name)) {
                courses.add(new Course(name, hours, ID));
            }
        }
    }

    public void passCourse(String name) {
        for (Course course: courses) {
            if (course.getName().equals(name)) {
                course.passCourse();
                break;
            }
        }
    }

    public boolean isCoursePassed(String name) {
        for (Course course: courses) {
            if (course.getName().equals(name)) {
                return course.isPassed();
            }
        }
        return false;
    }

    public int getCoursesNumber() {
        return courses.size();
    }

    public int getMaxCourses() {
        return MAX_COURSES;
    }

    @Override
    public int compareTo(Student student) {
        if (this.getName().compareTo(student.getName()) > 0) {
            return 1;
        } else if (this.getName().compareTo(student.getName()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "courses=" + courses +
                ", paidFees=" + paidFees +
                ", totalGrade=" + GPA +
                '}';
    }

    private boolean findCourse(String name) {
        for (Course checkedCourse : courses) {
            if (checkedCourse.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
