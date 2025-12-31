package com.lld.movie.concurrency;

import com.lld.movie.entities.Seat;
import com.lld.movie.entities.Show;
import com.lld.movie.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SeatLock {

    private Show show; // The show for which the seat is locked.
    private Seat seat; // The specific seat that is locked.
    private User lockedBy; // Identifier of the user or process that holds the lock.
    private LocalDateTime lockTime; // The timestamp when the lock was acquired.

    private LocalDateTime lockExpiryTime; // The timestamp when the lock will expire.

    public SeatLock(Show show, Seat seat, User lockedBy, LocalDateTime lockTime) {
        this.show = show;
        this.seat = seat;
        this.lockedBy = lockedBy;
        this.lockTime = lockTime;
        this.lockExpiryTime = lockTime.plusSeconds(60); // Example: lock expires after 1 min
    }

}
