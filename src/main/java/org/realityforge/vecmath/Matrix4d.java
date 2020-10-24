package org.realityforge.vecmath;

import grim.annotations.OmitSymbol;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * A 4x4-dimensional, double-precision, floating-point matrix.
 *
 * <p>If the matrix was laid out in column-major form it looks like:</p>
 * <pre>
 * m00  m10  m20  m30
 * m01  m11  m21  m31
 * m02  m12  m22  m32
 * m03  m13  m23  m33
 * </pre>
 */
public final class Matrix4d
{
  public double m00;
  public double m01;
  public double m02;
  public double m03;
  public double m10;
  public double m11;
  public double m12;
  public double m13;
  public double m20;
  public double m21;
  public double m22;
  public double m23;
  public double m30;
  public double m31;
  public double m32;
  public double m33;

  /**
   * Create a new matrix representing the identity matrix.
   */
  public Matrix4d()
  {
    m00 = m11 = m22 = m33 = 1;
  }

  /**
   * Create a new matrix with the specified components.
   *
   * @param m00 the m00 component.
   * @param m01 the m01 component.
   * @param m02 the m02 component.
   * @param m03 the m03 component.
   * @param m10 the m10 component.
   * @param m11 the m11 component.
   * @param m12 the m12 component.
   * @param m13 the m13 component.
   * @param m20 the m20 component.
   * @param m21 the m21 component.
   * @param m22 the m22 component.
   * @param m23 the m23 component.
   * @param m30 the m30 component.
   * @param m31 the m31 component.
   * @param m32 the m32 component.
   * @param m33 the m33 component.
   */
  public Matrix4d( final double m00, final double m01, final double m02, final double m03,
                   final double m10, final double m11, final double m12, final double m13,
                   final double m20, final double m21, final double m22, final double m23,
                   final double m30, final double m31, final double m32, final double m33 )
  {
    this.m00 = m00;
    this.m10 = m10;
    this.m20 = m20;
    this.m30 = m30;
    this.m01 = m01;
    this.m11 = m11;
    this.m21 = m21;
    this.m31 = m31;
    this.m02 = m02;
    this.m12 = m12;
    this.m22 = m22;
    this.m32 = m32;
    this.m03 = m03;
    this.m13 = m13;
    this.m23 = m23;
    this.m33 = m33;
  }

  /**
   * Create a new matrix from the other matrix.
   *
   * @param other the other matrix.
   */
  public Matrix4d( @Nonnull final Matrix4d other )
  {
    m00 = other.m00;
    m10 = other.m10;
    m20 = other.m20;
    m30 = other.m30;
    m01 = other.m01;
    m11 = other.m11;
    m21 = other.m21;
    m31 = other.m31;
    m02 = other.m02;
    m12 = other.m12;
    m22 = other.m22;
    m32 = other.m32;
    m03 = other.m03;
    m13 = other.m13;
    m23 = other.m23;
    m33 = other.m33;
  }

  /**
   * Duplicate the matrix.
   *
   * @return a new matrix with the same component values as the current matrix.
   */
  @Nonnull
  public Matrix4d dup()
  {
    return new Matrix4d( this );
  }

  /**
   * Set the components of this matrix to the components in the other matrix.
   *
   * @param other the other matrix.
   * @return this
   */
  @Nonnull
  public Matrix4d set( @Nonnull final Matrix4d other )
  {
    m00 = other.m00;
    m10 = other.m10;
    m20 = other.m20;
    m30 = other.m30;
    m01 = other.m01;
    m11 = other.m11;
    m21 = other.m21;
    m31 = other.m31;
    m02 = other.m02;
    m12 = other.m12;
    m22 = other.m22;
    m32 = other.m32;
    m03 = other.m03;
    m13 = other.m13;
    m23 = other.m23;
    m33 = other.m33;
    return this;
  }

