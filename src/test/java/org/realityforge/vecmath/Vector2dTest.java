package org.realityforge.vecmath;

import javax.annotation.Nonnull;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class Vector2dTest
  extends AbstractTest
{
  @Test
  public void testToString()
  {
    assertEquals( new Vector2d().toString(), "(0.0, 0.0)" );
    assertDefaultToStringWhenDebugToStringDisabled( new Vector2d() );
  }

  @Test
  public void asString()
  {
    assertEquals( new Vector2d().asString(), "(0.0, 0.0)" );
    VecmathTestUtil.disableDebugToString();
    assertEquals( new Vector2d().asString(), "(0.0, 0.0)" );
  }

  @Test
  public void isEqualTo()
  {
    final Vector2d value1 = new Vector2d( 1, 2 );
    final Vector2d value2 = new Vector2d( 1, 2 );
    final Vector2d value3 = new Vector2d( 4, 5 );
    assertTrue( value1.isEqualTo( value1 ) );
    assertTrue( value1.isEqualTo( value2 ) );
    assertFalse( value1.isEqualTo( value3 ) );
  }

  @Test
  public void testHashCode()
  {
    VecmathTestUtil.enableObjectEquals();
    final Vector2d value1 = new Vector2d( 1, 2 );
    final Vector2d value2 = new Vector2d( 1, 2 );
    final Vector2d value3 = new Vector2d( 4, 5 );
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
    final Vector2d value1 = new Vector2d( 1, 2 );
    final Vector2d value2 = new Vector2d( 1, 2 );

    assertVecEquals( value1, 1, 2 );
    assertEquals( value1, value1 );
    assertEquals( value1.hashCode(), value1.hashCode() );

    assertVecEquals( value2, 1, 2 );
    assertEquals( value2, value2 );
    assertEquals( value2.hashCode(), value2.hashCode() );

    assertNotEquals( value1, value2 );
    assertNotEquals( value1.hashCode(), value2.hashCode() );
  }

  @Test
  public void constructors()
  {
    assertVecEquals( new Vector2d(), 0.0, 0.0 );
    assertVecEquals( new Vector2d( 1, 2 ), 1, 2 );
    assertVecEquals( new Vector2d( new Vector2d( 1, 2 ) ), 1, 2 );
  }

  @Test
  public void dup()
  {
    final Vector2d value = new Vector2d( 1, 2 );
    final Vector2d dup = value.dup();
    assertVecEquals( dup, 1, 2 );
    assertNotSame( dup, value );
  }

  @Test
  public void set()
  {
    final Vector2d value = new Vector2d( 1, 2 );
    assertVecEquals( value, 1, 2 );

    assertSame( value.set( new Vector2d() ), value );
    assertVecEquals( value, 0, 0 );

    assertSame( value.set( 1, 2 ), value );
    assertVecEquals( value, 1, 2 );
  }

  @Test
  public void add()
  {
    final Vector2d value = new Vector2d( 1, 2 );
    assertVecEquals( value, 1, 2 );

    assertSame( value.add( new Vector2d( 4, 5 ) ), value );
    assertVecEquals( value, 5, 7 );

    assertSame( value.add( 5, 3 ), value );
    assertVecEquals( value, 10, 10 );

    assertSame( value.add( new Vector2d( 1, 2 ), new Vector2d( 1, 2 ) ), value );
    assertVecEquals( value, 2, 4 );
  }

  @Test
  public void sub()
  {
    final Vector2d value = new Vector2d( 1, 2 );
    assertVecEquals( value, 1, 2 );

    assertSame( value.sub( new Vector2d( 4, 5 ) ), value );
    assertVecEquals( value, -3, -3 );

    assertSame( value.sub( 5, 3, 1 ), value );
    assertVecEquals( value, -8, -6 );

    assertSame( value.sub( new Vector2d( 1, 2 ), new Vector2d( 1, 2 ) ), value );
    assertVecEquals( value, 0, 0 );
  }

  @Test
  public void mul()
  {
    final Vector2d value = new Vector2d( 1, 2 );
    assertVecEquals( value, 1, 2 );

    assertSame( value.mul( 2 ), value );
    assertVecEquals( value, 2, 4 );
  }

  @Test
  public void div()
  {
    final Vector2d value = new Vector2d( 1, 2 );
    assertVecEquals( value, 1, 2 );

    assertSame( value.div( 2 ), value );
    assertVecEquals( value, 0.5, 1 );
  }

  @Test
  public void length()
  {
    assertEquals( new Vector2d( 1, 0 ).length(), 1, 0.00001 );
    assertEquals( new Vector2d( 0, 1 ).length(), 1, 0.00001 );
    assertEquals( new Vector2d( 1, 2 ).length(), 2.23606797749979, 0.00001 );
  }

  @Test
  public void normalize()
  {
    assertVectorNormal( new Vector2d( 1, 0 ), 1, 0 );
    assertVectorNormal( new Vector2d( 0, 1 ), 0, 1 );
    assertVectorNormal( new Vector2d( 1, 2 ), 0.4472135954999579, 0.8944271909999159 );
  }

  private void assertVectorNormal( @Nonnull final Vector2d vector, final double x, final double y )
  {
    final Vector2d normalized = vector.normalize();
    assertVecEquals( normalized, x, y );
    assertEquals( normalized.length(), 1.0, 0.00001 );
  }

  @Test
  public void dot()
  {
    // Dot between orthogonal axis should be zero
    assertDot( /* x axis */ 1, 0,  /* y axis */  0, 1, 0 );
    assertDot( /* x axis */ 1, 0,  /* z axis */  0, 0, 0 );
    assertDot( /* y axis */ 0, 1,  /* z axis */  0, 0, 0 );

    // Dot between identical vectors should be 1 unless it is zero vector
    assertDot( /* x axis */ 1, 0,  /* x axis */  1, 0, 1 );
    assertDot( /* y axis */ 0, 1,  /* y axis */  0, 1, 1 );
    assertDot( /* z axis */ 0, 0,  /* z axis */  0, 0, 0 );

    // Dot between vectors with same direction and different magnitude should be the value of the largest magnitude
    assertDot( /* x axis */ 1, 0,  /* x axis */  33, 0, 33 );
    assertDot( /* y axis */ 0, 1,  /* y axis */  0, 42, 42 );

    // now incorporate negatives
    assertDot( /* x axis */ 1, 0,  /* x axis */  -33, 0, -33 );
    assertDot( /* y axis */ 0, 1,  /* y axis */  0, -42, -42 );
    assertDot( /* y axis */ 0, -1,  /* y axis */  0, -42, 42 );

    // higglety pigglety vectors
    assertDot( /* vector 1 */ 1, 2, /* vector */  4, 5, 14 );
  }

  private void assertDot( final double x1, final double y1,
                          final double x2, final double y2,
                          final double value )
  {
    assertEquals( new Vector2d( x1, y1 ).dot( new Vector2d( x2, y2 ) ), value );
    assertEquals( new Vector2d( x2, y2 ).dot( new Vector2d( x1, y1 ) ), value );
  }

  @Test
  public void angle()
  {
    assertAngle( /* x axis */ 1, 0,  /* y axis */  0, 1, Math.PI / 2 );
    assertAngle( /* y axis */ 0, 1,  /* z axis */  1, 0, Math.PI / -2 );

    assertAngle( /* x axis */ 1, 0,  /* x axis */  1, 0, 0 );
    assertAngle( /* y axis */ 0, 1,  /* y axis */  0, 1, 0 );

    assertAngle( /* x axis */ 1, 0,  /* x axis */  33, 0, 0 );
    assertAngle( /* y axis */ 0, 1,  /* y axis */  0, 42, 0 );
    assertAngle( /* z axis */ 0, 0,  /* z axis */  0, 0, 0 );

    // now incorporate negatives
    assertAngle( /* x axis */ 1, 0,  /* x axis */  -33, 0, Math.PI );
    assertAngle( /* y axis */ 0, 1,  /* y axis */  0, -42, -Math.PI );

    // higglety pigglety vectors
    assertAngle( /* vector 1 */ 1, 2, /* vector */  4, 5, -0.21109333322274654 );
  }

  private void assertAngle( final double x1, final double y1,
                            final double x2, final double y2,
                            final double value )
  {
    assertEquals( new Vector2d( x1, y1 ).angle( new Vector2d( x2, y2 ) ), value );
    if ( 0 != value )
    {
      assertEquals( new Vector2d( x2, y2 ).angle( new Vector2d( x1, y1 ) ), -value );
    }
  }

  @Test
  public void lerp()
  {
    assertLerp( /* v1 */ 0, 0,  /* v2 */  1, 1,  /* factor */ 0, /* result */ 0, 0 );
    assertLerp( /* v1 */ 0, 0,  /* v2 */  1, 1,  /* factor */ 1, /* result */ 1, 1 );
    assertLerp( /* v1 */ 0, 0,  /* v2 */  1, 1,  /* factor */ 0.5, /* result */ 0.5, 0.5 );
    assertLerp( /* v1 */ 0, 0,  /* v2 */  1, 1,  /* factor */ 0.15, /* result */ 0.15, 0.15 );
    assertLerp( /* v1 */ 0, 0,  /* v2 */  1, 1,  /* factor */ 0.75, /* result */ 0.75, 0.75 );

    assertLerp( /* v1 */ 9, 4,  /* v2 */  2, -2,  /* factor */ 0.32, /* result */ 6.76, 2.08 );
  }

  private void assertLerp( final double x1, final double y1,
                           final double x2, final double y2,
                           final double interpolationValue,
                           final double x3, final double y3 )
  {
    assertVecEquals( new Vector2d( x1, y1 ).lerp( new Vector2d( x2, y2 ), interpolationValue ), x3, y3 );
    assertVecEquals( new Vector2d().lerp( new Vector2d( x1, y1 ), new Vector2d( x2, y2 ), interpolationValue ),
                     x3,
                     y3 );
  }

  @Test
  public void toArray()
  {
    final Vector2d value = new Vector2d( 1, 2 );

    assertArray( value.toArray(), "[1.0, 2.0]" );

    // Now with an offset
    assertArray( value.toArray( new double[ 6 ], 2 ), "[0.0, 0.0, 1.0, 2.0, 0.0, 0.0]" );
  }
}
