package org.example.model;

public class Main {


    public static void main(String[] args) {

        EmployeeMap employeeMap = new EmployeeMap();

        Employee Polina = new Employee("Романова ", "Полина ", "Денисовна", 1, 58471);

        employeeMap.addEmployee("Куприянов ", "Тимофей ", "Артёмович", 3, 71103);
        employeeMap.addEmployee("Горбунова ", "Арина ", "Семёновна", 4, 87535);
        employeeMap.addEmployee("Куприянов ", "Тимофей ", "Артёмович",3, 71103);
        employeeMap.addEmployee("Кузнецов ", "Кирилл ", "Максимович", 5, 67421);
        employeeMap.addEmployee("Дементьева ", "Дарья ", "Андреевна", 3, 110211);
        employeeMap.addEmployee("Кузьмина ", "Диана ", "Юрьевна", 3, 68231);
        employeeMap.addEmployee("Воробьев ", "Матвей ", "Иванович", 1, 70531);
        employeeMap.addEmployee("Титова ", "Дарина ", "Михайловна", 2, 100123);
        employeeMap.addEmployee("Куприянов ", "Тимофей ", "Артёмович", 3, 71103);
        employeeMap.addEmployee("Максимов ", "Михаил ", "Егорович", 2, 110011);

        employeeMap.addEmployee(Polina);
        employeeMap.changeSalary(Polina,88912);
        employeeMap.printEmployeeByDepartment();


       employeeMap.printAllEmployees();
        double totalSalaries = employeeMap.totalSalaries();
            System.out.println(" Сумма ЗП всех сотрудников составляет: " + totalSalaries + " рублей");
        Employee employeeWithMinSalary = employeeMap.findEmployeeWithMinSalary();
            System.out.println("  Минимальная ЗП у следующего сотрудника: " + employeeWithMinSalary);
        Employee employeeWithMaxSalary = employeeMap.findEmployeeWithMaxSalary();
            System.out.println("Максимальная ЗП у следующего сотрудника: " + employeeWithMaxSalary);
        double averageSalary = employeeMap.averageSalary();
            System.out.println("Средняя ЗП сотудников " + averageSalary+ " рублей");
        //  employeeMap.printFullNameEmployees();

        employeeMap.indexSalaries(5);
        System.out.println("После индексации");
        employeeMap.printAllEmployees();

        System.out.printf("Сотрудник с минимальной ЗП из %d отдела: %s%n", 3, employeeMap.findEmployeeWithMinSalaryFromDepartment(3));
        System.out.printf("Сотрудник с максимальной ЗП из %d отдела: %s%n", 3, employeeMap.findEmployeeWithMaxSalaryFromDepartment(3));
        System.out.printf("Сумма ЗП всех сотрудников за месяц из отдела %d: %.2f%n", 3, employeeMap.totalSalariesForDepartment(3));
        System.out.printf("Средняя ЗП всех сотрудников за месяц из отдела %d: %.2f%n", 3, employeeMap.averageSalaryForDepartment(3));

        employeeMap.indexSalariesForDepartment(5,2);
        System.out.println("После индексации для отдела "+ 2);
        employeeMap.printAllEmployeesFromDepartment(2);
        employeeMap.printEmployeeWithSalaryLessThan(100_000);
        employeeMap.printEmployeeWithSalaryGreaterOrEqualThan(100_000);






    }
}