package com.alimmit;

import java.io.Serializable;

public class InstitutionSearch implements Serializable {
    private String q;
    private String[] fields;

    public InstitutionSearch() {}

    InstitutionSearch(final String q) {
        this(q, new String[] {});
    }

    InstitutionSearch(final String q, final String[] fields) {
        this.q = q;
        this.fields = fields;
    }

    public String getQ() {
        return q;
    }

    public void setQ(final String q) {
        this.q = q;
    }

    public String[] getFields() {
        return fields;
    }

    public void setFields(final String[] fields) {
        this.fields = fields;
    }
}
