package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "Employee.retrieveEmployeesByLastName",
                query = "FROM Employee WHERE lastName = :LASTNAME"
        ),
        @NamedQuery(
                name = "Employee.findEmployeeByFirstName",
                query = "FROM Employee WHERE firstName LIKE CONCAT('%',CONCAT(:FIRSTNAME,'%'))"
        )
})

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private List<Company> companies = new ArrayList<>();

    public Employee(){

    }

    public Employee(String firstname, String lastname) {
        this.firstName = firstname;
        this.lastName = lastname;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "EMPLOYEE_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    public String getLastName() {
        return lastName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_COMPANY_EMPLOYEE",
            joinColumns = {@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")}

    )
    public List<Company> getCompanies() {
        return companies;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    private void setLastName(String lastname) {
        this.lastName = lastname;
    }

    private void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
