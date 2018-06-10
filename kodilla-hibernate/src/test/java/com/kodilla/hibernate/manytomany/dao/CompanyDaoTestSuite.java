package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testRetrieveEmployeesByLastName() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        employeeDao.save(johnSmith);
        int johnSmithId = johnSmith.getId();
        employeeDao.save(stephanieClarckson);
        int stephanieClarksonId = stephanieClarckson.getId();
        employeeDao.save(lindaKovalsky);
        int lindaKovalskyId = lindaKovalsky.getId();
        //When
        List<Employee> findByLastName1 = employeeDao.retrieveEmployeesByLastName("Smith");
        List<Employee> findByLastName2 = employeeDao.retrieveEmployeesByLastName("Clarckson");
        List<Employee> findByLastName3 = employeeDao.retrieveEmployeesByLastName("Kovalsky");
        //Then
        Assert.assertEquals(1, findByLastName1.size());
        Assert.assertEquals(1, findByLastName2.size());
        Assert.assertEquals(1, findByLastName3.size());
        //CleanUp
        employeeDao.delete(johnSmithId);
        employeeDao.delete(stephanieClarksonId);
        employeeDao.delete(lindaKovalskyId);
    }

    @Test
    public void testRetrieveCompanyWith3FirstLettersAsRequested() {
        //Given
        Company dataMachine = new Company("Data Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        companyDao.save(dataMachine);
        int dataMachineId = dataMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        //When
        List<Company> searchBy3FirstLetters1 = companyDao.retrieveCompanyWith3FirstLettersAsRequested("Dat");
        List<Company> searchBy3FirstLetters2 = companyDao.retrieveCompanyWith3FirstLettersAsRequested("Gre");
        System.out.println(searchBy3FirstLetters1);
        //Then
        Assert.assertEquals(2, searchBy3FirstLetters1.size());
        Assert.assertEquals(1, searchBy3FirstLetters2.size());
        //CleanUp
        companyDao.delete(dataMachineId);
        companyDao.delete(dataMaestersId);
        companyDao.delete(greyMatterId);

    }

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);
        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);
        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }
}
