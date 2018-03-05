package com.rolety.roletycrud.repository;

import static org.junit.Assert.*;
import org.junit.Test;
import com.rolety.roletycrud.domain.Rolety;
import com.rolety.roletycrud.repository.RoletyRepository;;

public class RoletyRepositoryTest
{
    RoletyRepository roletyRepository;

	@Test
    public void getAll(){
    assertNotNull(roletyRepository.getAll());
    }

    @Test
    public void initDatabase() {

    }

    @Test
    public Rolety getById(long id) {
        return null;
        
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
        rolety = roletyRepository.getById((long) 1);
        roletyRepository.deleteRolety(rolety);
        if (roletyRepository.getAll().size() > 0){
            assertNotNull(roletyRepository.getAll());
        }else {
            assertNull(roletyRepository.getById(rolety.getId()));
        }
    }

    @Test
    public void updateRolety(long oldId, Rolety newRolety) {

    }
}