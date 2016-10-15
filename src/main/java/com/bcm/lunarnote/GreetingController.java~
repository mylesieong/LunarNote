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
      try{
	/* Setup AS400 connection */
        String systemName="S657274B";
        String userName="ZCSERVICE";
        String password="ECIVRESCZ";
	AS400 system = new AS400(systemName, userName , password);

	/* Setup calling program info */
        String programName="/QSYS.LIB/YMYLES1.LIB/DSNTEAUTCL.PGM";
	ProgramParameter[] parmList= new ProgramParameter[3];
	AS400Text parm1 = new AS400Text(10);
	AS400Text parm2 = new AS400Text(1);
	AS400Text parm3 = new AS400Text(1);
	parmList[0] = new ProgramParameter(parm1.toBytes("MYLES     "));    //10 bytes
	parmList[1] = new ProgramParameter(parm2.toBytes("I"));             //1 bytes
	parmList[2] = new ProgramParameter(1);                              //output1 byte
	ProgramCall program = new ProgramCall(system);
	program.setProgram(programName, parmList);
	
	/* Run the program */
	if (program.run()!= true){
	  AS400Message[] messagelist = program.getMessageList();
          for (int i = 0; i < messagelist.length; ++i){
            System.out.println(messagelist[i]);
          }
	}else{
	  System.out.println("parm3 value: "+ parm3.toObject(parmList[2].getOutputData()));
          if(((String)parm3.toObject(parmList[2].getOutputData())).equals("0")){
            name = "VERIFIED";
	  }else{
	    name = "NO_ACCESS";
	  }
	  //int i=parmList[0].getOutputData()[0];
	  //name =  Integer.toString(i);
	}

      }catch(Exception e){
        e.printStackTrace();
        name = "No access";
      }
      model.addAttribute("name", name);
      return "login";
    }

}
