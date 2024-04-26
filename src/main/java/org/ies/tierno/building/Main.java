package org.ies.tierno.building;

import org.ies.tierno.building.components.ApartmentReader;
import org.ies.tierno.building.components.BuildingReader;
import org.ies.tierno.building.components.OwnerReader;
import org.ies.tierno.building.components.Reader;
import org.ies.tierno.building.exceptions.ApartmentNotFoundException;
import org.ies.tierno.building.model.Apartment;
import org.ies.tierno.building.model.Building;
import org.ies.tierno.building.model.Owner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var ownerReader = new OwnerReader(scanner);
        var apartmentReader = new ApartmentReader(scanner, ownerReader);
        Reader<Building> buildingReader = new BuildingReader(scanner, apartmentReader);

        var building = buildingReader.read();
        try {
            Apartment apartment = building.getApartment(2, "A");
            log.info(apartment.toString());

            var owners = building.getApartmentOwners(1, "A");
            log.info(owners.toString());
        } catch (ApartmentNotFoundException e) {
            log.error("No se ha encontrado el apartamento " + e.getFloor() + e.getDoor());
        }
    }
}