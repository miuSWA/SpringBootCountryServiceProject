package com.example.springbootcountryserviceproject.services;

import com.example.springbootcountryserviceproject.beans.Country;
import com.example.springbootcountryserviceproject.controllers.AddResponse;
import com.example.springbootcountryserviceproject.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class CountryService {

    @Autowired
    CountryRepository countryrep;


    public List<Country> getAllCountries(){

        return countryrep.findAll();

    }
    public Country getCountrybyID(int id){
       return countryrep.findById(id).get();
    }
    public Country getCountrybyName(String countryName) {
        List<Country> countries = countryrep.findAll();
        Country country = null;

        for (Country con : countries) {

            if (con.getCountryName().equalsIgnoreCase(countryName))
                country = con;
        }

        return country;

    }
    public Country addCountry(Country country){
        country.setId(getMaxId());
        countryrep.save(country);

        return country;

    }
    public int getMaxId(){
        return countryrep.findAll().size()+1;
    }
    public Country updateCountry(Country country){
        countryrep.save(country);
        return country;

    }
    public AddResponse deleteCountry(int id){
        countryrep.deleteById(id);
        AddResponse res = new AddResponse();
        res.setMsg("Country Deleted !");
        res.setId(id);

        return res;

    }
}
