import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class EmployeeFileReader {
    private String filePath; // File path

    public EmployeeFileReader(String filePath) {
        this.filePath = filePath;
    }
    public List<Employee> readEmployees() {
    List<Employee> employees = new ArrayList<>(); //
    File file = new File (filePath);

        try{
           Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] fields = line.split("\\|");
                if(fields.length == 4){
                    employees.add(new Employee(fields[0], fields[1], fields[2], fields[3]));
                }
            }
            scanner.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return employees;
}
}


