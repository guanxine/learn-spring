package cn.gx.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by always on 16/3/16.
 */
public class CStartEventHandler implements ApplicationListener{
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("ContextStartedEvent Received");
    }
}
