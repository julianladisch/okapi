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

  @Test
  public void test4(TestContext context) {
    Vertx vertx = Vertx.vertx();

    vertx.createHttpServer()
      .requestHandler(x -> {})
      .listen(0)
      .compose(x -> {
            HttpClient cli = vertx.createHttpClient();
            return cli.request(HttpMethod.POST, "localhostxxx", "/test2");
      })
      .onComplete(context.asyncAssertFailure(res -> {
        context.assertTrue(res.getMessage().contains("localhostxxx"), res.getMessage());
      }));
  }

}
