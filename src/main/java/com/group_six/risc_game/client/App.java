/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.group_six.risc_game.client;

import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static String chooseRoomSize(){
        System.out.println("Please choose the number of players: ");
        System.out.println("A.2  B.3  C.4  D.5 (Input A, B, C, or D)");
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            String choose = line.toUpperCase();
            if (!choose.equals("A") && !choose.equals("B") && !choose.equals("C") && !choose.equals("D")) {
                System.out.println("Please re-input the choice.");
            } else {
                return choose;
            }
        }
    }
    public static void main(String[] args) {
        String choose = chooseRoomSize();
        int roomSize = 0;
        if(choose.equals("A"))
            roomSize = 2;
        else if(choose.equals("B"))
            roomSize = 3;
        else
            roomSize = 4;
        Client client = new Client();
        client.joinGame("test001", roomSize);

    }
}
