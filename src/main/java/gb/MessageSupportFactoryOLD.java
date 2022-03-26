package gb;

import java.util.Properties;

public class MessageSupportFactoryOLD {
    private static MessageSupportFactoryOLD instance;

    private MessageRender messageRender;
    private MessageProvider messageProvider;
    private Properties properties;

    static {
        instance = new MessageSupportFactoryOLD();
    }

    public static MessageSupportFactoryOLD getInstance() {
        return instance;
    }

    public MessageRender getMessageRender() {
        return messageRender;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    private MessageSupportFactoryOLD() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/message-context.properties"));
            String renderClass = properties.getProperty("render.class");
            String providerClass = properties.getProperty("provider.class");

            messageRender = (MessageRender) Class.forName(renderClass).newInstance();
            messageProvider = (MessageProvider) Class.forName(providerClass).newInstance();

            messageRender.setMessageProvider(messageProvider);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
