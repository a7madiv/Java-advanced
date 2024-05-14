import java.io.*;
import java.util.*;

// StudentReader class to read student data from a file
class StudentCounselingReader {
    // Member variable to store the file path
    private String filepath;

    // Constructor to initialize the file path
    public StudentCounselingReader(String filepath) {
        this.filepath = filepath;
    }

    // Method to read students from a file and return a list of Student objects
    public List<StudentCounseling> readStudentsFromFile() {
        List<StudentCounseling> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split each line by '|' delimiter
                String[] data = line.split("\\|");
                if (data.length == 5) { // Ensure correct data format
                    String studentID = data[0];
                    String dateOfAdmission = data[1];
                    String dateOfBirth = data[2];
                    String departmentChoices = data[3];

                    // Create a new Student object and add to the list
                    StudentCounseling student = new StudentCounseling(studentID, dateOfAdmission, dateOfBirth, departmentChoices);
                    students.add(student);
                } else {
                    System.err.println("Invalid data format in line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filepath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return students;
    }

}
