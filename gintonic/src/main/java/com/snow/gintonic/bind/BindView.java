package com.snow.gintonic.bind;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) //解析常量
@Retention(RetentionPolicy.RUNTIME) //运行时
public @interface BindView {
    int value() default -1;
}
