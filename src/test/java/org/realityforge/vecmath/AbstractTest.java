package org.realityforge.vecmath;

import javax.annotation.Nonnull;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.*;

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

  void assertDefaultToStringWhenDebugToStringDisabled( @Nonnull final Object object )
  {
    VecmathTestUtil.disableDebugToString();
    assertDefaultToString( new Vec3f() );
    VecmathTestUtil.enableDebugToString();
  }

  void assertDefaultToString( @Nonnull final Object object )
  {
    assertEquals( object.toString(), object.getClass().getName() + "@" + Integer.toHexString( object.hashCode() ) );
  }
}
