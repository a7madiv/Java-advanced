import java.util.List;

// this class will iterate over all departments and return the matching one
class DepartmentInfoRetriever {
    private List<Department> departments;

    public DepartmentInfoRetriever(List<Department> departments) {
        this.departments = departments;
    }

    public Department getDepartmentById(String id) {
        for (Department department : departments) {
            if (department.getId().equals(id)) {
                return department;
            }
        }
        return null; // Department not found
    }

}