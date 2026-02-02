package com.lld.movie.entities;

import com.lld.movie.entities.enums.SEAT_TYPE;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Seat {

    // Seat will be in form
    // rowNumber-columnNumber (cateogory)
    // in 1st row there will be 5 seat , 3 will be regular 2 premium like this

    Integer seatId;
    int row;
    int col;
    String seatNumber;
    SEAT_TYPE seatType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seat)) return false;
        Seat seat = (Seat) o;
        return seatId == seat.seatId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatId);
    }


}