  /**
   * Set the components of this matrix to the specified components.
   *
   * @param m00 the m00 component.
   * @param m01 the m01 component.
   * @param m02 the m02 component.
   * @param m03 the m03 component.
   * @param m10 the m10 component.
   * @param m11 the m11 component.
   * @param m12 the m12 component.
   * @param m13 the m13 component.
   * @param m20 the m20 component.
   * @param m21 the m21 component.
   * @param m22 the m22 component.
   * @param m23 the m23 component.
   * @param m30 the m30 component.
   * @param m31 the m31 component.
   * @param m32 the m32 component.
   * @param m33 the m33 component.
   * @return this
   */
  @Nonnull
  public Matrix4d set( final double m00, final double m01, final double m02, final double m03,
                       final double m10, final double m11, final double m12, final double m13,
                       final double m20, final double m21, final double m22, final double m23,
                       final double m30, final double m31, final double m32, final double m33 )
  {
    this.m00 = m00;
    this.m10 = m10;
    this.m20 = m20;
    this.m30 = m30;
    this.m01 = m01;
    this.m11 = m11;
    this.m21 = m21;
    this.m31 = m31;
    this.m02 = m02;
    this.m12 = m12;
    this.m22 = m22;
    this.m32 = m32;
    this.m03 = m03;
    this.m13 = m13;
    this.m23 = m23;
    this.m33 = m33;
    return this;
  }

  /**
   * Set the matrix to the identity matrix.
   *
   * @return this
   */
  @Nonnull
  public Matrix4d setIdentity()
  {
    return set(
      1, 0, 0, 0,
      0, 1, 0, 0,
      0, 0, 1, 0,
      0, 0, 0, 1
    );
  }

  /**
   * Set the matrix to the translation matrix.
   * The matrix is:
   *
   * <pre>
   * 1 0 0 x
   * 0 1 0 y
   * 0 0 1 z
   * 0 0 0 1
   * </pre>
   *
   * @param x the translation in x.
   * @param y the translation in y.
   * @param z the translation in z.
   * @return this
   */
  @Nonnull
  public Matrix4d setTranslation( final double x, final double y, final double z )
  {
    return set(
      1, 0, 0, x,
      0, 1, 0, y,
      0, 0, 1, z,
      0, 0, 0, 1
    );
  }

  /**
   * Apply a translation to this matrix by the specified units.
   * This is equivalent to multiplying this matrix by the matrix:
   *
   * <pre>
   * 1 0 0 x
   * 0 1 0 y
   * 0 0 1 z
   * 0 0 0 1
   * </pre>
   *
   * @param x the translation in x.
   * @param y the translation in y.
   * @param z the translation in z.
   * @return this
   */
  @Nonnull
  public Matrix4d translate( final double x, final double y, final double z )
  {
    m03 = m00 * x + m01 * y + m02 * z + m03;
    m13 = m10 * x + m11 * y + m12 * z + m13;
    m23 = m20 * x + m21 * y + m22 * z + m23;
    m33 = m30 * x + m31 * y + m32 * z + m33;
    return this;
  }

  /**
   * Apply a translation to this matrix by the specified vector.
   * See {@link #translate(double, double, double)} for a more detail explanation.
   *
   * @param vector the translation vector.
   * @return this
   */
  @Nonnull
  public Matrix4d translate( @Nonnull final Vector3d vector )
  {
    return translate( vector.x, vector.y, vector.z );
  }

  /**
   * Set the matrix to a uniform scaling matrix.
   * The matrix is:
   *
   * <pre>
   * k 0 0 0
   * 0 k 0 0
   * 0 0 k 0
   * 0 0 0 1
   * </pre>
   *
   * @param k the uniform scaling applied to all dimensions.
   * @return this
   */
  @Nonnull
  public Matrix4d setScale( final double k )
  {
    return setScale( k, k, k );
  }

  /**
   * Set the matrix to the scaling matrix.
   * The matrix is:
   *
   * <pre>
   * x 0 0 0
   * 0 y 0 0
   * 0 0 z 0
   * 0 0 0 1
   * </pre>
   *
   * @param x the scaling in x.
   * @param y the scaling in y.
   * @param z the scaling in z.
   * @return this
   */
  @Nonnull
  public Matrix4d setScale( final double x, final double y, final double z )
  {
    return set(
      x, 0, 0, 0,
      0, y, 0, 0,
      0, 0, z, 0,
      0, 0, 0, 1
    );
  }

  /**
   * Apply a scaling transformation to this matrix by the specified units.
   * This is equivalent to multiplying this matrix by the matrix:
   *
   * <pre>
   * x 0 0 0
   * 0 y 0 0
   * 0 0 z 0
   * 0 0 0 1
   * </pre>
   *
   * @param x the scaling in x.
   * @param y the scaling in y.
   * @param z the scaling in z.
   * @return this
   */
  @Nonnull
  public Matrix4d scale( final double x, final double y, final double z )
  {
    m00 *= x;
    m10 *= x;
    m20 *= x;
    m30 *= x;
    m01 *= y;
    m11 *= y;
    m21 *= y;
    m31 *= y;
    m02 *= z;
    m12 *= z;
    m22 *= z;
    m32 *= z;
    return this;
  }

