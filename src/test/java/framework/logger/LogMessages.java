package framework.logger;

import config_util.ConfigManager;

/**
 * @author Pavel Romanov 28.12.2022
 */
public enum LogMessages {
    PRESS_BUTTON("Нажимаем кнопку ");

    private final String messageText;

    private LogMessages(String messageText) {
        this.messageText = messageText;
    }

    public String getText() {
        return messageText;
    }
}
