package club.ljk.comm.note;

import java.lang.annotation.*;

/**
 * 正则匹配
 * Created by XKey on 2016/1/14.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Reg {
    String regExp();
    String msg();
}
