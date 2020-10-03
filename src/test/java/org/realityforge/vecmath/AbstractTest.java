package org.realityforge.vecmath;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract class AbstractTest
{
  @BeforeMethod
  void beforeTest()
  {
    VecmathTestUtil.resetConfig( false );
  }

  @AfterMethod
  void afterTest()
  {
    VecmathTestUtil.resetConfig( true );
  }
}
