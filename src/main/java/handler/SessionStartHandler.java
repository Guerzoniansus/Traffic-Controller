package handler;

import controller.Controller;
import message.SessionStartMessage;

import java.util.logging.Logger;

public class SessionStartHandler  {

    private final static Logger LOGGER = Logger.getLogger(SessionStartHandler.class.getName());

    public void handle(SessionStartMessage message) {
        // TODO
        LOGGER.info("Session started");
        Controller.getInstance().start();
    }
}
