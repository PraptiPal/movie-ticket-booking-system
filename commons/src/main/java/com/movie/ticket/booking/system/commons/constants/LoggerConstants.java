package com.movie.ticket.booking.system.commons.constants;

public enum LoggerConstants {

    ENTERED_CONTROLLER_MESSAGE("Entered {} controller of {} class with value {}"),
    EXITING_CONTROLLER_MESSAGE("Exiting {} controller of {} class with value {}"),
    ENTERED_SERVICE_MESSAGE("Entered {} service of {} class with value {}"),
    EXITING_SERVICING_MESSAGE("Entered {} service of {} class with value {}");

    private final String value;

    LoggerConstants(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
