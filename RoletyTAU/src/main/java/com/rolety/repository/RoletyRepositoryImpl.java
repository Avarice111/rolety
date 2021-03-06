package com.rolety.repository;

import com.rolety.domain.Rolety;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RoletyRepositoryImpl implements IRoletyRepository {

    private Connection connection;
    private PreparedStatement getAll;
    private PreparedStatement add;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement getById;

    public RoletyRepositoryImpl(Connection connection) throws SQLException{
        this.connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
        if (!isDatabaseReady()) {
            createTables();
        }
        this.setConnection(this.connection);
    }

    public RoletyRepositoryImpl() throws SQLException {
        
    }
    
    private boolean isDatabaseReady() {
        try {
            ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
            boolean tablesExists = false;
            while (rs.next()) {
                if ("Rolety".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tablesExists = true;
                    break;
                }
            }
            return tablesExists;
        } catch (SQLException e) {
            return false;
        }
	}

	private void createTables() throws SQLException {
        connection.createStatement().executeUpdate(
            "CREATE TABLE "
            + "Rolety(id int GENERATED BY DEFAULT AS IDENTITY, " +
            "Name varchar(50) NOT NULL, " + "Price integer NOT NULL, " +
            "Size integer NOT NULL)");
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
        add = connection.prepareStatement(
            "INSERT INTO Rolety (Name, Price, Size) VALUES (?, ?, ?)"
        );
        getAll = connection.prepareStatement(
            "SELECT Id, Name, Price, Size FROM Rolety"
        );
        delete = connection.prepareStatement(
            "DELETE FROM Rolety WHERE Id = ?"
        );
        update = connection.prepareStatement(
            "UPDATE Rolety SET Name = ?, Price = ?, Size = ? WHERE Id = ?"
        );
        getById = connection.prepareStatement(
            "SELECT * FROM Rolety WHERE Id = ?"
        );
	}

	@Override
	public List<Rolety> getAll() {
        List<Rolety> roletys = new LinkedList<Rolety>();
        try {
            ResultSet rs = getAll.executeQuery();

            while (rs.next()) {
                Rolety r = new Rolety();
                r.setId(rs.getInt("Id"));
                r.setName(rs.getString("Name"));
                r.setSize(rs.getInt("Size"));
                r.setPrice(rs.getInt("Price"));
                roletys.add(r);
            } 
        } catch (SQLException e) {
                throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
            }
            return roletys;
    }

	@Override
	public Rolety getById(int id) throws SQLException{
        Rolety rolety = new Rolety();
        try {
            getById.setInt(1, id);
            ResultSet rs = getById.executeQuery();

            while (rs.next()) {
                rolety.setId(rs.getInt("Id"));
                rolety.setName(rs.getString("Name"));
                rolety.setSize(rs.getInt("Size"));
                rolety.setPrice(rs.getInt("Price"));
            } 
        } catch (SQLException e) {
                throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
            }
            return rolety;
    }


	@Override
	public int add(Rolety rolety) {
        int count = 0;
        try {
            add.setString(1, rolety.getName());
            add.setInt(2, rolety.getPrice());
            add.setInt(3, rolety.getSize());
            count = add.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
        return count;
	}

	@Override
	public int delete(int id) {
        int count = 0;
        try {
            delete.setInt(1, id);
            count = delete.executeUpdate();
            
        }catch(SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
		return count;
    }

	@Override
	public int update(Rolety rolety, int id) throws SQLException {
        int count = 0;
        try {
            update.setString(1, rolety.getName());
            update.setInt(2, rolety.getPrice());
            update.setInt(3, rolety.getSize());
            update.setInt(4, rolety.getId());
            count = update.executeUpdate();
        } catch(SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }

        return count;
    }
}