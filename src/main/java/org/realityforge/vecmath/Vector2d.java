package org.realityforge.vecmath;

import grim.annotations.OmitSymbol;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * A 2-dimensional, double-precision, floating-point vector.
 */
public final class Vector2d
{
  /**
   * The number of components in the {@code Vector2d}.
   */
  public static final int COMPONENTS = 2;
  /**
   * The number of bits used to represent a {@code Vector2d} value.
   */
  public static final int SIZE = Double.SIZE * COMPONENTS;
  /**
   * The number of bytes used to represent a {@code Vector2d} value.
   */
  public static final int BYTES = Double.BYTES * COMPONENTS;
  /**
   * The number of bits used to represent a {@code Vector2d} value at half-precision.
   * This is useful as the type is often converted to floats when passed to other frameworks
   * such as WebGL or WebGPU.
   */
  public static final int FLOAT_SIZE = Float.SIZE * COMPONENTS;
  /**
   * The number of bytes used to represent a {@code Vector2d} value at half-precision.
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
   * Create a new vector representing the zero vector.
   * i.e. all the components are <code>0</code>.
   */
  public Vector2d()
  {
  }

  /**
   * Create a new vector with the specified components.
   *
   * @param x the x component.
   * @param y the y component.
   */
  public Vector2d( final double x, final double y )
  {
    this.x = x;
    this.y = y;
  }

  /**
   * Create a new vector from the other vector.
   *
   * @param other the other vector.
   */
  public Vector2d( @Nonnull final Vector2d other )
  {
    this( other.x, other.y );
  }

  /**
   * Duplicate the vector.
   *
   * @return a new vector with the same component values as the current vector.
   */
  @Nonnull
  public Vector2d dup()
  {
    return new Vector2d( this );
  }

  /**
   * Set the components of this vector to the components in the other vector.
   *
   * @param other the other vector.
   * @return this
   */
  @Nonnull
  public Vector2d set( @Nonnull final Vector2d other )
  {
    x = other.x;
    y = other.y;
    return this;
  }

  /**
   * Set the components of this vector to the specified components.
   *
   * @param x the x component.
   * @param y the y component.
   * @return this
   */
  @Nonnull
  public Vector2d set( final double x, final double y )
  {
    this.x = x;
    this.y = y;
    return this;
  }

  /**
   * Add the components of the other vector to this vector.
   *
   * @param other the other vector
   * @return this
   */
  @Nonnull
  public Vector2d add( @Nonnull final Vector2d other )
  {
    x += other.x;
    y += other.y;
    return this;
  }

  /**
   * Add the components of the other vector to this vector.
   *
   * @param x the x component.
   * @param y the y component.
   * @return this
   */
  @Nonnull
  public Vector2d add( final double x, final double y )
  {
    this.x += x;
    this.y += y;
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
  public Vector2d add( @Nonnull final Vector2d value1, @Nonnull final Vector2d value2 )
  {
    x = value1.x + value2.x;
    y = value1.y + value2.y;
    return this;
  }

  /**
   * Subtract the components of the other vector from this vector.
   *
   * @param other the other vector
   * @return this
   */
  @Nonnull
  public Vector2d sub( @Nonnull final Vector2d other )
  {
    x -= other.x;
    y -= other.y;
    return this;
  }

  /**
   * Subtract the components of the other vector from this vector.
   *
   * @param x the x component.
   * @param y the y component.
   * @return this
   */
  @Nonnull
  public Vector2d sub( final double x, final double y )
  {
    this.x -= x;
    this.y -= y;
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
  public Vector2d sub( @Nonnull final Vector2d value1, @Nonnull final Vector2d value2 )
  {
    x = value1.x - value2.x;
    y = value1.y - value2.y;
    return this;
  }

  /**
   * Multiply this vector by the specified scalar value.
   *
   * @param value the value to multiple vector by.
   * @return this
   */
  @Nonnull
  public Vector2d mul( final double value )
  {
    x *= value;
    y *= value;
    return this;
  }

  /**
   * Divide this vector by the specified scalar value.
   *
   * @param value the value to divide vector by.
   * @return this
   */
  @Nonnull
  public Vector2d div( final double value )
  {
    x /= value;
    y /= value;
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
    return x * x + y * y;
  }

  /**
   * Returns the length or magnitude of this vector.
   *
   * @return the length or magnitude of this vector.
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
  public Vector2d normalize()
  {
    return mul( 1.0 / length() );
  }

  /**
   * Compute the dot product of this vector and the other vector.
   *
   * @param other the other vector.
   * @return the dot product of this vector and the other vector.
   */
  public double dot( @Nonnull final Vector2d other )
  {
    return x * other.x + y * other.y;
  }

  /**
   * Calculate the angle between this vector and the other vector.
   *
   * @param other the other vector.
   * @return the angle between this vector and the other vector.
   */
  public double angle( @Nonnull final Vector2d other )
  {
    double dot = dot( other );
    double det = x * other.y - y * other.x;
    return Math.atan2( det, dot );
    //return Math.acos( dot( other ) / Math.acos( dot( other ) / Math.sqrt( lengthSquared() * other.lengthSquared() ) );
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
  public Vector2d lerp( @Nonnull final Vector2d other, final double interpolationFactor )
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
  public Vector2d lerp( @Nonnull final Vector2d value1,
                        @Nonnull final Vector2d value2,
                        final double interpolationFactor )
  {
    assert interpolationFactor >= 0.0 && interpolationFactor <= 1.0;
    x = ( value2.x - value1.x ) * interpolationFactor + value1.x;
    y = ( value2.y - value1.y ) * interpolationFactor + value1.y;
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
    return toArray( new double[ 2 ] );
  }

  /**
   * Returns true if the other vector has components with the same values.
   *
   * @param other the other vector.
   * @return true if the other vector has components with the same values, otherwise false.
   */
  public boolean isEqualTo( @Nonnull final Vector2d other )
  {
    return x == other.x && y == other.y;
  }

  /**
   * Returns a string representation of the vector.
   *
   * @return a string representation of the vector.
   */
  @Nonnull
  public String asString()
  {
    return "(" + x + ", " + y + ")";
  }

  @Override
  public int hashCode()
  {
    return Vecmath.isObjectEqualsImplemented() ? Objects.hash( x, y ) : super.hashCode();
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
    return Vecmath.isObjectEqualsImplemented() ? o instanceof Vector2d && isEqualTo( (Vector2d) o ) : super.equals( o );
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
