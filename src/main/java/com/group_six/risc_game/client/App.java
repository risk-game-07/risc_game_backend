package com.group_six.risc_game.client;
import com.group_six.risc_game.client.dto.GameActionReq;
import com.group_six.risc_game.client.dto.TextUi;

import java.util.List;
import java.util.Map;


public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        HttpClient httpClient = new HttpClient();
        String userName = TextUi.inputUserName();
        int roomSize = TextUi.chooseRoom();
        int curNum = httpClient.addGame(userName, roomSize);
        TextUi.showCurNum(curNum, roomSize);
        String roomId = "0";
        while (roomId.equals("0")){
            roomId = httpClient.waitOther(userName);
        }

        ClientPlayer clientPlayer = httpClient.getTerritory(userName, roomId);
        Map<String, Integer> map =  TextUi.showInitMapInfo(clientPlayer);
        httpClient.assignUnit(map, userName, roomId);
        int curPhase = 0;
        httpClient.sendEndPhase(userName, roomId);
        while (!httpClient.moveNextPhase(curPhase, userName, roomId))
            ;
        System.out.println(
                httpClient.getWorldMap(userName, roomId)
        );
        curPhase++;

        Map<String, List<String>> neibor = TextUi.createNeibour();
        TextUi.showNiebor(neibor);

        // begin the game
        while (true){
            String choose = TextUi.chooseOrder(userName);
            // move
            String errMes = "";
            if(choose.equals("M")){
                GameActionReq gameActionReq = null;
                while (!errMes.equals("null")){
                    gameActionReq = TextUi.chooseOrderDetail();
                    errMes = httpClient.sendMove(userName, roomId, gameActionReq);
                    if(!errMes.equals("null")) System.out.println(errMes);
                }
                // httpClient.sendMove(userName, roomId, gameActionReq);
            }
            // attack
            else if (choose.equals("A")){
                GameActionReq gameActionReq = null;
                while (!errMes.equals("null")){
                    gameActionReq = TextUi.chooseOrderDetail();
                    errMes = httpClient.sendAttack(userName, roomId, gameActionReq);
                    if(!errMes.equals("null")) System.out.println(errMes);
                }

            }else{// end
                httpClient.sendEndPhase(userName, roomId);
                System.out.println(curPhase);
                while (!httpClient.moveNextPhase(curPhase, userName, roomId)) ;
                curPhase++;
                if(httpClient.isEnd == 1){
                    System.out.println("WIN!!!!!!");
                    break;
                }
                if(httpClient.isEnd == 2){
                    System.out.println("LOSE!!!!!!");
                    break;
                }
            }
            System.out.println(
                    httpClient.getWorldMap(userName, roomId)
            );

            TextUi.showNiebor(neibor);

        }



    }
}