package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMonoGeneratorServiceTest {
    FluxAndMonoGeneratorService fmgs = new FluxAndMonoGeneratorService();

    @Test
    void namesFlux() {
        //given
        //when
        var namesFlux = fmgs.namesFlux();
        //then
        StepVerifier.create(namesFlux)
                .expectNext("Alex", "Ben", "Chloe")
                .verifyComplete();
    }

    @Test
    void namesFluxCount() {
        //given
        //when
        var namesFlux = fmgs.namesFlux();
        //then
        StepVerifier.create(namesFlux)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void namesFlux1Name2Count() {
        //given
        //when
        var namesFlux = fmgs.namesFlux();
        //then
        StepVerifier.create(namesFlux)
                .expectNext("Alex")
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void namesFlux_map() {
        var namesFlux = fmgs.namesFlux_map();
        StepVerifier.create(namesFlux)
                .expectNext("ALEX", "BEN", "CHLOE")
                .verifyComplete();
    }

    @Test
    void namesFlux_mapImmutability() {
        var namesFlux = fmgs.namesFlux_mapImmutability();
        StepVerifier.create(namesFlux)
                .expectNext("Alex", "Ben", "Chloe")
                .verifyComplete();
    }

    @Test
    void namesFlux_filter() {
        var namesFlux = fmgs.namesFlux_filter(3);
        StepVerifier.create(namesFlux)
                .expectNext("4-ALEX", "5-CHLOE")
                .verifyComplete();
    }
}