package org.ies.tierno.building.exceptions;

import lombok.Getter;

@Getter
public class ApartmentNotFoundException extends Exception {
    private final int floor;
    private final String door;

    public ApartmentNotFoundException(int floor, String door) {
        this.floor = floor;
        this.door = door;
    }

}
