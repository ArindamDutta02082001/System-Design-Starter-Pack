package com.lld.notification.entities.enums;


public enum LOG_LEVEL {

    // DEBUG, INFO, WARN, ERROR, FATAL
    DEBUG(5),
    FATAL(1),
    INFO(4),
    WARN(3),
    ERROR(2);


    int n ;

    LOG_LEVEL( int n )
    {
        this.n = n;
    }

    public int getLevel()
    {
        return this.n;
    }
}
