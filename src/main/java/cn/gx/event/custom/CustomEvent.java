package cn.gx.event.custom;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by always on 16/3/16.
 */
public class CustomEvent extends ApplicationEvent {
    public CustomEvent(Object source) {
        super(source);
    }

    public String toString(){
        return "My Customer Event";
    }
}
