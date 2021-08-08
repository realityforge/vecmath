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
                  "1.0 0.0 0.0 0.0\n" +
                  "0.0 1.0 0.0 0.0\n" +
                  "0.0 0.0 1.0 0.0\n" +
                  "0.0 0.0 0.0 1.0\n" );
    assertDefaultToStringWhenDebugToStringDisabled( new Matrix4d() );
  }

  @Test
  public void asString()
  {
    final Matrix4d matrix =
      new Matrix4d( 1, 2, 3, 4,
                    5, 6, 7, 8,
                    9, 10, 11, 12,
                    13, 14, 15, 16 );
    assertEquals( matrix.asString(),
                  "1.0 2.0 3.0 4.0\n" +
                  "5.0 6.0 7.0 8.0\n" +
                  "9.0 10.0 11.0 12.0\n" +
                  "13.0 14.0 15.0 16.0\n" );
    assertEquals( matrix.asString(), matrix.asColumnMajorString() );
    VecmathTestUtil.disableDebugToString();
    assertEquals( matrix.asString(),
                  "1.0 2.0 3.0 4.0\n" +
                  "5.0 6.0 7.0 8.0\n" +
                  "9.0 10.0 11.0 12.0\n" +
                  "13.0 14.0 15.0 16.0\n" );
  }

  @Test
  public void asColumnMajorString()
  {
    final Matrix4d matrix =
      new Matrix4d( 1, 2, 3, 4,
                    5, 6, 7, 8,
                    9, 10, 11, 12,
                    13, 14, 15, 16 );
    assertEquals( matrix.asColumnMajorString(),
                  "1.0 2.0 3.0 4.0\n" +
                  "5.0 6.0 7.0 8.0\n" +
                  "9.0 10.0 11.0 12.0\n" +
                  "13.0 14.0 15.0 16.0\n" );
  }

  @Test
  public void asRowMajorString()
  {
    final Matrix4d matrix =
      new Matrix4d( 1, 2, 3, 4,
                    5, 6, 7, 8,
                    9, 10, 11, 12,
                    13, 14, 15, 16 );
    assertEquals( matrix.asRowMajorString(),
                  "1.0 5.0 9.0 13.0\n" +
                  "2.0 6.0 10.0 14.0\n" +
                  "3.0 7.0 11.0 15.0\n" +
                  "4.0 8.0 12.0 16.0\n" );
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
    final Matrix4d value1 =
      new Matrix4d( 1, 2, 3, 4,
                    5, 6, 7, 8,
                    9, 10, 11, 12,
                    13, 14, 15, 16 );
    final Matrix4d value2 =
      new Matrix4d( 1, 2, 3, 4,
                    5, 6, 7, 8,
                    9, 10, 11, 12,
                    13, 14, 15, 16 );

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
    assertIdentityMatrix( new Matrix4d() );
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
    final Matrix4d value =
      new Matrix4d( 1, 2, 3, 4,
                    5, 6, 7, 8,
                    9, 10, 11, 12,
                    13, 14, 15, 16 );
    assertMatEquals( value,
                     1, 2, 3, 4,
                     5, 6, 7, 8,
                     9, 10, 11, 12,
                     13, 14, 15, 16 );

    assertSame( value.set( new Matrix4d( 16, 15, 14, 13,
                                         12, 11, 10, 9,
                                         8, 7, 6, 5,
                                         4, 3, 2, 1 ) ),
                value );
    assertMatEquals( value,
                     16, 15, 14, 13,
                     12, 11, 10, 9,
                     8, 7, 6, 5,
                     4, 3, 2, 1 );

    assertSame( value.set( 1, 2, 3, 4,
                           5, 6, 7, 8,
                           9, 10, 11, 12,
                           13, 14, 15, 16 ),
                value );
    assertMatEquals( value,
                     1, 2, 3, 4,
                     5, 6, 7, 8,
                     9, 10, 11, 12,
                     13, 14, 15, 16 );
  }

  @Test
  public void setIdentity()
  {
    final Matrix4d value = new Matrix4d( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );
    assertMatEquals( value, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 );

    assertIdentityMatrix( value.setIdentity() );

    // verify value has been changed
    assertIdentityMatrix( value );
  }

  @Test
  public void toArray()
  {
    final Matrix4d value =
      new Matrix4d( 1, 2, 3, 4,
                    5, 6, 7, 8,
                    9, 10, 11, 12,
                    13, 14, 15, 16 );

    assertArray( value.toArray(),
                 "[1.0, 5.0, 9.0, 13.0, 2.0, 6.0, 10.0, 14.0, 3.0, 7.0, 11.0, 15.0, 4.0, 8.0, 12.0, 16.0]" );

    // Now with an offset
    assertArray( value.toArray( new double[ 20 ], 2 ),
                 "[0.0, 0.0, 1.0, 5.0, 9.0, 13.0, 2.0, 6.0, 10.0, 14.0, 3.0, 7.0, 11.0, 15.0, 4.0, 8.0, 12.0, 16.0, 0.0, 0.0]" );
  }

  @Test
  public void setTranslation()
  {
    final Matrix4d value = new Matrix4d().setTranslation( 1, 2, 3 );
    assertEquals( value.asString(),
                  "1.0 0.0 0.0 1.0\n" +
                  "0.0 1.0 0.0 2.0\n" +
                  "0.0 0.0 1.0 3.0\n" +
                  "0.0 0.0 0.0 1.0\n" );
    assertMatEquals( value,
                     1, 0, 0, 1,
                     0, 1, 0, 2,
                     0, 0, 1, 3,
                     0, 0, 0, 1 );

    final Matrix4d other = value.setTranslation( 1, 2, 3 );

    assertSame( value, other );
    assertEquals( value.asString(),
                  "1.0 0.0 0.0 1.0\n" +
                  "0.0 1.0 0.0 2.0\n" +
                  "0.0 0.0 1.0 3.0\n" +
                  "0.0 0.0 0.0 1.0\n" );
    assertMatEquals( value,
                     1, 0, 0, 1,
                     0, 1, 0, 2,
                     0, 0, 1, 3,
                     0, 0, 0, 1 );
  }

  @Test
  public void translate()
  {
    final Matrix4d value = new Matrix4d().translate( 1, 2, 3 );
    assertEquals( value.asString(),
                  "1.0 0.0 0.0 1.0\n" +
                  "0.0 1.0 0.0 2.0\n" +
                  "0.0 0.0 1.0 3.0\n" +
                  "0.0 0.0 0.0 1.0\n" );

    assertMatEquals( value,
                     1, 0, 0, 1,
                     0, 1, 0, 2,
                     0, 0, 1, 3,
                     0, 0, 0, 1 );

    // Ensure setIdentity().translate(x,y,z) is equivalent to setTranslation(x,y,z)
    assertEquals( new Matrix4d().setTranslation( 1, 2, 3 ).asString(), value.asString() );

    final Matrix4d other = value.translate( new Vector3d( 1, 2, 3 ) );

    assertSame( value, other );
    assertEquals( other.asString(),
                  "1.0 0.0 0.0 2.0\n" +
                  "0.0 1.0 0.0 4.0\n" +
                  "0.0 0.0 1.0 6.0\n" +
                  "0.0 0.0 0.0 1.0\n" );
    assertMatEquals( other,
                     1, 0, 0, 2,
                     0, 1, 0, 4,
                     0, 0, 1, 6,
                     0, 0, 0, 1 );
  }

  @Test
  public void setScale()
  {
    final Matrix4d value = new Matrix4d().setScale( 5, 2, 3 );
    assertEquals( value.asString(),
                  "5.0 0.0 0.0 0.0\n" +
                  "0.0 2.0 0.0 0.0\n" +
                  "0.0 0.0 3.0 0.0\n" +
                  "0.0 0.0 0.0 1.0\n" );
    assertMatEquals( value,
                     5, 0, 0, 0,
                     0, 2, 0, 0,
                     0, 0, 3, 0,
                     0, 0, 0, 1 );

    // Verify that setScale replaces matrix
    final Matrix4d other = value.setScale( 5, 2, 3 );

    assertSame( value, other );
    assertEquals( value.asString(),
                  "5.0 0.0 0.0 0.0\n" +
                  "0.0 2.0 0.0 0.0\n" +
                  "0.0 0.0 3.0 0.0\n" +
                  "0.0 0.0 0.0 1.0\n" );
    assertMatEquals( value,
                     5, 0, 0, 0,
                     0, 2, 0, 0,
                     0, 0, 3, 0,
                     0, 0, 0, 1 );

    final Matrix4d other2 = value.setScale( 7 );

    assertSame( value, other2 );
    assertEquals( value.asString(),
                  "7.0 0.0 0.0 0.0\n" +
                  "0.0 7.0 0.0 0.0\n" +
                  "0.0 0.0 7.0 0.0\n" +
                  "0.0 0.0 0.0 1.0\n" );
    assertMatEquals( value,
                     7, 0, 0, 0,
                     0, 7, 0, 0,
                     0, 0, 7, 0,
                     0, 0, 0, 1 );
  }

  @Test
  public void scale()
  {
    final Matrix4d value = new Matrix4d().scale( 5, 2, 3 );
    assertEquals( value.asString(),
                  "5.0 0.0 0.0 0.0\n" +
                  "0.0 2.0 0.0 0.0\n" +
                  "0.0 0.0 3.0 0.0\n" +
                  "0.0 0.0 0.0 1.0\n" );
    assertMatEquals( value,
                     5, 0, 0, 0,
                     0, 2, 0, 0,
                     0, 0, 3, 0,
                     0, 0, 0, 1 );

    // Ensure setIdentity().scale(x,y,z) is equivalent to setScale(x,y,z)
    assertEquals( new Matrix4d().setScale( 5, 2, 3 ).asString(), value.asString() );

    // Verify that scale applies operation to matrix
    final Matrix4d other = value.scale( 5, 2, 3 );

    assertSame( value, other );
    assertEquals( value.asString(),
                  "25.0 0.0 0.0 0.0\n" +
                  "0.0 4.0 0.0 0.0\n" +
                  "0.0 0.0 9.0 0.0\n" +
                  "0.0 0.0 0.0 1.0\n" );
    assertMatEquals( value,
                     25, 0, 0, 0,
                     0, 4, 0, 0,
                     0, 0, 9, 0,
                     0, 0, 0, 1 );

    final Matrix4d other2 = value.scale( 2 );

    assertSame( value, other2 );
    assertEquals( value.asString(),
                  "50.0 0.0 0.0 0.0\n" +
                  "0.0 8.0 0.0 0.0\n" +
                  "0.0 0.0 18.0 0.0\n" +
                  "0.0 0.0 0.0 1.0\n" );
    assertMatEquals( value,
                     50, 0, 0, 0,
                     0, 8, 0, 0,
                     0, 0, 18, 0,
                     0, 0, 0, 1 );
  }

  @Test
  public void rotateX()
  {
    final Matrix4d target = new Matrix4d();
    assertMatEquals( target.dup().rotateX( 0 ),
                     1, 0, 0, 0,
                     0, 1, 0, 0,
                     0, 0, 1, 0,
                     0, 0, 0, 1 );
    assertMatEquals( target.dup().rotateX( Math.PI / 4 ),
                     1, 0, 0, 0,
                     0, 0.7071067811865476, -0.7071067811865475, 0,
                     0, 0.7071067811865475, 0.7071067811865476, 0,
                     0, 0, 0, 1 );
    assertMatEquals( target.dup().rotateX( Math.PI / 2 ),
                     1, 0, 0, 0,
                     0, 0, -1, 0,
                     0, 1, 0, 0,
                     0, 0, 0, 1 );
    assertMatEquals( target.dup().rotateX( Math.PI ),
                     1, 0, 0, 0,
                     0, -1, 0, 0,
                     0, 0, -1, 0,
                     0, 0, 0, 1 );
    assertMatEquals( target.dup().rotateX( 2 * Math.PI ),
                     1, 0, 0, 0,
                     0, 1, 0, 0,
                     0, 0, 1, 0,
                     0, 0, 0, 1 );
  }

  @Test
  public void rotateY()
  {
    final Matrix4d target = new Matrix4d();
    assertMatEquals( target.dup().rotateY( 0 ),
                     1, 0, 0, 0,
                     0, 1, 0, 0,
                     0, 0, 1, 0,
                     0, 0, 0, 1 );
    assertMatEquals( target.dup().rotateY( Math.PI / 4 ),
                     0.7071067811865476, 0, 0.7071067811865475, 0,
                     0, 1, 0, 0,
                     -0.7071067811865475, 0, 0.7071067811865476, 0,
                     0, 0, 0, 1 );
    assertMatEquals( target.dup().rotateY( Math.PI / 2 ),
                     0, 0, 1, 0,
                     0, 1, 0, 0,
                     -1, 0, 0, 0,
                     0, 0, 0, 1 );
    assertMatEquals( target.dup().rotateY( Math.PI ),
                     -1, 0, 0, 0,
                     0, 1, 0, 0,
                     0, 0, -1, 0,
                     0, 0, 0, 1 );
    assertMatEquals( target.dup().rotateY( 2 * Math.PI ),
                     1, 0, 0, 0,
                     0, 1, 0, 0,
                     0, 0, 1, 0,
                     0, 0, 0, 1 );
  }

  @Test
  public void rotateZ()
  {
    final Matrix4d target = new Matrix4d();
    assertMatEquals( target.dup().rotateZ( 0 ),
                     1, 0, 0, 0,
                     0, 1, 0, 0,
                     0, 0, 1, 0,
                     0, 0, 0, 1 );
    assertMatEquals( target.dup().rotateZ( Math.PI / 4 ),
                     0.7071067811865476, -0.7071067811865475, 0, 0,
                     0.7071067811865475, 0.7071067811865476, 0, 0,
                     0, 0, 1, 0,
                     0, 0, 0, 1 );
    assertMatEquals( target.dup().rotateZ( Math.PI / 2 ),
                     0, -1, 0, 0,
                     1, 0, 0, 0,
                     0, 0, 1, 0,
                     0, 0, 0, 1 );
    assertMatEquals( target.dup().rotateZ( Math.PI ),
                     -1, 0, 0, 0,
                     0, -1, 0, 0,
                     0, 0, 1, 0,
                     0, 0, 0, 1 );
    assertMatEquals( target.dup().rotateZ( 2 * Math.PI ),
                     1, 0, 0, 0,
                     0, 1, 0, 0,
                     0, 0, 1, 0,
                     0, 0, 0, 1 );
  }

  @Test
  public void setPerspective()
  {
    final Matrix4d target = new Matrix4d();
    final Matrix4d value = target.setPerspective( Math.PI / 2, 1.4, -1, 1 );
    assertEquals( value.asString(),
                  "0.7142857142857144 0.0 0.0 0.0\n" +
                  "0.0 1.0000000000000002 0.0 0.0\n" +
                  "0.0 0.0 -0.0 1.0\n" +
                  "0.0 0.0 -1.0 0.0\n" );
    assertMatEquals( value,
                     0.7142857142857144, 0, 0, 0,
                     0, 1.0000000000000002, 0, 0,
                     0, 0, 0, 1,
                     0, 0, -1, 0 );
    assertSame( value, target );

    final Matrix4d value2 = target.setPerspective( Math.PI / 2, 1.4, 1, 10 );
    assertEquals( value2.asString(),
                  "0.7142857142857144 0.0 0.0 0.0\n" +
                  "0.0 1.0000000000000002 0.0 0.0\n" +
                  "0.0 0.0 -1.2222222222222223 -2.2222222222222223\n" +
                  "0.0 0.0 -1.0 0.0\n" );
    assertMatEquals( value2,
                     0.7142857142857144, 0, 0, 0,
                     0, 1.0000000000000002, 0, 0,
                     0, 0, -1.2222222222222223, -2.2222222222222223,
                     0, 0, -1, 0 );
    assertSame( value2, target );
  }

  @Test
  public void lookAt()
  {
    final Vector3d eye = new Vector3d( 0, 10, 10 );
    final Vector3d center = new Vector3d( 10, 10, 10 );
    final Vector3d up = new Vector3d( 0, 1, 0 );
    final Matrix4d target = new Matrix4d();
    final Matrix4d value = target.lookAt( eye, center, up );
    assertEquals( value.asString(),
                  "0.0 0.0 1.0 -10.0\n" +
                  "0.0 1.0 0.0 -10.0\n" +
                  "-1.0 0.0 0.0 0.0\n" +
                  "0.0 0.0 0.0 1.0\n" );
    assertMatEquals( value,
                     0, 0, 1, -10,
                     0, 1, 0, -10,
                     -1, 0, 0, 0,
                     0, 0, 0, 1 );
    assertSame( value, target );
  }
}
