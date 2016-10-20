package com.bcm.lunarnote;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;

public class AS400ToolkitTest {

  @Test
  public void testGetICBSDate(){
    assertEquals(AS400Toolkit.getICBSDate(AS400Toolkit.DATE_FORMAT_YMD), 20161020);
  }
  
}

