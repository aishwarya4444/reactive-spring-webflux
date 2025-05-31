package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {

    public Flux<String> namesFlux() {
        // we will get it from db or a remote service call
        // for now we pass from here
        return Flux.fromIterable(List.of("Alex", "Ben", "Chloe")).log();
    }

    public Flux<String> namesFlux_map() {
        // we will get it from db or a remote service call
        // for now we pass from here
        return Flux.fromIterable(List.of("Alex", "Ben", "Chloe"))
                .map(String::toUpperCase)
//                .map(str -> str.toUpperCase())
                .log();
    }

    public Flux<String> namesFlux_mapImmutability() {
        var namesFlux = Flux.fromIterable(List.of("Alex", "Ben", "Chloe"));
        // flux is immutable
        // so even if i do UpperCase .. it will not make any change
        namesFlux.map(String::toUpperCase);
        return namesFlux;
    }

    public Flux<String> namesFlux_filter(int len) {
        return Flux.fromIterable(List.of("Alex", "Ben", "Chloe"))
                .filter(str -> str.length() > len)
                .map(String::toUpperCase)
                .map(s -> s.length()+"-"+s)
                .log();
    }

    public Mono<String> namesMono() {
        return Mono.just("Alex").log();
    }

    public static void main(String[] args) {
        FluxAndMonoGeneratorService fmgs = new FluxAndMonoGeneratorService();

        fmgs.namesFlux().subscribe(name -> {
            System.out.println(name);
        });

        fmgs.namesMono().subscribe(name -> {
            System.out.println(name);
        });

        fmgs.namesFlux_map().subscribe(System.out::println);
    }
}
