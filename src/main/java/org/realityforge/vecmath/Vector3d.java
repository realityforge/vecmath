package org.realityforge.vecmath;

import grim.annotations.OmitSymbol;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * A 3-dimensional, double-precision, floating-point vector.
 */
public final class Vector3d
{
  /**
   * The number of components in the {@code Vector3d}.
   */
  public static final int COMPONENTS = 3;
  /**
   * The number of bits used to represent a {@code Vector3d} value.
   */
  public static final int SIZE = Double.SIZE * COMPONENTS;
  /**
   * The number of bytes used to represent a {@code Vector3d} value.
   */
  public static final int BYTES = Double.BYTES * COMPONENTS;
  /**
   * The number of bits used to represent a {@code Vector3d} value at half-precision.
   * This is useful as the type is often converted to floats when passed to other frameworks
   * such as WebGL or WebGPU.
   */
  public static final int FLOAT_SIZE = Float.SIZE * COMPONENTS;
  /**
   * The number of bytes used to represent a {@code Vector3d} value at half-precision.
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
   * Create a new vector representing the zero vector.
   * i.e. all the components are <code>0</code>.
   */
  public Vector3d()
  {
  }

  /**
   * Create a new vector with the specified components.
   *
   * @param x the x component.
   * @param y the y component.
   * @param z the z component.
   */
  public Vector3d( final double x, final double y, final double z )
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
  public Vector3d( @Nonnull final Vector3d other )
  {
    this( other.x, other.y, other.z );
  }

  /**
   * Duplicate the vector.
   *
   * @return a new vector with the same component values as the current vector.
   */
  @Nonnull
  public Vector3d dup()
  {
    return new Vector3d( this );
  }

  /**
   * Set the components of this vector to the components in the other vector.
   *
   * @param other the other vector.
   * @return this
   */
  @Nonnull
  public Vector3d set( @Nonnull final Vector3d other )
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
  public Vector3d set( final double x, final double y, final double z )
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
  public Vector3d add( @Nonnull final Vector3d other )
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
  public Vector3d add( final double x, final double y, final double z )
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
  public Vector3d add( @Nonnull final Vector3d value1, @Nonnull final Vector3d value2 )
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
  public Vector3d sub( @Nonnull final Vector3d other )
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
  public Vector3d sub( final double x, final double y, final double z )
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
  public Vector3d sub( @Nonnull final Vector3d value1, @Nonnull final Vector3d value2 )
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
  public Vector3d mul( final double value )
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
  public Vector3d div( final double value )
  {
    x /= value;
    y /= value;
    z /= value;
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
    return x * x + y * y + z * z;
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
  public Vector3d normalize()
  {
    return mul( 1.0 / length() );
  }

  /**
   * Set this vector to the cross product of the specified vectors.
   *
   * @param value1 the first vector.
   * @param value2 the second vector.
   * @return this
   */
  @Nonnull
  public Vector3d cross( @Nonnull final Vector3d value1, @Nonnull final Vector3d value2 )
  {
    // These temp variables allow for the scenario of this being passed as
    // a parameter and the calculation still producing the correct result
    final double newX = value1.y * value2.z - value1.z * value2.y;
    final double newY = value2.x * value1.z - value2.z * value1.x;
    final double newZ = value1.x * value2.y - value1.y * value2.x;
    x = newX;
    y = newY;
    z = newZ;
    return this;
  }

  /**
   * Multiply this by the specified matrix, performing perspective division.
   * This method assumes <code>w=1.0</code> as the fourth vector component.
   *
   * @param m the matrix to multiply this vector.
   * @return this
   */
  @Nonnull
  public Vector3d mul( @Nonnull final Matrix4d m )
  {
    final double invW = 1.0 / ( m.m03 * x + m.m13 * y + m.m23 * z + m.m33 );
    final double rx = ( m.m00 * x + m.m10 * y + m.m20 * z + m.m30 ) * invW;
    final double ry = ( m.m01 * x + m.m11 * y + m.m21 * z + m.m31 ) * invW;
    final double rz = ( m.m02 * x + m.m12 * y + m.m22 * z + m.m32 ) * invW;
    this.x = rx;
    this.y = ry;
    this.z = rz;
    return this;
  }

  /**
   * Compute the dot product of this vector and the other vector.
   *
   * @param other the other vector.
   * @return the dot product of this vector and the other vector.
   */
  public double dot( @Nonnull final Vector3d other )
  {
    return x * other.x + y * other.y + z * other.z;
  }

  /**
   * Calculate the angle between this vector and the other vector.
   *
   * @param other the other vector.
   * @return the angle between this vector and the other vector.
   */
  public double angle( @Nonnull final Vector3d other )
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
  public Vector3d lerp( @Nonnull final Vector3d other, final double interpolationFactor )
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
  public Vector3d lerp( @Nonnull final Vector3d value1,
                        @Nonnull final Vector3d value2,
                        final double interpolationFactor )
  {
    assert interpolationFactor >= 0.0 && interpolationFactor <= 1.0;
    x = ( value2.x - value1.x ) * interpolationFactor + value1.x;
    y = ( value2.y - value1.y ) * interpolationFactor + value1.y;
    z = ( value2.z - value1.z ) * interpolationFactor + value1.z;
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
    return toArray( new double[ 3 ] );
  }

  /**
   * Returns true if the other vector has components with the same values.
   *
   * @param other the other vector.
   * @return true if the other vector has components with the same values, otherwise false.
   */
  public boolean isEqualTo( @Nonnull final Vector3d other )
  {
    return x == other.x && y == other.y && z == other.z;
  }

  /**
   * Returns a string representation of the vector.
   *
   * @return a string representation of the vector.
   */
  @Nonnull
  public String asString()
  {
    return "(" + x + ", " + y + ", " + z + ")";
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
    return Vecmath.isObjectEqualsImplemented() ? o instanceof Vector3d && isEqualTo( (Vector3d) o ) : super.equals( o );
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
