package com.snow.gintonic.bind;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * 自定义butterknife
 */
public class BindViewParser {
    public static void inject(Object object) {
        try {
            parse(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析获取值
     *
     * @param object
     * @throws Exception
     */
    public static void parse(Object object) throws Exception {
        final Class<?> clazz = object.getClass();
        View view = null;
        //获取clazz的变量，不论private还是public
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //这个变量 是否有BindView注解
            if (field.isAnnotationPresent(BindView.class)) {
                //获取这个变量对应的注解
                BindView injectView = field.getAnnotation(BindView.class);
                //获取值
                int id = injectView.value();
                if (id <= 0) {
                    throw new Exception("View的id不能为空");
                } else {
                    //设置可以访问
                    field.setAccessible(true);
                    //获取view
                    if (object instanceof View) {
                        view = ((View) object).findViewById(id);
                    } else if (object instanceof Activity) {
                        view = ((Activity) object).findViewById(id);
                    }
                    //设置View
                    field.set(object, view);
                }
            }
        }
    }
}
