package com.rolety.repository;

import com.rolety.domain.Rolety;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IRoletyRepository {

	public void setConnection(Connection connection) throws SQLException;
    public List<Rolety> getAll();
    public Rolety getById(int id) throws SQLException;
    public int add(Rolety rolety);
    public int delete(int id);
    public int update(Rolety rolety, int id) throws SQLException;

}