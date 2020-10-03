package org.realityforge.vecmath;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class Vec3fTest
  extends AbstractTest
{
  @Test
  public void testToString()
  {
    assertEquals( new Vec3f().toString(), "(0.0, 0.0, 0.0)" );
    assertDefaultToStringWhenDebugToStringDisabled( new Vec3f() );
  }

  @Test
  public void testHashCode()
  {
    assertVecEquals( new Vec3f(), 0.0F, 0.0F, 0.0F );
    final Vec3f value1 = new Vec3f( 1F, 2F, 3F );
    final Vec3f value2 = new Vec3f( 1F, 2F, 3F );
    final Vec3f value3 = new Vec3f( 4F, 5F, 6F );
    assertEquals( value1, value1 );
    assertEquals( value1.hashCode(), value1.hashCode() );
    assertEquals( value1, value2 );
    assertNotEquals( value1, value3 );
    assertNotEquals( value1.hashCode(), value3.hashCode() );
    assertNotEquals( value3, value1 );
    assertNotEquals( value3.hashCode(), value1.hashCode() );
  }

  @Test
  public void constructors()
  {
    assertVecEquals( new Vec3f(), 0.0F, 0.0F, 0.0F );
    assertVecEquals( new Vec3f( 1F, 2F, 3F ), 1F, 2F, 3F );
    assertVecEquals( new Vec3f( new Vec3f( 1F, 2F, 3F ) ), 1F, 2F, 3F );
  }

  @Test
  public void dup()
  {
    final Vec3f value = new Vec3f( 1F, 2F, 3F );
    final Vec3f dup = value.dup();
    assertVecEquals( dup, 1F, 2F, 3F );
    assertNotSame( dup, value );
    assertEquals( dup, value );
  }

  @Test
  public void set()
  {
    final Vec3f value = new Vec3f( 1F, 2F, 3F );
    assertVecEquals( value, 1F, 2F, 3F );

    assertSame( value.set( new Vec3f() ), value );
    assertVecEquals( value, 0F, 0F, 0F );

    assertSame( value.set( 1F, 2F, 3F ), value );
    assertVecEquals( value, 1F, 2F, 3F );
  }

  @Test
  public void add()
  {
    final Vec3f value = new Vec3f( 1F, 2F, 3F );
    assertVecEquals( value, 1F, 2F, 3F );

    assertSame( value.add( new Vec3f( 4F, 5F, 6F ) ), value );
    assertVecEquals( value, 5F, 7F, 9F );

    assertSame( value.add( 5F, 3F, 1F ), value );
    assertVecEquals( value, 10F, 10F, 10F );

    assertSame( value.add( new Vec3f( 1F, 2F, 3F ), new Vec3f( 1F, 2F, 3F ) ), value );
    assertVecEquals( value, 2F, 4F, 6F );
  }

  @Test
  public void sub()
  {
    final Vec3f value = new Vec3f( 1F, 2F, 3F );
    assertVecEquals( value, 1F, 2F, 3F );

    assertSame( value.sub( new Vec3f( 4F, 5F, 6F ) ), value );
    assertVecEquals( value, -3F, -3F, -3F );

    assertSame( value.sub( 5F, 3F, 1F ), value );
    assertVecEquals( value, -8F, -6F, -4F );

    assertSame( value.sub( new Vec3f( 1F, 2F, 3F ), new Vec3f( 1F, 2F, 3F ) ), value );
    assertVecEquals( value, 0F, 0F, 0F );
  }

  @Test
  public void mul()
  {
    final Vec3f value = new Vec3f( 1F, 2F, 3F );
    assertVecEquals( value, 1F, 2F, 3F );

    assertSame( value.mul( 2 ), value );
    assertVecEquals( value, 2F, 4F, 6F );
  }

  @Test
  public void length()
  {
    assertEquals( new Vec3f( 1F, 0F, 0F ).length(), 1F, 0.00001 );
    assertEquals( new Vec3f( 0F, 1F, 0F ).length(), 1F, 0.00001 );
    assertEquals( new Vec3f( 0F, 0F, 1F ).length(), 1F, 0.00001 );
    assertEquals( new Vec3f( 1F, 2F, 3F ).length(), 3.7416575F, 0.00001 );
  }
}
