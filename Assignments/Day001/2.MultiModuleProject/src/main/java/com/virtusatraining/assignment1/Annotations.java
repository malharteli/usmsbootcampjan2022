package com.virtusatraining.assignment1;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@NoArgsConstructor
class Bar{
    public String value = "Bar";
}


class Foo{
    public String value = "Foo";
    Bar bar;
    Foo (Bar bar){
        this.bar = bar;
    }
    String printFooBar(){
        String rtrnString = "";
        if (this.bar.value.length() > 0){
            rtrnString = this.value + this.bar.value;
        }
        return rtrnString;
    }
}

//This is a @Configuration annotation. When a class is marked with this tag, it is able to add and use Spring Beans from the context
@Configuration
class BeanConfigDemo {
    //This is a @Bean annotation. This takes the return of the function that follows it and insert it into the Spring Context
    @Bean
    public Foo foo(){
        return new Foo(bar());
    }
    //This @Bean annotation is required by the @Bean function above to construct its return. All one has to do to ensure @Bean foo() runs properly is to call @Bean bar() in its context
    @Bean
    public Bar bar(){
        return new Bar();
    }
}

public class Annotations {
    //To access @Bean classes from the context, you will first need to instantiate the context.

    public static void main(String[] args) {
        //To access @Bean classes from the context, you will first need to instantiate the context.
        //We'll give the AnnotationConfigApplicationContext our @Configuration class, BeanConfigDemo
        //This is what allows Spring to instantiate the needed singletons required by our code.
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigDemo.class);
        //From this context, built from our @Configuration class, we can run our
        Foo fooTest = context.getBean(Foo.class);
        System.out.println(fooTest.printFooBar());
    }
}