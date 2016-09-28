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
        String programName="/QSYS.LIB/IMODULE.LIB/DICBSYMD.PGM";
	AS400 system = new AS400(systemName, userName , password);
	ProgramParameter[] parmList= new ProgramParameter[1];
	parmList[0] = new ProgramParameter(8);
	ProgramCall program = new ProgramCall(system);
	program.setProgram(programName, parmList);
	//run the program 
	if (program.run()!= true){
	  AS400Message[] messagelist = program.getMessageList();
          for (int i = 0; i < messagelist.length; ++i){
            System.out.println(messagelist[i]);
          }
	}else{
	  //name = output.toObject(parmList[0].getOutputData()).toString();
	  int i=parmList[0].getOutputData()[0];
	  name =  Integer.toString(i);
	}

      }catch(Exception e){
        e.printStackTrace();
        name = "No access";
      }
      model.addAttribute("name", name);
      return "login";
    }

}
