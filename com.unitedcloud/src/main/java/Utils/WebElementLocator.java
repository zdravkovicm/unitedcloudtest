package main.java.Utils;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WebElementLocator {
    String webDesktop() default "";

}
