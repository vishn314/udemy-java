package com.udemy.java.lambda;

public class Caller {
    public static void main(String[] args) {

        /* We can create an implementaion for an interface the below way by defining and instantiating the below way
         * define greet method and create an object for the interface.
         * This way we can skip creating a class and creating an object for the class to use the method. */
        GreetingService helloService1 = new GreetingService() {
            @Override
            public void greet(String name) {
                System.out.println("Hello " + name);
            }
        };
        System.out.println("heap object :" + helloService1); // heap object :com.udemy.java.lambda.Caller$1@3feba861
        helloService1.greet("vishnu");

        /* If we wanted to create different implementations to the interface, we can do the below.
           But a lot of code is same as the above
         */

        GreetingService howdyService1 = new GreetingService() {
            @Override
            public void greet(String name) {
                System.out.println("Howdy " + name);
            }
        };
        System.out.println("heap object :"+ howdyService1); //heap object :com.udemy.java.lambda.Caller$2@10f87f48
        howdyService1.greet("vishnu");
        /* Hence came the concept of lambdas where we can replace the entire interface implementation in one line.
           Only condition is that the interface should have only one abstract method
           compiler will know that there is only one method in GreetingService and the method takes a String,
           So the parameter passed here - name should be a string, so it lets us do the String operations in name
           If we change the interface GreetingService to have one abstract method accepting Dog types
           Compiler will consider name as a Dog type and will let us perform Dog behavior on name - makenoise(), walk() etc
         */
        GreetingService g2 = (name) -> System.out.println("Hello " + name);
        g2.greet("gopal");
    }
}
