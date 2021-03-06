package org.thechiselgroup.biomixer.client.core.error_handling;

import java.util.Date;

public class ThrowableCaught {

    private final Date timeStamp;

    private final Throwable throwable;

    // maybe some additional information

    public ThrowableCaught(Throwable throwable) {
        this.timeStamp = new Date();
        this.throwable = throwable;
    }

    public ThrowableCaught(Throwable throwable, Date timeStamp) {
        this.throwable = throwable;
        this.timeStamp = timeStamp;
    }

    // @Override
    // public boolean equals(Object other) {
    // return other instanceof ThrowableCaught
    // && timeStamp.equals(((ThrowableCaught) other).getTimeStamp())
    // && throwable.equals(((ThrowableCaught) other).getThrowable());
    // }

    public Throwable getThrowable() {
        return throwable;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return timeStamp.toString() + ": " + throwable.getLocalizedMessage();
    }

}
