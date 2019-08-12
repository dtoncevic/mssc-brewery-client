package darko.test.msscbreweryclient.web.client;

import darko.test.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void testSaveNewBeer() {
        BeerDto newBeer = BeerDto.builder().beerName("New beer").build();

        URI uri = breweryClient.saveNewBeer(newBeer);

        assertNotNull(uri);

        System.out.printf(uri.toString());
    }

    @Test
    void testUpdate() {
        BeerDto beerDto = BeerDto.builder().beerName("New beer").build();

        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDelete() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}