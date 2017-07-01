package com.sda;

import com.sda.model.Address;
import com.sda.model.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-07-01.
 */
public class Application {
    public static void main(String[] args) {

        Address address1 = Address.builder()
                .city("Poznań")
                .street("Myśliborska")
                .flatNumber(31)
                .postalCode("60-432")
                .build();

        Address address2 = Address.builder()
                .city("Poznań")
                .street("Dąbrowskiego")
                .flatNumber(456)
                .postalCode("60-123")
                .build();

        Address address3 = Address.builder()
                .city("Warszawa")
                .street("Parkowa")
                .flatNumber(23)
                .postalCode("12-123")
                .build();

        User user1 = User.builder()
                .firstName("Bartek")
                .lastName("Mytko")
                .age(31)
                .phoneNumber("123456789")
                .address(address1)
                .build();

        User user2 = User.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .age(40)
                .phoneNumber("456123789")
                .address(address2)
                .build();

        User user3 = User.builder()
                .firstName("Janina")
                .lastName("Kowalska")
                .age(39)
                .phoneNumber("123789456")
                .address(address2)
                .build();

        User user4 = User.builder()
                .firstName("Hanna")
                .lastName("Wiśniewska")
                .age(35)
                .phoneNumber("987654321")
                .address(address3)
                .build();

        List<String> list = new ArrayList<>();


        //////////////////////////////////////////////////////////////////////////////

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        //1. wyswietlic wszystkich userow
        System.out.println("1. wyswietlic wszystkich userow");
        users.stream()
                .map(e -> e.toString()) //zamiana obiektu user na String
                .forEach(e -> System.out.println(e));

        //2. wyswietlic tlyko userow, ktorych wiek jest powyzej 35
        System.out.println("2. wyswietlic tlyko userow, ktorych wiek jest powyzej 35");
        users.stream()
                .filter(e -> e.getAge() > 35)
                .forEach(e -> System.out.println(e));

        //3. wyswietlic wszystkichuserowz Poznania
        System.out.println("3. wyswietlic wszystkichuserowz Poznania");
        users.stream()
                .filter(e -> e.getAddress().getCity().equals("Poznań"))
                .forEach(e -> System.out.println(e));

        //4. wyswietlic wszystkichuserow z kodem pocztowym zaczynajacym sie na 12
        System.out.println("4. wyswietlic wszystkichuserow z kodem pocztowym zaczynajacym sie na 12");
        users.stream()
                .filter(e -> e.getAddress().getPostalCode().startsWith("12"))
                .forEach(e -> System.out.println(e));

        //5. zliczyc wystapienia nazwiska Kowalski
        System.out.println("5. zliczyc wystapienia nazwiska Kowalski");
        long amout = users.stream()
                .filter(e -> e.getLastName().equals("Kowalski"))
                .count();
        System.out.println(amout);

        users.stream()
                .map(e -> e.getLastName()) //ze strumienia userow robie strumien stringow z lastName
                .filter(e -> "Kowalski".equals(e)) //filtruje
                .count(); //zliczam

        //5a. zliczyc liczbeadresow
        System.out.println("5a. zliczyc liczbeadresow");
        long count = users.stream()
                .map(e -> e.getAddress()) //ze strumienia userow robie strumien obiektow Adres
                .distinct() //pozbywam sie duplikatow
                .count();//zliczam
        System.out.println(count);

        //6. wyswietlic osoby mieszkajace pod adresem address2
        System.out.println("6. wyswietlic osoby mieszkajace pod adresem address2");
        users.stream()
                .filter(e -> e.getAddress().equals(address2))
                .forEach(e -> System.out.println(e));

        //7. utworzyc LISTE userow, ktorych imie zaczyna sie na J
        System.out.println("7. utworzyc LISTE userow, ktorych imie zaczyna sie na J");
        List<User> newList = users.stream()
                .filter(e -> e.getFirstName().startsWith("J"))
                .collect(Collectors.toList());
        System.out.println(newList);

        //8. sparwdzic czy wkolekcji instnieje ktokolwiek z miata Kalisz
        System.out.println("8. sparwdzic czy wkolekcji instnieje ktokolwiek z miata Kalisz");
        boolean anybodyFromKalisz = users.stream()
                .map(e -> e.getAddress())
                .map(e -> e.getCity())
                .anyMatch(e -> "Kalisz".equals(e));
        System.out.println(anybodyFromKalisz);

        //9. sprawdzic czy wszyscy userzy o nazwisku Kowalski mieszkaja w Poznaniu
        System.out.println("9. sprawdzic czy wszyscy userzy o nazwisku Kowalski mieszkaja w Poznaniu");
        boolean allKowalskiPersonFromPoznan = users.stream()
                .filter(e -> "Kowalski".equals(e.getLastName()))
                .map(e -> e.getAddress())
                .map(e -> e.getCity())
                .distinct()
                .allMatch(e -> "Poznań".equals(e));
        System.out.println(allKowalskiPersonFromPoznan);

        //10. obliczyc srednia wieku userow
        System.out.println("10. obliczyc srednia wieku userow");
        double average = users.stream()
                .mapToInt(e -> e.getAge())
                .average()
                .getAsDouble();
        System.out.println(average);

        //11. wyswietlic hashe wszystkich userow
        System.out.println("11. wyswietlic hashe wszystkich userow");
        users.stream()
                .mapToInt(e -> e.hashCode())
                .forEach(e -> System.out.println(e));


        /////////////////////////////////////////////////////////////////
        //jakie literki zostaly uzyte do tych imionna?
        List<String> names = Arrays.asList("Szymon", "Anna", "Jan", "Tadeusz", "Mateusz");

        names.stream()
                .map(e -> convert(e)) //ze stringa robie liste znakow z tego stringa
                .flatMap(e -> e.stream()) //tutaj mam strumien list, zamieniam go na strumien jego skladowych, czyli pojedynczych literek
                .map(e -> e.toLowerCase())
                .distinct()
                .sorted()
                .forEach(e -> System.out.println(e));

        ///////////////////////////////////////////////////////////////////////
        //usuwanie duplikatow z listy, rezultat do innej listy
        List<String> names2 = Arrays.asList("Szymon", "Anna", "Jan", "Tadeusz", "Mateusz", "Szymon", "Tadeusz");
        HashSet<String> namesSet = new HashSet<>(names2);
        ArrayList<String> distinctNames = new ArrayList<>(namesSet);



        ////////////////////////////////////////////////////////////////
        List<String> names3 = new ArrayList<>();
        names3.add("Szymon");
        names3.add("Anna");
        names3.add("Jan");
        names3.add("Tadeusz");
        names3.add("Mateusz");
        names3.add("Szymon");
        //names3.add("Tadeusz");

        Set<String> namesSet2 = new HashSet<>();
        List<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i < names3.size(); i++) {
            String name = names3.get(i);
            if (namesSet2.contains(name)) {
                toRemove.add(i);
            } else {
                namesSet2.add(name);
            }
        }

        System.out.println(names3);
        for (Integer i : toRemove) {
            names3.remove(i.intValue()); //bo "i" jest obiektem Integer, wiec zamieniamy go na zwykly int
        }
        System.out.println("asd");
        System.out.println(names3);


        /////////////////////////////////////////////////////////////////

        Map<String, List<User>> usersByDistrict = new HashMap<>();
        usersByDistrict.put("wielkopolskie", Arrays.asList(user1, user2, user3));
        usersByDistrict.put("mazowieckie", Arrays.asList(user4));

        System.out.println("1. Zrobic z tego liste userow");
        usersByDistrict.entrySet().stream() //entrySet - to zbior [klucz-wartosc] z mapy i robmy z tego strumien
                .map(e -> e.getValue()) //tworzy strumien list, bo kazda wartosc ze zbioru to pojedyncza lista
                .flatMap(e -> e.stream()) //spaszczamy, tworzy strumien userow
                .forEach(e -> System.out.println(e));



    } //koniec maina

    public static List<String> convert(String name) {
        List<String> list = new ArrayList<>();
        char[] charArray = name.toCharArray();
        for (char c : charArray) {
            list.add(String.valueOf(c));
        }
        return list;
    }
}
