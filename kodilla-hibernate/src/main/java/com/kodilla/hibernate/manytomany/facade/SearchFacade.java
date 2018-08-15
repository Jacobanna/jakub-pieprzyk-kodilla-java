package com.kodilla.hibernate.manytomany.facade;
import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchFacade {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyDao companyDao;

    public List<Company> findCompanyByName(String companyName) {
        return companyDao.findCompanyByName(companyName);
    }

    public List<Employee> findEmployeeByFirstName (String employeeName) {
        return employeeDao.findEmployeeByFirstName(employeeName);
    }


}
