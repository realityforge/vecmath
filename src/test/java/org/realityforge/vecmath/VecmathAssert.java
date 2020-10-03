package org.realityforge.vecmath;

import javax.annotation.Nonnull;
import org.testng.Assert;

public abstract class VecmathAssert
{
  private VecmathAssert()
  {
  }

  public static void assertEquals( @Nonnull final Vec3f vec3f, final float x, final float y, final float z )
  {
    Assert.assertEquals( vec3f.x, x, 0.00001 );
    Assert.assertEquals( vec3f.y, y, 0.00001 );
    Assert.assertEquals( vec3f.z, z, 0.00001 );
  }
}
