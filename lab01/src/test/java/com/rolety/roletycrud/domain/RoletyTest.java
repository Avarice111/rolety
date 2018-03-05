package com.rolety.roletycrud.domain;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoletyTest
{
    
    @Test
    public void testRoletyTest()
    {
        Rolety rolety = new Rolety(1,"Piekne rolety", 160 , 100);
        assertNotNull(rolety);
    }
}