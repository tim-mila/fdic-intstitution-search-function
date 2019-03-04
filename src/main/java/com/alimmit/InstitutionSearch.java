package com.alimmit;

import java.io.Serializable;

public class InstitutionSearch implements Serializable {
    private String q;

    public InstitutionSearch() {}

    public InstitutionSearch(final String q) {
        this.q = q;
    }

    public String getQ() {
        return q;
    }

    public void setQ(final String q) {
        this.q = q;
    }
}
