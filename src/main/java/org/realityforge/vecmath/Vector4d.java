package org.realityforge.vecmath;

import grim.annotations.OmitSymbol;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * A 4-dimensional, double-precision, floating-point vector.
 */
public final class Vector4d
{
  /**
   * The number of components in the {@code Vector4d}.
   */
  public static final int COMPONENTS = 4;
  /**
   * The number of bits used to represent a {@code Vector4d} value.
   */
  public static final int SIZE = Double.SIZE * COMPONENTS;
  /**
   * The number of bytes used to represent a {@code Vector4d} value.
   */
  public static final int BYTES = Double.BYTES * COMPONENTS;
  /**
   * The number of bits used to represent a {@code Vector4d} value at half-precision.
   * This is useful as the type is often converted to floats when passed to other frameworks
   * such as WebGL or WebGPU.
   */
  public static final int FLOAT_SIZE = Float.SIZE * COMPONENTS;
  /**
   * The number of bytes used to represent a {@code Vector4d} value at half-precision.
   * This is useful as the type is often converted to floats when passed to other frameworks
   * such as WebGL or WebGPU.
   */
  public static final int FLOAT_BYTES = Float.BYTES * COMPONENTS;
  /**
   * The x component.
   */
  public double x;
  /**
   * The y component.
   */
  public double y;
  /**
   * The z component.
   */
  public double z;
  /**
   * The w component.
   */
  public double w;

  /**
   * Create a new vector representing the zero vector.
   * i.e. all the components are <code>0</code>.
   */
  public Vector4d()
  {
  }

  /**
   * Create a new vector with the specified components.
   *
   * @param x the x component.
   * @param y the y component.
   * @param z the z component.
   * @param w the w component.
   */
  public Vector4d( final double x, final double y, final double z, final double w )
  {
    this.x = x;
    this.y = y;
    this.z = z;
    this.w = w;
  }

  /**
   * Create a new vector from the other vector.
   *
   * @param other the other vector.
   */
  public Vector4d( @Nonnull final Vector4d other )
  {
    this( other.x, other.y, other.z, other.w );
  }

  /**
   * Duplicate the vector.
   *
   * @return a new vector with the same component values as the current vector.
   */
  @Nonnull
  public Vector4d dup()
  {
    return new Vector4d( this );
  }

  /**
   * Set the components of this vector to the components in the other vector.
   *
   * @param other the other vector.
   * @return this
   */
  @Nonnull
  public Vector4d set( @Nonnull final Vector4d other )
  {
    x = other.x;
    y = other.y;
    z = other.z;
    w = other.w;
    return this;
  }

  /**
   * Set the components of this vector to the specified components.
   *
   * @param x the x component.
   * @param y the y component.
   * @param z the z component.
   * @param w the w component.
   * @return this
   */
  @Nonnull
  public Vector4d set( final double x, final double y, final double z, final double w )
  {
    this.x = x;
    this.y = y;
    this.z = z;
    this.w = w;
    return this;
  }

  /**
   * Add the components of the other vector to this vector.
   *
   * @param other the other vector
   * @return this
   */
  @Nonnull
  public Vector4d add( @Nonnull final Vector4d other )
  {
    x += other.x;
    y += other.y;
    z += other.z;
    w += other.w;
    return this;
  }

