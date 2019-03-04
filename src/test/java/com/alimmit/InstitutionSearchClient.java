package com.alimmit;

import io.micronaut.function.client.FunctionClient;
import io.micronaut.http.annotation.Body;
import io.reactivex.Single;

import javax.inject.Named;

@FunctionClient
public interface InstitutionSearchClient {

    @Named("fdic-institution-search")
    Single<String> apply(@Body InstitutionSearch request);
}
