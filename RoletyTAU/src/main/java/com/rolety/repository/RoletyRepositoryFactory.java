package com.rolety.repository;

import java.sql.DriverManager;
import java.sql.SQLException;

public class RoletyRepositoryFactory {
    public static IRoletyRepository getInstance() {

        try {
            String url = "jdbc:hsqldb:hsql://localhost/workdb";
            return new RoletyRepositoryImpl(DriverManager.getConnection(url));
        }
        catch (SQLException e){
            return null;
        }
}
}