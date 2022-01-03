package com.lq.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author qili
 * @create 2021-12-05-15:03
 */
public class WebUtils {
    /**
     * 将Map中的值注入到JavaBean中
     * @param value
     * @param bean
     */
    public static <T> T copyParamtersToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转化为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt, int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
