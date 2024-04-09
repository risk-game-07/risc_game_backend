package com.group_six.risc_game.client;

public class App1 {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.joinGame("test002", 2);
    }
}
