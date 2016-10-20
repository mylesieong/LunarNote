package com.bcm.lunarnote;

import com.ibm.as400.access.*;

/**
 * Toolkit class include static method:
 * 1. loginIntent: call DSNTEMCHK on AS400 and return boolean
 * 2. enquiryIntent: call DSNTEMCHG on AS400 and return boolean
 * 3. modifyIntent: call DSNTEMCHG on AS400 and return boolean
 */

public class AS400Toolkit{
  
  final static int DATE_FORMAT_YMD = 1;

  public static boolean loginIntent(String user){
    return true;
  }

  public static boolean enquiryIntent(String user){
    return true;
  }

  public static boolean modifyIntent(String user){
    return true;
  }

  public static int getICBSDate(int dateFormat){
    /* read dtaara from as400 */
    int r=0;
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
      if (program.run()!= true){
        AS400Message[] messagelist = program.getMessageList();
          for (int i = 0; i < messagelist.length; ++i){
            System.out.println(messagelist[i]);
          }
      }else{
        /* Get the result set */
        r=BytesHelper.toInt(parmList[0].getOutputData());
      }
    }catch(Exception e){
      e.printStackTrace();
      r=0;
    }
    return r;
  }
}
