package club.ljk.comm.util;

import java.util.UUID;

/**
 * Created by lijk on 2015/11/25.
 */
public class IDGenerator {
    public static synchronized String getUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }
}