  /**
   * Add the components of the other vector to this vector.
   *
   * @param x the x component.
   * @param y the y component.
   * @param z the z component.
   * @param w the w component.
   * @return this
   */
  @Nonnull
  public Vector4d add( final double x, final double y, final double z, final double w )
  {
    this.x += x;
    this.y += y;
    this.z += z;
    this.w += w;
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
  public Vector4d add( @Nonnull final Vector4d value1, @Nonnull final Vector4d value2 )
  {
    x = value1.x + value2.x;
    y = value1.y + value2.y;
    z = value1.z + value2.z;
    w = value1.w + value2.w;
    return this;
  }

  /**
   * Subtract the components of the other vector from this vector.
   *
   * @param other the other vector
   * @return this
   */
  @Nonnull
  public Vector4d sub( @Nonnull final Vector4d other )
  {
    x -= other.x;
    y -= other.y;
    z -= other.z;
    w -= other.w;
    return this;
  }

  /**
   * Subtract the components of the other vector from this vector.
   *
   * @param x the x component.
   * @param y the y component.
   * @param z the z component.
   * @param w the w component.
   * @return this
   */
  @Nonnull
  public Vector4d sub( final double x, final double y, final double z, final double w )
  {
    this.x -= x;
    this.y -= y;
    this.z -= z;
    this.w -= w;
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
  public Vector4d sub( @Nonnull final Vector4d value1, @Nonnull final Vector4d value2 )
  {
    x = value1.x - value2.x;
    y = value1.y - value2.y;
    z = value1.z - value2.z;
    w = value1.w - value2.w;
    return this;
  }

  /**
   * Multiply this vector by the specified scalar value.
   *
   * @param value the value to multiple vector by.
   * @return this
   */
  @Nonnull
  public Vector4d mul( final double value )
  {
    x *= value;
    y *= value;
    z *= value;
    w *= value;
    return this;
  }

  /**
   * Divide this vector by the specified scalar value.
   *
   * @param value the value to divide vector by.
   * @return this
   */
  @Nonnull
  public Vector4d div( final double value )
  {
    x /= value;
    y /= value;
    z /= value;
    w /= value;
    return this;
  }

  /**
   * Returns the length or magnitude of this vector squared.
   * This is used as an optimization to avoid multiple sqrt when a single sqrt will do.
   *
   * @return the length or magnitude of this vector squared.
   */
  public double lengthSquared()
  {
    return x * x + y * y + z * z + w * w;
  }

  /**
   * Returns the length or magnitude of this vector.
   *
   * @return the length or magnitude of this vector
   */
  public double length()
  {
    return Math.sqrt( lengthSquared() );
  }

  /**
   * Normalize this vector.
   *
   * @return this
   */
  @Nonnull
  public Vector4d normalize()
  {
    return mul( 1.0 / length() );
  }

  /**
   * Compute the dot product of this vector and the other vector.
   *
   * @param other the other vector.
   * @return the dot product of this vector and the other vector.
   */
  public double dot( @Nonnull final Vector4d other )
  {
    return x * other.x + y * other.y + z * other.z + w * other.w;
  }

  /**
   * Calculate the angle between this vector and the other vector.
   *
   * @param other the other vector.
   * @return the angle between this vector and the other vector.
   */
  public double angle( @Nonnull final Vector4d other )
  {
    return Math.acos( dot( other ) / Math.sqrt( lengthSquared() * other.lengthSquared() ) );
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
  public Vector4d lerp( @Nonnull final Vector4d other, final double interpolationFactor )
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
  public Vector4d lerp( @Nonnull final Vector4d value1,
                        @Nonnull final Vector4d value2,
                        final double interpolationFactor )
  {
    assert interpolationFactor >= 0.0 && interpolationFactor <= 1.0;
    x = ( value2.x - value1.x ) * interpolationFactor + value1.x;
    y = ( value2.y - value1.y ) * interpolationFactor + value1.y;
    z = ( value2.z - value1.z ) * interpolationFactor + value1.z;
    w = ( value2.w - value1.w ) * interpolationFactor + value1.w;
    return this;
  }

  /**
   * Fill the specified target with the vector components starting at the specified offset.
   *
   * @param target the array in which to store the vector components. The target must be large enough to contain the vector.
   * @param offset the offset in the target array to start storing the vector components.
   * @return the vector represented as an array.
   */
  @Nonnull
  public double[] toArray( final double[] target, final int offset )
  {
    target[ offset ] = x;
    target[ offset + 1 ] = y;
    target[ offset + 2 ] = z;
    target[ offset + 3 ] = w;
    return target;
  }

  /**
   * Fill the specified target with the vector components.
   *
   * @param target the array in which to store the vector components. The target must be large enough to contain the vector.
   * @return the vector represented as an array.
   */
  @Nonnull
  public double[] toArray( final double[] target )
  {
    return toArray( target, 0 );
  }

  /**
   * Create an array to represent the vector.
   *
   * @return the vector represented as an array.
   */
  @Nonnull
  public double[] toArray()
  {
    return toArray( new double[ 4 ] );
  }

  /**
   * Returns true if the other vector has components with the same values.
   *
   * @param other the other vector.
   * @return true if the other vector has components with the same values, otherwise false.
   */
  public boolean isEqualTo( @Nonnull final Vector4d other )
  {
    return x == other.x && y == other.y && z == other.z && w == other.w;
  }

  /**
   * Returns a string representation of the vector.
   *
   * @return a string representation of the vector.
   */
  @Nonnull
  public String asString()
  {
    return "(" + x + ", " + y + ", " + z + ", " + w + ")";
  }

  @Override
  public int hashCode()
  {
    return Vecmath.isObjectEqualsImplemented() ? Objects.hash( x, y, z, w ) : super.hashCode();
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
    return Vecmath.isObjectEqualsImplemented() ? o instanceof Vector4d && isEqualTo( (Vector4d) o ) : super.equals( o );
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
    return Vecmath.isDebugToStringEnabled() ? asString() : super.toString();
  }
}
