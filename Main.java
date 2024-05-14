import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize DepartmentDataReader
        DepartmentReader dataReader = new DepartmentReader("/home/ahmad/vscode/advanced/Dataset/Department_Information.txt");
        List<Department> departments = dataReader.readDepartments();  // get the list of departments

        // // Initialize DepartmentInfoRetriever
        DepartmentInfoRetriever infoRetriever = new DepartmentInfoRetriever(departments);

        // // Initialize StudentCounselingFileReader
        StudentCounselingReader fileReader = new StudentCounselingReader("/home/ahmad/vscode/advanced/Dataset/Student_Counceling_Information.txt");
        List<StudentCounseling> students = fileReader.readStudentsFromFile(); // get the list of students

        // // Initialize StudentManager with the list of students
        StudentCounselingManager studentManager = new StudentCounselingManager("/home/ahmad/vscode/advanced/Dataset/Student_Counceling_Information.txt");

        // Initialize EmployeeFileReader
        EmployeeFileReader EmpReader = new EmployeeFileReader("/home/ahmad/vscode/advanced/Dataset/Employee_Information.txt");
        List<Employee> employees = EmpReader.readEmployees(); // get the list of employees

        // Initialize EmployeeInfoRetriever
        EmployeeInfoRetriever EmpInfoRetriever = new EmployeeInfoRetriever(employees);

        StudentPerformanceReader reader = new StudentPerformanceReader("/home/ahmad/vscode/advanced/Dataset/Student_Performance_Data.txt");
        List <StudentPerformance> performances = reader.readStudentPerformances();
        StudentPerformanceManager stper = new StudentPerformanceManager(performances);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Department Information System");
        // String startDate = scanner.nextLine();
        // String endDate = scanner.nextLine();

        // List<Student> studentsWithinRange = studentManager.getStudentsWithinDOBRange(startDate, endDate);
        // for (Student student : studentsWithinRange) {
        //     System.out.println(student.getStudentID());
        // }
        // System.out.println("Enter student ID ");
        // String stdID= scanner.nextLine();
        // int numpaper = stper.numPapers(stdID);
        // System.out.println(numpaper);
        // int maxMarks = stper.getMaxMarks(stdID);
        // int minMarks = stper.getMinMarks(stdID);
        // System.out.println(minMarks);

        int operation = 0;
        while (operation != 5) {
            System.out.println("Menu:");
            System.out.println("1. Retrieve department information");
            System.out.println("2. Retrieve Student information ");
            System.out.println("3. Retrieve Employee information");
            System.out.println("4. Retrieve all students information based on department ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                operation = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                if (operation == 1) {
                    System.out.print("Enter department ID: ");
                    String departmentId = scanner.nextLine();
                    Department department = infoRetriever.getDepartmentById(departmentId);
                    if (department != null) {
                        System.out.println("Department Name: " + department.getName());
                        System.out.println("Establishment Date: " + department.getEstablishmentDate());
                    } else {
                        System.out.println("Department not found.");
                    }
                } else if (operation == 2) {
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    StudentCounseling students_in_department = studentManager.getStudentInfo(studentId);
                    if (students_in_department != null){
                        System.out.println("Student ID: " + students_in_department.getStudentID());
                        System.out.println("Date of Admission: " + students_in_department.getDateOfAdmission());
                        System.out.println("Date of Birth: " + students_in_department.getDateOfBirth());
                        System.out.println("Department Choice: " + students_in_department.getDepartmentChoices());
                    } else {
                        System.out.println("Student not found.");
                    }
                } else if (operation == 3){
                    System.out.print("Enter Employee ID: ");
                    String employeeId = scanner.nextLine();
                    Employee employee = EmpInfoRetriever.getEmployeeById(employeeId);
                    if(employee != null){
                        System.out.println("Employee ID: " + employee.getEmployeeID());
                        System.out.println("Date of Birth: " + employee.getDateOfBirth());
                        System.out.println("Date of Joining: " + employee.getDateOfJoining());
                        System.out.println("Department ID: " + employee.getDepartmentID());
                    } else {
                        System.out.println("Employee not found.");
                    }
                }else if(operation == 4){
                    System.out.println("Enter a dept ID: ");

                    String deptID = scanner.next();
                    List<StudentCounseling> students_in_department = studentManager.student_info_dept(deptID);
                    for (StudentCounseling s : students_in_department) {
                        System.out.println("Student ID: " + s.getStudentID());
                        System.out.println("Date of Admission: " + s.getDateOfAdmission());
                        System.out.println("Date of Birth: " + s.getDateOfBirth());
                        System.out.println("Department Choice: " + s.getDepartmentChoices());
                        System.out.println("*********************************************");

                    }

                }
                else {
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
            }
        }
        scanner.close();
    }
}
