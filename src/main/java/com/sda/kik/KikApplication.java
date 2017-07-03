package com.sda.kik;

/**
 * Created by RENT on 2017-07-01.
 *
 * UWAGA!!!!!!!!!!!!
 * aplikacja korzysta z pakietu Board, z projektu javapoz3-hell0-servlet !!!!
 * patrz importy: import com.sda.sockets.kik.Board;  w pozostalych plikach tej aplikacji
 * pakiet ten zostal dodany w dependencies w pliku pom.xml
 * dzieki temu pliki z tego pakietu (pliki skompilowane: *.class) zostaly zaimportowane
 * do tego projektu (patrz external libraries w drzewku projektu)
 * aby import sie powiodl nalezalo w projekcie javapoz3-hello-servlet zakomentowac w
 * pliku pom opcję: <packaging>war</packaging>
 * dzieki czemu pliki *.class zostaly utworzone i mozna je bylo gdzies indziej (tutaj) zaimportowac
 *
 */
public class KikApplication {
    public static void main(String[] args) {
        KikJFrameBoard kikJFrameBoard = new KikJFrameBoard();
        kikJFrameBoard.run();
    }
}
