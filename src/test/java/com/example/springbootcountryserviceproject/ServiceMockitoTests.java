package com.example.springbootcountryserviceproject;

import com.example.springbootcountryserviceproject.beans.Country;
import com.example.springbootcountryserviceproject.repositories.CountryRepository;
import com.example.springbootcountryserviceproject.services.CountryService;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = {ServiceMockitoTests.class})
public class ServiceMockitoTests {

    @Mock
    CountryRepository countryRepo;

    @InjectMocks
    CountryService countryService;

    public List<Country> mycountries;

    @Test
    //@Order(1)
    public void test_getAllCountries(){

        List<Country> mycountries = new ArrayList<>();
        mycountries.add(new Country(1, "India", "Delhi"));
        mycountries.add(new Country(2, "USA", "Washington"));

        when(countryRepo.findAll()).thenReturn(mycountries);
        assertEquals(2,countryService.getAllCountries().size());
    }
}
