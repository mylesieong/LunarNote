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
      /* read dtaara from as400 */
      try{
        String systemName="S657274B";
        String userName="ZCSERVICE";
        String password="ECIVRESCZ";
        String fileName="DEMO_JAVA";
        String libraryName="YMYLES";
        String fileType="DTAARA";
        AS400 system = new AS400(systemName, userName , password);
        QSYSObjectPathName path = new QSYSObjectPathName(libraryName, fileName, fileType);
        CharacterDataArea dataArea = new CharacterDataArea(system, path.getPath());
        name = dataArea.read();
      }catch(Exception e){
        e.printStackTrace();
        name = "No access";
      }
      model.addAttribute("name", name);
      return "login";
    }

}
