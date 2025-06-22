package com.employee.builder.util;

import java.io.InputStream;
import java.util.Objects;

public class ContentUtil {

    public static String readContent(String fileName) throws RuntimeException {
        ClassLoader classLoader = ContentUtil.class.getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(
                fileName)) {
            return new String(
                    Objects.requireNonNull(inputStream).readAllBytes());
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
