package com.udemy.java.lambda.MethodReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Caller {
    public static void main(String[] args) {


        /* Example 1: We give an object to a Static method call - pass object as parameter
        Method accepts data and prints it (data) Using System.out.println
        */
        System.out.println("Example 1: ----------------------------------------------------------------");
        //        Regular lambda ----------------------------------------------------------------
        StringOperationsNoReturn s1 = (s -> System.out.println(s));
        s1.process("vishnu");
        //Method reference for the above example
        StringOperationsNoReturn s2 = System.out::println;
        s2.process("gopal");



        /* Example 2:We give an object to a Static method call - pass object as parameter
        Method accepts data/string and we pass it(data/string) to another method to check if it is null
        */
        System.out.println("Example 2: ----------------------------------------------------------------");
        //        Regular lambda ----------------------------------------------------------------
        StringOperationReturnBoolean s5 = s -> Objects.isNull(s);
        Boolean c = s5.process(null);
        System.out.println(c);
        //Method reference for above example
        StringOperationReturnBoolean s6 = Objects::isNull;
        Boolean d = s6.process(null);
        System.out.println(d);

        /* Example 3: We give an object, on that object we do an Instance method call.
        Method accepts string object, on that string object we perform isEmpty() call.
        */
        System.out.println("Example 3: ----------------------------------------------------------------");
        //        Regular lambda ----------------------------------------------------------------
        StringOperationReturnBoolean s3 = (s -> s.isEmpty());
        Boolean a =  s3.process("vishnu");
        System.out.println(a);
        //Method reference for above example
        StringOperationReturnBoolean s4 = String::isEmpty;
        Boolean b = s4.process("");
        System.out.println(b);

        /* Example 4: We give an object, on that object we do an Instance method call.
        Method accepts string object, on that string object we perform toUpperCase() call.
         */
        System.out.println("Example 4: ----------------------------------------------------------------");
        //  Regular lambda ----------------------------------------------------------------
        StringOperationsReturnString s7 = s -> s.toUpperCase();
        String returned =  s7.process("vishnu");
        System.out.println(returned);
        //Method reference for above example
        StringOperationsReturnString s8 = String::toUpperCase;
        String returned2 = s8.process("vishnu");
        System.out.println(returned2);


        /* Example 5: We give two objects, on the first object we do an Instance method call with the second object as parameter
        Method accepts two string objects x and y. On first object x, we perform the method concat(with second object y as paramter)
        // (s1,s2) -> s1.concat(s2)
        */
        System.out.println("Example 5: ----------------------------------------------------------------");
        //  Regular lambda ----------------------------------------------------------------
        StringOpeationsWithTwoParameters s9 = (x,y) -> x.concat(y);
        String returned3 = s9.process("vishnu", "gopal");
        System.out.println(returned3);
        //Method reference for above example
        StringOpeationsWithTwoParameters s10 = String::concat;
        String returned4 = s10.process("vinoth","selva");
        System.out.println(returned4);

        /* Example 6:  We give three objects, on the first object we do an Instance method call with the second and third objects as parameters
        Method accepts three string objects x, y and z, on the first object x , we perform replaceFirst(y,z) passing the remaining two string objects as parameters
        Java will take the order as (object, first parameter, second parameter) and apply the parameters in the order received to the function definition
        IN JAVA DOC : public String replaceAll(String regex, String replacement)
         */
        System.out.println("Example 6: ----------------------------------------------------------------");
        //  Regular lambda ----------------------------------------------------------------
        StringOperationsWithThreeParameters s11 = (x,y, z ) -> x.concat(y).concat(z);
        String returned5 = s11.process("Vishnu ", "Gopal ", "Raja");
        System.out.println(returned5);

        /*Method reference for above example does not work,
        Why, because this is the definition of concat() method in java docs - "public String concat(String str)"
        concat method accepts one parameter strictly.
        One object to apply the concat method on and the second object is the paramter to concat method. In that order.
        so (s1,s2) -> s1.concat(s2) is a possible translation.
         */

        //where as this will work - regular lambda
        StringOperationsWithThreeParameters s12 = (x , y, z) -> x.replaceFirst(y,z);
        String returned6 =  s12.process("Hello Vishnu Hello Hello", "Hello", "Hi");
        System.out.println(returned6);

        //Method reference of above
        // (s1,s2,s3) -> s1.replaceFirst(s2,s3)
        StringOperationsWithThreeParameters s13 = String::replaceFirst; //public String replaceFirst(String regex, String replacement) First object will be used as input, the second and third will be used as the two parameters in the call.
        String returned7 = s13.process("Hello Vishnu Hello Hello", "Hello", "Hi");
        System.out.println(returned7);

        /* Example 7: We give one object, But we use that object as a parameter to a different objects method.
        We send the String object var, but within the lambda function, we pass that string object as a parameter to an ArrayList object's add () method.
        ArrayList object here is listEntries (actually a reference variable to the ArrayList Object)
         */
        System.out.println("Example 7: ----------------------------------------------------------------");
        //regular lambda
        // (object1) -> object2.method(object1)
        // (string var) -> listEntries.add(var)
        List<String> listEntries = new ArrayList<>();
        StringOperationsNoReturn s14 = (var) -> listEntries.add(var);
        s14.process("Manickam");
        System.out.println(listEntries);
        //Method reference
        StringOperationsNoReturn s15 = listEntries::add;
        s15.process("Gem");
        System.out.println(listEntries);
        
        /* Example 8: No object passed, but lambda function creates an object
        () -> new cat()
        Cat::new
        */
        System.out.println("Example 8: ----------------------------------------------------------------");
        PersonProviderInterface guy = () -> new Person();
        Person ra1= guy.create();
        ra1.methodInPerson();

        PersonProviderInterface guy2 = Person::new;
        Person ra2 = guy2.create();
        ra2.methodInPerson();


    }
}
