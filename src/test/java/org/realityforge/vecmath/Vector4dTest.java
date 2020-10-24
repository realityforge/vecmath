package org.realityforge.vecmath;

import javax.annotation.Nonnull;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class Vector4dTest
  extends AbstractTest
{
  @Test
  public void testToString()
  {
    assertEquals( new Vector4d().toString(), "(0.0, 0.0, 0.0, 0.0)" );
    assertDefaultToStringWhenDebugToStringDisabled( new Vector4d() );
  }

  @Test
  public void asString()
  {
    assertEquals( new Vector4d().asString(), "(0.0, 0.0, 0.0, 0.0)" );
    VecmathTestUtil.disableDebugToString();
    assertEquals( new Vector4d().asString(), "(0.0, 0.0, 0.0, 0.0)" );
  }

  @Test
  public void isEqualTo()
  {
    final Vector4d value1 = new Vector4d( 1, 2, 3, 4 );
    final Vector4d value2 = new Vector4d( 1, 2, 3, 4 );
    final Vector4d value3 = new Vector4d( 5, 6, 7, 8 );
    assertTrue( value1.isEqualTo( value1 ) );
    assertTrue( value1.isEqualTo( value2 ) );
    assertFalse( value1.isEqualTo( value3 ) );
  }

  @Test
  public void testHashCode()
  {
    VecmathTestUtil.enableObjectEquals();
    final Vector4d value1 = new Vector4d( 1, 2, 3, 4 );
    final Vector4d value2 = new Vector4d( 1, 2, 3, 4 );
    final Vector4d value3 = new Vector4d( 5, 6, 7, 8 );
    assertEquals( value1, value1 );
    assertEquals( value1.hashCode(), value1.hashCode() );
    assertEquals( value1, value2 );
    assertNotEquals( value1, value3 );
    assertNotEquals( value1.hashCode(), value3.hashCode() );
    assertNotEquals( value3, value1 );
    assertNotEquals( value3.hashCode(), value1.hashCode() );
  }

  @Test
  public void testHashCode_whenObjectEqualsDisabled()
  {
    final Vector4d value1 = new Vector4d( 1, 2, 3, 4 );
    final Vector4d value2 = new Vector4d( 1, 2, 3, 4 );

    assertVecEquals( value1, 1, 2, 3, 4 );
    assertEquals( value1, value1 );
    assertEquals( value1.hashCode(), value1.hashCode() );

    assertVecEquals( value2, 1, 2, 3, 4 );
    assertEquals( value2, value2 );
    assertEquals( value2.hashCode(), value2.hashCode() );

    assertNotEquals( value1, value2 );
    assertNotEquals( value1.hashCode(), value2.hashCode() );
  }

  @Test
  public void constructors()
  {
    assertVecEquals( new Vector4d(), 0.0, 0.0, 0.0, 0.0 );
    assertVecEquals( new Vector4d( 1, 2, 3, 4 ), 1, 2, 3, 4 );
    assertVecEquals( new Vector4d( new Vector4d( 1, 2, 3, 4 ) ), 1, 2, 3, 4 );
  }

  @Test
  public void dup()
  {
    final Vector4d value = new Vector4d( 1, 2, 3, 4 );
    final Vector4d dup = value.dup();
    assertVecEquals( dup, 1, 2, 3, 4 );
    assertNotSame( dup, value );
  }

  @Test
  public void set()
  {
    final Vector4d value = new Vector4d( 1, 2, 3, 4 );
    assertVecEquals( value, 1, 2, 3, 4 );

    assertSame( value.set( new Vector4d() ), value );
    assertVecEquals( value, 0, 0, 0, 0 );

    assertSame( value.set( 1, 2, 3, 4 ), value );
    assertVecEquals( value, 1, 2, 3, 4 );
  }

  @Test
  public void add()
  {
    final Vector4d value = new Vector4d( 1, 2, 3, 4 );
    assertVecEquals( value, 1, 2, 3, 4 );

    assertSame( value.add( new Vector4d( 5, 6, 7, 8 ) ), value );
    assertVecEquals( value, 6, 8, 10, 12 );

    assertSame( value.add( 5, 3, 1, -1 ), value );
    assertVecEquals( value, 11, 11, 11, 11 );

    assertSame( value.add( new Vector4d( 1, 2, 3, 4 ), new Vector4d( 1, 2, 3, 4 ) ), value );
    assertVecEquals( value, 2, 4, 6, 8 );
  }

  @Test
  public void sub()
  {
    final Vector4d value = new Vector4d( 1, 2, 3, 4 );
    assertVecEquals( value, 1, 2, 3, 4 );

    assertSame( value.sub( new Vector4d( 5, 6, 7, 8 ) ), value );
    assertVecEquals( value, -4, -4, -4, -4 );

    assertSame( value.sub( 5, 3, 1, 0 ), value );
    assertVecEquals( value, -9, -7, -5, -4 );

    assertSame( value.sub( new Vector4d( 1, 2, 3, 4 ), new Vector4d( 1, 2, 3, 4 ) ), value );
    assertVecEquals( value, 0, 0, 0, 0 );
  }

  @Test
  public void mul()
  {
    final Vector4d value = new Vector4d( 1, 2, 3, 4 );
    assertVecEquals( value, 1, 2, 3, 4 );

    assertSame( value.mul( 2 ), value );
    assertVecEquals( value, 2, 4, 6, 8 );
  }

  @Test
  public void div()
  {
    final Vector4d value = new Vector4d( 1, 2, 3, 4 );
    assertVecEquals( value, 1, 2, 3, 4 );

    assertSame( value.div( 2 ), value );
    assertVecEquals( value, 0.5, 1, 1.5, 2 );
  }

  @Test
  public void lengthSquared()
  {
    assertEquals( new Vector4d( 1, 0, 0, 0 ).lengthSquared(), 1, 0.00001 );
    assertEquals( new Vector4d( 0, 1, 0, 0 ).lengthSquared(), 1, 0.00001 );
    assertEquals( new Vector4d( 0, 0, 1, 0 ).lengthSquared(), 1, 0.00001 );
    assertEquals( new Vector4d( 1, 2, 3, 4 ).lengthSquared(), 30, 0.00001 );
  }

  @Test
  public void length()
  {
    assertEquals( new Vector4d( 1, 0, 0, 0 ).length(), 1, 0.00001 );
    assertEquals( new Vector4d( 0, 1, 0, 0 ).length(), 1, 0.00001 );
    assertEquals( new Vector4d( 0, 0, 1, 0 ).length(), 1, 0.00001 );
    assertEquals( new Vector4d( 1, 2, 3, 4 ).length(), 5.477225575051661, 0.00001 );
  }

  @Test
  public void normalize()
  {
    assertVectorNormal( new Vector4d( 1, 0, 0, 0 ), 1, 0, 0, 0 );
    assertVectorNormal( new Vector4d( 0, 1, 0, 0 ), 0, 1, 0, 0 );
    assertVectorNormal( new Vector4d( 0, 0, 1, 0 ), 0, 0, 1, 0 );
    assertVectorNormal( new Vector4d( 1, 2, 3, 4 ),
                        0.18257418583505536,
                        0.3651483716701107,
                        0.5477225575051661,
                        0.7302967433402214 );
  }

  private void assertVectorNormal( @Nonnull final Vector4d vector,
                                   final double x,
                                   final double y,
                                   final double z,
                                   final double w )
  {
    final Vector4d normalized = vector.normalize();
    assertVecEquals( normalized, x, y, z, w );
    assertEquals( normalized.length(), 1.0, 0.00001 );
  }

  @Test
  public void dot()
  {
    // Dot between orthogonal axis should be zero
    assertDot( /* x axis */ 1, 0, 0, 0, /* y axis */  0, 1, 0, 0, 0 );
    assertDot( /* x axis */ 1, 0, 0, 0, /* z axis */  0, 0, 1, 0, 0 );
    assertDot( /* y axis */ 0, 1, 0, 0, /* z axis */  0, 0, 1, 0, 0 );

    // Dot between identical vectors should be 1
    assertDot( /* x axis */ 1, 0, 0, 0, /* x axis */  1, 0, 0, 0, 1 );
    assertDot( /* y axis */ 0, 1, 0, 0, /* y axis */  0, 1, 0, 0, 1 );
    assertDot( /* z axis */ 0, 0, 1, 0, /* z axis */  0, 0, 1, 0, 1 );

    // Dot between vectors with same direction and different magnitude should be the value of the largest magnitude
    assertDot( /* x axis */ 1, 0, 0, 0, /* x axis */  33, 0, 0, 0, 33 );
    assertDot( /* y axis */ 0, 1, 0, 0, /* y axis */  0, 42, 0, 0, 42 );
    assertDot( /* z axis */ 0, 0, 1, 0, /* z axis */  0, 0, 71, 0, 71 );

    // now incorporate negatives
    assertDot( /* x axis */ 1, 0, 0, 0, /* x axis */  -33, 0, 0, 0, -33 );
    assertDot( /* y axis */ 0, 1, 0, 0, /* y axis */  0, -42, 0, 0, -42 );
    assertDot( /* z axis */ 0, 0, 1, 0, /* z axis */  0, 0, -71, 0, -71 );
    assertDot( /* w axis */ 0, 0, 0, 1, /* w axis */  0, 0, 0, -22, -22 );

    // higglety pigglety vectors
    assertDot( /* vector 1 */ 1, 2, 3, 4, /* vector */  5, 6, 7, 8, 70 );
    assertDot( /* z axis */ 0, 0, -1, 13, /* z axis */  0, 0, -71, 22, 357 );
  }

  private void assertDot( final double x1, final double y1, final double z1, final double w1,
                          final double x2, final double y2, final double z2, final double w2,
                          final double value )
  {
    assertEquals( new Vector4d( x1, y1, z1, w1 ).dot( new Vector4d( x2, y2, z2, w2 ) ), value );
    assertEquals( new Vector4d( x2, y2, z2, w1 ).dot( new Vector4d( x1, y1, z1, w2 ) ), value );
  }

  @Test
  public void angle()
  {
    assertAngle( /* x axis */ 1, 0, 0, 0, /* y axis */  0, 1, 0, 0, Math.PI / 2 );
    assertAngle( /* x axis */ 1, 0, 0, 0, /* z axis */  0, 0, 1, 0, Math.PI / 2 );
    assertAngle( /* x axis */ 1, 0, 0, 0, /* w axis */  0, 0, 0, 1, Math.PI / 2 );
    assertAngle( /* y axis */ 0, 1, 0, 0, /* z axis */  0, 0, 1, 0, Math.PI / 2 );
    assertAngle( /* y axis */ 0, 1, 0, 0, /* w axis */  0, 0, 0, 1, Math.PI / 2 );
    assertAngle( /* z axis */ 0, 0, 1, 0, /* w axis */  0, 0, 0, 1, Math.PI / 2 );

    assertAngle( /* x axis */ 1, 0, 0, 0, /* x axis */  1, 0, 0, 0, 0 );
    assertAngle( /* y axis */ 0, 1, 0, 0, /* y axis */  0, 1, 0, 0, 0 );
    assertAngle( /* z axis */ 0, 0, 1, 0, /* z axis */  0, 0, 1, 0, 0 );
    assertAngle( /* w axis */ 0, 0, 0, 1, /* w axis */  0, 0, 0, 1, 0 );

    assertAngle( /* x axis */ 1, 0, 0, 0, /* x axis */  33, 0, 0, 0, 0 );
    assertAngle( /* y axis */ 0, 1, 0, 0, /* y axis */  0, 42, 0, 0, 0 );
    assertAngle( /* z axis */ 0, 0, 1, 0, /* z axis */  0, 0, 71, 0, 0 );
    assertAngle( /* w axis */ 0, 0, 0, 1, /* w axis */  0, 0, 0, 47, 0 );

    // now incorporate negatives
    assertAngle( /* x axis */ 1, 0, 0, 0, /* x axis */  -33, 0, 0, 0, Math.PI );
    assertAngle( /* y axis */ 0, 1, 0, 0, /* y axis */  0, -42, 0, 0, Math.PI );
    assertAngle( /* z axis */ 0, 0, 1, 0,/* z axis */  0, 0, -71, 0, Math.PI );
    assertAngle( /* z axis */ 0, 0, -1, 0, /* z axis */  0, 0, -71, 0, 0 );

    // higglety pigglety vectors
    assertAngle( /* vector 1 */ 1, 2, 3, 4, /* vector */  5, 6, 7, 8, 0.2501959204225109 );
  }

  private void assertAngle( final double x1, final double y1, final double z1, final double w1,
                            final double x2, final double y2, final double z2, final double w2,
                            final double value )
  {
    assertEquals( new Vector4d( x1, y1, z1, w1 ).angle( new Vector4d( x2, y2, z2, w2 ) ), value );
    assertEquals( new Vector4d( x2, y2, z2, w2 ).angle( new Vector4d( x1, y1, z1, w1 ) ), value );
  }

  @Test
  public void lerp()
  {
    assertLerp( /* v1 */ 0, 0, 0, 0, /* v2 */  1, 1, 1, 1, /* factor */ 0, /* result */ 0, 0, 0, 0 );
    assertLerp( /* v1 */ 0, 0, 0, 0, /* v2 */  1, 1, 1, 1, /* factor */ 1, /* result */ 1, 1, 1, 1 );
    assertLerp( /* v1 */ 0, 0, 0, 0, /* v2 */  1, 1, 1, 1,/* factor */ 0.5, /* result */ 0.5, 0.5, 0.5, 0.5 );
    assertLerp( /* v1 */ 0, 0, 0, 0, /* v2 */  1, 1, 1, 1,/* factor */ 0.15, /* result */ 0.15, 0.15, 0.15, 0.15 );
    assertLerp( /* v1 */ 0, 0, 0, 0, /* v2 */  1, 1, 1, 1,/* factor */ 0.75, /* result */ 0.75, 0.75, 0.75, 0.75 );

    assertLerp( /* v1 */ 9, 4, 3, 3, /* v2 */  2, -2, 9, 2, /* factor */ 0.32, /* result */ 6.76, 2.08, 4.92, 2.68 );
  }

  private void assertLerp( final double x1, final double y1, final double z1, final double w1,
                           final double x2, final double y2, final double z2, final double w2,
                           final double interpolationValue,
                           final double x3, final double y3, final double z3, final double w3 )
  {
    assertVecEquals( new Vector4d( x1, y1, z1, w1 ).lerp( new Vector4d( x2, y2, z2, w2 ), interpolationValue ),
                     x3, y3, z3, w3 );
    assertVecEquals( new Vector4d().lerp( new Vector4d( x1, y1, z1, w1 ),
                                          new Vector4d( x2, y2, z2, w2 ),
                                          interpolationValue ),
                     x3, y3, z3, w3 );
  }

  @Test
  public void toArray()
  {
    final Vector4d value = new Vector4d( 1, 2, 3, 4 );

    assertArray( value.toArray(), "[1.0, 2.0, 3.0, 4.0]" );

    // Now with an offset
    assertArray( value.toArray( new double[ 7 ], 2 ), "[0.0, 0.0, 1.0, 2.0, 3.0, 4.0, 0.0]" );
  }
}
