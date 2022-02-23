import java.util.function.Consumer;

/**
 * Use Principle
 * 1. Create your resource
 * 2. your resource constructor should be private
 * 3. define Use method to create the resource and run the required activity and finally safety close the resource
 *
 * this will insure who use our resource , use method will close it 
 */


class ResourceSpecial {

    private ResourceSpecial() {
        System.out.println("ResourceSpecial created");
    }

    public void m1() {
        System.out.println("ResourceSpecial method 1 called");
    }

    public void m2() {
        System.out.println("ResourceSpecial method 2 called");
    }

    private void close() {
        System.out.println("ResourceSpecial closed");
    }

    public static void use(Consumer<ResourceSpecial> block) {
        ResourceSpecial resourceSpecial = new ResourceSpecial();
        try {
            block.accept(resourceSpecial);
        } finally {
            resourceSpecial.close();
        }
    }
}

public class MainClass {


    public static void main(String[] args) {
        ResourceSpecial.use(MainClass::executeFun);

    }

    private static void executeFun(ResourceSpecial resourceSpecial) {
            resourceSpecial.m1();
            resourceSpecial.m2();

    }




}
