package com.example.controllers;

import com.example.annotation.AnnotationController;
import com.example.annotation.UrlMethod;

@AnnotationController(url = "/oatra")
public class OatraController {

    @UrlMethod(path = "/kely")
    public void test() {
        System.out.println("→ OatraController.test() exécutée !");
    }
}
