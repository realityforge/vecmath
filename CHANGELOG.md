# Change Log

### Unreleased

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
