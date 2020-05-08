package p1.console;


import p1.interfaces.Game;

/**
 * Created by Kamil on 05.04.2020.
 * klasa odpowiedzialna za wykonanywanie gry konsolowej
 */
public class GameConsole extends ArrayConsole implements Runnable, Game {

    private boolean gameArray[][] = createTempTable();//przypisanie tablicy stworzonej w klasie ArrayConsole

    //dzialanie wersji konsolowej odbywa sie przy pomocy uzycia watkow, dzieki implementacji intefersju Runnable i przeciazonej metody run()
    //wywolujemy w petli nieskonczonej metode analize, ktora wywolywuje metode view dzieki czemu nasz program sie wykonuje
    @Override
    public void run() {

        view();//pierwsze wyswietlenie tablicy przy pomocy uzycia klasy ArrayConsole

        while (true) {
            try {
                analize();
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Metoda odpowiedzialna za wyswietlanie przeanalizowanej tablicy
    @Override
    public void view() {
        for(int i =0; i<x; i++){
            for(int j =0; j<y; j++){
                if(gameArray[i][j]==false){
                    System.out.print(" |");
                }else{
                    System.out.print("x|");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        //stworzenie odstepu miedzy kolejnymi zmianami tablic
        System.out.println(); System.out.println(); System.out.println(); System.out.println(); System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

    //Metoda odpowiedzialna za analizowanie statusu komorek i zmiane w tablicach
    @Override
    public void analize() {
        int licznik=0; //zmienna odpowiedzialna za stan badanej komorki
        boolean [][]temp = gameArray;

        for(int i =1; i<x-1; i++){
            for(int j =1; j<y-1; j++){
                if((temp[i-1][j-1])==true){
                    licznik++;
                }
                if((temp[i][j-1])==true){
                    licznik++;
                }
                if((temp[i+1][j-1])==true){
                    licznik++;
                }
                if((temp[i-1][j])==true){
                    licznik++;
                }
                if((temp[i+1][j])==true){
                    licznik++;
                }
                if((temp[i-1][j+1])==true){
                    licznik++;
                }
                if((temp[i][j+1])==true){
                    licznik++;
                }
                if((temp[i+1][j+1])==true){
                    licznik++;
                }
                if(temp[i][j]==false && (licznik==3)){
                    gameArray[i][j]=true;//martwa staje sie zywa
                }else if(temp[i][j]==true && (licznik==2 || licznik==3)){
                    licznik=0; // zerujemy tutaj licznik, poniewaz jesli zostanie wywolane continue to wrocimy do poczatku petli i licznik nie zostalby wyzerowany
                    continue;//zywa pozostaje zywa
                }else{
                    gameArray[i][j]=false;//zywa staje sie martwa, lub martwa pozostaje martwa
                }
                licznik=0; //resetowanie zmiennej dla zbadania nowej komorki
            }
        }
        view();
    }

}
