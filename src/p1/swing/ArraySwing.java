package p1.swing;

import p1.Cell;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kamil on 21.04.2020.
 * klasa odpowiedzialna za tworzenie tablicy przyciskow i przypisanie im poczatkowych stanow - wersja okienkowa
 */
public class ArraySwing extends Cell {

    JButton [][] squares;

    protected JButton[][] addArray(){

        squares = new JButton[x][y];
        for ( int i = 0; i < x; i++ ) {
            for (int j = 0; j < y; j++) {
                Cell cell = new Cell();
                squares[i][j] = new JButton();
                if(cell.isAlive()) {
                    squares[i][j].setBackground(Color.RED);
                }else{
                    squares[i][j].setBackground(Color.BLACK);
                }
            }
        }
        return squares;
    }
}
