package androidx.datastore.preferences.protobuf;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class ManifestSchemaFactory implements SchemaFactory {
    public static final MessageInfoFactory EMPTY_FACTORY = new MessageInfoFactory() {
        public boolean isSupported(Class<?> cls) {
            return false;
        }

        public MessageInfo messageInfoFor(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    };
    public final MessageInfoFactory messageInfoFactory;

    public static class CompositeMessageInfoFactory implements MessageInfoFactory {
        public MessageInfoFactory[] factories;

        public CompositeMessageInfoFactory(MessageInfoFactory... messageInfoFactoryArr) {
            this.factories = messageInfoFactoryArr;
        }

        public boolean isSupported(Class<?> cls) {
            for (MessageInfoFactory isSupported : this.factories) {
                if (isSupported.isSupported(cls)) {
                    return true;
                }
            }
            return false;
        }

        public MessageInfo messageInfoFor(Class<?> cls) {
            for (MessageInfoFactory messageInfoFactory : this.factories) {
                if (messageInfoFactory.isSupported(cls)) {
                    return messageInfoFactory.messageInfoFor(cls);
                }
            }
            throw new UnsupportedOperationException(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("No factory is available for message type: ")));
        }
    }

    public ManifestSchemaFactory() {
        MessageInfoFactory messageInfoFactory2;
        MessageInfoFactory[] messageInfoFactoryArr = new MessageInfoFactory[2];
        messageInfoFactoryArr[0] = GeneratedMessageInfoFactory.instance;
        try {
            messageInfoFactory2 = (MessageInfoFactory) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            messageInfoFactory2 = EMPTY_FACTORY;
        }
        messageInfoFactoryArr[1] = messageInfoFactory2;
        CompositeMessageInfoFactory compositeMessageInfoFactory = new CompositeMessageInfoFactory(messageInfoFactoryArr);
        Internal.checkNotNull(compositeMessageInfoFactory, "messageInfoFactory");
        this.messageInfoFactory = compositeMessageInfoFactory;
    }
}
