package cn.gx.helloworldexample;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by always on 16/3/15.
 */
public class HelloWorld{

    private String message;

    public void setMessage(String message){
        this.message  = message;
    }

    public void getMessage(){
        System.out.println("Your Message : " + message);
    }


    public void init(){
        //BeforeInitialization : helloWorld
        System.out.println("HelloWorld init");
        //AfterInitialization : helloWorld
    }

    public void destory(){
        System.out.println("HelloWorld destroy");
    }
}
