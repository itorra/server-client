package com.exc0502;


/**
 * Created by ido on 11/05/15.
 */
public interface StringProducer {
    public void addConsumer(StringConsumer sc);
    public void removeConsumer(StringConsumer sc);
}
