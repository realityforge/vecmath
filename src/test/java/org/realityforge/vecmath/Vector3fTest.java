package org.realityforge.vecmath;

import javax.annotation.Nonnull;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class Vector3fTest
  extends AbstractTest
{
  @Test
  public void testToString()
  {
    assertEquals( new Vector3f().toString(), "(0.0, 0.0, 0.0)" );
    assertDefaultToStringWhenDebugToStringDisabled( new Vector3f() );
  }

  @Test
  public void testHashCode()
  {
    VecmathTestUtil.enableObjectEquals();
    final Vector3f value1 = new Vector3f( 1F, 2F, 3F );
    final Vector3f value2 = new Vector3f( 1F, 2F, 3F );
    final Vector3f value3 = new Vector3f( 4F, 5F, 6F );
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
    final Vector3f value1 = new Vector3f( 1F, 2F, 3F );
    final Vector3f value2 = new Vector3f( 1F, 2F, 3F );

    assertVecEquals( value1, 1F, 2F, 3F );
    assertEquals( value1, value1 );
    assertEquals( value1.hashCode(), value1.hashCode() );

    assertVecEquals( value2, 1F, 2F, 3F );
    assertEquals( value2, value2 );
    assertEquals( value2.hashCode(), value2.hashCode() );

    assertNotEquals( value1, value2 );
    assertNotEquals( value1.hashCode(), value2.hashCode() );
  }

  @Test
  public void constructors()
  {
    assertVecEquals( new Vector3f(), 0.0F, 0.0F, 0.0F );
    assertVecEquals( new Vector3f( 1F, 2F, 3F ), 1F, 2F, 3F );
    assertVecEquals( new Vector3f( new Vector3f( 1F, 2F, 3F ) ), 1F, 2F, 3F );
  }

  @Test
  public void dup()
  {
    final Vector3f value = new Vector3f( 1F, 2F, 3F );
    final Vector3f dup = value.dup();
    assertVecEquals( dup, 1F, 2F, 3F );
    assertNotSame( dup, value );
  }

  @Test
  public void set()
  {
    final Vector3f value = new Vector3f( 1F, 2F, 3F );
    assertVecEquals( value, 1F, 2F, 3F );

    assertSame( value.set( new Vector3f() ), value );
    assertVecEquals( value, 0F, 0F, 0F );

    assertSame( value.set( 1F, 2F, 3F ), value );
    assertVecEquals( value, 1F, 2F, 3F );
  }

  @Test
  public void add()
  {
    final Vector3f value = new Vector3f( 1F, 2F, 3F );
    assertVecEquals( value, 1F, 2F, 3F );

    assertSame( value.add( new Vector3f( 4F, 5F, 6F ) ), value );
    assertVecEquals( value, 5F, 7F, 9F );

    assertSame( value.add( 5F, 3F, 1F ), value );
    assertVecEquals( value, 10F, 10F, 10F );

    assertSame( value.add( new Vector3f( 1F, 2F, 3F ), new Vector3f( 1F, 2F, 3F ) ), value );
    assertVecEquals( value, 2F, 4F, 6F );
  }

  @Test
  public void sub()
  {
    final Vector3f value = new Vector3f( 1F, 2F, 3F );
    assertVecEquals( value, 1F, 2F, 3F );

    assertSame( value.sub( new Vector3f( 4F, 5F, 6F ) ), value );
    assertVecEquals( value, -3F, -3F, -3F );

    assertSame( value.sub( 5F, 3F, 1F ), value );
    assertVecEquals( value, -8F, -6F, -4F );

    assertSame( value.sub( new Vector3f( 1F, 2F, 3F ), new Vector3f( 1F, 2F, 3F ) ), value );
    assertVecEquals( value, 0F, 0F, 0F );
  }

  @Test
  public void mul()
  {
    final Vector3f value = new Vector3f( 1F, 2F, 3F );
    assertVecEquals( value, 1F, 2F, 3F );

    assertSame( value.mul( 2 ), value );
    assertVecEquals( value, 2F, 4F, 6F );
  }

  @Test
  public void length()
  {
    assertEquals( new Vector3f( 1F, 0F, 0F ).length(), 1F, 0.00001 );
    assertEquals( new Vector3f( 0F, 1F, 0F ).length(), 1F, 0.00001 );
    assertEquals( new Vector3f( 0F, 0F, 1F ).length(), 1F, 0.00001 );
    assertEquals( new Vector3f( 1F, 2F, 3F ).length(), 3.7416575F, 0.00001 );
  }

  @Test
  public void normalize()
  {
    assertVectorNormal( new Vector3f( 1F, 0F, 0F ), 1F, 0F, 0F );
    assertVectorNormal( new Vector3f( 0F, 1F, 0F ), 0F, 1F, 0F );
    assertVectorNormal( new Vector3f( 0F, 0F, 1F ), 0F, 0F, 1F );
    assertVectorNormal( new Vector3f( 1F, 2F, 3F ), 0.26726124F, 0.5345225F, 0.8017837F );
  }

  private void assertVectorNormal( @Nonnull final Vector3f vector, final float x, final float y, final float z )
  {
    final Vector3f normalized = vector.normalize();
    assertVecEquals( normalized, x, y, z );
    assertEquals( normalized.length(), 1.0F, 0.00001 );
  }

  @Test
  public void cross()
  {
    // x axis crossed with y axis should produce z axis
    assertCross( 1F, 0F, 0F,
                 0F, 1F, 0F,
                 0F, 0F, 1F );

    // x axis crossed with z axis should produce -y axis
    assertCross( 1F, 0F, 0F,
                 0F, 0F, 1F,
                 0F, -1F, 0F );

    // y axis crossed with z axis should produce x axis
    assertCross( 0F, 1F, 0F,
                 0F, 0F, 1F,
                 1F, 0F, 0F );

    // z axis crossed with y axis should produce -x axis
    assertCross( 0F, 0F, 1F,
                 0F, 1F, 0F,
                 -1F, 0F, 0F );

    // z axis crossed with x axis should produce y axis
    assertCross( 0F, 0F, 1F,
                 1F, 0F, 0F,
                 0F, 1F, 0F );

    // random vectors should produce expected cross-product
    assertCross( 1F, 2F, 3F,
                 4F, 5F, 6F,
                 -3.0F, 6.0F, -3.0F );
  }

  private void assertCross( final float x1, final float y1, final float z1,
                            final float x2, final float y2, final float z2,
                            final float x3, final float y3, final float z3 )
  {
    {
      final Vector3f value1 = new Vector3f( x1, y1, z1 );
      final Vector3f value2 = new Vector3f( x2, y2, z2 );
      final Vector3f value = new Vector3f();
      value.cross( value1, value2 );
      assertVecEquals( value, x3, y3, z3 );
    }

    {
      final Vector3f value1 = new Vector3f( x1, y1, z1 );
      final Vector3f value2 = new Vector3f( x2, y2, z2 );
      value1.cross( value1, value2 );
      assertVecEquals( value1, x3, y3, z3 );
    }

    {
      final Vector3f value1 = new Vector3f( x1, y1, z1 );
      final Vector3f value2 = new Vector3f( x2, y2, z2 );
      value2.cross( value1, value2 );
      assertVecEquals( value2, x3, y3, z3 );
    }
  }

  @Test
  public void dot()
  {
    // Dot between orthogonal axis should be zero
    assertDot( /* x axis */ 1F, 0F, 0F, /* y axis */  0F, 1F, 0F, 0F );
    assertDot( /* x axis */ 1F, 0F, 0F, /* z axis */  0F, 0F, 1F, 0F );
    assertDot( /* y axis */ 0F, 1F, 0F, /* z axis */  0F, 0F, 1F, 0F );

    // Dot between identical vectors should be 1
    assertDot( /* x axis */ 1F, 0F, 0F, /* x axis */  1F, 0F, 0F, 1F );
    assertDot( /* y axis */ 0F, 1F, 0F, /* y axis */  0F, 1F, 0F, 1F );
    assertDot( /* z axis */ 0F, 0F, 1F, /* z axis */  0F, 0F, 1F, 1F );

    // Dot between vectors with same direction and different magnitude should be the value of the largest magnitude
    assertDot( /* x axis */ 1F, 0F, 0F, /* x axis */  33F, 0F, 0F, 33F );
    assertDot( /* y axis */ 0F, 1F, 0F, /* y axis */  0F, 42F, 0F, 42F );
    assertDot( /* z axis */ 0F, 0F, 1F, /* z axis */  0F, 0F, 71F, 71F );

    // now incorporate negatives
    assertDot( /* x axis */ 1F, 0F, 0F, /* x axis */  -33F, 0F, 0F, -33F );
    assertDot( /* y axis */ 0F, 1F, 0F, /* y axis */  0F, -42F, 0F, -42F );
    assertDot( /* z axis */ 0F, 0F, 1F, /* z axis */  0F, 0F, -71F, -71F );
    assertDot( /* z axis */ 0F, 0F, -1F, /* z axis */  0F, 0F, -71F, 71F );

    // higglety pigglety vectors
    assertDot( /* vector 1 */ 1F, 2F, 3F, /* vector */  4F, 5F, 6F, 32F );
  }

  private void assertDot( final float x1, final float y1, final float z1,
                          final float x2, final float y2, final float z2,
                          final float value )
  {
    assertEquals( new Vector3f( x1, y1, z1 ).dot( new Vector3f( x2, y2, z2 ) ), value );
    assertEquals( new Vector3f( x2, y2, z2 ).dot( new Vector3f( x1, y1, z1 ) ), value );
  }

  @Test
  public void angle()
  {
    assertAngle( /* x axis */ 1F, 0F, 0F, /* y axis */  0F, 1F, 0F, (float) ( Math.PI / 2 ) );
    assertAngle( /* x axis */ 1F, 0F, 0F, /* z axis */  0F, 0F, 1F, (float) ( Math.PI / 2 ) );
    assertAngle( /* y axis */ 0F, 1F, 0F, /* z axis */  0F, 0F, 1F, (float) ( Math.PI / 2 ) );

    assertAngle( /* x axis */ 1F, 0F, 0F, /* x axis */  1F, 0F, 0F, 0F );
    assertAngle( /* y axis */ 0F, 1F, 0F, /* y axis */  0F, 1F, 0F, 0F );
    assertAngle( /* z axis */ 0F, 0F, 1F, /* z axis */  0F, 0F, 1F, 0F );

    assertAngle( /* x axis */ 1F, 0F, 0F, /* x axis */  33F, 0F, 0F, 0F );
    assertAngle( /* y axis */ 0F, 1F, 0F, /* y axis */  0F, 42F, 0F, 0F );
    assertAngle( /* z axis */ 0F, 0F, 1F, /* z axis */  0F, 0F, 71F, 0F );

    // now incorporate negatives
    assertAngle( /* x axis */ 1F, 0F, 0F, /* x axis */  -33F, 0F, 0F, (float) Math.PI );
    assertAngle( /* y axis */ 0F, 1F, 0F, /* y axis */  0F, -42F, 0F, (float) Math.PI );
    assertAngle( /* z axis */ 0F, 0F, 1F, /* z axis */  0F, 0F, -71F, (float) Math.PI );
    assertAngle( /* z axis */ 0F, 0F, -1F, /* z axis */  0F, 0F, -71F, 0F );

    // higglety pigglety vectors
    assertAngle( /* vector 1 */ 1F, 2F, 3F, /* vector */  4F, 5F, 6F, 0.2257264F );
  }

  private void assertAngle( final float x1, final float y1, final float z1,
                            final float x2, final float y2, final float z2,
                            final float value )
  {
    assertEquals( new Vector3f( x1, y1, z1 ).angle( new Vector3f( x2, y2, z2 ) ), value );
    assertEquals( new Vector3f( x2, y2, z2 ).angle( new Vector3f( x1, y1, z1 ) ), value );
  }
}
