package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;

import java.util.List;

public class FluxAndMonoGeneratorService {
    public Flux<String> namesFlux() {
        // we will get it from db or a remote service call
        // for now we pass from here
        return Flux.fromIterable(List.of("Alex", "Ben", "Chloe"));
    }

    public static void main(String[] args) {
        FluxAndMonoGeneratorService fmgs = new FluxAndMonoGeneratorService();

        fmgs.namesFlux().subscribe(name -> {
            System.out.println(name);
        });
    }
}
