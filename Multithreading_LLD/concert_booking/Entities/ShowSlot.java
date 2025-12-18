package Multithreading_LLD.movie_booking.Entities;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ShowSlot {

    Slot slot;
    int capacity;
    int booked;
    Deque<BookingRequest> waitList = new ArrayDeque<>();

}
