package com.alimmit;

import io.micronaut.context.ApplicationContext;
import io.micronaut.core.util.StringUtils;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InstitutionSearchFunctionTest {

    @Test
    public void testFunction() throws Exception {
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class);

        InstitutionSearchClient client = server.getApplicationContext().getBean(InstitutionSearchClient.class);

        assertTrue(StringUtils.isNotEmpty(client.apply(new InstitutionSearch("Wells*")).blockingGet()));
        System.out.println(client.apply(new InstitutionSearch("Wells*")).blockingGet());
        server.stop();
    }
}
