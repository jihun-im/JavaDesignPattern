package reflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jihun.im on 2017-04-24.
 */
public class ReflectionMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<?> concreteClass = ConcreteClass.class;
        System.out.println(concreteClass.getCanonicalName());

        //concreteClass = new ConcreteClass(5).getClass();
        System.out.println(concreteClass.getCanonicalName());

        try {
            // below method is used most of the times in frameworks like JUnit
            //Spring dependency injection, Tomcat web container
            //Eclipse auto completion of method names, hibernate, Struts2 etc.
            //because ConcreteClass is not available at compile time
            concreteClass = Class.forName("reflection.ConcreteClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(concreteClass.getCanonicalName());


        //for primitive types, wrapper classes and arrays
        Class<?> booleanClass = boolean.class;
        System.out.println(booleanClass.getCanonicalName());

        Class<?> intClass = int.class;
        System.out.println(intClass.getCanonicalName());


        Class<?> cDouble = Double.TYPE;
        System.out.println(cDouble.getCanonicalName()); // prints double

        Class<?> cDoubleArray = null;
        try {
            cDoubleArray = Class.forName("[D");
            System.out.println(cDoubleArray.getCanonicalName()); //prints double[]
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Class<?> twoDStringArray = String[][][].class;
        System.out.println(twoDStringArray.getCanonicalName()); // prints java.lang.String[][]


        //Super Class Test
        Class<?> superClass = null;
        Class<?> superSuperClass = null;
        try {
            superClass = Class.forName("reflection.ConcreteClass").getSuperclass();
            superSuperClass = superClass.getSuperclass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(superClass); // prints "class reflection.BaseClass"
        System.out.println(superSuperClass); // prints "class java.lang.Object"


        //Get Public Member Classes
        Class<?>[] classes = concreteClass.getClasses();
        System.out.println(Arrays.toString(classes));


        //Get Declared Classes (+Private Classes)
        Class<?>[] explicitClasses = concreteClass.getDeclaredClasses();
        System.out.println(Arrays.toString(explicitClasses));


        //Get Declaring Classes
        Class<?> innerClass = Class.forName("reflection.ConcreteClass$ConcreteClassDefaultClass");
//prints com.journaldev.reflection.ConcreteClass
        System.out.println(innerClass.getDeclaringClass().getCanonicalName());
        System.out.println(innerClass.getEnclosingClass().getCanonicalName());


        //Get Package Name
        System.out.println(innerClass.getPackage().getName());

        //Modifier
        System.out.println(concreteClass.getModifiers());
        System.out.println(Modifier.toString(concreteClass.getModifiers()));


        //Get Type parameters (generics)
        TypeVariable<?>[] typeParameters = Class.forName("java.util.HashMap").getTypeParameters();
        for (TypeVariable<?> t : typeParameters)
            System.out.println(t.getName() + ",");

        //Get interfaces
        System.out.println(Arrays.toString(Class.forName("java.util.HashMap").getGenericInterfaces()));
        System.out.println(Arrays.toString(Class.forName("java.util.HashMap").getInterfaces()));


        //get methods
        Method[] publicMethods = Class.forName("reflection.ConcreteClass").getMethods();
        //prints public methods of ConcreteClass, BaseClass, Object
        System.out.println(Arrays.toString(publicMethods));

        //get public constructors
        Constructor<?>[] publicConstructors = Class.forName("reflection.ConcreteClass").getConstructors();
        System.out.println(Arrays.toString(publicConstructors));

        //Get All public fields
        Field[] publicFields = Class.forName("reflection.ConcreteClass").getFields();
        //prints public fields of ConcreteClass, it's superclass and super interfaces
        System.out.println(Arrays.toString(publicFields));

        try {
            Field field = Class.forName("reflection.ConcreteClass").getField("interfaceInt");
            System.out.println(field);
            Class<?> classA = field.getDeclaringClass();
            System.out.println("classA : " + classA);
            System.out.println("getType : " + field.getType());
            ConcreteClass concreteClass2 = new ConcreteClass(5);
            field = Class.forName("reflection.ConcreteClass").getField("publicInt");
            try {
                System.out.println(field.get(concreteClass2)); //prints 5
                field.setInt(concreteClass2, 10); //setting field value to 10 in object
                System.out.println(field.get(concreteClass2)); //prints 10

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }



        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        Field privateField = Class.forName("reflection.ConcreteClass").getDeclaredField("privateString");
        //turning off access check with below method call
        privateField.setAccessible(true);
        ConcreteClass objTest = new ConcreteClass(1);
        System.out.println(privateField.get(objTest)); // prints "private string"
        privateField.set(objTest, "private string updated");
        System.out.println(privateField.get(objTest)); //prints "private string updated"



        java.lang.annotation.Annotation[] annotations = Class.forName("reflection.ConcreteClass").getAnnotations();
        //prints [@java.lang.Deprecated()]
        System.out.println(Arrays.toString(annotations));




        //Invoking public method

        Method method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
        Map<String, String> hm = new HashMap<>();
        hm.put("key2","value2");
        method.invoke(hm, "key", "value");
        System.out.println(hm); // prints {key=value}


        //Instantiate Object using Constructor
        Constructor<?> constructor = Class.forName("reflection.ConcreteClass").getConstructor(int.class);
        //getting constructor parameters
        System.out.println(Arrays.toString(constructor.getParameterTypes())); // prints "[int]"

        Object myObj = constructor.newInstance(10);
        Method myObjMethod = myObj.getClass().getMethod("method1", null);
        myObjMethod.invoke(myObj, null); //prints "Method1 impl."
        System.out.println("((ConcreteClass)myObj).publicInt : " + ((ConcreteClass)myObj).publicInt);


        Constructor<?> hashMapConstructor = Class.forName("java.util.HashMap").getConstructor(null);
        System.out.println(Arrays.toString(hashMapConstructor.getParameterTypes())); // prints "[]"
        HashMap<String,String> myMap = (HashMap<String,String>) hashMapConstructor.newInstance(null);
    }
}
