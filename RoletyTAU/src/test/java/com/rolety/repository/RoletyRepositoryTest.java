package com.rolety.repository;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import com.rolety.domain.Rolety;
import com.rolety.repository.RoletyRepositoryFactory;

public class RoletyRepositoryTest
{
    IRoletyRepository roletyRepository;

    @Before
    public void initDatabase() throws SQLException {
        String url = "jdbc:hsqldb:hsql://localhost/workdb";
        roletyRepository = new RoletyRepositoryFactory(DriverManager.getConnection(url));
        Rolety wyborne = new Rolety();
        wyborne.setId(1);
        wyborne.setName("Wyborne");
        wyborne.setPrice(20);
        wyborne.setSize(22);
        Rolety najlepsze = new Rolety();
        najlepsze.setId(2);
        najlepsze.setName("Najlepsze");
        najlepsze.setPrice(80);
        najlepsze.setSize(40);

        roletyRepository.add(wyborne);
        roletyRepository.add(najlepsze);

    }

	@Test
    public void getAll(){
        assertNotNull(roletyRepository.getAll());
    }

    @Test
    public void getById() throws SQLException{
        assertNotNull(roletyRepository.getById(1));
        
    }

    @Test
    public void addRolety() throws SQLException {
        Rolety rolety = new Rolety();
        rolety.setId(3);
        rolety.setName("Mango");
        rolety.setSize(10);
        rolety.setPrice(100);
        roletyRepository.add(rolety);
        assertEquals(roletyRepository.getById(3).getName(), "Mango");
    }

    @Test
    public void deleteRolety() throws SQLException {
        roletyRepository.delete(3);
        assertNotNull(roletyRepository.getById(1));
        assertNotNull(roletyRepository.getById(2));   
        assertNull(roletyRepository.getById(3));     
    }

    @Test
    public void updateRolety () throws SQLException {
        Rolety updateRolety = roletyRepository.getById(1);
        updateRolety.setName("Wyborne_po_zmianie");
        roletyRepository.update(updateRolety, 1);

        assertEquals("Wyborne_po_zmianie", roletyRepository.getById(1).getName());
        assertNotEquals("Wyborne_po_zmianie", roletyRepository.getById(2).getName());

    }
}