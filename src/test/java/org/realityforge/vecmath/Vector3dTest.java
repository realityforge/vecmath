package org.realityforge.vecmath;

import javax.annotation.Nonnull;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class Vector3dTest
  extends AbstractTest
{
  @Test
  public void testToString()
  {
    assertEquals( new Vector3d().toString(), "(0.0, 0.0, 0.0)" );
    assertDefaultToStringWhenDebugToStringDisabled( new Vector3d() );
  }

  @Test
  public void asString()
  {
    assertEquals( new Vector3d().asString(), "(0.0, 0.0, 0.0)" );
    VecmathTestUtil.disableDebugToString();
    assertEquals( new Vector3d().asString(), "(0.0, 0.0, 0.0)" );
  }

  @Test
  public void isEqualTo()
  {
    final Vector3d value1 = new Vector3d( 1, 2, 3 );
    final Vector3d value2 = new Vector3d( 1, 2, 3 );
    final Vector3d value3 = new Vector3d( 4, 5, 6 );
    assertTrue( value1.isEqualTo( value1 ) );
    assertTrue( value1.isEqualTo( value2 ) );
    assertFalse( value1.isEqualTo( value3 ) );
  }

  @Test
  public void testHashCode()
  {
    VecmathTestUtil.enableObjectEquals();
    final Vector3d value1 = new Vector3d( 1, 2, 3 );
    final Vector3d value2 = new Vector3d( 1, 2, 3 );
    final Vector3d value3 = new Vector3d( 4, 5, 6 );
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
    final Vector3d value1 = new Vector3d( 1, 2, 3 );
    final Vector3d value2 = new Vector3d( 1, 2, 3 );

    assertVecEquals( value1, 1, 2, 3 );
    assertEquals( value1, value1 );
    assertEquals( value1.hashCode(), value1.hashCode() );

    assertVecEquals( value2, 1, 2, 3 );
    assertEquals( value2, value2 );
    assertEquals( value2.hashCode(), value2.hashCode() );

    assertNotEquals( value1, value2 );
    assertNotEquals( value1.hashCode(), value2.hashCode() );
  }

  @Test
  public void constructors()
  {
    assertVecEquals( new Vector3d(), 0.0, 0.0, 0.0 );
    assertVecEquals( new Vector3d( 1, 2, 3 ), 1, 2, 3 );
    assertVecEquals( new Vector3d( new Vector3d( 1, 2, 3 ) ), 1, 2, 3 );
  }

  @Test
  public void dup()
  {
    final Vector3d value = new Vector3d( 1, 2, 3 );
    final Vector3d dup = value.dup();
    assertVecEquals( dup, 1, 2, 3 );
    assertNotSame( dup, value );
  }

  @Test
  public void set()
  {
    final Vector3d value = new Vector3d( 1, 2, 3 );
    assertVecEquals( value, 1, 2, 3 );

    assertSame( value.set( new Vector3d() ), value );
    assertVecEquals( value, 0, 0, 0 );

    assertSame( value.set( 1, 2, 3 ), value );
    assertVecEquals( value, 1, 2, 3 );
  }

  @Test
  public void add()
  {
    final Vector3d value = new Vector3d( 1, 2, 3 );
    assertVecEquals( value, 1, 2, 3 );

    assertSame( value.add( new Vector3d( 4, 5, 6 ) ), value );
    assertVecEquals( value, 5, 7, 9 );

    assertSame( value.add( 5, 3, 1 ), value );
    assertVecEquals( value, 10, 10, 10 );

    assertSame( value.add( new Vector3d( 1, 2, 3 ), new Vector3d( 1, 2, 3 ) ), value );
    assertVecEquals( value, 2, 4, 6 );
  }

  @Test
  public void sub()
  {
    final Vector3d value = new Vector3d( 1, 2, 3 );
    assertVecEquals( value, 1, 2, 3 );

    assertSame( value.sub( new Vector3d( 4, 5, 6 ) ), value );
    assertVecEquals( value, -3, -3, -3 );

    assertSame( value.sub( 5, 3, 1 ), value );
    assertVecEquals( value, -8, -6, -4 );

    assertSame( value.sub( new Vector3d( 1, 2, 3 ), new Vector3d( 1, 2, 3 ) ), value );
    assertVecEquals( value, 0, 0, 0 );
  }

  @Test
  public void mul()
  {
    final Vector3d value = new Vector3d( 1, 2, 3 );
    assertVecEquals( value, 1, 2, 3 );

    assertSame( value.mul( 2 ), value );
    assertVecEquals( value, 2, 4, 6 );
  }

  @Test
  public void div()
  {
    final Vector3d value = new Vector3d( 1, 2, 3 );
    assertVecEquals( value, 1, 2, 3 );

    assertSame( value.div( 2 ), value );
    assertVecEquals( value, 0.5, 1, 1.5 );
  }

  @Test
  public void length()
  {
    assertEquals( new Vector3d( 1, 0, 0 ).length(), 1, 0.00001 );
    assertEquals( new Vector3d( 0, 1, 0 ).length(), 1, 0.00001 );
    assertEquals( new Vector3d( 0, 0, 1 ).length(), 1, 0.00001 );
    assertEquals( new Vector3d( 1, 2, 3 ).length(), 3.7416575, 0.00001 );
  }

  @Test
  public void normalize()
  {
    assertVectorNormal( new Vector3d( 1, 0, 0 ), 1, 0, 0 );
    assertVectorNormal( new Vector3d( 0, 1, 0 ), 0, 1, 0 );
    assertVectorNormal( new Vector3d( 0, 0, 1 ), 0, 0, 1 );
    assertVectorNormal( new Vector3d( 1, 2, 3 ), 0.26726124, 0.5345225, 0.8017837 );
  }

  private void assertVectorNormal( @Nonnull final Vector3d vector, final double x, final double y, final double z )
  {
    final Vector3d normalized = vector.normalize();
    assertVecEquals( normalized, x, y, z );
    assertEquals( normalized.length(), 1.0, 0.00001 );
  }

  @Test
  public void cross()
  {
    // x axis crossed with y axis should produce z axis
    assertCross( 1, 0, 0,
                 0, 1, 0,
                 0, 0, 1 );

    // x axis crossed with z axis should produce -y axis
    assertCross( 1, 0, 0,
                 0, 0, 1,
                 0, -1, 0 );

    // y axis crossed with z axis should produce x axis
    assertCross( 0, 1, 0,
                 0, 0, 1,
                 1, 0, 0 );

    // z axis crossed with y axis should produce -x axis
    assertCross( 0, 0, 1,
                 0, 1, 0,
                 -1, 0, 0 );

    // z axis crossed with x axis should produce y axis
    assertCross( 0, 0, 1,
                 1, 0, 0,
                 0, 1, 0 );

    // random vectors should produce expected cross-product
    assertCross( 1, 2, 3,
                 4, 5, 6,
                 -3.0, 6.0, -3.0 );
  }

  private void assertCross( final double x1, final double y1, final double z1,
                            final double x2, final double y2, final double z2,
                            final double x3, final double y3, final double z3 )
  {
    {
      final Vector3d value1 = new Vector3d( x1, y1, z1 );
      final Vector3d value2 = new Vector3d( x2, y2, z2 );
      final Vector3d value = new Vector3d();
      value.cross( value1, value2 );
      assertVecEquals( value, x3, y3, z3 );
    }

    {
      final Vector3d value1 = new Vector3d( x1, y1, z1 );
      final Vector3d value2 = new Vector3d( x2, y2, z2 );
      value1.cross( value1, value2 );
      assertVecEquals( value1, x3, y3, z3 );
    }

    {
      final Vector3d value1 = new Vector3d( x1, y1, z1 );
      final Vector3d value2 = new Vector3d( x2, y2, z2 );
      value2.cross( value1, value2 );
      assertVecEquals( value2, x3, y3, z3 );
    }
  }

  @Test
  public void dot()
  {
    // Dot between orthogonal axis should be zero
    assertDot( /* x axis */ 1, 0, 0, /* y axis */  0, 1, 0, 0 );
    assertDot( /* x axis */ 1, 0, 0, /* z axis */  0, 0, 1, 0 );
    assertDot( /* y axis */ 0, 1, 0, /* z axis */  0, 0, 1, 0 );

    // Dot between identical vectors should be 1
    assertDot( /* x axis */ 1, 0, 0, /* x axis */  1, 0, 0, 1 );
    assertDot( /* y axis */ 0, 1, 0, /* y axis */  0, 1, 0, 1 );
    assertDot( /* z axis */ 0, 0, 1, /* z axis */  0, 0, 1, 1 );

    // Dot between vectors with same direction and different magnitude should be the value of the largest magnitude
    assertDot( /* x axis */ 1, 0, 0, /* x axis */  33, 0, 0, 33 );
    assertDot( /* y axis */ 0, 1, 0, /* y axis */  0, 42, 0, 42 );
    assertDot( /* z axis */ 0, 0, 1, /* z axis */  0, 0, 71, 71 );

    // now incorporate negatives
    assertDot( /* x axis */ 1, 0, 0, /* x axis */  -33, 0, 0, -33 );
    assertDot( /* y axis */ 0, 1, 0, /* y axis */  0, -42, 0, -42 );
    assertDot( /* z axis */ 0, 0, 1, /* z axis */  0, 0, -71, -71 );
    assertDot( /* z axis */ 0, 0, -1, /* z axis */  0, 0, -71, 71 );

    // higglety pigglety vectors
    assertDot( /* vector 1 */ 1, 2, 3, /* vector */  4, 5, 6, 32 );
  }

  private void assertDot( final double x1, final double y1, final double z1,
                          final double x2, final double y2, final double z2,
                          final double value )
  {
    assertEquals( new Vector3d( x1, y1, z1 ).dot( new Vector3d( x2, y2, z2 ) ), value );
    assertEquals( new Vector3d( x2, y2, z2 ).dot( new Vector3d( x1, y1, z1 ) ), value );
  }

  @Test
  public void angle()
  {
    assertAngle( /* x axis */ 1, 0, 0, /* y axis */  0, 1, 0, Math.PI / 2 );
    assertAngle( /* x axis */ 1, 0, 0, /* z axis */  0, 0, 1, Math.PI / 2 );
    assertAngle( /* y axis */ 0, 1, 0, /* z axis */  0, 0, 1, Math.PI / 2 );

    assertAngle( /* x axis */ 1, 0, 0, /* x axis */  1, 0, 0, 0 );
    assertAngle( /* y axis */ 0, 1, 0, /* y axis */  0, 1, 0, 0 );
    assertAngle( /* z axis */ 0, 0, 1, /* z axis */  0, 0, 1, 0 );

    assertAngle( /* x axis */ 1, 0, 0, /* x axis */  33, 0, 0, 0 );
    assertAngle( /* y axis */ 0, 1, 0, /* y axis */  0, 42, 0, 0 );
    assertAngle( /* z axis */ 0, 0, 1, /* z axis */  0, 0, 71, 0 );

    // now incorporate negatives
    assertAngle( /* x axis */ 1, 0, 0, /* x axis */  -33, 0, 0, Math.PI );
    assertAngle( /* y axis */ 0, 1, 0, /* y axis */  0, -42, 0, Math.PI );
    assertAngle( /* z axis */ 0, 0, 1, /* z axis */  0, 0, -71, Math.PI );
    assertAngle( /* z axis */ 0, 0, -1, /* z axis */  0, 0, -71, 0 );

    // higglety pigglety vectors
    assertAngle( /* vector 1 */ 1, 2, 3, /* vector */  4, 5, 6, 0.2257261285527342 );
  }

  private void assertAngle( final double x1, final double y1, final double z1,
                            final double x2, final double y2, final double z2,
                            final double value )
  {
    assertEquals( new Vector3d( x1, y1, z1 ).angle( new Vector3d( x2, y2, z2 ) ), value );
    assertEquals( new Vector3d( x2, y2, z2 ).angle( new Vector3d( x1, y1, z1 ) ), value );
  }

  @Test
  public void lerp()
  {
    assertLerp( /* v1 */ 0, 0, 0, /* v2 */  1, 1, 1, /* factor */ 0, /* result */ 0, 0, 0 );
    assertLerp( /* v1 */ 0, 0, 0, /* v2 */  1, 1, 1, /* factor */ 1, /* result */ 1, 1, 1 );
    assertLerp( /* v1 */ 0, 0, 0, /* v2 */  1, 1, 1, /* factor */ 0.5, /* result */ 0.5, 0.5, 0.5 );
    assertLerp( /* v1 */ 0, 0, 0, /* v2 */  1, 1, 1, /* factor */ 0.15, /* result */ 0.15, 0.15, 0.15 );
    assertLerp( /* v1 */ 0, 0, 0, /* v2 */  1, 1, 1, /* factor */ 0.75, /* result */ 0.75, 0.75, 0.75 );

    assertLerp( /* v1 */ 9, 4, 3, /* v2 */  2, -2, 9, /* factor */ 0.32, /* result */ 6.76, 2.08, 4.92 );
  }

  private void assertLerp( final double x1, final double y1, final double z1,
                           final double x2, final double y2, final double z2,
                           final double interpolationValue,
                           final double x3, final double y3, final double z3 )
  {
    assertVecEquals( new Vector3d( x1, y1, z1 ).lerp( new Vector3d( x2, y2, z2 ), interpolationValue ),
                     x3, y3, z3 );
    assertVecEquals( new Vector3d().lerp( new Vector3d( x1, y1, z1 ), new Vector3d( x2, y2, z2 ), interpolationValue ),
                     x3, y3, z3 );
  }
}
