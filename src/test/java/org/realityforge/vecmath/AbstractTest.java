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
    assertDefaultToString( object );
    VecmathTestUtil.enableDebugToString();
  }

  void assertDefaultToString( @Nonnull final Object object )
  {
    assertEquals( object.toString(), object.getClass().getName() + "@" + Integer.toHexString( object.hashCode() ) );
  }

  void assertVecEquals( @Nonnull final Vec3f vec3f, final float x, final float y, final float z )
  {
    final Vec3f actual = new Vec3f( x, y, z );
    assertEquals( vec3f.x,
                  x,
                  0.00001,
                  "Expected " + vec3f + " to contain an x component of " + x + " but actual vec is " + actual );
    assertEquals( vec3f.y,
                  y,
                  0.00001,
                  "Expected " + vec3f + " to contain an y component of " + y + " but actual vec is " + actual );
    assertEquals( vec3f.z,
                  z,
                  0.00001,
                  "Expected " + vec3f + " to contain an z component of " + z + " but actual vec is " + actual );
  }
}
