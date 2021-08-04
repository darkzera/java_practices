package Starter;

public class ErrorHandling {

    public static void main(String[] args) {

        Fool f = txt -> {
            return " - " + txt;
        };

        System.out.println(f.firstTry("oi"));

    }
}

@FunctionalInterface
interface Fool {
    public String firstTry(String s);


}
