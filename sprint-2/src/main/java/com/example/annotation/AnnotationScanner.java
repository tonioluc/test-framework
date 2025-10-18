package com.example.annotation;

import com.example.annotation.UrlMethod;
import com.example.controller.MyController;

import java.lang.reflect.Method;

public class AnnotationScanner {

    public static void main(String[] args) {
        // Classe à analyser
        Class<MyController> controllerClass = MyController.class;

        System.out.println("Méthodes annotées avec @UrlMethod :");

        for (Method method : controllerClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(UrlMethod.class)) {
                UrlMethod annotation = method.getAnnotation(UrlMethod.class);
                System.out.println("→ Méthode : " + method.getName() +
                                   ", chemin : " + annotation.path());
            }
        }
    }
}
