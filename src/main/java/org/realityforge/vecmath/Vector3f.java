package org.realityforge.vecmath;

import grim.annotations.OmitSymbol;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * A 3-dimensional, single-precision, floating-point vector.
 */
public final class Vector3f
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
   * Create a new vector representing the zero vector.
   * i.e. all the components are <code>0</code>.
   */
  public Vector3f()
  {
  }

  /**
   * Create a new vector with the specified components.
   *
   * @param x the x component.
   * @param y the y component.
   * @param z the z component.
   */
  public Vector3f( final float x, final float y, final float z )
  {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Create a new vector from the other vector.
   *
   * @param other the other vector.
   */
  public Vector3f( @Nonnull final Vector3f other )
  {
    this( other.x, other.y, other.z );
  }

  /**
   * Duplicate the vector.
   *
   * @return a new vector with the same component values as the current vector.
   */
  @Nonnull
  public Vector3f dup()
  {
    return new Vector3f( this );
  }

  /**
   * Set the components of this vector to the components in the other vector.
   *
   * @param other the other vector.
   * @return this
   */
  @Nonnull
  public Vector3f set( @Nonnull final Vector3f other )
  {
    x = other.x;
    y = other.y;
    z = other.z;
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
  public Vector3f set( final float x, final float y, final float z )
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
  public Vector3f add( @Nonnull final Vector3f other )
  {
    x += other.x;
    y += other.y;
    z += other.z;
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
  public Vector3f add( final float x, final float y, final float z )
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
  public Vector3f add( @Nonnull final Vector3f value1, @Nonnull final Vector3f value2 )
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
  public Vector3f sub( @Nonnull final Vector3f other )
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
  public Vector3f sub( final float x, final float y, final float z )
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
  public Vector3f sub( @Nonnull final Vector3f value1, @Nonnull final Vector3f value2 )
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
  public Vector3f mul( final float value )
  {
    x *= value;
    y *= value;
    z *= value;
    return this;
  }

  /**
   * Divide this vector by the specified scalar value.
   *
   * @param value the value to divide vector by.
   * @return this
   */
  @Nonnull
  public Vector3f div( final float value )
  {
    x /= value;
    y /= value;
    z /= value;
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
  public Vector3f normalize()
  {
    return mul( 1.0F / length() );
  }

  /**
   * Set this vector to the cross product of the specified vectors.
   *
   * @param value1 the first vector.
   * @param value2 the second vector.
   * @return this
   */
  @Nonnull
  public Vector3f cross( @Nonnull final Vector3f value1, @Nonnull final Vector3f value2 )
  {
    // These temp variables allow for the scenario of this being passed as
    // a parameter and the calculation still producing the correct result
    final float newX = value1.y * value2.z - value1.z * value2.y;
    final float newY = value2.x * value1.z - value2.z * value1.x;
    final float newZ = value1.x * value2.y - value1.y * value2.x;
    x = newX;
    y = newY;
    z = newZ;
    return this;
  }

  /**
   * Compute the dot product of this vector and the other vector.
   *
   * @param other the other vector.
   * @return the dot product of this vector and the other vector.
   */
  public float dot( @Nonnull final Vector3f other )
  {
    return x * other.x + y * other.y + z * other.z;
  }

  /**
   * Calculate the angle between this vector and the other vector.
   *
   * @param other the other vector.
   * @return the angle between this vector and the other vector.
   */
  public float angle( @Nonnull final Vector3f other )
  {
    return (float) Math.acos( dot( other ) / ( length() * other.length() ) );
  }

  /**
   * Linearly interpolate this vector and the other vector using the specified interpolation factor and store the
   * result in this vector.
   *
   * @param other               the other vector
   * @param interpolationFactor the interpolation factor. A value between 0.0 and 1.0.
   * @return this
   */
  @Nonnull
  public Vector3f lerp( @Nonnull final Vector3f other, final float interpolationFactor )
  {
    return lerp( this, other, interpolationFactor );
  }

  /**
   * Linearly interpolate the <code>value1</code> vector and the <code>value2</code> vector using
   * the specified <code>interpolationFactor</code> and store the result in this vector.
   *
   * @param value1              the first vector.
   * @param value2              the second vector.
   * @param interpolationFactor the interpolation factor. A value between 0.0 and 1.0.
   * @return this
   */
  @Nonnull
  public Vector3f lerp( @Nonnull final Vector3f value1,
                        @Nonnull final Vector3f value2,
                        final float interpolationFactor )
  {
    assert interpolationFactor >= 0.0 && interpolationFactor <= 1.0;
    x = ( value2.x - value1.x ) * interpolationFactor + value1.x;
    y = ( value2.y - value1.y ) * interpolationFactor + value1.y;
    z = ( value2.z - value1.z ) * interpolationFactor + value1.z;
    return this;
  }

  /**
   * Returns true if the other vector has components with the same values.
   *
   * @param other the other vector.
   * @return true if the other vector has components with the same values, otherwise false.
   */
  public boolean isEqualTo( @Nonnull final Vector3f other )
  {
    return x == other.x && y == other.y && z == other.z;
  }

  @Override
  public int hashCode()
  {
    return Vecmath.isObjectEqualsImplemented() ? Objects.hash( x, y, z ) : super.hashCode();
  }

  /**
   * Returns true if the specified object is the same type and has components with the same values.
   * This method only produces a useful representation if {@link Vecmath#isObjectEqualsImplemented()}
   * returns <code>true</code>.
   *
   * @param o the object.
   * @return true if the specified object is the same type and has components with the same values, otherwise false.
   */
  @Override
  public boolean equals( final Object o )
  {
    return Vecmath.isObjectEqualsImplemented() ? o instanceof Vector3f && isEqualTo( (Vector3f) o ) : super.equals( o );
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
    return Vecmath.isDebugToStringEnabled() ? "(" + x + ", " + y + ", " + z + ")" : super.toString();
  }
}
