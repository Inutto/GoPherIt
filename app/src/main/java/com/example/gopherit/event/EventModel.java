package com.example.gopherit.event;

import ir.mirrajabi.searchdialog.core.Searchable;

public class EventModel implements Searchable {

    private String name;

    public EventModel(String name) {
        this.name = name;
    }

    @Override
    public String getTitle() {
        return name;
    }
}
