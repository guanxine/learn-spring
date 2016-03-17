package cn.gx.event.custom;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created by always on 16/3/16.
 */
public class CustomEventPublisher implements ApplicationEventPublisherAware{
    private  ApplicationEventPublisher publisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher=applicationEventPublisher;
    }

    public void publish(){
        CustomEvent ce=new CustomEvent(this);
        publisher.publishEvent(ce);
    }

}
