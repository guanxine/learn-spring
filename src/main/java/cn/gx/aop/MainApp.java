package cn.gx.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by always on 16/3/16.
 */
public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("aop-mxl.xml");

        Student student = (Student) context.getBean("student");

        student.getName();
        System.out.println("==================");
        student.getAge();
        System.out.println("==================");
        student.printThrowException();
    }
}
