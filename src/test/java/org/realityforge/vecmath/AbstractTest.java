package org.realityforge.vecmath;

import java.util.Arrays;
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

  void assertVecEquals( @Nonnull final Vector4d actual, final double x, final double y, final double z, final double w )
  {
    final Vector4d expected = new Vector4d( x, y, z, w );
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
    assertEquals( actual.w,
                  w,
                  0.00001,
                  "Expected " + actual + " to contain an w component of " + w + ". Expected: " + expected );
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

  void assertUniformScaleMatrix( @Nonnull final Matrix4d matrix, final double scale )
  {
    assertMatEquals( matrix,
                     scale, 0.0, 0.0, 0.0,
                     0.0, scale, 0.0, 0.0,
                     0.0, 0.0, scale, 0.0,
                     0.0, 0.0, 0.0, 1.0 );
  }

  void assertIdentityMatrix( @Nonnull final Matrix4d matrix )
  {
    assertUniformScaleMatrix( matrix, 1.0 );
  }

  void assertMatEquals( @Nonnull final Matrix4d actual,
                        @Nonnull final org.joml.Matrix4d expected )
  {
    assertMatEquals( actual,
                     expected.m00(), expected.m01(), expected.m02(), expected.m03(),
                     expected.m10(), expected.m11(), expected.m12(), expected.m13(),
                     expected.m20(), expected.m21(), expected.m22(), expected.m23(),
                     expected.m30(), expected.m31(), expected.m32(), expected.m33(),
                     0.00001 );
  }

  void assertMatEquals( @Nonnull final Matrix4d actual,
                        final double m00, final double m10, final double m20, final double m30,
                        final double m01, final double m11, final double m21, final double m31,
                        final double m02, final double m12, final double m22, final double m32,
                        final double m03, final double m13, final double m23, final double m33 )
  {
    assertMatEquals( actual, m00, m10, m20, m30, m01, m11, m21, m31, m02, m12, m22, m32, m03, m13, m23, m33, 0.00001 );
  }

  @SuppressWarnings( "SameParameterValue" )
  void assertMatEquals( @Nonnull final Matrix4d actual,
                        final double m00, final double m10, final double m20, final double m30,
                        final double m01, final double m11, final double m21, final double m31,
                        final double m02, final double m12, final double m22, final double m32,
                        final double m03, final double m13, final double m23, final double m33,
                        final double delta )
  {
    final Matrix4d expected =
      new Matrix4d( m00, m10, m20, m30, m01, m11, m21, m31, m02, m12, m22, m32, m03, m13, m23, m33 );
    assertComponent( actual, expected, "m00", actual.m00, m00, delta );
    assertComponent( actual, expected, "m01", actual.m01, m01, delta );
    assertComponent( actual, expected, "m02", actual.m02, m02, delta );
    assertComponent( actual, expected, "m03", actual.m03, m03, delta );

    assertComponent( actual, expected, "m10", actual.m10, m10, delta );
    assertComponent( actual, expected, "m11", actual.m11, m11, delta );
    assertComponent( actual, expected, "m12", actual.m12, m12, delta );
    assertComponent( actual, expected, "m13", actual.m13, m13, delta );

    assertComponent( actual, expected, "m20", actual.m20, m20, delta );
    assertComponent( actual, expected, "m21", actual.m21, m21, delta );
    assertComponent( actual, expected, "m22", actual.m22, m22, delta );
    assertComponent( actual, expected, "m23", actual.m23, m23, delta );

    assertComponent( actual, expected, "m30", actual.m30, m30, delta );
    assertComponent( actual, expected, "m31", actual.m31, m31, delta );
    assertComponent( actual, expected, "m32", actual.m32, m32, delta );
    assertComponent( actual, expected, "m33", actual.m33, m33, delta );
  }

  private void assertComponent( @Nonnull final Matrix4d actual,
                                @Nonnull final Matrix4d expected,
                                final String componentName,
                                final double actualValue,
                                final double expectedValue,
                                final double delta )
  {
    assertEquals( actualValue,
                  expectedValue,
                  delta,
                  "Expected component " +
                  componentName + " to have the value " +
                  expectedValue + " but was " +
                  actualValue +
                  "\nActual matrix:" +
                  "\n----------------------------\n" +
                  actual +
                  "\n----------------------------\n" +
                  "\nExpected matrix:" +
                  "\n----------------------------\n" +
                  expected +
                  "\n----------------------------\n" );
  }

  protected final void assertArray( @Nonnull final double[] doubles, @Nonnull final String expected )
  {
    assertEquals( Arrays.asList( boxArray( doubles ) ).toString(), expected );
  }

  @Nonnull
  private Double[] boxArray( @Nonnull final double[] value )
  {
    final Double[] result = new Double[ value.length ];
    for ( int i = 0; i < value.length; i++ )
    {
      result[ i ] = value[ i ];
    }
    return result;
  }
}
