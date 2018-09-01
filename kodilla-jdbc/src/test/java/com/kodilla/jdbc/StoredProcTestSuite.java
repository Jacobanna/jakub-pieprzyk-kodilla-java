package com.kodilla.jdbc;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "update readers set vip_level=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        //When
        String sqlProcedureCall = "call UpdateVipLevels()";
        statement.execute(sqlProcedureCall);
        //Then
        String sqlCheckTable = "select count(*) as how_many from readers where vip_level=\"Not set\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if(rs.next()) {
            howMany = rs.getInt("how_many");
        }
        assertEquals(0, howMany);
    }

    @Test
    public void testUpdateBestsellers() throws SQLException{
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "update books set bestseller = null";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        //When
        String sqlProcedureCall = "call UpdateBestSellers()";
        statement.execute(sqlProcedureCall);
        //Then
        String sqlCheckTable = "select count(*) as how_many from books where bestseller = null";
        ResultSet resultSet = statement.executeQuery(sqlCheckTable);
        int howmany = -1;
        if(resultSet.next()) {
            howmany = resultSet.getInt("how_many");
        }
        assertEquals(0, howmany);
    }
}