  /**
   * Apply a uniform scaling transformation to this matrix.
   * This is equivalent to multiplying this matrix by the matrix:
   *
   * <pre>
   * k 0 0 0
   * 0 k 0 0
   * 0 0 k 0
   * 0 0 0 1
   * </pre>
   *
   * @param k the uniform scaling applied to all dimensions.
   * @return this
   */
  @Nonnull
  public Matrix4d scale( final double k )
  {
    return scale( k, k, k );
  }

  /**
   * Fill the specified target with the matrix components starting at the specified offset.
   * The components are emitted in row-major form.
   *
   * @param target the array in which to store the matrix components. The target must be large enough to contain the matrix.
   * @param offset the offset in the target array to start storing the matrix components.
   * @return the matrix represented as an array.
   */
  @Nonnull
  public double[] toArray( final double[] target, final int offset )
  {
    target[ offset ] = m00;
    target[ offset + 1 ] = m10;
    target[ offset + 2 ] = m20;
    target[ offset + 3 ] = m30;
    target[ offset + 4 ] = m01;
    target[ offset + 5 ] = m11;
    target[ offset + 6 ] = m21;
    target[ offset + 7 ] = m31;
    target[ offset + 8 ] = m02;
    target[ offset + 9 ] = m12;
    target[ offset + 10 ] = m22;
    target[ offset + 11 ] = m32;
    target[ offset + 12 ] = m03;
    target[ offset + 13 ] = m13;
    target[ offset + 14 ] = m23;
    target[ offset + 15 ] = m33;
    return target;
  }

  /**
   * Fill the specified target with the matrix components.
   * The components are emitted in row-major form.
   *
   * @param target the array in which to store the matrix components. The target must be large enough to contain the matrix.
   * @return the matrix represented as an array.
   */
  @Nonnull
  public double[] toArray( final double[] target )
  {
    return toArray( target, 0 );
  }

  /**
   * Create an array to represent the matrix.
   * The components are emitted in row-major form.
   *
   * @return the matrix represented as an array.
   */
  @Nonnull
  public double[] toArray()
  {
    return toArray( new double[ 16 ] );
  }

  /**
   * Returns true if the other matrix has components with the same values.
   *
   * @param other the other matrix.
   * @return true if the other matrix has components with the same values, otherwise false.
   */
  public boolean isEqualTo( @Nonnull final Matrix4d other )
  {
    return
      m00 == other.m00 && m01 == other.m01 && m02 == other.m02 && m03 == other.m03 &&
      m10 == other.m10 && m11 == other.m11 && m12 == other.m12 && m13 == other.m13 &&
      m20 == other.m20 && m21 == other.m21 && m22 == other.m22 && m23 == other.m23 &&
      m30 == other.m30 && m31 == other.m31 && m32 == other.m32 && m33 == other.m33;
  }

  /**
   * Returns a string representation of the matrix.
   *
   * @return a string representation of the matrix.
   */
  @Nonnull
  public String asString()
  {
    return
      "(" +
      m00 + ", " + m01 + ", " + m02 + ", " + m03 + " | " +
      m10 + ", " + m11 + ", " + m12 + ", " + m13 + " | " +
      m20 + ", " + m21 + ", " + m22 + ", " + m23 + " | " +
      m30 + ", " + m31 + ", " + m32 + ", " + m33 +
      ")";
  }

  @Override
  public int hashCode()
  {
    return Vecmath.isObjectEqualsImplemented() ?
           Objects.hash( m00, m01, m02, m03,
                         m10, m11, m12, m13,
                         m20, m21, m22, m23,
                         m30, m31, m32, m33 ) :
           super.hashCode();
  }

  /**
   * Returns true if the specified object is the same type and has components with the same values.
   * This method only produces a useful representation if {@link Vecmath#isDebugToStringEnabled()}
   * returns <code>true</code>.
   *
   * @param o the object.
   * @return true if the specified object is the same type and has components with the same values, otherwise false.
   */
  @Override
  public boolean equals( final Object o )
  {
    return Vecmath.isObjectEqualsImplemented() ? o instanceof Matrix4d && isEqualTo( (Matrix4d) o ) : super.equals( o );
  }

  /**
   * Returns a string representation of the matrix.
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
