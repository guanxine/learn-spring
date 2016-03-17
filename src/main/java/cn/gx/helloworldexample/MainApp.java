package cn.gx.helloworldexample;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by always on 16/3/15.
 */
public class MainApp {

    public static void main(String[] args) {

        AbstractApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld= (HelloWorld) context.getBean("helloWorld");

        helloWorld.getMessage();//Your Message : hello,world

        helloWorld.setMessage("I'm object A");

        helloWorld.getMessage();//Your Message : I'm object A

        HelloWorld another= (HelloWorld) context.getBean("helloWorld");

        //Your Message : I'm object A (singleton)(default)
        //Your Message : hello,world (prototype)
        another.getMessage();

        context.registerShutdownHook();
    }
}
