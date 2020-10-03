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
}
