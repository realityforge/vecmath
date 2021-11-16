# Change Log

### Unreleased

* Update the `org.realityforge.grim` artifacts to version `0.06`.
* Add `Vector3d.mult(Matrix4d)` method.
* Add the `Matrix4d.setOrthographic(...)` support method.

### [v0.12](https://github.com/realityforge/vecmath/tree/v0.12) (2021-08-13) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.11...v0.12)

Changes in this release:

* Add constants `COMPONENTS`, `BYTES`, `SIZE`, `FLOAT_SIZE` and `FLOAT_BYTES` to the types `Matrix4d`, `Vector2d`, `Vector3f`, `Vector3d` and `Vector4d` to simplify operations when manipulating buffers containing these values.

### [v0.11](https://github.com/realityforge/vecmath/tree/v0.11) (2021-08-09) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.10...v0.11)

Changes in this release:

* Remove test dependencies from the pom as not needed by downstream libraries.
* Make the `org.realityforge.grim` dependency transitive in the generated pom to reflect actual intent.

### [v0.10](https://github.com/realityforge/vecmath/tree/v0.10) (2021-08-09) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.09...v0.10)

Changes in this release:

* Upgrade the `org.realityforge.grim` artifacts to version `0.05`.
* Upgrade the `au.com.stocksoftware.idea.codestyle` artifact to version `1.17`.
* Add `Matrix4d.multiply(...)` static and instance methods.

### [v0.09](https://github.com/realityforge/vecmath/tree/v0.09) (2021-01-17)
[Full Changelog](https://github.com/realityforge/vecmath/compare/v0.08...v0.09)

* Upgrade the `org.realityforge.org.jetbrains.annotations` artifact to version `1.7.0`.
* Add `Matrix4d.setTranslation(x,y,z)` method to change matrix into translation matrix.
* Add `Matrix4d.translate(...)` methods to support applying a translation to a matrix.
* Change the way that the `Matrix4d.toArray(...)` layout the matrix in the array to align with OpenGL conventions.
* Rename `Matrix4d.identity()` method to `Matrix4d.setIdentity()` to follow the conventions that methods that set the values of the matrix rather than applying an operation are prefixed with set.
* Add `Matrix4d.setScale(...)` methods to change matrix into a scaling matrix.
* Add `Matrix4d.scale(...)` methods to support applying a scale operation to a matrix.
* Change the `Matrix4d.asString()` method to layout the matrix components in multi-line column major format rather than a single line row-major format. Introduce the methods `Matrix4d.asColumnMajorString()` and `Matrix4d.asRowMajorString()` so that the desired string form can be explicitly requested.
* Add `Matrix4d.setPerspective(...)` method to set matrix up with a perspective projection.
* Add basic rotations to `Matrix4d` in the form `Matrix4d.rotateX(double)`, `Matrix4d.rotateY(double)` and `Matrix4d.rotateZ(double)`.
* Add the `Matrix4d.lookAt(eye,center,up)` helper method to apply the "lookAt" transformation.

### [v0.08](https://github.com/realityforge/vecmath/tree/v0.08) (2020-10-24)
[Full Changelog](https://github.com/realityforge/vecmath/compare/v0.07...v0.08)

* Update javadocs in `Vector*` classes to indicate that the `toString()` method may be optimized out depending on the values of some compile-time settings.
* Introduce a method named `asString()` to the `Vector*` classes to return a string representation of the vectors that
  will not be optimized out if it is used, regardless of the compile time settings.
* Create a minimal `Matrix4d` matrix.
* Add a `toArray()` method to the `Vector*` classes to support extracting the vector components as an array of values.
* Remove the unused `z` parameter from the `Vector2d.sub(...)` method.
* Add a `lengthSquared()` method to the `Vector*` classes to support retrieving the suared magnitude of the vector. This allows the caller to minimize the number of invocations to sqrt if multiple length values are added or subtracted.
* Create a 4-dimensional, double-precision, floating-point vector class named `Vector4d`.

### [v0.07](https://github.com/realityforge/vecmath/tree/v0.07) (2020-10-18)
[Full Changelog](https://github.com/realityforge/vecmath/compare/v0.06...v0.07)

* Add a 2-dimensional, double-precision, floating-point vector named `Vector2d`.

### [v0.06](https://github.com/realityforge/vecmath/tree/v0.06) (2020-10-18)
[Full Changelog](https://github.com/realityforge/vecmath/compare/v0.05...v0.06)

* Add `div` (scalar divide) method to `Vector3[fd]`.

### [v0.05](https://github.com/realityforge/vecmath/tree/v0.05) (2020-10-18)
[Full Changelog](https://github.com/realityforge/vecmath/compare/v0.04...v0.05)

* Add `lerp` (linear interpolation) methods to `Vector3[fd]`.

### [v0.04](https://github.com/realityforge/vecmath/tree/v0.04) (2020-10-18)
[Full Changelog](https://github.com/realityforge/vecmath/compare/v0.03...v0.04)

* Add `Vector3f.isEqualTo(Vector3f)` method that can be invoked even if the `vecmath.isObjectEqualsImplemented`
  compile-time constant is set to `false`.
* Introduce a `Vector3d` which has feature parity with `Vector3f` except that the components are represented
  using double precision floating point numbers.

### [v0.03](https://github.com/realityforge/vecmath/tree/v0.03) (2020-10-04)
[Full Changelog](https://github.com/realityforge/vecmath/compare/v0.02...v0.03)

* Add a compile time setting that controls whether the `Vector3f` overrides `Object.equals(Object)` and
  `Object.hashCode()` methods. These methods are very difficult for GWT and/or J2CL to optimize away but
  are rarely needed for geometric objects. The compile setting defaults to omitting these methods but still
  allows the applciation developer to opt-in to including the methods if required.

### [v0.02](https://github.com/realityforge/vecmath/tree/v0.02) (2020-10-04)
[Full Changelog](https://github.com/realityforge/vecmath/compare/v0.01...v0.02)

* Add missing inherit of `grim.annotations.Annotations` gwt module into `org.realityforge.vecmath.Vecmath`.
* Add a `Vector3f.angle(Vector3f)` method to calculate the angle between two vectors.

### [v0.01](https://github.com/realityforge/vecmath/tree/v0.01) (2020-10-03)
[Full Changelog](https://github.com/realityforge/vecmath/compare/c629a14f7295a371410e3a500d252917a8ee0c33...v0.01)

🎉 Initial super-alpha release 🎉.
