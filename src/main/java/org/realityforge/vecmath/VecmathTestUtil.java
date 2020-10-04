package org.realityforge.vecmath;

import java.lang.reflect.Field;
import javax.annotation.Nonnull;

/**
 * Utility class for interacting with Vecmath config settings in tests.
 */
@SuppressWarnings( "WeakerAccess" )
@GwtIncompatible
public final class VecmathTestUtil
{
  private VecmathTestUtil()
  {
  }
  /**
   * Reset the state of Arez config to either production or development state.
   *
   * @param productionMode true to set it to production mode configuration, false to set it to development mode config.
   */
  public static void resetConfig( final boolean productionMode )
  {
    if ( VecmathConfig.isProductionEnvironment() )
    {
      /*
       * This should really never happen but if it does add assertion (so code stops in debugger) or
       * failing that throw an exception.
       */
      assert VecmathConfig.isDevelopmentEnvironment();
      throw new IllegalStateException( "Unable to reset config as Vecmath is in production mode" );
    }

    if ( productionMode )
    {
      disableDebugToString();
    }
    else
    {
      enableDebugToString();
    }
    disableObjectEquals();
  }

  /**
   * Set the `vecmath.isDebugToStringEnabled` setting to true.
   */
  public static void enableDebugToString()
  {
    setDebugToString( true );
  }

  /**
   * Set the `vecmath.isDebugToStringEnabled` setting to false.
   */
  public static void disableDebugToString()
  {
    setDebugToString( false );
  }

  /**
   * Configure the `vecmath.isDebugToStringEnabled` setting.
   *
   * @param value the setting.
   */
  private static void setDebugToString( final boolean value )
  {
    setConstant( "CONFIG_isDebugToStringEnabled", value );
  }

  /**
   * Set the `vecmath.isDebugToStringEnabled` setting to true.
   */
  public static void enableObjectEquals()
  {
    setObjectEquals( true );
  }

  /**
   * Set the `vecmath.isObjectEqualsImplemented` setting to false.
   */
  public static void disableObjectEquals()
  {
    setObjectEquals( false );
  }

  /**
   * Configure the `vecmath.isObjectEqualsImplemented` setting.
   *
   * @param value the setting.
   */
  private static void setObjectEquals( final boolean value )
  {
    setConstant( "CONFIG_isObjectEqualsImplemented", value );
  }

  /**
   * Set the specified field name on VecmathConfig.
   */
  @SuppressWarnings( { "NonJREEmulationClassesInClientCode", "SameParameterValue" } )
  private static void setConstant( @Nonnull final String fieldName, final boolean value )
  {
    if ( VecmathConfig.isProductionEnvironment() )
    {
      /*
       * This should really never happen but if it does add assertion (so code stops in debugger) or
       * failing that throw an exception.
       */
      assert VecmathConfig.isDevelopmentEnvironment();
      throw new IllegalStateException( "Unable to change constant " + fieldName + " as Vecmath is in production mode" );
    }
    else
    {
      try
      {
        final Field field = VecmathConfig.class.getDeclaredField( fieldName );
        field.setAccessible( true );
        field.set( null, value );
      }
      catch ( final NoSuchFieldException | IllegalAccessException e )
      {
        throw new IllegalStateException( "Unable to change constant " + fieldName, e );
      }
    }
  }
}
