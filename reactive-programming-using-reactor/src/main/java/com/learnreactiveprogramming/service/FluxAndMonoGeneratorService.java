package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {
    public Flux<String> namesFlux() {
        // we will get it from db or a remote service call
        // for now we pass from here
        return Flux.fromIterable(List.of("Alex", "Ben", "Chloe"));
    }

    public Mono<String> namesMono() {
        return Mono.just("Alex");
    }

    public static void main(String[] args) {
        FluxAndMonoGeneratorService fmgs = new FluxAndMonoGeneratorService();

        fmgs.namesFlux().subscribe(name -> {
            System.out.println(name);
        });

        fmgs.namesMono().subscribe(name -> {
            System.out.println(name);
        });
    }
}
