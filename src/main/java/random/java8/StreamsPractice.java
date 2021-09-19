package random.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsPractice {
    // create an object of list using ArrayList
    static List<String> places = new ArrayList<>();
    static List<List<String>> namesNested = new ArrayList<>();

    // preparing our data
    public static List getPlaces(){

        // add places and country to the list
        places.add("Nepal, Kathmandu");
        places.add("Nepal, Pokhara");
        places.add("Nepal, Pokhara");
        places.add("Nepal, Pokhara");
        places.add("India, Delhi");
        places.add("USA, New York");
        places.add("Africa, Nigeria");
        places.add("Africa, Nigeria");
        places.add("Africa, Nigeria");

        return places;
    }

    public  static void nestedStrings(){
        namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));
    }
    public static void main(String[] args) {
        List<String> places = getPlaces();


        printPlaces(places);
        nestedStrings();

        places.stream().filter(p->p.contains("Nepal"))
                .map((p) -> p.toUpperCase())
                .sorted()
                .forEach((p) -> System.out.println(p));
        List<String> temp = new ArrayList<>();


            printEven();
        printDistinctPlace(places);
        listToArray(places);
        flatMap(namesNested);

    }

    private static void flatMap(List<List<String>> namesNested) {
        System.out.println("Flat Map :\n");
        namesNested.stream().flatMap(p->p.stream())
                .forEach(p-> System.out.println(p));
    }

    private static void listToArray(List<String> places)
    {
        String [] placesArray = places.stream().toArray(String[]::new);
        System.out.println("Places Array :");

        Stream.of(placesArray).forEach(p-> System.out.println(p));


    }

    private static void printDistinctPlace(List<String> places) {
        places.stream().distinct().forEach(p-> System.out.println("Distinct places : "+p));
        System.out.println("count :"+places.stream().distinct().count());


    }

    private static void printEven() {
        IntStream.range(1,50)
                .filter(p->p%2==0)
                .forEach(p-> System.out.println(p));

        //Find first number divisible by 17
        int a = IntStream.range(1,101)
                .filter(p->(p!=89) && (p%89==0))
                .findFirst()

                .orElse(0);
        System.out.println("Optional a " + a);
    }

    private static void printPlaces(List<String> places) {
        System.out.println("Peek >");
        places.stream().peek(e-> System.out.println(e+"Peekacho")).forEach(e-> System.out.println(e));
        System.out.println("--------------------------------------------");
        List<String> newPlaces = places.stream().collect(Collectors.toList());
//
//        places.add("Noida, India");
//        System.out.println("Old Places \n -------------------");
//        places.stream().forEach(p-> System.out.println(p));
//
//
//        System.out.println("New Places \n -------------------");
//        newPlaces.stream().forEach(n-> System.out.println(n));
    }
}
