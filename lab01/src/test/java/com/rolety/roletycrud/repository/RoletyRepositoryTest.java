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
    roletyRepository = RoletyRepositoryFactory.getInstance();
    Rolety rolety1 = new Rolety();
    rolety1.setId(1);
    rolety1.setName("mango");
    rolety1.setPrice(100);
    rolety1.setSize(21);
    roletyRepository.addRolety(rolety1);
    }

    @Test
    public void getById(int id) {
        assertNotNull(roletyRepository.getById(id));
        
    }

    @Test
    public void addRolety(Rolety rolety) {
        rolety.setId(1);
        rolety.setName("Rolety z Mango");
        rolety.setSize(2);
        rolety.setPrice(10);
        roletyRepository.addRolety(rolety);
        assertNotNull(roletyRepository.getById(rolety.getId()));
    }

    @Test
    public void deleteRolety(Rolety rolety) {
        rolety = roletyRepository.getById(1);
        roletyRepository.deleteRolety(rolety);
        if (roletyRepository.getAll().size() > 0){
            assertNotNull(roletyRepository.getAll());
        }else {
            assertNull(roletyRepository.getById(rolety.getId()));
        }
    }

    @Test
    public void updateRolety () {
        Rolety rolety = new Rolety();
        rolety.setId(2);
        rolety.setName("mango_super_opcja");
        rolety.setPrice(120);
        rolety.setSize(22);
        int idToUpdate = 2;
        roletyRepository.updateRolety(idToUpdate, rolety);
        assertEquals(roletyRepository.getById(idToUpdate).getPrice(), roletyRepository.getById(rolety.getId()).getPrice());
    }
}