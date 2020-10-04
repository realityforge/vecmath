package org.realityforge.vecmath;

/**
 * Class used to access compile time settings for project.
 */
public final class Vecmath
{
  private Vecmath()
  {
  }

  /**
   * Return true if toString() methods should emit debug information.
   * The value returned is a compile-time setting that is used to strip debug methods during production builds.
   *
   * @return true if toString() methods should emit debug information.
   */
  public static boolean isDebugToStringEnabled()
  {
    return VecmathConfig.isDebugToStringEnabled();
  }

  /**
   * Return true if {@link Object#equals(Object)} and {@link Object#hashCode()} methods are implemented by geometric objects.
   * The value returned is a compile-time setting that is used to strip these methods if they are not needed. Most applications
   * will not need these methods.
   *
   * @return true if {@link Object#equals(Object)} and {@link Object#hashCode()} methods are implemented by geometric objects.
   */
  public static boolean isObjectEqualsImplemented()
  {
    return VecmathConfig.isObjectEqualsImplemented();
  }
}
