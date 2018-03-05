package com.rolety.domain;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoletyTest
{
    @Test
    public void testRoletyTest()
    {
        Rolety rolety = new Rolety("Piekne rolety", 160 , 100);
        assertNotNull(rolety);
    }

    @Test
    public void getbyId() {
        Long idToFind = (long) 1;
        assertNotNull(roletyRepository.getById(idToFind));
    }
}