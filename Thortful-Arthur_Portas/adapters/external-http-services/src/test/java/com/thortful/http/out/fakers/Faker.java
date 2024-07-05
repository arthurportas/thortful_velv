package com.thortful.http.out.fakers;


public class Faker extends com.github.javafaker.Faker {

    public final DomainFaker domain = new DomainFaker();

    public final ExternalServicesFaker external = new ExternalServicesFaker();
}
