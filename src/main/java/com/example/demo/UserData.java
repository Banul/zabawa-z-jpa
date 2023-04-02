package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class UserData {
    @Id
    UUID id;
    UUID id2;
    UUID id3;
    UUID id4;
    UUID id5;
    UUID id6;
    UUID id7;
    UUID id8;
    UUID id9;
    UUID id10;

    public UserData() {
        this.id = UUID.randomUUID();
        this.id2 = UUID.randomUUID();
        this.id3 = UUID.randomUUID();
        this.id4 = UUID.randomUUID();
        this.id5 = UUID.randomUUID();
        this.id6 = UUID.randomUUID();
        this.id7 = UUID.randomUUID();
        this.id8 = UUID.randomUUID();
        this.id9 = UUID.randomUUID();
        this.id10 = UUID.randomUUID();
    }
}
