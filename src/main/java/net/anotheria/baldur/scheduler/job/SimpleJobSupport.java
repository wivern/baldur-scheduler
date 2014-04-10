package net.anotheria.baldur.scheduler.job;

import net.anotheria.baldur.scheduler.Scheduler;
import net.anotheria.portalkit.services.common.scheduledqueue.Loader;
import net.anotheria.portalkit.services.common.scheduledqueue.LoadingException;
import net.anotheria.portalkit.services.common.scheduledqueue.ProcessingException;
import net.anotheria.portalkit.services.common.scheduledqueue.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * User: VKoulakov
 * Date: 10.04.14
 * Time: 16:17
 */
public class SimpleJobSupport implements Loader, Processor {

    private static final Logger logger = LoggerFactory.getLogger(SimpleJobSupport.class);

    private int maxObjects = Scheduler.MAX_OBJECTS;

    public SimpleJobSupport(int maxObjects) {
        if (maxObjects < 1){
            throw new IllegalArgumentException("maxObjects requires greater than 0");
        }
        this.maxObjects = maxObjects;
    }

    @Override
    public List<Object> load() throws LoadingException {
        logger.info("Load called");
        List<Object> dummy = new ArrayList<Object>();
        for(int i = 0; i < Math.random() * maxObjects + 1; i++){
            dummy.add("Index_" + i);
            try {
                Thread.sleep(100); //as a real job do
            } catch (InterruptedException ignored) {
            }
        }
        logger.info("Objects loaded: " + dummy.size());
        return dummy;
    }

    @Override
    public void process(Object o) throws ProcessingException {
        logger.info("Process called with " + o);
        try {
            Thread.sleep(300); //simulate item processing
        } catch (InterruptedException ignored) {
        }
    }
}
