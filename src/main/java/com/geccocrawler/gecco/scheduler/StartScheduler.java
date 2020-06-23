package com.geccocrawler.gecco.scheduler;

import java.util.concurrent.PriorityBlockingQueue;

import com.geccocrawler.gecco.request.HttpRequest;

/**
 * 阻塞队列
 * 
 * @author huchengyi
 *
 */
public class StartScheduler implements Scheduler {

    private PriorityBlockingQueue<HttpRequest> startQueue;

    public StartScheduler() {
        startQueue = new PriorityBlockingQueue<HttpRequest>();
    }

    @Override
    public HttpRequest out() {
        try {
            return startQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void into(HttpRequest request) {
        try {
            startQueue.put(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void into(HttpRequest request, long priority) {
        request.setPriority(priority);
        into(request);        
    }
}
