package org.ies.tierno.building.components;

import org.ies.tierno.building.model.Apartment;
import org.ies.tierno.building.model.Building;
import org.ies.tierno.building.model.Owner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BuildingReader implements Reader<Building> {

    private static final Logger log = LoggerFactory.getLogger(BuildingReader.class);

    private final Scanner scanner;

    private final Reader<Apartment> apartmentReader;

    public BuildingReader(Scanner scanner, Reader<Apartment> apartmentReader) {
        this.scanner = scanner;
        this.apartmentReader = apartmentReader;
    }

    @Override
    public Building read() {
        log.info("Introduce la dirección");
        String address = scanner.nextLine();

        log.info("Introduce la ciudad");
        String city = scanner.nextLine();

        int zipCode = askZipCode();

        var apartments = askApartments();
        return new Building(address, city, zipCode, apartments);
    }

    private int askZipCode() {
        Integer zipCode = null;
        do {
            log.info("Introduce el código postal");
            try {
                zipCode = scanner.nextInt();
            } catch (InputMismatchException e) {
                log.error("El valor introducido no es un entero");
            } finally {
                scanner.nextLine();
            }
        } while (zipCode == null);
        return zipCode;
    }

    public List<Apartment> askApartments() {
        List<Apartment> apartments = new ArrayList<>();
        boolean moreApartments = true;
        log.info("Apartamentos");
        do {
            log.info("Introduce apartamento");
            apartments.add(apartmentReader.read());
            log.info("¿Desea meter más apartamentos? (Y/n)");
            String response = scanner.nextLine();
            moreApartments = !response.equalsIgnoreCase("n");

        } while (moreApartments);
        return apartments;
    }
}
