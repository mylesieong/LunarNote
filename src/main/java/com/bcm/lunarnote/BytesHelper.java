package com.bcm.lunarnote;

import java.lang.Integer; 
import java.lang.Math;

public final class BytesHelper {

  private BytesHelper() {}

  public static int toInt(byte[] bytes) {
    int result = 0;
    for (int i=0; i<8; i++) {
      //Packed decimal consum ceiling((x+2)/2) bytes for a x digit number 
      //and it start with 4 bit 0 and end with 4 bit 1
      int index = (i+1)/2;
      int isHigh = i%2;
      System.out.println("index" + index + ", isHigh"+ isHigh);
      int value = isHigh==1?((int)bytes[index]>>4 & 0x0F):((int)bytes[index]& 0x0F);
      result = result * 10 + value;
    }
    return result;
  }
  
}