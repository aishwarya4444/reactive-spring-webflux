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
}