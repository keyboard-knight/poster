/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.example.spring.webmvc.application.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author stepan
 */
@Controller
@RequestMapping({"/", "/hello-world"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        System.out.println("HELLO WORLD!!!!!");
        return "home";
    }
}
