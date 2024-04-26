package org.ies.tierno.building.components;


import org.ies.tierno.building.model.Owner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class OwnerReader implements Reader<Owner> {
    private static final Logger log = LoggerFactory.getLogger(OwnerReader.class);

    private final Scanner scanner;

    public OwnerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Owner read() {
        log.info("Introduce el nombre");
        String name = scanner.nextLine();
        log.info("Introduce los apellidos");
        String surname = scanner.nextLine();
        return new Owner(name, surname);
    }
}
