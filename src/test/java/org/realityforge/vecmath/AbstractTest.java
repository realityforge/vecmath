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

  void assertVecEquals( @Nonnull final Vector2d actual, final double x, final double y )
  {
    final Vector2d expected = new Vector2d( x, y );
    assertEquals( actual.x,
                  x,
                  0.00001,
                  "Expected " + actual + " to contain an x component of " + x + ". Expected: " + expected );
    assertEquals( actual.y,
                  y,
                  0.00001,
                  "Expected " + actual + " to contain an y component of " + y + ". Expected: " + expected );
  }

  void assertVecEquals( @Nonnull final Vector3d actual, final double x, final double y, final double z )
  {
    final Vector3d expected = new Vector3d( x, y, z );
    assertEquals( actual.x,
                  x,
                  0.00001,
                  "Expected " + actual + " to contain an x component of " + x + ". Expected: " + expected );
    assertEquals( actual.y,
                  y,
                  0.00001,
                  "Expected " + actual + " to contain an y component of " + y + ". Expected: " + expected );
    assertEquals( actual.z,
                  z,
                  0.00001,
                  "Expected " + actual + " to contain an z component of " + z + ". Expected: " + expected );
  }

  void assertVecEquals( @Nonnull final Vector3f actual, final float x, final float y, final float z )
  {
    final Vector3f expected = new Vector3f( x, y, z );
    assertEquals( actual.x,
                  x,
                  0.00001,
                  "Expected " + actual + " to contain an x component of " + x + ". Expected: " + expected );
    assertEquals( actual.y,
                  y,
                  0.00001,
                  "Expected " + actual + " to contain an y component of " + y + ". Expected: " + expected );
    assertEquals( actual.z,
                  z,
                  0.00001,
                  "Expected " + actual + " to contain an z component of " + z + ". Expected: " + expected );
  }
}
