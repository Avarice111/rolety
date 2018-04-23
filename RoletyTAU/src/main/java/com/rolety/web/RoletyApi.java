package com.rolety.web;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.kolejarz.domain.Rolety;
import pl.kolejarz.repository.IRoletyRepository;

@RestController
public class RoletyApi {
    @Autowired
    IRoletyRepository roletyRepository;

    @RequestMapping("/")
    public String index()
    {
        return "This is not rest, just checking if everything works";
    }

    @RequestMapping(value = "/rolety", method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public int addRolety(@RequestBody Rolety r)
    {
            return new int(roletyRepository.add(r));
    }

    @RequestMapping(value = "/rolety", method = RequestMapping.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Rolety> getRoletys() throws SQLException
    {
        List<Rolety> rolety = new LinkedList<Rolety>();
        for(Rolety r : roletyRepository.getAll())
        {
                rolety.add(r);
        }
        return rolety;
    }

    @RequestMapping(value= "/rolety/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rolety getRolety(@PathVariable("id") int id) throws SQLException
    {
        return roletyRepository.getById(id);
    }

    @RequestMapping(value = "/rolety/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int deleteRolety(@PathVariable("id") int id) throws SQLException {
        return new int(roletyRepository.delete(id));
    }

    @RequestMapping(value = "/rolety/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateRolety(@PathVariable("id") int id ,@RequestBody Rolety r ) throws SQLException
    {
        return new int(roletyRepository.update(r, id));   
    }




}