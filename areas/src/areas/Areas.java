/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areas;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author student
 */
public class Areas {
    Scanner sc = new Scanner(System.in, "UTF-8");
    enum Options{
        S, R, T, C, X;
    }
    
    float readNumber(String text){
        float input = -1;
        do{
            try{
                System.out.printf(text + ": ");
                input = sc.nextFloat();
                if(input < 0){
                    System.out.println("Číslo nesmí bát záporné.");
                }
            } catch(InputMismatchException e){
                System.out.println("Nesprávně zadané číslo!");
            }
        } while(input < 0);
        return input;
    }
    
    double getSquareArea(float a){
        return Math.pow(a, 2);
    }
    
    double getRectangleArea(float a, float b){
        return a * b;
    }
    
    double getTriangleArea(float c, float v){
        return c * v / 2;
    }
    
    double getCircleArea(float r){
        return 3.14 * Math.pow(r, 2);
    }
    void menu(){
        String optChar = "";
        do{
            System.out.println("Výpočet plochy geometrických útvarů");
            System.out.println("--------------------------------------");
            System.out.println("S = čtverec, R = obdelník, T = trojúhelník, C = kruh, X = konec");
            System.out.printf("Zadej volbu: ");
            optChar = sc.nextLine();
            try{
                Options option = Options.valueOf(optChar.toUpperCase());
                switch(option){
                    case S: System.out.println("Čtverec");
                            float a = this.readNumber("Zadej stranu a");
                            System.out.printf("Plocha čtverce o straně %.2f je %.3f", a, this.getSquareArea(a));
                            System.out.println();
                            break;
                    case R: System.out.println("Obdelník");
                            float aSide = this.readNumber("Zadej stranu a");
                            float bSide = this.readNumber("Zadej stranu b");
                            System.out.printf("Plocha obdelníku o stranách %.2f a %.2f je %.3f", aSide, bSide, this.getRectangleArea(aSide, bSide));
                            System.out.println();
                            break;
                    case T: System.out.println("Trojúhelník");
                            float c = this.readNumber("Zadej stranu c");
                            float v = this.readNumber("Zadej výšku");
                            System.out.printf("Plocha obdelníku o straně %.2f a výšce %.2f je %.3f", c, v, this.getTriangleArea(c,v));
                            System.out.println();
                            break;
                    case C: System.out.println("Kruh");
                            float r = this.readNumber("Zadej poloměr kruhu");
                            System.out.printf("Plocha kruhu o polomeru %.2f je %.3f", r, this.getCircleArea(r));
                            System.out.println();
                            break;
                }
            } catch(Exception e){
                System.out.println("Chybná volba");
            }
        }while(!optChar.equalsIgnoreCase("X"));
    }
    public static void main(String[] args) {
        Areas areas = new Areas();
        areas.menu();
    }
    
}
