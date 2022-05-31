package handler;

import message.ErrorInvalidStateMessage;

/**
 * Error invalid state handler
 */
public class ErrorInvalidStateHandler {

    /**
     * Handle a message
     *
     * @param message the message to handle
     */
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
