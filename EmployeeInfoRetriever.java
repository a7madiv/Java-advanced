import java.util.List;

public class EmployeeInfoRetriever{
   private List <Employee> employees;

   public EmployeeInfoRetriever(List<Employee> employees) {
       this.employees = employees;
   }
   public Employee getEmployeeById(String id) {
    for (Employee employee : employees) {
        if (employee.getEmployeeID().equals(id)) {
            return employee;
        }
    }
    return null; // Employee not found
   }
   public int numberOfEmployees(String id) {
    int numberOfEmployee=0;
    for(Employee employee : employees){
        if (employee.getEmployeeID().equals(id)){
            numberOfEmployee++;
        }
    }
    return numberOfEmployee;
}
}