package com.pasmata.dynamicallyautocompletetextview.model;

import java.util.List;

/**
 * Created by jhon on 29/03/17.
 */
public class User {

    private List<Item> items = null;
    private Pagination pagination;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}