import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Библиотека commons-lang3");
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.addEmployee("ivan","petrov", 12000, 45);
        employeeService.findAll();


    }

}