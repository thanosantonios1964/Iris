package com.example.iris.domain;

public record IrisResponse(long id, String randomJoke) {
    @Override
    public long id() {
        return id;
    }

    @Override
    public String randomJoke() {
        return randomJoke;
    }
}
