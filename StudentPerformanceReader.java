import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentPerformanceReader{
    private String filepath;
    public StudentPerformanceReader(String filepath) {
        this.filepath = filepath;
    }
    public List<StudentPerformance> readStudentPerformances() {
        List<StudentPerformance> students = new ArrayList<>();
        try{
            File file = new File(filepath);
            Scanner reader = new Scanner(file);
            boolean isFirstLine = true;
            while(reader.hasNext()){
                String line = reader.nextLine(); // store the whole line
                 if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip header line
                }
                String[] fields = line.split("\\|");
                if(fields.length == 5){
                    students.add(new StudentPerformance(fields[0], fields[1], fields[2], fields[3], Integer.parseInt(fields[4])));
                }
            }
            reader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return students;
    }
}
