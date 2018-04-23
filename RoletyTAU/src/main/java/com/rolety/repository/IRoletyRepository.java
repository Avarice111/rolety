package com.rolety.repository;

import com.rolety.roletycrud.domain.Rolety;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RoletyRepository {

	public void setConnection(Connection connection) throws SQLException;
    public List<Rolety> getAll();
    public Rolety getById(int id);
    public int addRolety(Rolety rolety);
    public int deleteRolety(int id);
    public int updateRolety(Rolety rolety, int id);

}