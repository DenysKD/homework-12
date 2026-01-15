public class FizzBuzzClass {

    public static void fizz(int number){
        if(number % 3 == 0 && number % 5 != 0)
            System.out.println("fizz");
    }

    public static void buzz(int number){
        if(number % 3 != 0 && number % 5 == 0)
            System.out.println("buzz");
    }

    public static void fizzbuzz(int number) {
        if(number % 3 == 0 && number % 5 == 0 && number != 0)
            System.out.println("fizzbuzz");
    }

    public static void number(int number) {
        if(number % 3 != 0 && number % 5 != 0)
            System.out.println(number);
    }

}
