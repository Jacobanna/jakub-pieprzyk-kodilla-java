package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query
    List<Company> retrieveCompanyWith3FirstLettersAsRequested(@Param("SELECTED_STRING") String selectedString);

    @Query
    List<Company> findCompanyByName(@Param("NAME") String companyName);
}
