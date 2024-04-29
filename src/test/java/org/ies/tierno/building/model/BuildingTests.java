package org.ies.tierno.building.model;

import org.junit.Test;

import java.util.List;

public class BuildingTests {

    @Test
    public void getApartmentTest() {
        // Preparación
        List<Apartment> apartments = List.of(
                new Apartment(1, "B",
                        List.of(
                                new Owner("Bob", "Esponja")
                        )
                ),
                new Apartment(2, "B",
                        List.of(
                                new Owner("Peppa", "Pig")
                        )
                )
        );
        Building building = new Building(
                "Gran Vía",
                "Madrid",
                28000,
                apartments
        );

        int floor = 2;
        String door = "B";
        // Ejecutar el test



        // Realizar comprobaciones (Assert)

    }
}
