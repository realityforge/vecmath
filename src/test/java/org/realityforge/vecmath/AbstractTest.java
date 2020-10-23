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

  void assertMatEquals( @Nonnull final Matrix4d actual,
                        final double m00, final double m01, final double m02, final double m03,
                        final double m10, final double m11, final double m12, final double m13,
                        final double m20, final double m21, final double m22, final double m23,
                        final double m30, final double m31, final double m32, final double m33 )
  {
    final Matrix4d expected =
      new Matrix4d( m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33 );
    assertEquals( actual.m00,
                  m00,
                  0.00001,
                  "Expected " + actual + " to contain an m00 component of " + m00 + ". Expected: " + expected );
    assertEquals( actual.m01,
                  m01,
                  0.00001,
                  "Expected " + actual + " to contain an m01 component of " + m01 + ". Expected: " + expected );
    assertEquals( actual.m02,
                  m02,
                  0.00001,
                  "Expected " + actual + " to contain an m02 component of " + m02 + ". Expected: " + expected );
    assertEquals( actual.m03,
                  m03,
                  0.00001,
                  "Expected " + actual + " to contain an m03 component of " + m03 + ". Expected: " + expected );
    assertEquals( actual.m10,
                  m10,
                  0.00001,
                  "Expected " + actual + " to contain an m10 component of " + m10 + ". Expected: " + expected );
    assertEquals( actual.m11,
                  m11,
                  0.00001,
                  "Expected " + actual + " to contain an m11 component of " + m11 + ". Expected: " + expected );
    assertEquals( actual.m12,
                  m12,
                  0.00001,
                  "Expected " + actual + " to contain an m12 component of " + m12 + ". Expected: " + expected );
    assertEquals( actual.m13,
                  m13,
                  0.00001,
                  "Expected " + actual + " to contain an m13 component of " + m13 + ". Expected: " + expected );
    assertEquals( actual.m20,
                  m20,
                  0.00001,
                  "Expected " + actual + " to contain an m20 component of " + m20 + ". Expected: " + expected );
    assertEquals( actual.m21,
                  m21,
                  0.00001,
                  "Expected " + actual + " to contain an m21 component of " + m21 + ". Expected: " + expected );
    assertEquals( actual.m22,
                  m22,
                  0.00001,
                  "Expected " + actual + " to contain an m22 component of " + m22 + ". Expected: " + expected );
    assertEquals( actual.m23,
                  m23,
                  0.00001,
                  "Expected " + actual + " to contain an m23 component of " + m23 + ". Expected: " + expected );
    assertEquals( actual.m30,
                  m30,
                  0.00001,
                  "Expected " + actual + " to contain an m30 component of " + m30 + ". Expected: " + expected );
    assertEquals( actual.m31,
                  m31,
                  0.00001,
                  "Expected " + actual + " to contain an m31 component of " + m31 + ". Expected: " + expected );
    assertEquals( actual.m32,
                  m32,
                  0.00001,
                  "Expected " + actual + " to contain an m32 component of " + m32 + ". Expected: " + expected );
    assertEquals( actual.m33,
                  m33,
                  0.00001,
                  "Expected " + actual + " to contain an m33 component of " + m33 + ". Expected: " + expected );
  }
}
