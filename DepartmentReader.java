import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class DepartmentReader {
    private String filePath; // File path

    public DepartmentReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Department> readDepartments() { // method to read the department and store in list
        List<Department> departments = new ArrayList<>(); // List for departments
        try {
            File file = new File(filePath); // Create File object
            Scanner reader = new Scanner(file); // Scanner object
            while (reader.hasNextLine()) { // Read lines
                String line = reader.nextLine();
                String[] fields = line.split("\\|"); // Split line
                if (fields.length == 3) { // Check fields
                    departments.add(new Department(fields[0], fields[1], fields[2])); // Add department to list
                }
            }
            reader.close();
        }

          catch (IOException e) { // Handle IOException
            e.printStackTrace();
        }
        return departments; // Return departments
    }
}
