package org.example.model;

import java.util.*;

public class EmployeeMap {
    private Map<String, Employee> employees;



    public EmployeeMap() {
        employees = new HashMap<>();

    }

    private String getKey(Employee employee) {
        return employee.getName() + " " + employee.getSurName() + " " + employee.getMiddleName();
    }

    public void addEmployee(Employee employee) {
        employees.put(getKey(employee), employee);

    }

    // добавление сотрудника
    public void addEmployee(String name, String surName,String middleName, int department, double salary) {
        addEmployee(new Employee(name, surName,middleName, department, salary));
    }

    // удаление сотрудника
    public void removeEmployee(Employee employee) {
        employees.remove(getKey(employee));
    }

    // удаление сотрудника по id
    public void removeId(int id) {
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            String key = entry.getKey();
            if (employee.getId() == id) {
                employees.remove(key);
                break;
            }
        }
    }

    //изменение номера департамента у сотрудника
    public void changeDepartment(Employee employee, int departmentNumber) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setDepartment(departmentNumber);
        } else {
            System.out.println("Такого сотрудника не существует");
        }
    }

    //изменение зарплаты  у сотрудника
    public void changeSalary(Employee employee, double newSalary) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setSalary(newSalary);
        } else {
            System.out.println("Такого сотрудника не существует");
        }
    }

    public void printEmployeeByDepartment() {
        for (int department = 1; department <= 5; department++) {
            System.out.println("Сотрудники из отдела " + department + " :");
            for (Employee employee : employees.values()) {
                if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                    System.out.println(employee.getName() + " " + employee.getSurName()+ " " + employee.getMiddleName());
                }
            }
        }
    }

    public void printEmployeeWithSalaryLessThan(double bound) {
        System.out.println("Сотрудники с ЗП меньше,чем " + bound );
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getSalary() < bound) {
                System.out.printf(
                        "id: %d, ФИО : %s %s %s, ЗП: %.2f%n",
                        employee.getId(),
                        employee.getName(),
                        employee.getSurName(),
                        employee.getMiddleName(),
                        employee.getSalary());
            }
        }
    }

    public void printEmployeeWithSalaryGreaterOrEqualThan(double bound) {
        System.out.println("Сотрудники с ЗП большей или равной,чем " + bound + " :");
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getSalary() >= bound) {
                System.out.printf(
                        "id: %d, ФИО : %s %s %s, ЗП: %.2f%n",
                        employee.getId(),
                        employee.getName(),
                        employee.getSurName(),
                        employee.getMiddleName(),
                        employee.getSalary());
            }
        }
    }

    public void indexSalaries(double index) {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
            }
        }
    }

    public void indexSalariesForDepartment(double index, int department) {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
            }
        }
    }


    public void showAllEmployee() {
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }

    public void showEmployeesByDept() {
        for (int department = 1; department <= 5; department++) {
            System.out.println("Сотрудник из отдела " + department + ":");
            for (Employee employee : employees.values()) {
                if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                    System.out.println(employee.getName());
                }
            }
        }
    }

    public double averageSalary() {
        int count = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                count++;
            }
        }
        if (count != 0) {
            return totalSalaries() / count;
        }
        return 0;
    }

    public double averageSalaryForDepartment(int department) {
        double totalSalaryForDepartment = 0;
        int count = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                totalSalaryForDepartment += employee.getSalary();
                count++;
            }
        }
        return count == 0 ? 0 : totalSalaryForDepartment / count;
    }

    public Employee findEmployeeWithMinSalaryFromDepartment(int department) {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getDepartment() == department && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        } else {
            return null;
        }
    }

    public Employee findEmployeeWithMinSalary(){
            double minSalary = Double.MAX_VALUE;
            String key = null;
            for (Map.Entry<String, Employee> entry : employees.entrySet()){
                Employee employee=entry.getValue();
                if(Objects.nonNull(employee)&& employee.getSalary() < minSalary){
                    minSalary = employee.getSalary();
                   key=entry.getKey();
                }
            }
            if (key != null) {
                return employees.get(key);
            }else {
                return null;
            }
    }
    public Employee findEmployeeWithMaxSalaryFromDepartment(int department){
        double maxSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getDepartment() == department && employee.getSalary() >= maxSalary) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        } else {
            return null;
        }
    }
    public Employee findEmployeeWithMaxSalary(){
        double maxSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()){
            Employee employee=entry.getValue();
            if(Objects.nonNull(employee)&& employee.getSalary() > maxSalary){
                maxSalary = employee.getSalary();
                key=entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        }else {
            return null;
        }
    }

        public double totalSalariesForDepartment(int department){
        double sum = 0;
    for (Employee employee : employees.values()) {
        if(Objects.nonNull(employee)&& employee.getDepartment()==department){
            sum += employee.getSalary();
        }
    }
    return sum;
}

    public double totalSalaries(){
        double sum = 0;
        for (Employee employee : employees.values()) {
            if(Objects.nonNull(employee)){
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public void printAllEmployees() {
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                System.out.println(employee);
            }
        }
    }

    public void printAllEmployeesFromDepartment(int department){
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                System.out.printf(
                        "id: %d, ФИО : %s %s %s, ЗП: %.2f%n",
                        employee.getId(),
                        employee.getName(),
                        employee.getSurName(),
                        employee.getMiddleName(),
                        employee.getSalary());
            }
        }
    }

}