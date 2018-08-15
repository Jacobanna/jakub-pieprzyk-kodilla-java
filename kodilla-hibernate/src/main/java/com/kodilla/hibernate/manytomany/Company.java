package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "Company.retrieveCompanyWith3FirstLettersAsRequested",
        query = "SELECT * FROM COMPANIES" +
                " WHERE SUBSTRING(COMPANY_NAME, 1, 3) = :SELECTED_STRING",
        resultClass = Company.class
)
@NamedQuery(
        name = "Company.findCompanyByName",
        query = "FROM Company WHERE name LIKE CONCAT('%',CONCAT(:NAME,'%'))"
)
@Entity
@Table(name = "COMPANIES")
public class Company {
    private int id;
    private String name;
    private String extractString;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    @Column(name = "EXTRACT_STRING")
    public String getExtractString() {
        return extractString;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private void setExtractString(String extractString) {
        this.extractString = extractString;
    }
}
