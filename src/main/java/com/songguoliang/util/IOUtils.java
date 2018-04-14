package com.songguoliang.util;

import org.springframework.util.StreamUtils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @Description
 * @Author sgl
 * @Date 2018-04-13 15:31
 */
public class IOUtils extends StreamUtils {
    /**
     * 自动关闭
     *
     * @param closeable
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
