package com.abn.grpcSample.SampleBuilder;

public class GreetManyTimesRequestBuilder {

    Greeting greeting;
    GreetManyTimes greetManyTimes;

    public GreetManyTimesRequestBuilder() {

        greetManyTimes = new GreetManyTimes();
        greeting = new Greeting();
        greetManyTimes.setGreeting(greeting);


        greeting.setFirst_name("ABN");
        greeting.setLast_name("Stream");
    }

    public GreetManyTimes build() {

        return greetManyTimes;

    }
}
