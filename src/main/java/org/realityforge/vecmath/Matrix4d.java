package org.realityforge.vecmath;

import grim.annotations.OmitSymbol;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * A 4x4-dimensional, double-precision, floating-point matrix.
 *
 * <p>If the matrix was laid out in row-major form it looks like:</p>
 * <pre>
 * m00  m01  m02  m03
 * m10  m11  m12  m13
 * m20  m21  m22  m23
 * m30  m31  m32  m33
 * </pre>
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
  /**
   * The number of components in the {@code Matrix4d}.
   */
  public static final int COMPONENTS = 16;
  /**
   * The number of bits used to represent a {@code Matrix4d} value.
   */
  public static final int SIZE = Double.SIZE * COMPONENTS;
  /**
   * The number of bytes used to represent a {@code Matrix4d} value.
   */
  public static final int BYTES = Double.BYTES * COMPONENTS;
  /**
   * The number of bits used to represent a {@code Matrix4d} value at half-precision.
   * This is useful as the type is often converted to floats when passed to other frameworks
   * such as WebGL or WebGPU.
   */
  public static final int FLOAT_SIZE = Float.SIZE * COMPONENTS;
  /**
   * The number of bytes used to represent a {@code Matrix4d} value at half-precision.
   * This is useful as the type is often converted to floats when passed to other frameworks
   * such as WebGL or WebGPU.
   */
  public static final int FLOAT_BYTES = Float.BYTES * COMPONENTS;
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
  public Matrix4d( final double m00, final double m10, final double m20, final double m30,
                   final double m01, final double m11, final double m21, final double m31,
                   final double m02, final double m12, final double m22, final double m32,
                   final double m03, final double m13, final double m23, final double m33 )
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
  public Matrix4d set( final double m00, final double m10, final double m20, final double m30,
                       final double m01, final double m11, final double m21, final double m31,
                       final double m02, final double m12, final double m22, final double m32,
                       final double m03, final double m13, final double m23, final double m33 )
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
    m30 = m00 * x + m10 * y + m20 * z + m30;
    m31 = m01 * x + m11 * y + m21 * z + m31;
    m32 = m02 * x + m12 * y + m22 * z + m32;
    m33 = m03 * x + m13 * y + m23 * z + m33;
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
   * Apply a rotation about the X axis by rotating the specified amount of radians.
   *
   * @param angleInRadians the angle in radians
   * @return this
   * @see <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Basic_rotations">Basic Matrix rotations</a>
   */
  @Nonnull
  public Matrix4d rotateX( final double angleInRadians )
  {
    final double sin = Math.sin( angleInRadians );
    final double cos = Math.cos( angleInRadians );

    final double nm10 = m10 * cos + m20 * sin;
    final double nm11 = m11 * cos + m21 * sin;
    final double nm12 = m12 * cos + m22 * sin;
    final double nm13 = m13 * cos + m23 * sin;

    m20 = m10 * -sin + m20 * cos;
    m21 = m11 * -sin + m21 * cos;
    m22 = m12 * -sin + m22 * cos;
    m23 = m13 * -sin + m23 * cos;
    m10 = nm10;
    m11 = nm11;
    m12 = nm12;
    m13 = nm13;
    return this;
  }

  /**
   * Apply a rotation about the Y axis by rotating the specified amount of radians.
   *
   * @param angleInRadians the angle in radians
   * @return this
   * @see <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Basic_rotations">Basic Matrix rotations</a>
   */
  @Nonnull
  public Matrix4d rotateY( final double angleInRadians )
  {
    final double sin = Math.sin( angleInRadians );
    final double cos = Math.cos( angleInRadians );

    final double nm00 = m00 * cos + m20 * -sin;
    final double nm01 = m01 * cos + m21 * -sin;
    final double nm02 = m02 * cos + m22 * -sin;
    final double nm03 = m03 * cos + m23 * -sin;
    m20 = m00 * sin + m20 * cos;
    m21 = m01 * sin + m21 * cos;
    m22 = m02 * sin + m22 * cos;
    m23 = m03 * sin + m23 * cos;
    m00 = nm00;
    m01 = nm01;
    m02 = nm02;
    m03 = nm03;
    return this;
  }

  /**
   * Apply a rotation about the Z axis by rotating the specified amount of radians.
   *
   * @param angleInRadians the angle in radians
   * @return this
   * @see <a href="http://en.wikipedia.org/wiki/Rotation_matrix#Basic_rotations">Basic Matrix rotations</a>
   */
  @Nonnull
  public Matrix4d rotateZ( final double angleInRadians )
  {
    final double sin = Math.sin( angleInRadians );
    final double cos = Math.cos( angleInRadians );
    final double nm00 = m00 * cos + m10 * sin;
    final double nm01 = m01 * cos + m11 * sin;
    final double nm02 = m02 * cos + m12 * sin;
    final double nm03 = m03 * cos + m13 * sin;
    m10 = m00 * -sin + m10 * cos;
    m11 = m01 * -sin + m11 * cos;
    m12 = m02 * -sin + m12 * cos;
    m13 = m03 * -sin + m13 * cos;
    m00 = nm00;
    m01 = nm01;
    m02 = nm02;
    m03 = nm03;
    return this;
  }

  /**
   * Multiply this matrix by the matrix <code>right</code> and store the result in this matrix.
   *
   * @param right the right operand of the multiplication.
   * @return this the result of the operation.
   */
  @Nonnull
  public Matrix4d multiply( @Nonnull final Matrix4d right )
  {
    multiply( this, this, right );
    return this;
  }

  /**
   * Multiply the matrix <code>left</code> by the matrix <code>right</code> and place the result in <code>result</code>.
   *
   * @param result the matrix where the result is stored. May be the same instance as the other parameters.
   * @param left   the left operand of the multiplication.
   * @param right  the right operand of the multiplication.
   */
  public static void multiply( @Nonnull final Matrix4d result,
                               @Nonnull final Matrix4d left,
                               @Nonnull final Matrix4d right )
  {
    final double a00 = left.m00;
    final double a01 = left.m01;
    final double a02 = left.m02;
    final double a03 = left.m03;
    final double a10 = left.m10;
    final double a11 = left.m11;
    final double a12 = left.m12;
    final double a13 = left.m13;
    final double a20 = left.m20;
    final double a21 = left.m21;
    final double a22 = left.m22;
    final double a23 = left.m23;
    final double a30 = left.m30;
    final double a31 = left.m31;
    final double a32 = left.m32;
    final double a33 = left.m33;

    final double b00 = right.m00;
    final double b01 = right.m01;
    final double b02 = right.m02;
    final double b03 = right.m03;
    final double b10 = right.m10;
    final double b11 = right.m11;
    final double b12 = right.m12;
    final double b13 = right.m13;
    final double b20 = right.m20;
    final double b21 = right.m21;
    final double b22 = right.m22;
    final double b23 = right.m23;
    final double b30 = right.m30;
    final double b31 = right.m31;
    final double b32 = right.m32;
    final double b33 = right.m33;
    result.set( a00 * b00 + a01 * b10 + a02 * b20 + a03 * b30,
                a10 * b00 + a11 * b10 + a12 * b20 + a13 * b30,
                a20 * b00 + a21 * b10 + a22 * b20 + a23 * b30,
                a30 * b00 + a31 * b10 + a32 * b20 + a33 * b30,

                a00 * b01 + a01 * b11 + a02 * b21 + a03 * b31,
                a10 * b01 + a11 * b11 + a12 * b21 + a13 * b31,
                a20 * b01 + a21 * b11 + a22 * b21 + a23 * b31,
                a30 * b01 + a31 * b11 + a32 * b21 + a33 * b31,

                a00 * b02 + a01 * b12 + a02 * b22 + a03 * b32,
                a10 * b02 + a11 * b12 + a12 * b22 + a13 * b32,
                a20 * b02 + a21 * b12 + a22 * b22 + a23 * b32,
                a30 * b02 + a31 * b12 + a32 * b22 + a33 * b32,

                a00 * b03 + a01 * b13 + a02 * b23 + a03 * b33,
                a10 * b03 + a11 * b13 + a12 * b23 + a13 * b33,
                a20 * b03 + a21 * b13 + a22 * b23 + a23 * b33,
                a30 * b03 + a31 * b13 + a32 * b23 + a33 * b33 );
  }

  /**
   * Set this matrix to be a symmetric perspective projection frustum transformation for a right-handed coordinate system.
   *
   * @param fovY   the vertical field of view in radians (must be greater than zero and less than {@link Math#PI PI})
   * @param aspect the aspect ratio (i.e. width / height; must be greater than zero)
   * @param zNear  the near clipping plane distance
   * @param zFar   the far clipping plane distance.
   * @return this
   * @see <a href="https://github.com/JOML-CI/JOML/blob/main/src/org/joml/Matrix4d.java">Derived from equivalent in org.joml.Matrix4d</a>
   */
  @Nonnull
  public Matrix4d setPerspective( final double fovY, final double aspect, final double zNear, final double zFar )
  {
    assert fovY > 0 && fovY < Math.PI;
    assert aspect > 0;
    assert !Double.isInfinite( zNear );
    assert !Double.isInfinite( zFar );

    final double h = Math.tan( fovY * 0.5 );
    return set( 1 / ( h * aspect ), 0, 0, 0,
                0, 1.0 / h, 0, 0,
                0, 0, ( zFar + zNear ) / ( zNear - zFar ), ( zFar + zFar ) * zNear / ( zNear - zFar ),
                0, 0, -1, 0 );
  }

  /**
   * Apply a "lookat" transformation to this matrix for a right-handed coordinate system,
   * that aligns <code>-z</code> with <code>center - eye</code>.
   *
   * @param eye    the position of the camera
   * @param center the point in space to look at
   * @param up     the direction of 'up'
   * @return this
   * @see <a href="https://github.com/JOML-CI/JOML/blob/main/src/org/joml/Matrix4d.java">Derived from equivalent in org.joml.Matrix4d</a>
   */
  @Nonnull
  public Matrix4d lookAt( @Nonnull final Vector3d eye, @Nonnull final Vector3d center, @Nonnull final Vector3d up )
  {
    return lookAt( eye.x, eye.y, eye.z, center.x, center.y, center.z, up.x, up.y, up.z );
  }

  /**
   * Apply a "lookat" transformation to this matrix for a right-handed coordinate system,
   * that aligns <code>-z</code> with <code>center - eye</code>.
   *
   * @param eyeX    the x-coordinate of the eye/camera location
   * @param eyeY    the y-coordinate of the eye/camera location
   * @param eyeZ    the z-coordinate of the eye/camera location
   * @param centerX the x-coordinate of the point to look at
   * @param centerY the y-coordinate of the point to look at
   * @param centerZ the z-coordinate of the point to look at
   * @param upX     the x-coordinate of the up vector
   * @param upY     the y-coordinate of the up vector
   * @param upZ     the z-coordinate of the up vector
   * @return this
   * @see <a href="https://github.com/JOML-CI/JOML/blob/main/src/org/joml/Matrix4d.java">Derived from equivalent in org.joml.Matrix4d</a>
   */
  @SuppressWarnings( "UnnecessaryLocalVariable" )
  @Nonnull
  public Matrix4d lookAt( final double eyeX,
                          final double eyeY,
                          final double eyeZ,
                          final double centerX,
                          final double centerY,
                          final double centerZ,
                          final double upX,
                          final double upY,
                          final double upZ )
  {
    double dirX = eyeX - centerX;
    double dirY = eyeY - centerY;
    double dirZ = eyeZ - centerZ;
    // Normalize direction
    final double invDirLength = 1.0 / Math.sqrt( dirX * dirX + dirY * dirY + dirZ * dirZ );
    dirX *= invDirLength;
    dirY *= invDirLength;
    dirZ *= invDirLength;
    // left = up x direction
    double leftX = upY * dirZ - upZ * dirY;
    double leftY = upZ * dirX - upX * dirZ;
    double leftZ = upX * dirY - upY * dirX;
    // normalize left
    double invLeftLength = 1.0 / Math.sqrt( leftX * leftX + leftY * leftY + leftZ * leftZ );
    leftX *= invLeftLength;
    leftY *= invLeftLength;
    leftZ *= invLeftLength;
    // up = direction x left
    final double upnX = dirY * leftZ - dirZ * leftY;
    final double upnY = dirZ * leftX - dirX * leftZ;
    final double upnZ = dirX * leftY - dirY * leftX;
    // calculate right matrix elements
    final double rm00 = leftX;
    final double rm01 = upnX;
    final double rm02 = dirX;
    final double rm10 = leftY;
    final double rm11 = upnY;
    final double rm12 = dirY;
    final double rm20 = leftZ;
    final double rm21 = upnZ;
    final double rm22 = dirZ;
    final double rm30 = -( leftX * eyeX + leftY * eyeY + leftZ * eyeZ );
    final double rm31 = -( upnX * eyeX + upnY * eyeY + upnZ * eyeZ );
    final double rm32 = -( dirX * eyeX + dirY * eyeY + dirZ * eyeZ );
    final double nm00 = m00 * rm00 + m10 * rm01 + m20 * rm02;
    final double nm01 = m01 * rm00 + m11 * rm01 + m21 * rm02;
    final double nm02 = m02 * rm00 + m12 * rm01 + m22 * rm02;
    final double nm03 = m03 * rm00 + m13 * rm01 + m23 * rm02;
    final double nm10 = m00 * rm10 + m10 * rm11 + m20 * rm12;
    final double nm11 = m01 * rm10 + m11 * rm11 + m21 * rm12;
    final double nm12 = m02 * rm10 + m12 * rm11 + m22 * rm12;
    final double nm13 = m03 * rm10 + m13 * rm11 + m23 * rm12;
    final double nm20 = m00 * rm20 + m10 * rm21 + m20 * rm22;
    final double nm21 = m01 * rm20 + m11 * rm21 + m21 * rm22;
    final double nm22 = m02 * rm20 + m12 * rm21 + m22 * rm22;
    final double nm23 = m03 * rm20 + m13 * rm21 + m23 * rm22;
    final double nm30 = m00 * rm30 + m10 * rm31 + m20 * rm32 + m30;
    final double nm31 = m01 * rm30 + m11 * rm31 + m21 * rm32 + m31;
    final double nm32 = m02 * rm30 + m12 * rm31 + m22 * rm32 + m32;
    final double nm33 = m03 * rm30 + m13 * rm31 + m23 * rm32 + m33;
    return set( nm00, nm10, nm20, nm30,
                nm01, nm11, nm21, nm31,
                nm02, nm12, nm22, nm32,
                nm03, nm13, nm23, nm33 );
  }

  /**
   * Fill the specified target with the matrix components starting at the specified offset.
   * The components are emitted in column-major form.
   *
   * @param target the array in which to store the matrix components. The target must be large enough to contain the matrix.
   * @param offset the offset in the target array to start storing the matrix components.
   * @return the matrix represented as an array.
   */
  @Nonnull
  public double[] toArray( @Nonnull final double[] target, final int offset )
  {
    target[ offset ] = m00;
    target[ offset + 1 ] = m01;
    target[ offset + 2 ] = m02;
    target[ offset + 3 ] = m03;
    target[ offset + 4 ] = m10;
    target[ offset + 5 ] = m11;
    target[ offset + 6 ] = m12;
    target[ offset + 7 ] = m13;
    target[ offset + 8 ] = m20;
    target[ offset + 9 ] = m21;
    target[ offset + 10 ] = m22;
    target[ offset + 11 ] = m23;
    target[ offset + 12 ] = m30;
    target[ offset + 13 ] = m31;
    target[ offset + 14 ] = m32;
    target[ offset + 15 ] = m33;
    return target;
  }

  /**
   * Fill the specified target with the matrix components.
   * The components are emitted in column-major form.
   *
   * @param target the array in which to store the matrix components. The target must be large enough to contain the matrix.
   * @return the matrix represented as an array.
   */
  @Nonnull
  public double[] toArray( @Nonnull final double[] target )
  {
    return toArray( target, 0 );
  }

  /**
   * Create an array to represent the matrix.
   * The components are emitted in column-major form.
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
    return asColumnMajorString();
  }

  /**
   * Returns a string representation of the matrix in column-major form.
   * <pre>
   * m00  m10  m20  m30
   * m01  m11  m21  m31
   * m02  m12  m22  m32
   * m03  m13  m23  m33
   * </pre>
   *
   * @return a string representation of the matrix in column-major form.
   */
  @Nonnull
  public String asColumnMajorString()
  {
    return
      m00 + " " + m10 + " " + m20 + " " + m30 + "\n" +
      m01 + " " + m11 + " " + m21 + " " + m31 + "\n" +
      m02 + " " + m12 + " " + m22 + " " + m32 + "\n" +
      m03 + " " + m13 + " " + m23 + " " + m33 + "\n";
  }

  /**
   * Returns a string representation of the matrix in row-major form.
   * <pre>
   * m00  m01  m02  m03
   * m10  m11  m12  m13
   * m20  m21  m22  m23
   * m30  m31  m32  m33
   * </pre>
   *
   * @return a string representation of the matrix in row-major form.
   */
  @Nonnull
  public String asRowMajorString()
  {
    return
      m00 + " " + m01 + " " + m02 + " " + m03 + "\n" +
      m10 + " " + m11 + " " + m12 + " " + m13 + "\n" +
      m20 + " " + m21 + " " + m22 + " " + m23 + "\n" +
      m30 + " " + m31 + " " + m32 + " " + m33 + "\n";
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
