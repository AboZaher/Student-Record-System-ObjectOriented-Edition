package main;

import user.*;

import java.util.ArrayList;

import java.util.Scanner;

public class SystemData {
    private static ArrayList<User> admins;
    private static ArrayList<User> teachers;
    private static ArrayList<User> students;

    private SystemData() {

    }

    public static void systemInit() {
        admins = new ArrayList<>();
        teachers = new ArrayList<>();
        students = new ArrayList<>();

        admins.add(new Admin("Islam Walid", "Islam_Walid", "0000", "male", 20));
        admins.add(new Admin("Ahmed Hossam", "Ahmed_Hossam", "1111", "male", 20));
        admins.add(new Admin("Mohamed Salah", "Mohamed_Salah", "2222", "male", 20));
        admins.add(new Admin("Ahmed Salah", "Ahmed_Salah", "3333", "male", 20));

        teachers.add(new Teacher("Noha Sakr", "Noha_Sakr", "6969", "female", 40, 5000.0));
        teachers.add(new Teacher("Sabry Sraya", "Sabry_Sraya", "1010", "male", 48, 5000.0));
        teachers.add(new Teacher("Ali Desouky", "Ali_Desouky", "5555", "male", 50, 5000.0));

        students.add(new Student("Ali Ghorab", "Ali_Ghorab", "1234", "male", 20));
        students.add(new Student("Mahmoud Basiony", "Mahmoud_Basiony", "1234", "male", 20));
        students.add(new Student("Mahmoud Hegab", "Mahmoud_Hegab", "1234", "male", 20));
        students.add(new Student("Ahmed Saad", "Ahmed_Saad", "1234", "male", 20));
        students.add(new Student("Mohamed Gad", "Mohamed_Gad", "1234", "male", 20));
        students.add(new Student("Ahmed Aweda", "Ahmed_Aweda", "1234", "male", 20));
    }

    public static void systemRun() {
        System.out.println("Select Mode:");
        System.out.println("1-Admin");
        System.out.println("2-Teacher");
        System.out.println("3-Student");
        int systemMode = 0;
        try {
            systemMode = modeSelection(1,3);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.exit(1);
        }

        switch (systemMode) {
            case 1:
                adminMode();
                break;

            case 2:
                teacherMode();
                break;

            case 3:
                studentMode();
                break;

            default:
                break;
        }
    }

    private static void adminMode() {
        Admin currentAdmin = null;
        try {
            currentAdmin = (Admin) userLogin(admins);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.exit(1);
        }
        adminMenu();
        adminAction(currentAdmin);
    }

    private static void adminMenu() {
        System.out.println("Enter the number of operation you need:");
        System.out.println();
        System.out.println("Admin's section:");
        System.out.println("01-Change your password.");
        System.out.println("02-Return to main menu");

        System.out.println();
        System.out.println("Teacher's section:");
        System.out.println("03-Add new teacher");
        System.out.println("04-Add courses");
        System.out.println("05-Edit salary.");
        System.out.println("06-Edit teacher password.");
        System.out.println("07-View teacher info.");

        System.out.println();
        System.out.println("Student's section:");
        System.out.println("08-Add new student.");
        System.out.println("09-Pay fees.");
        System.out.println("10-Edit total grade");
        System.out.println("11-Edit student password.");
        System.out.println("12-Add courses");
        System.out.println("13-Pass course");
        System.out.println("14-View student courses.");
        System.out.println("15-View student info.");
        System.out.println("16-Remove student.");
        System.out.println();
        System.out.println("17-Exit Program.");
    }

