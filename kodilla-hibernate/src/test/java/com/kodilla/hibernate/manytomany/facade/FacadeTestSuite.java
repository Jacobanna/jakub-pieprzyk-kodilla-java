package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class FacadeTestSuite {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private SearchFacade searchFacade;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testFindCompanyByName() {
        //Given
        Company company = new Company("company");
        companyDao.save(company);
        //When
        List<Company> result = searchFacade.findCompanyByName("omp");
        //Then
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void testFindEmployeeByName() {
        //Given
        Employee employee = new Employee("John", "Wick");
        employeeDao.save(employee);
        //When
        List<Employee> result = searchFacade.findEmployeeByFirstName("ohn");
        //Then
        Assert.assertEquals(1, result.size());
    }
}
