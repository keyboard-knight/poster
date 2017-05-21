/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.example.spring.webmvc.application.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import su.lambda.example.spring.webmvc.application.persist.DatabaseFacade;

/**
 *
 * @author stepan
 */
@Controller
@RequestMapping("/init-db")
public class InitializeDatabaseController {

    @Autowired
    private DatabaseFacade databaseFacade;

    public DatabaseFacade getDatabaseFacade() {
        return databaseFacade;
    }

    public void setDatabaseFacade(DatabaseFacade databaseFacade) {
        this.databaseFacade = databaseFacade;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String init() {
        databaseFacade.cleanDatabase();
        databaseFacade.generateDatabaseContent();
        return "init-db";
    }

}
