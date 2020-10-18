# Change Log

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
