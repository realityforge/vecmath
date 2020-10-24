package org.realityforge.vecmath;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class Matrix4dTest
  extends AbstractTest
{
  @Test
  public void testToString()
  {
    assertEquals( new Matrix4d().toString(),
                  "(1.0, 0.0, 0.0, 0.0 | 0.0, 1.0, 0.0, 0.0 | 0.0, 0.0, 1.0, 0.0 | 0.0, 0.0, 0.0, 1.0)" );
    assertDefaultToStringWhenDebugToStringDisabled( new Matrix4d() );
  }

  @Test
  public void asString()
  {
    assertEquals( new Matrix4d().asString(),
                  "(1.0, 0.0, 0.0, 0.0 | 0.0, 1.0, 0.0, 0.0 | 0.0, 0.0, 1.0, 0.0 | 0.0, 0.0, 0.0, 1.0)" );
    VecmathTestUtil.disableDebugToString();
    assertEquals( new Matrix4d().asString(),
                  "(1.0, 0.0, 0.0, 0.0 | 0.0, 1.0, 0.0, 0.0 | 0.0, 0.0, 1.0, 0.0 | 0.0, 0.0, 0.0, 1.0)" );
  }

  @Test
  public void isEqualTo()
  {
    final Matrix4d value1 = new Matrix4d( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );
    final Matrix4d value2 = new Matrix4d( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );
    final Matrix4d value3 = new Matrix4d( 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 1, 2, 3 );
    assertTrue( value1.isEqualTo( value1 ) );
    assertTrue( value1.isEqualTo( value2 ) );
    assertFalse( value1.isEqualTo( value3 ) );
  }

  @Test
  public void testHashCode()
  {
    VecmathTestUtil.enableObjectEquals();
    final Matrix4d value1 = new Matrix4d( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );
    final Matrix4d value2 = new Matrix4d( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );
    final Matrix4d value3 = new Matrix4d( 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 1, 2, 3 );
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
    final Matrix4d value1 = new Matrix4d( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );
    final Matrix4d value2 = new Matrix4d( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );

    assertMatEquals( value1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );
    assertEquals( value1, value1 );
    assertEquals( value1.hashCode(), value1.hashCode() );

    assertMatEquals( value2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );
    assertEquals( value2, value2 );
    assertEquals( value2.hashCode(), value2.hashCode() );

    assertNotEquals( value1, value2 );
    assertNotEquals( value1.hashCode(), value2.hashCode() );
  }

  @Test
  public void constructors()
  {
    assertMatEquals( new Matrix4d(), 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0 );
    assertMatEquals( new Matrix4d( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 ),
                     1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );
    assertMatEquals( new Matrix4d( new Matrix4d( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 ) ),
                     1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );
  }

  @Test
  public void dup()
  {
    final Matrix4d value = new Matrix4d( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );
    final Matrix4d dup = value.dup();
    assertMatEquals( dup, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );
    assertNotSame( dup, value );
  }

  @Test
  public void set()
  {
    final Matrix4d value = new Matrix4d( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );
    assertMatEquals( value, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );

    assertSame( value.set( new Matrix4d() ), value );
    assertMatEquals( value, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0 );

    assertSame( value.set( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 ), value );
    assertMatEquals( value, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );
  }

  @Test
  public void identity()
  {
    final Matrix4d value = new Matrix4d( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );
    assertMatEquals( value, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );

    assertMatEquals( value.identity(), 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0 );

    // verify value has been changed
    assertMatEquals( value, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0 );
  }

  @Test
  public void toArray()
  {
    final Matrix4d value = new Matrix4d( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );

    assertArray( value.toArray(),
                 "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0]" );

    // Now with an offset
    assertArray( value.toArray( new double[ 20 ], 2 ),
                 "[0.0, 0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 0.0, 0.0]" );
  }
}
