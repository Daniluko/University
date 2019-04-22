package project.sqlqueries;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by Daniluko
 */
public interface SQLQueriesDao {

    void headOfDepartment(BigDecimal id) throws SQLException;
    void averageSalaryOfDepartment(BigDecimal department) throws SQLException;
    void membersOfDepartment (BigDecimal department)throws SQLException;
    void countLectorsOfDepartment (BigDecimal department)throws SQLException;

}
