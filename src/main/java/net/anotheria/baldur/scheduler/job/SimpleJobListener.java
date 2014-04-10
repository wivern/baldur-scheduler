package net.anotheria.baldur.scheduler.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: VKoulakov
 * Date: 10.04.14
 * Time: 16:58
 */
public class SimpleJobListener implements JobListener {

    private static final Logger logger = LoggerFactory.getLogger(SimpleJobListener.class);

    private String name;

    public SimpleJobListener(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        logger.info("Starting job - " + getName());
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        logger.info("Job execution vetoed - " + getName());
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        logger.info("Job finished - " + getName());
    }
}
