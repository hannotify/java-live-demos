import java.lang.reflect.InvocationTargetException;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String dynamicString = (String) Class.forName("java.lang.String").getDeclaredConstructor().newInstance();

        System.out.println(dynamicString.length());

    }
}
