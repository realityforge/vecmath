package org.realityforge.vecmath;

import grim.annotations.OmitSymbol;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * A 3-dimensional, single-precision, floating-point vector.
 */
public final class Vec3f
{
  /**
   * The x component.
   */
  public float x;
  /**
   * The y component.
   */
  public float y;
  /**
   * The z component.
   */
  public float z;

  /**
   * Create a new Vec3f representing the zero vector.
   * i.e. all the components are <code>0</code>.
   */
  public Vec3f()
  {
  }

  /**
   * Create a new Vec3f with the specified components.
   *
   * @param x the x component.
   * @param y the y component.
   * @param z the z component.
   */
  public Vec3f( final float x, final float y, final float z )
  {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Create a new Vec3f from the other vector.
   *
   * @param other the other vector.
   */
  public Vec3f( @Nonnull final Vec3f other )
  {
    this( other.x, other.y, other.z );
  }

  /**
   * Duplicate the vector.
   *
   * @return a new vector with the same component values as the current vector.
   */
  @Nonnull
  public Vec3f dup()
  {
    return new Vec3f( this );
  }

  /**
   * Set the components of this vector to the components in the other vector.
   *
   * @param other the other vector.
   * @return this
   */
  @Nonnull
  public Vec3f set( @Nonnull final Vec3f other )
  {
    x = other.x;
    y = other.y;
    this.z = other.z;
    return this;
  }

  /**
   * Set the components of this vector to the specified components.
   *
   * @param x the x component.
   * @param y the y component.
   * @param z the z component.
   * @return this
   */
  @Nonnull
  public Vec3f set( final float x, final float y, final float z )
  {
    this.x = x;
    this.y = y;
    this.z = z;
    return this;
  }

  /**
   * Add the components of the other vector to this vector.
   *
   * @param other the other vector
   * @return this
   */
  @Nonnull
  public Vec3f add( @Nonnull final Vec3f other )
  {
    this.x += other.x;
    this.y += other.y;
    this.z += other.z;
    return this;
  }

  /**
   * Add the components of the other vector to this vector.
   *
   * @param x the x component.
   * @param y the y component.
   * @param z the z component.
   * @return this
   */
  @Nonnull
  public Vec3f add( final float x, final float y, final float z )
  {
    this.x += x;
    this.y += y;
    this.z += z;
    return this;
  }

  /**
   * Set this vector to the result of adding the specified vectors.
   *
   * @param value1 the first vector.
   * @param value2 the second vector.
   * @return this
   */
  @Nonnull
  public Vec3f add( @Nonnull final Vec3f value1, @Nonnull final Vec3f value2 )
  {
    x = value1.x + value2.x;
    y = value1.y + value2.y;
    z = value1.z + value2.z;
    return this;
  }

  /**
   * Subtract the components of the other vector from this vector.
   *
   * @param other the other vector
   * @return this
   */
  @Nonnull
  public Vec3f sub( @Nonnull final Vec3f other )
  {
    x -= other.x;
    y -= other.y;
    z -= other.z;
    return this;
  }

  /**
   * Subtract the components of the other vector from this vector.
   *
   * @param x the x component.
   * @param y the y component.
   * @param z the z component.
   * @return this
   */
  @Nonnull
  public Vec3f sub( final float x, final float y, final float z )
  {
    this.x -= x;
    this.y -= y;
    this.z -= z;
    return this;
  }

  /**
   * Set this vector to the result of adding the specified vectors.
   *
   * @param value1 the first vector.
   * @param value2 the second vector.
   * @return this
   */
  @Nonnull
  public Vec3f sub( @Nonnull final Vec3f value1, @Nonnull final Vec3f value2 )
  {
    x = value1.x - value2.x;
    y = value1.y - value2.y;
    z = value1.z - value2.z;
    return this;
  }

  /**
   * Multiply this vector by the specified scalar value.
   *
   * @param value the value to multiple vector by.
   * @return this
   */
  @Nonnull
  public Vec3f mul( final float value )
  {
    x *= value;
    y *= value;
    z *= value;
    return this;
  }

  /**
   * Returns the length or magnitude of this vector.
   *
   * @return the length or magnitude of this vector
   */
  public float length()
  {
    return (float) Math.sqrt( x * x + y * y + z * z );
  }

  /**
   * Normalize this vector.
   *
   * @return this
   */
  @Nonnull
  public Vec3f normalize()
  {
    final float normalizeFactor = 1.0F / length();
    x = x * normalizeFactor;
    y = y * normalizeFactor;
    z = z * normalizeFactor;
    return this;
  }

  /**
   * Set this vector to the cross product of the specified vectors.
   *
   * @param value1 the first vector.
   * @param value2 the second vector.
   * @return this
   */
  @Nonnull
  public Vec3f cross( @Nonnull final Vec3f value1, @Nonnull final Vec3f value2 )
  {
    // These temp variables allow for the scenario of this being passed as
    // a parameter and the calculation still producing the correct result
    float newX = value1.y * value2.z - value1.z * value2.y;
    float newY = value2.x * value1.z - value2.z * value1.x;
    z = value1.x * value2.y - value1.y * value2.x;
    x = newX;
    y = newY;
    return this;
  }

  /**
   * Compute the dot product of this vector and the other vector.
   *
   * @param other the other vector.
   * @return the dot product of this vector and the other vector.
   */
  public float dot( @Nonnull final Vec3f other )
  {
    return x * other.x + y * other.y + z * other.z;
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( x, y, z );
  }

  /**
   * Returns true if the specified object is the same type and has components with the same values.
   *
   * @param o the object.
   * @return true if the specified object is the same type and has components with the same values, otherwise false.
   */
  @Override
  public boolean equals( final Object o )
  {
    if ( o instanceof Vec3f )
    {
      final Vec3f other = (Vec3f) o;
      return x == other.x && y == other.y && z == other.z;
    }
    else
    {
      return false;
    }
  }

  /**
   * Returns a string representation of the vector.
   * This method only produces a useful representation if {@link Vecmath#isDebugToStringEnabled()}
   * returns <code>true</code>.
   *
   * @return a string representation of the object.
   */
  @OmitSymbol( unless = "vecmath.isDebugToStringEnabled" )
  @Override
  public String toString()
  {
    return VecmathConfig.isDebugToStringEnabled() ? "(" + x + ", " + y + ", " + z + ")" : super.toString();
  }
}
