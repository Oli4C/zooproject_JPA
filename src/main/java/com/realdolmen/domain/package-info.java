@NamedQueries({
        @NamedQuery(name = "findAllTigers", query = "select t From Tiger t"),
        @NamedQuery(name = "findTigerById", query = "select t From Tiger t where t.id = :id"),
        @NamedQuery(name = "findAllFood", query = "select f From Food f"),
})

package com.realdolmen.domain;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;