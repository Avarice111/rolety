package com.rolety.roletycrud.repository;

import static org.junit.Assert.*;
import org.junit.Test;
import com.rolety.roletycrud.domain.Rolety;
import com.rolety.roletycrud.repository.RoletyRepository;
import com.rolety.roletycrud.repository.RoletyRepositoryFactory;

public class RoletyRepositoryTest
{
    RoletyRepository roletyRepository;

	@Test
    public void getAll(){
    assertNotNull(roletyRepository.getAll());
    }

    @Test
    public void initDatabase() {
    assertNotNull(RoletyRepositoryFactory.getInstance());
    }

    @Test
    public void getById() {
        assertNotNull(RoletyRepositoryFactory.getInstance().getById(1));
        
    }

    @Test
    public void addRolety() {
        Rolety rolety = new Rolety();
        rolety.setId(1);
        rolety.setName("Rolety z Mango");
        rolety.setSize(2);
        rolety.setPrice(10);
        roletyRepository.addRolety(rolety);
        assertEquals(RoletyRepositoryFactory.getInstance().getById(1).getName(), "Rolety z Mango");
    }

    @Test
    public void deleteRolety() {
        Rolety rolety = RoletyRepositoryFactory.getInstance().getById(1);
        roletyRepository.deleteRolety(rolety);
        assertEquals(null, RoletyRepositoryFactory.getInstance().getById(1));
    }

    @Test
    public void updateRolety () {
        Rolety rolety = RoletyRepositoryFactory.getInstance().getById(2);
        rolety.setName("mango_super_opcja");
        roletyRepository.updateRolety(2, rolety);
        assertEquals("mango_super_opcja", RoletyRepositoryFactory.getInstance().getById(2).getName());
    }
}