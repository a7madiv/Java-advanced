public class StudentPerformance{
    private String Student_ID;
    private String Semester;
    private String Paper_ID;
    private String Paper;
    private int Marks;
    public StudentPerformance(String Student_ID, String Semester, String Paper_ID, String Paper, int Marks) {
        this.Student_ID = Student_ID;
        this.Semester = Semester;
        this.Paper_ID = Paper_ID;
        this.Paper = Paper;
        this.Marks = Marks;
    }
    public String getID() {
        return Student_ID;
    }
    public String getSemester() {
        return Semester;
    }
    public String getPaper_ID() {
        return Paper_ID;
    }
    public String getPaper() {
        return Paper;
    }
    public int getMarks() {
        return Marks;
    }

}