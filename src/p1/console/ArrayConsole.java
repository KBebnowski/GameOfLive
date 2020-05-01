package p1.console;

import p1.Cell;

/**
 * Created by Kamil on 21.04.2020.
 * klasa odpowiedzialna za tworzenie tablicy i przypisanie poczatkowych stanow komorkom - wersja konsolowa
 */
public class ArrayConsole extends Cell {

    protected boolean[][] createTempTable(){
        boolean [][]tab = new boolean[x][y];

        for(int i =0; i<x; i++){
            for(int j =0; j<y; j++){
                Cell cell = new Cell();
                tab[i][j] = cell.isAlive();
            }
        }
        return tab;
    }
}
