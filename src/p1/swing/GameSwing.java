package p1.swing;

import p1.interfaces.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kamil on 22.04.2020.
 * klasa odpowiedzialna za wykonanywanie gry okienkowej
 */
public class GameSwing extends ArraySwing implements Game {

    private JFrame jFrame = new JFrame();
    private JPanel jPanel = new JPanel();


    private Timer timer;  //zmienna, ktora jest odpowiedzialna za wyzwalanie co okreslony czas metody ActionPerformed
    private int time_delay = 100; //czas co ile uruchamiana jest metoda ActionPerformed

    private JButton [][] jButtons = addArray(); //przypisanie do Tablicy Buttonow tablicy obiektu arraySwing


    public GameSwing(){

        //ustawianie naszego jFrame
        jFrame.setSize(900,900);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jPanel.setLayout(new GridLayout(x,y));
            //dodanie do Buttonow do jPanel
            for ( int i = 0; i < x; i++ ) {
                for (int j = 0; j < y; j++) {
                    jPanel.add(jButtons[i][j]);
                }
            }
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        //ustawienie i uruchomienie timer'a
        timer = new Timer(time_delay, taskPerformer);
        timer.start();
    }

    //Klasa odpowiedzialna za dodanie zaktualizowanych Buttonow z tablicy jButtons do jPanel
    @Override
    public void view() {

        for ( int i = 0; i < x; i++ ) {
            for (int j = 0; j < y; j++) {
                jPanel.add(jButtons[i][j]);
            }
        }
    }


    //Metoda odpowiedzialna za analizowanie statusu komorek(Buttonow) i zmiane w tablicach
   @Override
    public void analize() {

        int licznik = 0; //zmienna odpowiedzialna za stan badanej komorki(Buttona)
        JButton[][] squares = jButtons;

        for ( int i = 1; i < x-1; i++ ) {
            for (int j = 1; j < y-1; j++) {
                if(squares[i-1][j-1].getBackground()== Color.RED){
                    licznik++;
                }
                if(squares[i][j-1].getBackground()== Color.RED){
                    licznik++;
                }
                if(squares[i+1][j-1].getBackground()== Color.RED){
                    licznik++;
                }
                if(squares[i-1][j].getBackground()== Color.RED){
                    licznik++;
                }
                if(squares[i+1][j].getBackground()== Color.RED){
                    licznik++;
                }
                if(squares[i-1][j+1].getBackground()== Color.RED){
                    licznik++;
                }
                if(squares[i][j+1].getBackground()== Color.RED){
                    licznik++;
                }
                if(squares[i+1][j+1].getBackground()== Color.RED){
                    licznik++;
                }
                if(squares[i][j].getBackground()!= Color.RED && licznik==3){
                    jButtons[i][j].setBackground(Color.RED);//martwa staje sie zywa
                  //  jPanel.add(jButtons[i][j]);
                  //  jPanel.repaint();
                }else if(squares[i][j].getBackground()== Color.RED && (licznik==2 || licznik==3)){
                    continue;//zywa pozostaje zywa
                }else{
                    jButtons[i][j].setBackground(Color.BLACK);//zywa staje sie martwa, lub martwa pozostaje martwa
                   // jPanel.add(jButtons[i][j]);
                   // jPanel.repaint();
                }
                licznik=0; //resetowanie zmiennej dla zbadania nowej komorki
            }
        }
    }

    //Metoda wywolywana co dany czas (time_delay), dzieki niej wykonuje sie wersja okienkowa gry w zycie
    public ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            analize();
            view();
            jPanel.revalidate();
            jPanel.repaint();
        }
    };
}
