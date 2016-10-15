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
public class AppController {
    
    /**
     * Page from index to enquiry html
     */
    @RequestMapping("/login")
    public String checkLogin(@RequestParam(value="fusr", required=false, defaultValue="World") String fusr, Model model) {
      String goal="";
      if (AS400Toolkit.loginIntent(fusr)){
	model.addAttribute("tusr", fusr);
	goal = "enquiry";
      }else{
	goal = "loginfail";
      }
      return goal;
    }
    
    /**
     * Page from enquiry (or modify) to itself htm
     */
    @RequestMapping("/fetch")
    public String getData(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
      return "login";
    }
}
