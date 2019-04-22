package project.sqlqueries;

import project.connectiontodb.ConnectionToDB;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Daniluko
 */
public class SQLQueriesImpl implements SQLQueriesDao {


    @Override
    public void headOfDepartment(BigDecimal id) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionToDB.getConnection();
            stmt = connection.prepareStatement("select  departments.name , lectors.name from departments , lectors\n" +
                    "where departments.head_of_department = lectors.id and departments.number_of_departmen = ?");
            stmt.setBigDecimal(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("------------------------------------------------");
                System.out.println( "Department name : " + rs.getString(1));
                System.out.println("Head of department : " + rs.getString(2));
            }
        }  finally {
            rs.close();
            stmt.close();
            connection.close();
        }
    }


    @Override
    public void averageSalaryOfDepartment(BigDecimal department) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionToDB.getConnection();
            stmt = connection.prepareStatement("SELECT AVG(SALARY) from lectors where department = ?");
            stmt.setBigDecimal(1, department);
            rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("------------------------------------------------");
                System.out.println("Average salary of Department : " +  rs.getString(1));
            }
        }  finally {
            rs.close();
            stmt.close();
            connection.close();
        }
    }


    @Override
    public void membersOfDepartment(BigDecimal department) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionToDB.getConnection();
            stmt = connection.prepareStatement("Select  d.number_of_departmen,d.name,l.name  , l.position from lectors l " +
                            "inner join departments d on l.department = d.number_of_departmen " +
                    "where d.number_of_departmen = ?");
            stmt.setBigDecimal(1, department);
            rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("------------------------------------------------");
                System.out.println("All members of this department :");
                System.out.println("Department number :" + rs.getString(1));
                System.out.println("Department name : " +rs.getString(2));
                System.out.println("Name : " + rs.getString(3));
                System.out.println("Position : " + rs.getString(4));
            }
        }  finally {
            rs.close();
            stmt.close();
            connection.close();
        }
    }


    @Override
    public void countLectorsOfDepartment(BigDecimal department) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionToDB.getConnection();
            stmt = connection.prepareStatement("select number_of_lectors from departments where number_of_departmen = ?");
            stmt.setBigDecimal(1, department);
            rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("------------------------------------------------");
                System.out.println("Members of this department  = " + rs.getString(1));

            }
        }  finally {
            rs.close();
            stmt.close();
            connection.close();
        }
    }
}

