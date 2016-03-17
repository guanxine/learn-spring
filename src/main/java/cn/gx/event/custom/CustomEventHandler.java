package cn.gx.event.custom;

import org.springframework.context.ApplicationListener;

/**
 * Created by always on 16/3/16.
 */
public class CustomEventHandler implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent customerEvent) {
        System.out.println(customerEvent.toString());
    }
}
