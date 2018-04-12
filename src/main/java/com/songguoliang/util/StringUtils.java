package com.songguoliang.util;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-12 11:26
 */
public class StringUtils extends org.springframework.util.StringUtils {
    public static boolean isNotBlank(final CharSequence cs) {
        return hasText(cs);
    }

    public static boolean isBlank(final CharSequence cs) {
        return !hasText(cs);
    }
}
