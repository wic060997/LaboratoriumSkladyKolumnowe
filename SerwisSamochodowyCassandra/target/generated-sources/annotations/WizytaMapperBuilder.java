import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.mapper.MapperBuilder;
import com.datastax.oss.driver.internal.mapper.DefaultMapperContext;
import java.lang.Override;

/**
 * Builds an instance of {@link WizytaMapper} wrapping a driver {@link CqlSession}.
 *
 * <p>Generated by the DataStax driver mapper, do not edit directly.
 */
public class WizytaMapperBuilder extends MapperBuilder<WizytaMapper> {
  public WizytaMapperBuilder(CqlSession session) {
    super(session);
  }

  @Override
  public WizytaMapper build() {
    DefaultMapperContext context = new DefaultMapperContext(session, defaultKeyspaceId, defaultExecutionProfileName, defaultExecutionProfile, customState);
    return new WizytaMapperImpl__MapperGenerated(context);
  }
}
