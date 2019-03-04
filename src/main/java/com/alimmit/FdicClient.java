package com.alimmit;

import io.micronaut.core.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.inject.Singleton;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Singleton
class FdicClient {

    private static final Log LOG = LogFactory.getLog(FdicClient.class);
    private static final String HOST = "https://banks.data.fdic.gov";
    private static final String HOST_API = HOST + "/api";

    String query(final String input) {
        try {
            LOG.info("query: " + input);
            final HttpClient client = HttpClientBuilder.create().build();
            final HttpGet get = new HttpGet(HOST_API + "/institutions?filters=NAME%3A" + input + "%20AND%20ACTIVE%3A1&sort_by=OFFICES&sort_order=DESC&limit=10&offset=0&format=json");
            final HttpResponse response = client.execute(get);
            return IOUtils.readText(new BufferedReader(new InputStreamReader(response.getEntity().getContent())));
        }
        catch(Exception e) {
            LOG.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
