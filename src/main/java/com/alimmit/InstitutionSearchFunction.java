package com.alimmit;

import com.alimmit.query.FdicQuery;
import com.alimmit.query.Filter;
import io.micronaut.function.FunctionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

@FunctionBean("fdic-institution-search")
public class InstitutionSearchFunction implements Function<InstitutionSearch, String> {

    private static final Logger LOG = LoggerFactory.getLogger(InstitutionSearchFunction.class);

    @Override
    public String apply(final InstitutionSearch search) {
        final FdicQuery query = FdicQuery.from(Endpoint.Institution)
                .filter(Filter.and(Filter.value("ACTIVE", "1"), Filter.value("NAME", search.getQ())));

        if (null != search.getFields() && search.getFields().length > 0) {
            query.fields(search.getFields());
        }
        return new FdicClient().query(query);
    }
}
