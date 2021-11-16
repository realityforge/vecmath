# vecmath

[![Build Status](https://secure.travis-ci.org/realityforge/vecmath.svg?branch=master)](http://travis-ci.org/realityforge/vecmath)
[<img src="https://img.shields.io/maven-central/v/org.realityforge.vecmath/vecmath.svg?label=latest%20release"/>](https://search.maven.org/search?q=g:org.realityforge.vecmath%20a:vecmath)
[![codecov](https://codecov.io/gh/realityforge/vecmath/branch/master/graph/badge.svg)](https://codecov.io/gh/realityforge/vecmath)
![GWT3/J2CL compatible](https://img.shields.io/badge/GWT3/J2CL-compatible-brightgreen.svg)

## What is vecmath?

Vecmath is yet another vector math library for java. It was created so that it could be optimized for usage
in WebGL and WebGPU projects.

### Getting Started

The library is released to Maven Central and can be downloaded using normal dependency download mechanisms.
The Maven dependency is:

```xml
<dependency>
  <groupId>org.realityforge.vecmath</groupId>
  <artifactId>vecmath</artifactId>
  <version>0.13</version>
</dependency>
```

# Contributing

The project was released as open source so others could benefit from the project. We are thankful for any
contributions from the community. A [Code of Conduct](CODE_OF_CONDUCT.md) has been put in place and
a [Contributing](CONTRIBUTING.md) document is under development.

# License

The project is licensed under [Apache License, Version 2.0](LICENSE).

# Credit

The toolkit took inspiration from a number of different frameworks. The authors familiarity with with the
`javax.vecmath` package from the Java3D suite means that it is likely that many affordances originated with
that package. The author was also using the [JOML](https://github.com/JOML-CI/JOML) (a `Java math library
for OpenGL rendering calculations`) and [glMatrix](https://github.com/toji/gl-matrix) (a `Javascript Matrix and
Vector library for High Performance WebGL apps`) libraries while evolving this project.
