package random.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class GenericsClass {
    public static <T> void main(String[] args) {
        List list = new ArrayList();
        list.add(2);
        list.add("Hello");
        String s =(String) list.get(0);
        System.out.println(list.get(1));
        System.out.println(s);
        Integer[] arr = new Integer[10];

        List<Integer> aList = new ArrayList<>();
        aList.add(2);
        genericMethod(aList);
        trueGeneric(arr,list);
    }
    public static <T> List<T> genericMethod(List<T> a){
        Stream.of(a).forEach(p-> System.out.println(p));
        List<String> sList = new ArrayList<>();
        sList.add("dssd");
        return (List<T>) sList;
    }

    public static <T> void trueGeneric(T[] arr, Collection<T> collection){

    }

    public static <T> void wildCard(T[] arr, Collection<?> collection){

    }
}
