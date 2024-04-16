package com.group_six.risc_game.client;

import com.group_six.risc_game.client.dto.TextUi;
import com.group_six.risc_game.domain.vo.request.GameActionReq;

import java.util.List;
import java.util.Map;

import static com.group_six.risc_game.client.dto.TextUi.checkInput;
import static com.group_six.risc_game.client.dto.TextUi.createNeibour;

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
                while (errMes != null){
                    gameActionReq = TextUi.chooseOrderDetail();
                    errMes = checkInput(gameActionReq.getFrom(), gameActionReq.getTo(), neibor);
                    if(errMes != null) System.out.println(errMes);
                }
                httpClient.sendMove(userName, roomId, gameActionReq);
            }
            // attack
            else if (choose.equals("A")){
                GameActionReq gameActionReq = null;
                while (errMes != null){
                    gameActionReq = TextUi.chooseOrderDetail();
                    errMes = checkInput(gameActionReq.getFrom(), gameActionReq.getTo(), neibor);
                    if(errMes != null) System.out.println(errMes);
                }
                httpClient.sendAttack(userName, roomId, gameActionReq);
            }else{// end
                httpClient.sendEndPhase(userName, roomId);
                System.out.println(curPhase);
                while (!httpClient.moveNextPhase(curPhase, userName, roomId))
                    ;
                curPhase++;
            }
            System.out.println(
                    httpClient.getWorldMap(userName, roomId)
            );

            TextUi.showNiebor(neibor);

        }



    }
}