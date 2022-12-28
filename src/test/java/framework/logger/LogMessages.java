package framework.logger;

/**
 * @author Pavel Romanov 28.12.2022
 */
public enum LogMessages {
    PRESS_BUTTON("Нажимаем кнопку "),
    CHECK_PAGE("Проверям открытие "),
    CHECK_WHAT("Проверяем, что "),
    SWITCH_TO_MAIN("Переходим на главную страницу.");

    private final String messageText;

    private LogMessages(String messageText) {
        this.messageText = messageText;
    }

    public String getText() {
        return messageText;
    }
}
