package Java8Practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Practice {
    public static void main(String[] args) {
        //1.print even nos from the list
        int arr[] = new int[]{9,10,15,8,12,11,9,4,2,5,2,7,9,2,8,8,8};
        List<Integer> collect = Arrays.stream(arr).filter(a -> a % 2 == 0).boxed()
                .collect(Collectors.toList());
        System.out.println("Even number- "+collect);

        //2.Find first element in the list
        System.out.println(Arrays.stream(arr).findFirst());
        Arrays.stream(arr).findFirst().ifPresent(System.out::println);

        //3.find duplicate in the list
        Set<Integer> set = new HashSet<>();
      //  Arrays.stream(arr).filter(s ->!set.add(s)).forEach(System.out::println);
        List<Integer> collect1 = Arrays.stream(arr).filter(s -> !(set.add(s)))
                .boxed().collect(Collectors.toList());
        System.out.println("Duplicate numbers in List-- "+collect1);

        //4.print the number that start with 1 from the list
        Arrays.stream(arr).mapToObj(s->s+"").filter(s->s.startsWith("1"))
                .forEach(System.out::println);

        //5.find minimum and maximum in the list
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println("Maximum number-- "+max);
        System.out.println("Minimum number-- "+min);
        
        //6.find first non repeated character
        //step1 count occurrence of each number 
        LinkedHashMap<Integer, Long> frequentCharMap = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println("frequentCharMap---" +frequentCharMap);
        Optional<Integer> first = frequentCharMap.entrySet().stream()
                .filter(m -> m.getValue() == 1).map(Map.Entry::getKey).findFirst();
        System.out.println("first non repeated -" +first);

        frequentCharMap.entrySet().stream()
                .filter(m -> m.getValue() == 1).limit(1).forEach(System.out::println);
         // find first 2 repeated
        frequentCharMap.entrySet().stream()
                .filter(m -> m.getValue() == 1).skip(1).limit(2).forEach(System.out::println);

    }
}
