package club.ljk.comm.util;

/**
 * 常量工具
 * Created by XKey on 2016/1/21.
 */
public class ConstantUtils {

    /**
     * 有效标识
     */
    public interface EFFECTIVE_FLAG {
        /**
         * 有效
         */
        final static Integer NO_DEL = 0;
        /**
         * 无效，逻辑删除
         */
        final static Integer IS_DEL = 1;
    }
}
