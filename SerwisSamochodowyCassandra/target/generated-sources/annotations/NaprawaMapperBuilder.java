import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.mapper.MapperBuilder;
import com.datastax.oss.driver.internal.mapper.DefaultMapperContext;
import java.lang.Override;

/**
 * Builds an instance of {@link NaprawaMapper} wrapping a driver {@link CqlSession}.
 *
 * <p>Generated by the DataStax driver mapper, do not edit directly.
 */
public class NaprawaMapperBuilder extends MapperBuilder<NaprawaMapper> {
  public NaprawaMapperBuilder(CqlSession session) {
    super(session);
  }

  @Override
  public NaprawaMapper build() {
    DefaultMapperContext context = new DefaultMapperContext(session, defaultKeyspaceId, defaultExecutionProfileName, defaultExecutionProfile, customState);
    return new NaprawaMapperImpl__MapperGenerated(context);
  }
}
