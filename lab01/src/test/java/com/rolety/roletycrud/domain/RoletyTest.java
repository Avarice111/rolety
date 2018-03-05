package com.rolety.roletycrud.domain;

import static org.junit.Assert.*;

import com.rolety.roletycrud.repository.RoletyRepository;
import org.junit.Test;

public class RoletyTest
{
    
    @Test
    public void testRoletyTest()
    {
        Rolety rolety = new Rolety("Piekne rolety", 160 , 100);
        assertNotNull(rolety);
    }
}