package com.rolety.web;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rolety.domain.Rolety;
import com.rolety.repository.IRoletyRepository;
import com.rolety.repository.RoletyRepositoryFactory;

@RestController
public class RoletyApi {

    @Autowired
    IRoletyRepository roletyRepository;

    @RequestMapping("/")
    public String index() {
        return "This is not rest, just checking if everything works.";
    }

    @RequestMapping(value = "/rolety", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Rolety> getAll() throws SQLException {
        roletyRepository = RoletyRepositoryFactory.getInstance();
        List<Rolety> roletys = new LinkedList<Rolety>();
        for (Rolety rolety : roletyRepository.getAll()) {
                roletys.add(rolety);
        }
        return roletys;
    }

    @RequestMapping(value = "/rolety/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Rolety getById(@PathVariable("id") int id) throws SQLException {
        roletyRepository = RoletyRepositoryFactory.getInstance();
        return roletyRepository.getById(id);
    }

    @RequestMapping(value = "/rolety", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long add(@RequestBody Rolety rolety) {
        roletyRepository = RoletyRepositoryFactory.getInstance();
        return new Long(roletyRepository.add(rolety));
    }

    @RequestMapping(value = "/rolety/{id}", method = RequestMethod.DELETE)
    public Long delete(@PathVariable("id") int id) throws SQLException {
        roletyRepository = RoletyRepositoryFactory.getInstance();
        return new Long(roletyRepository.delete(id));
    }

    @RequestMapping(value = "/rolety/{id}", method = RequestMethod.PUT)
    public Long update(@PathVariable("id") int id, @RequestBody Rolety rolety) throws SQLException {
        roletyRepository = RoletyRepositoryFactory.getInstance();
        return new Long(roletyRepository.update(rolety,id));
    }

}