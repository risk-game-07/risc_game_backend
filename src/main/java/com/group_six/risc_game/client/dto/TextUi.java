package com.group_six.risc_game.client.dto;

import com.group_six.risc_game.client.Client;
import com.group_six.risc_game.client.ClientPlayer;
import com.group_six.risc_game.domain.vo.request.GameActionReq;

import java.util.*;

public class TextUi {
    public static int chooseRoom() {
        System.out.println("A.2  B.3  C.4  D.5 (Input A, B, C, or D)");
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            String choose = line.toUpperCase();
            if (!choose.equals("A") && !choose.equals("B") && !choose.equals("C") && !choose.equals("D")) {
                System.out.println("Please re-input the choice.");
            } else {
                switch (choose) {
                    case "A" -> {
                        return 2;
                    }
                    case "B" -> {
                        return 3;
                    }
                    case "C" -> {
                        return 4;
                    }
                }
            }
        }
    }

    public static String inputUserName(){
        System.out.println("please input your name");
        Scanner in = new Scanner(System.in);
         return in.nextLine();
    }

    public static void showCurNum(int curNum, int roomSize){
        if(curNum != roomSize)
            System.out.println("now " + curNum + " in the room, please wait");
        else
            System.out.println("now " + curNum + " in the room, the game can start");
    }

    public static Map<String, Integer> showInitMapInfo(ClientPlayer players) {
        Map<String, Integer> map = new HashMap<>();
        int units = players.getUnits();
        Scanner in = new Scanner(System.in);
        System.out.println("now you have " + players.getTerritoryName().size() + " territories");
        System.out.println("There are:");
        for(String name : players.getTerritoryName())
            System.out.print(name + " ");
        System.out.println();
        System.out.println("You have " + players.getUnits() + " avaliable units");
        for(String name : players.getTerritoryName()){
            System.out.println("how many units you want to put into " + name);
            int num = in.nextInt();
            while (units < num || num < 0){
                System.out.println("you do not have so many avaliable units");
                num = in.nextInt();
            }
            units -= num;
            System.out.println("you still have " + units + " units");
            System.out.println("(you should apply all units in this stage)");
            map.put(name, num);
        }
        return map;
    }

    public static Map<String, List<String>> createNeibour(){
        Map<String, List<String>> ans = new HashMap<>();
        String[] names = {"Arcadia","Belmont", "Citadel","Duskwood",
                          "Everglade", "Frostholm","Glimmermere","Havenbrook",
                          "Ironforge","Jade Falls", "Kaldoria", "Lunar Crest"};
        List<String> ans1 = new ArrayList<>();
        ans1.add("Belmont");
        ans1.add("Citadel");
        List<String> ans2 = new ArrayList<>();
        ans2.add("Arcadia");
        ans2.add("Ironforge");
        List<String> ans3 = new ArrayList<>();
        ans3.add("Arcadia");
        ans3.add("Frostholm");
        ans3.add("Duskwood");
        List<String> ans4 = new ArrayList<>();
        ans4.add("Belmont");
        ans4.add("Citadel");
        ans4.add("Lunar Crest");
        ans4.add("Kaldoria");
        List<String> ans5 = new ArrayList<>();
        ans5.add("Lunar Crest");
        ans5.add("Frostholm");
        List<String> ans6 = new ArrayList<>();
        ans6.add("Citadel");
        ans6.add("Havenbrook");
        ans6.add("Everglade");
        List<String> ans7 = new ArrayList<>();
        ans7.add("Jade Falls");
        ans7.add("Lunar Crest");
        List<String> ans8 = new ArrayList<>();
        ans8.add("Frostholm");
        ans8.add("Jade Falls");
        List<String> ans9 = new ArrayList<>();
        ans9.add("Belmont");
        ans9.add("Kaldoria");
        List<String> ans10 = new ArrayList<>();
        ans10.add("Lunar Crest");
        ans10.add("Havenbrook");
        ans10.add("Glimmermere");
        List<String> ans11 = new ArrayList<>();
        ans11.add("Lunar Crest");
        ans11.add("Duskwood");
        ans11.add("Ironforge");

        List<String> ans12 = new ArrayList<>();
        ans12.add("Duskwood");
        ans12.add("Everglade");
        ans12.add("Jade Falls");
        ans12.add("Glimmermere");
        ans12.add("Kaldoria");

        ans.put(names[0], ans1);
        ans.put(names[1], ans2);
        ans.put(names[2], ans3);
        ans.put(names[3], ans4);
        ans.put(names[4], ans5);
        ans.put(names[5], ans6);
        ans.put(names[6], ans7);
        ans.put(names[7], ans8);
        ans.put(names[8], ans9);
        ans.put(names[9], ans10);
        ans.put(names[10], ans11);
        ans.put(names[11], ans12);
        return ans;
    }

    public static void showNiebor(Map<String, List<String>> map){
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " has neibor");
            for(String name : entry.getValue()){
                System.out.print(name + "  ");
            }
            System.out.println();
        }
    }

    public static String chooseOrder(String userName) {
        System.out.println("You are the " + userName + " player, what would you like to do?");
        System.out.println("(M)ove\n(A)ttack\n(D)one");
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            String choose = line.toUpperCase();
            if (!choose.equals("M") && !choose.equals("A") && !choose.equals("D")) {
                System.out.println("Please re-input the choice.");
            } else {
                return choose;
            }
        }
    }

    public static  GameActionReq chooseOrderDetail() {
        GameActionReq req = new GameActionReq();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input the From territory: ");
        req.setFrom(scanner.next());
        System.out.print("Please input the To territory: ");
        req.setTo(scanner.next());
        System.out.print("Please input the units you want to perform order: ");
        req.setUnits(scanner.nextInt());
        return req;
    }



}

