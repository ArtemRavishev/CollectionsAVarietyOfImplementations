package org.example.model;

import java.util.Objects;

public class Employee  implements Comparable{

    private  static  int counter = 1;
    private final int id;
    private final String name;
    private final String surName;
    private final String middleName;
    private int department;
    private double salary;

    public Employee(String name, String surName,String middleName, int department, double salary) {
        this.name = name;
        this.surName = surName;
        this.middleName=middleName;
        this.department = department;
        this.salary = salary;
        id = counter;
        counter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getMiddleName() {return middleName;}

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "id: " + id + "; ФИО : " + name + " " + surName + " " + middleName + "; Зарплата : " + salary +"; Департамент №: " + department ;
    }

    public void setDepartment(int dept){
        this.department = department;}

    public void setSalary(double amount){
        salary = amount;}

    @Override
    public boolean equals(Object o) {
        if(this == o ) return true;
        if (o==null||getClass() !=o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department && Double.compare(employee.salary, salary) == 0
                && Objects.equals(name, employee.name) && Objects.equals(surName, employee.surName);
    }
    @Override
    public int hashCode(){return  Objects.hash(id,name,surName,department,salary);}

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee){
        return department - ((Employee)o).department;
    }else {
            throw new RuntimeException();
        }
    }
}

