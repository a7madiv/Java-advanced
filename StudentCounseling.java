class StudentCounseling {
    private String studentID;
    private String dateOfAdmission;
    private String dateOfBirth;
    private String departmentChoices;

    public StudentCounseling(String studentID, String dateOfAdmission, String dateOfBirth, String departmentChoices) {
        this.studentID = studentID;
        this.dateOfAdmission = dateOfAdmission;
        this.dateOfBirth = dateOfBirth;
        this.departmentChoices = departmentChoices;
    }

    // Getters
    public String getStudentID() {
        return studentID;
    }

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDepartmentChoices() {
        return departmentChoices;
    }
}
