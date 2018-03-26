package com.rolety.roletycrud.repository;

import com.rolety.roletycrud.domain.Rolety;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RoletyRepository {

    public Connection getConnection();

	public void setConnection(Connection connection) throws SQLException;
    public List<Rolety> getAll();
    public void initDatabase();
    public Rolety getById(int id);
    public void addRolety(Rolety rolety);
    public void deleteRolety(Rolety rolety);
    public void updateRolety(Rolety rolety);

}