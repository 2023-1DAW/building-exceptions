package org.ies.tierno.building.model;

import org.ies.tierno.building.exceptions.ApartmentNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BuildingTests {

    // Preparación
    private Apartment apartment1B = new Apartment(1, "B",
            List.of(
                    new Owner("Bob", "Esponja")
            )
    );
    private Apartment apartment2B =  new Apartment(2, "B",
            List.of(
                    new Owner("Peppa", "Pig")
            )
    );
    private List<Apartment> apartments = List.of(
            apartment1B,
            apartment2B
    );
    private Building building = new Building(
            "Gran Vía",
            "Madrid",
            28000,
            apartments
    );

    @Test
    public void getApartment2BTest() throws ApartmentNotFoundException {
        // Ejecutar el test
        Apartment apartment = building.getApartment(2, "B");

        // Realizar comprobaciones (Assert)
        Assert.assertEquals(apartment2B, apartment);
    }

    @Test(expected = ApartmentNotFoundException.class)
    public void getApartment3BTest() throws ApartmentNotFoundException {
        // Ejecutar el test
        building.getApartment(3, "B");
    }


}
