package handler;

import message.ErrorInvalidStateMessage;

public class ErrorInvalidStateHandler {
    public void handle(ErrorInvalidStateMessage message) {
        System.out.println("==============");
        System.out.println("ERROR: Invalid State");
        System.out.println("Error: ");
        System.out.println(message.getError());
        System.out.println("Received message:");
        System.out.println(message.getReceivedMessage());
        System.out.println("==============");
    }
}