    private static void adminAction(Admin currentAdmin) {
        Scanner input = new Scanner(System.in);

        Teacher currentTeacher;
        Student currentStudent;

        String name;
        String userName;
        String password;
        String gender;
        double salary;
        int age;

        String courseName;
        int courseID;
        int courseHours;

        int selection = 0;
        try {
            selection = modeSelection(1,17);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.exit(1);
        }


        switch (selection) {
            case 1:
                System.out.println("Enter the new password:");
                currentAdmin.setPassword(input.nextLine());
                break;

            case 2:
                systemRun();
                break;

            case 3:
                System.out.println("Enter name:");
                name = input.nextLine();

                System.out.println("Enter username:");
                userName = input.nextLine();

                System.out.println("Enter password:");
                password = input.nextLine();

                System.out.println("Enter gender:");
                gender = input.nextLine();

                System.out.println("Enter age:");
                age = Integer.parseInt(input.nextLine());

                System.out.println("Enter salary:");
                salary = Double.parseDouble(input.nextLine());

                if (userSearch(userName, password, teachers) == null) {
                    teachers.add(new Teacher(name, userName, password, gender, age, salary));
                    System.out.println("Teacher added successfully");
                }
                else {
                    System.out.println("Teacher already exist");
                }

                break;

            case 4:
                try {
                    currentTeacher = (Teacher) userLogin(teachers);
                    if (currentTeacher.getCoursesNumber() < currentTeacher.getMaxCourses()) {
                        System.out.println("Enter course name:");
                        courseName = input.nextLine();

                        System.out.println("Enter course hours:");
                        courseHours = Integer.parseInt(input.nextLine());

                        System.out.println("Enter course ID:");
                        courseID = Integer.parseInt(input.nextLine());

                        currentTeacher.addCourse(courseName, courseHours, courseID);

                        System.out.println("Course added successfully");
                    }
                    else {
                        System.out.println("Max courses reached or course already exists.");
                    }

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    System.out.println("Operation failed");
                }
                break;

            case 5:
                try {
                    currentTeacher = (Teacher) userLogin(teachers);
                    System.out.println("Enter new salary:");
                    salary = Double.parseDouble(input.nextLine());

                    currentTeacher.setSalary(salary);
                    System.out.println("Salary changed successfully.");

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    System.out.println("Operation failed");
                }
                break;

            case 6:
                try {
                    currentTeacher = (Teacher) userLogin(teachers);
                    System.out.println("Enter new Password:");
                    password = input.nextLine();

                    currentTeacher.setPassword(password);
                    System.out.println("Password changed successfully.");
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    System.out.println("Operation failed");
                }
                break;

            case 7:
                try {
                    currentTeacher = (Teacher) userLogin(teachers);
                    System.out.println(currentTeacher.toString());
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    System.out.println("Operation failed");
                }
                break;

            case 8:
                    System.out.println("Enter name:");
                    name = input.nextLine();

                    System.out.println("Enter username:");
                    userName = input.nextLine();

                    System.out.println("Enter password:");
                    password = input.nextLine();

                    System.out.println("Enter gender:");
                    gender = input.nextLine();

                    System.out.println("Enter age:");
                    age = Integer.parseInt(input.nextLine());

                if (userSearch(userName, password, students) == null) {
                    students.add(new Student(name, userName, password, gender, age));
                    System.out.println("Student added successfully");
                }
                else {
                    System.out.println("Student already exist");
                }
                break;

            case 9:
                try {
                    currentStudent = (Student) userLogin(students);
                    if (!currentStudent.isPaidFees()) {
                        currentStudent.payFees();
                        System.out.println("Fees paid successfully.");
                    }
                    else
                        System.out.println("Fees Already Paid.");

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    System.out.println("Operation failed");
                }
                break;

            case 10:
                try {
                    currentStudent = (Student) userLogin(students);
                    System.out.println("Enter student's total grade");
                    currentStudent.setGPA(Double.parseDouble(input.nextLine()));
                    System.out.println("Grade changed successfully.");

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    System.out.println("Operation failed");
                }
                break;

            case 11:
                try {
                    currentStudent = (Student) userLogin(students);
                    System.out.println("Enter new password");
                    currentStudent.setPassword(input.nextLine());
                    System.out.println("Password changed successfully.");

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    System.out.println("Operation failed");
                }
                break;

            case 12:
                try {
                    currentStudent = (Student) userLogin(students);
                    if (currentStudent.getCoursesNumber() < currentStudent.getMaxCourses()) {
                        System.out.println("Enter course name:");
                        courseName = input.nextLine();

                        System.out.println("Enter course hours:");
                        courseHours = Integer.parseInt(input.nextLine());

                        System.out.println("Enter course ID:");
                        courseID = Integer.parseInt(input.nextLine());

                        currentStudent.addCourse(courseName, courseHours, courseID);

                        System.out.println("Course added successfully");
                    }
                    else {
                        System.out.println("Max courses reached or course already exists.");
                    }

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    System.out.println("Operation failed");
                }
                break;

            case 13:
                try {
                    currentStudent = (Student) userLogin(students);

                    System.out.println("Enter course name:");
                    courseName = input.nextLine();

                    currentStudent.passCourse(courseName);

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    System.out.println("Operation failed");
                }
                break;

            case 14:
                try {
                    currentStudent = (Student) userLogin(students);
                    System.out.println(currentStudent.getCourses());

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    System.out.println("Operation failed");
                }
                break;

            case 15:
                try {
                    currentStudent = (Student) userLogin(students);
                    System.out.println(currentStudent.toString());

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    System.out.println("Operation failed");
                }
                break;

            case 16:
                try {
                    currentStudent = (Student) userLogin(students);
                    students.remove(currentStudent);

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    System.out.println("Operation failed");
                }
                break;

            case 17:
                System.exit(0);
                break;
        }
        adminMenu();
        adminAction(currentAdmin);
    }

