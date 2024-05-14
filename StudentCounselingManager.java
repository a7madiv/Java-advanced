import java.util.ArrayList;
import java.util.List;

class StudentCounselingManager {
    private List<StudentCounseling> students;

    public StudentCounselingManager(String filePath) {
        // Initialize StudentReader and read student data from file
        StudentCounselingReader reader = new StudentCounselingReader(filePath);
        this.students = reader.readStudentsFromFile();
    }

    // Method to retrieve student information based on ID
    public StudentCounseling getStudentInfo(String studentID) {
        for (StudentCounseling student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null; // Student not found
    }

    // Method to retrieve all students' information for students in a given department
    public List<StudentCounseling> student_info_dept(String departmentID) {
        List<StudentCounseling> studentsInDept = new ArrayList<>();
        for (StudentCounseling student : students) {
            if (student.getDepartmentChoices().equals(departmentID)) {
                studentsInDept.add(student);
            }
        }
        return studentsInDept;
    }
      public List<StudentCounseling> getStudentsWithinDOBRange(String startDate, String endDate) {
        List<StudentCounseling> studentsWithinRange = new ArrayList<>();
        for (StudentCounseling student : students) {
            String dob = student.getDateOfBirth();
            if (dob.compareTo(startDate) >= 0 && dob.compareTo(endDate) <= 0) {
                studentsWithinRange.add(student);
            }
        }
        return studentsWithinRange;
    }
    public List<StudentCounseling> getStudentsbyDOARange(String startDate, String endDate){
        List<StudentCounseling> studentsWithinRange = new ArrayList<>();
        for(StudentCounseling student: students){
            String doa = student.getDateOfAdmission();
            if(doa.compareTo(startDate) >= 0 && doa.compareTo(endDate) <= 0){
                studentsWithinRange.add(student);
            }
        }
        return studentsWithinRange;
    }
    public int studentsNDept(String id){
        int cou = 0;
        for(StudentCounseling student: students){
            if(student.getDepartmentChoices().equals(id)){
                cou++;
            }
        }
        return cou;
    }
}