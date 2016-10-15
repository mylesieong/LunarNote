package com.bcm.lunarnote;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.as400.access.*;

import java.util.*;
import java.io.*;
import java.net.*;

/**
 * Controller of Spring MVC
 *
 */

@Controller
public class GreetingController {

    @RequestMapping("/login")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
      model.addAttribute("name", name);
      return "login";
    }

}
