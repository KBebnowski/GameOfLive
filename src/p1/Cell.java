package p1;

import java.util.Random;

/**
 * Created by Kamil on 05.04.2020.
 * klasas odpowiedzialna za tworzenie komorek i nadawanie wielkosci tablic dla wszystkich wersji gier
 */
public class Cell {

    // Zmienne opisujace wielkosc tablicy
    public static final int x=30;       //szerokosc
    public static final int y=30;       //wysokosc

    private boolean isAlive;

    //Zmienna losowa, dzieki ktorej bedziemy mogli otrzymywac rozne wartosci zmiennej isAlive podczas kazdego tworzenia obiektu Cell
    private Random random = new Random();

    //konstruktor bezparametorowy w ktorym przypisujemy do zmiennej isAlive zmienna losowa
    public Cell(){

        isAlive=random.nextBoolean();
    }

    public boolean isAlive() {

        //komorka zostanie stworzona jesli po 3 losowaniach bedzie nadal true
        if (isAlive == true) {
             isAlive = random.nextBoolean();
             if(isAlive == true) {
                 isAlive = random.nextBoolean();
                 return isAlive;
             }else
                 return isAlive;
        } else {
            return isAlive;
        }
    }

}
