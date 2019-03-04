package com.alimmit;

import io.micronaut.function.FunctionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

@FunctionBean("fdic-institution-search")
public class InstitutionSearchFunction implements Function<InstitutionSearch, String> {

    private static final Logger LOG = LoggerFactory.getLogger(InstitutionSearchFunction.class);

    private final FdicClient fdicClient;

    public InstitutionSearchFunction(final FdicClient fdicClient) {
        this.fdicClient = fdicClient;
    }

    @Override
    public String apply(final InstitutionSearch search) {
        return fdicClient.query(search.getQ());
    }
}
