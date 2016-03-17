package cn.gx.aopAuto;

import cn.gx.aop.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by always on 16/3/16.
 */
public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("aop-auto.xml");

        Student student = (Student) context.getBean("student");

        student.getName();
        student.getAge();

        student.printThrowException();
    }
}
