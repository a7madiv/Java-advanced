import java.util.List;

public class StudentPerformanceManager {
    private List<StudentPerformance> students;
    public StudentPerformanceManager(List<StudentPerformance> students) {
        this.students = students;
    }
    public StudentPerformance getStudentsByID(String id){
        for (StudentPerformance student : students) {
            if (student.getID().equals(id)) {
                return student;
            }
        }
        return null; // student performance not found
    }
   public int numPapers(String id) {
    int count = 0;
    for (StudentPerformance student : students) {
        if (student.getID().equals(id)) {
            count++;
        }
    }
    return count;
}

public int numSemesters(String id) {
    int numSem = 1; // Start with 1 semester (assuming at least one semester exists) OMG
    // here deal with the list as its an array
    for (int index = 0; index < students.size() - 1; index++) {
        String currentSemester = students.get(index).getSemester();
        String nextSemester = students.get(index + 1).getSemester();
        if (currentSemester != nextSemester) {
            numSem++;
        }
    }
    return numSem;
}


public int getTotalMarks(String id) {
    int totalMarks = 0;
    for (StudentPerformance student : students) {
        if (student.getID().equals(id)) {
            totalMarks += student.getMarks();
        }
    }
    return totalMarks;
}
public double averageMarks(String id) {
    return getTotalMarks(id) / numPapers(id);
}
//     int totalMarks = 0;
//     for (StudentPerformance student : students) {
//         if (student.getID().equals(id)) {
//             totalMarks += student.getMarks();
//         }
//     }
//     return totalMarks / numPapers(id);
// }
public int getMaxMarks(String id) {
    int maxMarks = 0;
    for (StudentPerformance student : students) {
        if (student.getID().equals(id) && student.getMarks() > maxMarks) {
            maxMarks = student.getMarks();
        }
    }
    return maxMarks;
}
// the oppsite concept fo the max marks method
public int getMinMarks(String id) {
    int minMarks = getMaxMarks(id);
    for (StudentPerformance student : students) {
        if (student.getID().equals(id) && student.getMarks() < minMarks) {
            minMarks = student.getMarks();
        }
    }
    return minMarks;
}
// public int getStudentsNDepartment(String id){
//     int cou = 0;
//     for (StudentPerformance student : students) {
//         if(student.)
// }
}