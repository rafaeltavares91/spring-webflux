package com.example.springwebflux.controller;

import com.example.springwebflux.domain.Vendor;
import com.example.springwebflux.repository.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class VendorControllerTest {

    private WebTestClient webTestClient;
    private VendorRepository vendorRepository;
    private VendorController vendorController;

    @Before
    public void setUp() {
        vendorRepository = Mockito.mock(VendorRepository.class);
        vendorController = new VendorController(vendorRepository);
        webTestClient = WebTestClient.bindToController(vendorController).build();
    }

    @Test
    public void list() {
        BDDMockito.given(vendorRepository.findAll())
                .willReturn(Flux.just(
                        Vendor.builder().firstName("Rafael").lastName("Tavares").build(),
                        Vendor.builder().firstName("Gabriel").lastName("Pires").build()));

        webTestClient.get().uri("/vendors")
                .exchange()
                .expectBodyList(Vendor.class)
                .hasSize(2);
    }

    @Test
    public void getById() {
        BDDMockito.given(vendorRepository.findById("someId"))
                .willReturn(Mono.just(
                        Vendor.builder().firstName("Rafael").lastName("Tavares").build()));

        webTestClient.get().uri("/vendors/someId")
                .exchange()
                .expectBody(Vendor.class);
    }

}
