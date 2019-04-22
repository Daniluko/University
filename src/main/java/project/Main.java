package project;


import project.sqlqueries.SQLQueriesImpl;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by Daniluko
 */
public class Main {
    public static void main(String[] args) throws SQLException {

        SQLQueriesImpl sqlQueriesImpl = new SQLQueriesImpl();

        sqlQueriesImpl.headOfDepartment(BigDecimal.valueOf(101));
        sqlQueriesImpl.averageSalaryOfDepartment(BigDecimal.valueOf(102));
        sqlQueriesImpl.countLectorsOfDepartment(BigDecimal.valueOf(103));
        sqlQueriesImpl.membersOfDepartment(BigDecimal.valueOf(104));

    }
}
