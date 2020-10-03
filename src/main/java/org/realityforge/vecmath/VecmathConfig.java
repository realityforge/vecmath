package org.realityforge.vecmath;

import grim.annotations.OmitType;
import javax.annotation.Nonnull;

/**
 * Location of all compile time configuration settings for framework.
 */
@SuppressWarnings( "FieldMayBeFinal" )
@OmitType
final class VecmathConfig
{
  @Nonnull
  private static final ConfigProvider PROVIDER = new ConfigProvider();
  private static final boolean PRODUCTION_ENVIRONMENT = PROVIDER.isProductionEnvironment();
  private static boolean CONFIG_isDebugToStringEnabled = PROVIDER.isDebugToStringEnabled();

  private VecmathConfig()
  {
  }

  static boolean isDevelopmentEnvironment()
  {
    return !isProductionEnvironment();
  }

  static boolean isProductionEnvironment()
  {
    return PRODUCTION_ENVIRONMENT;
  }

  static boolean isDebugToStringEnabled()
  {
    return CONFIG_isDebugToStringEnabled;
  }

  private static final class ConfigProvider
    extends AbstractConfigProvider
  {
    @GwtIncompatible
    @Override
    boolean isProductionEnvironment()
    {
      return "production".equals( System.getProperty( "vecmath.environment", "production" ) );
    }

    @GwtIncompatible
    @Override
    boolean isDebugToStringEnabled()
    {
      return "true".equals( System.getProperty( "vecmath.isDebugToStringEnabled",
                                                isProductionEnvironment() ? "false" : "true" ) );
    }
  }

  @SuppressWarnings( { "unused", "StringEquality" } )
  private static abstract class AbstractConfigProvider
  {
    boolean isProductionEnvironment()
    {
      return "production" == System.getProperty( "vecmath.environment" );
    }

    boolean isDebugToStringEnabled()
    {
      return "true" == System.getProperty( "vecmath.isDebugToStringEnabled" );
    }
  }
}
