package club.ljk.comm.util;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;

/**
 * serializeUtils
 * Created by XKey on 2016/1/30.
 */
public class SerializeUtils extends SerializationUtils {

    public static Session deserializeFromString(String base64) {
        try {
            byte[] objectData = Base64.decode(base64);
            return deserialize(objectData);
        } catch (Exception e) {
            throw new RuntimeException("deserialize session error", e);
        }
    }

    public static byte[] serialize(Session session) {
        return null;
    }

    public static byte[] serialize(Object o) {
        return null;
    }
}
