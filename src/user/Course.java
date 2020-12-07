package user;

public class Course implements Comparable<Course> {
    private String name;
    private int hours;
    private int ID;
    private boolean passed = false;

    public Course(){

    }
    public Course(String name, int hours, int ID){
        this.name = name;
        this.hours = hours;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public boolean isPassed() {
        return passed;
    }

    public void passCourse() {
        this.passed = true;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", hours=" + hours +
                ", ID=" + ID +
                ", passed=" + passed +
                '}';
    }

    @Override
    public int compareTo(Course o) {
        return name.compareTo(o.getName());
    }
}