    private static void teacherMode() {
        Teacher currentTeacher = null;
        try {
            currentTeacher = (Teacher) userLogin(teachers);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            systemRun();
        }
        teacherMenu();
        teacherAction(currentTeacher);
    }

    private static void teacherMenu() {
        System.out.println("01-Show courses");
        System.out.println("02-Get salary.");
        System.out.println("03-Edit your password.");
        System.out.println("04-View your info.");
        System.out.println("05-Return to main menu.");
        System.out.println("06-Exit program.");
    }

    private static void teacherAction(Teacher currentTeacher) {
        int selection = 0;
        Scanner input = new Scanner(System.in);

        try {
            selection = modeSelection(1,6);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.exit(1);
        }

        switch (selection) {
            case 1:
                System.out.println(currentTeacher.getCourses());
                break;

            case 2:
                System.out.println("Your salary is " + currentTeacher.getSalary() + "L.E");
                break;

            case 3:
                System.out.println("Enter new password:");
                currentTeacher.setPassword(input.nextLine());
                System.out.println("Password changed successfully.");
                break;

            case 4:
                System.out.println(currentTeacher.toString());
                break;

            case 5:
                systemRun();
                break;

            case 6:
                System.exit(0);
                break;
        }
        teacherMenu();
        teacherAction(currentTeacher);
    }

    private static void studentMode() {
        Student currentStudent = null;
        try {
            currentStudent = (Student) userLogin(students);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            systemRun();
        }
        studentMenu();
        studentAction(currentStudent);
    }

    private static void studentMenu() {
        System.out.println("01-Edit your password.");
        System.out.println("02-Is course passed.");
        System.out.println("03-View your courses.");
        System.out.println("04-View your info.");
        System.out.println("05-Return to main menu.");
        System.out.println("06-Exit Program.");
    }

    private static void studentAction(Student currentStudent) {
        int selection = 0;
        Scanner input = new Scanner(System.in);

        try {
            selection = modeSelection(1,6);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.exit(1);
        }

        switch (selection) {
            case 1:
                System.out.println("Enter new password:");
                currentStudent.setPassword(input.nextLine());
                System.out.println("Password changed successfully.");
                break;

            case 2:
                System.out.println("Enter course name:");
                if (currentStudent.isCoursePassed(input.nextLine())) {
                    System.out.println("You passed the course.");
                }
                else {
                    System.out.println("You didn't pass the course.");
                }
                break;

            case 3:
                System.out.println(currentStudent.getCourses());
                break;

            case 4:
                System.out.println(currentStudent.toString());
                break;

            case 5:
                systemRun();
                break;

            case 6:
                System.exit(0);
                break;
        }
        studentMenu();
        studentAction(currentStudent);
    }


/***************************************************************** Utility Methods ***************************************************************/

    private static User userLogin(ArrayList<User> users) throws Exception {
        Scanner input = new Scanner(System.in);
        int trials = 0;
        User currentUser;

        System.out.println("UserName:");
        String userName = input.nextLine();
        System.out.println("Password:");
        String password = input.nextLine();

        currentUser = userSearch(userName, password, users);

        while (currentUser == null) {
            System.out.println("Wrong username or password, try again!");
            System.out.println("UserName:");
            userName = input.nextLine();
            System.out.println("Password:");
            password = input.nextLine();

            currentUser = userSearch(userName, password, admins);
            trials++;
            if (trials == 2) {
                throw new Exception("login failed, too many wrong trials!");
            }
        }
        return currentUser;
    }

    private static User userSearch(String userName, String password, ArrayList<User> users) {
        User result = null;
        for (User user: users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password))
                result = user;
        }
        return result;
    }

    private static int modeSelection(int first, int second) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your selection");
        int systemMode = Integer.parseInt(input.nextLine());
        int trials = 0;
        while (systemMode < first || systemMode > second) {
            System.out.println("Selection out of constrains, try again!");
            systemMode = Integer.parseInt(input.nextLine());
            trials++;
            if (trials == 2) {
                throw new Exception("Selection failed, too many trials!");
            }
        }
        return systemMode;
    }

}
