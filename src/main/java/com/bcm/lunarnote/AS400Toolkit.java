package com.bcm.lunarnote;

import com.ibm.as400.access.*;

/**
 * Toolkit class include static method:
 * 1. loginIntent: call DSNTEMCHK on AS400 and return boolean
 * 2. enquiryIntent: call DSNTEMCHG on AS400 and return boolean
 * 3. modifyIntent: call DSNTEMCHG on AS400 and return boolean
 */

public class AS400Toolkit{
  
  public static boolean loginIntent(String user){
    return true;
  }

  public static boolean enquiryIntent(String user){
    return true;
  }

  public static boolean modifyIntent(String user){
    return true;
  }

}
