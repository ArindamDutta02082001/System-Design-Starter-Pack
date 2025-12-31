package com.lld.movie.entities;

import com.lld.movie.entities.enums.SEAT_TYPE;
import lombok.Getter;

@Getter
public class Seat {

    // Seat will be in form   rowNumber-columnNumber

    Integer seatId;
    String seatNumber;
    SEAT_TYPE seatType;

}
