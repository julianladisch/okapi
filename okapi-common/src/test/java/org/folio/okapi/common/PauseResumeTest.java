package org.folio.okapi.common;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class PauseResumeTest {

  private Vertx vertx;

  @Before
  public void setUp(TestContext context) {
    vertx = Vertx.vertx();

    vertx.createHttpServer()
      .requestHandler(x -> {})
      .listen(0)
      .onComplete(context.asyncAssertSuccess());
  }

  @Test
  public void test4(TestContext context) {
    HttpClient cli = vertx.createHttpClient();
    cli.request(HttpMethod.GET, "example.invalid", "/").onComplete(context.asyncAssertFailure(res -> {
      context.assertTrue(res.getMessage().contains("example.invalid"), res.getMessage());
    }));
  }

}
