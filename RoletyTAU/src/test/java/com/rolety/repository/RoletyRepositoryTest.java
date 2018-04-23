package com.rolety.repository;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.rolety.roletycrud.domain.Rolety;
import com.rolety.roletycrud.repository.RoletyRepository;
import com.rolety.roletycrud.repository.RoletyRepositoryFactory;

public class RoletyRepositoryTest
{
    IRoletyRepository roletyRepository;

    @Before
    public void initDatabase() throws SQLException {
        String url = "jdbc:hsqldb:hsql://localhost/workdb";
        roletyRepository = new RoletyRepositoryFactory(DriverManager.getConnection(url));
        Rolety wyborne = new Rolety();
        wyborne.setId(1);
        wybore.setName("Wyborne");
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
    public void getById() {
        assertNotNull(RoletyRepository.getById(1));
        assertThat(rolety.getName(), is("Wyborne"));
        
    }

    @Test
    public void addRolety() {
        Rolety rolety = new Rolety();
        rolety.setId(3);
        rolety.setName("Mango");
        rolety.setSize(10);
        rolety.setPrice(100);
        roletyRepository.add(rolety);
        assertEquals(RoletyRepository.getById(3).getName(), "Mango");
    }

    @Test
    public void deleteRolety() {
        roletyRepository.delete(3);
        assertNotNull(roletyRepository.getById(1));
        assertNotNull(roletyRepository.getById(2));   
        assertNull(roletyRepository.getById(3));     
    }

    @Test
    public void updateRolety () {
        Rolety updateRolety = roletyRepository.getById(1);
        updateRolety.setName("Wyborne_po_zmianie");
        roletyRepository.update(updateRolety, 1);

        assertEquals("Wyborne_po_zmianie", roletyRepository.getById(1).getName());
        assertNotEquals("Wyborne_po_zmianie", roletyRepository.getById(2).getName());

    }
}