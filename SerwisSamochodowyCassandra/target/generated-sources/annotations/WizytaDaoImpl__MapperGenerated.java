import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.BoundStatementBuilder;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.mapper.MapperContext;
import com.datastax.oss.driver.api.mapper.entity.saving.NullSavingStrategy;
import com.datastax.oss.driver.internal.core.util.concurrent.BlockingOperation;
import com.datastax.oss.driver.internal.core.util.concurrent.CompletableFutures;
import com.datastax.oss.driver.internal.mapper.DaoBase;
import com.datastax.oss.driver.internal.querybuilder.update.DefaultUpdate;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Override;
import java.lang.Throwable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generated by the DataStax driver mapper, do not edit directly.
 */
public class WizytaDaoImpl__MapperGenerated extends DaoBase implements WizytaDao {
  private static final Logger LOG = LoggerFactory.getLogger(WizytaDaoImpl__MapperGenerated.class);

  private final WizytaHelper__MapperGenerated wizytaHelper;

  private final PreparedStatement findByIdStatement;

  private final PreparedStatement saveStatement;

  private final PreparedStatement updateStatement;

  private final PreparedStatement deleteStatement;

  private WizytaDaoImpl__MapperGenerated(MapperContext context,
      WizytaHelper__MapperGenerated wizytaHelper, PreparedStatement findByIdStatement,
      PreparedStatement saveStatement, PreparedStatement updateStatement,
      PreparedStatement deleteStatement) {
    super(context);
    this.wizytaHelper = wizytaHelper;
    this.findByIdStatement = findByIdStatement;
    this.saveStatement = saveStatement;
    this.updateStatement = updateStatement;
    this.deleteStatement = deleteStatement;
  }

  @Override
  public Wizyta findById(Integer id) {
    BoundStatementBuilder boundStatementBuilder = findByIdStatement.boundStatementBuilder();

    boundStatementBuilder = boundStatementBuilder.set("id", id, Integer.class);

    BoundStatement boundStatement = boundStatementBuilder.build();
    return executeAndMapToSingleEntity(boundStatement, wizytaHelper);
  }

  @Override
  public void save(Wizyta wizyta) {
    BoundStatementBuilder boundStatementBuilder = saveStatement.boundStatementBuilder();
    wizytaHelper.set(wizyta, boundStatementBuilder, NullSavingStrategy.DO_NOT_SET);

    BoundStatement boundStatement = boundStatementBuilder.build();
    execute(boundStatement);
  }

  @Override
  public void update(Wizyta wizyta) {
    BoundStatementBuilder boundStatementBuilder = updateStatement.boundStatementBuilder();
    wizytaHelper.set(wizyta, boundStatementBuilder, NullSavingStrategy.DO_NOT_SET);

    BoundStatement boundStatement = boundStatementBuilder.build();
    execute(boundStatement);
  }

  @Override
  public void delete(Wizyta wizyta) {
    BoundStatementBuilder boundStatementBuilder = deleteStatement.boundStatementBuilder();

    boundStatementBuilder = boundStatementBuilder.set("id", wizyta.getId(), Integer.class);

    BoundStatement boundStatement = boundStatementBuilder.build();
    execute(boundStatement);
  }

  public static CompletableFuture<WizytaDao> initAsync(MapperContext context) {
    LOG.debug("[{}] Initializing new instance for keyspace = {} and table = {}",
        context.getSession().getName(),
        context.getKeyspaceId(),
        context.getTableId());
    throwIfProtocolVersionV3(context);
    try {
      // Initialize all entity helpers
      WizytaHelper__MapperGenerated wizytaHelper = new WizytaHelper__MapperGenerated(context);
      if ((Boolean)context.getCustomState().get("datastax.mapper.schemaValidationEnabled")) {
        wizytaHelper.validateEntityFields();
      }
      List<CompletionStage<PreparedStatement>> prepareStages = new ArrayList<>();
      // Prepare the statement for `findById(java.lang.Integer)`:
      SimpleStatement findByIdStatement_simple = wizytaHelper.selectByPrimaryKeyParts(1).build();
      LOG.debug("[{}] Preparing query `{}` for method findById(java.lang.Integer)",
          context.getSession().getName(),
          findByIdStatement_simple.getQuery());
      CompletionStage<PreparedStatement> findByIdStatement = prepare(findByIdStatement_simple, context);
      prepareStages.add(findByIdStatement);
      // Prepare the statement for `save(Wizyta)`:
      SimpleStatement saveStatement_simple = wizytaHelper.insert().build();
      LOG.debug("[{}] Preparing query `{}` for method save(Wizyta)",
          context.getSession().getName(),
          saveStatement_simple.getQuery());
      CompletionStage<PreparedStatement> saveStatement = prepare(saveStatement_simple, context);
      prepareStages.add(saveStatement);
      // Prepare the statement for `update(Wizyta)`:
      SimpleStatement updateStatement_simple = SimpleStatement.newInstance(((DefaultUpdate)wizytaHelper.updateByPrimaryKey()).asCql());
      LOG.debug("[{}] Preparing query `{}` for method update(Wizyta)",
          context.getSession().getName(),
          updateStatement_simple.getQuery());
      CompletionStage<PreparedStatement> updateStatement = prepare(updateStatement_simple, context);
      prepareStages.add(updateStatement);
      // Prepare the statement for `delete(Wizyta)`:
      SimpleStatement deleteStatement_simple = wizytaHelper.deleteByPrimaryKeyParts(1).build();
      LOG.debug("[{}] Preparing query `{}` for method delete(Wizyta)",
          context.getSession().getName(),
          deleteStatement_simple.getQuery());
      CompletionStage<PreparedStatement> deleteStatement = prepare(deleteStatement_simple, context);
      prepareStages.add(deleteStatement);
      // Initialize all method invokers
      // Build the DAO when all statements are prepared
      return CompletableFutures.allSuccessful(prepareStages)
          .thenApply(v -> (WizytaDao) new WizytaDaoImpl__MapperGenerated(context,
              wizytaHelper,
              CompletableFutures.getCompleted(findByIdStatement),
              CompletableFutures.getCompleted(saveStatement),
              CompletableFutures.getCompleted(updateStatement),
              CompletableFutures.getCompleted(deleteStatement)))
          .toCompletableFuture();
    } catch (Throwable t) {
      return CompletableFutures.failedFuture(t);
    }
  }

  public static WizytaDao init(MapperContext context) {
    BlockingOperation.checkNotDriverThread();
    return CompletableFutures.getUninterruptibly(initAsync(context));
  }
}
