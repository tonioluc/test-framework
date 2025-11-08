package com.example.scanner;

import com.example.annotation.AnnotationController;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class AnnotationScannerManual {

    public static void main(String[] args) throws Exception {
        Set<Class<?>> annotated = findAnnotatedClasses("com.example");
        if (annotated.isEmpty()) {
            System.out.println("Aucune classe annotée trouvée !");
        } else {
            for (Class<?> clazz : annotated) {
                AnnotationController annotation = clazz.getAnnotation(AnnotationController.class);
                System.out.println("Classe : " + clazz.getName() + " => URL = " + annotation.url());
            }
        }
    }

    public static Set<Class<?>> findAnnotatedClasses(String packageName)
            throws IOException, ClassNotFoundException {
        Set<Class<?>> annotated = new HashSet<>();
        String path = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = classLoader.getResources(path);

        while (resources.hasMoreElements()) {
            File directory = new File(resources.nextElement().getFile());
            annotated.addAll(findClasses(directory, packageName));
        }

        Set<Class<?>> result = new HashSet<>();
        for (Class<?> clazz : annotated) {
            if (clazz.isAnnotationPresent(AnnotationController.class)) {
                result.add(clazz);
            }
        }
        return result;
    }

    private static Set<Class<?>> findClasses(File directory, String packageName)
            throws ClassNotFoundException {
        Set<Class<?>> classes = new HashSet<>();
        if (!directory.exists()) return classes;
        File[] files = directory.listFiles();
        if (files == null) return classes;

        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + '.'
                        + file.getName().substring(0, file.getName().length() - 6);
                classes.add(Class.forName(className));
            }
        }
        return classes;
    }
}
