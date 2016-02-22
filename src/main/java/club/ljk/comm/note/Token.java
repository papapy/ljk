package club.ljk.comm.note;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 重复提交
 * Created by lijk on 2015/11/25.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {
    boolean save() default false;

    boolean remove() default false;
}
