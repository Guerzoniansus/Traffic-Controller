package handler;

import controller.Controller;
import message.SessionStartMessage;

import java.util.logging.Logger;

/**
 * Session start handler
 */
public class SessionStartHandler  {

    private final static Logger LOGGER = Logger.getLogger(SessionStartHandler.class.getName());

    /**
     * Handle a message
     *
     * @param message the message to handle
     */
    public void handle(SessionStartMessage message) {
        // TODO
        LOGGER.info("Session started");
        Controller.getInstance().start();
    }
}
