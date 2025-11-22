package com.example.controllers;

import com.example.annotation.AnnotationController;
import com.example.annotation.UrlMethod;
import com.example.utils.ModelView;

@AnnotationController(url = "/oatra")
public class OatraController {

    @UrlMethod(path = "/kely")
    public ModelView test() {
        System.out.println("→ OatraController.test() exécutée !");
        return new ModelView("a.html");
    }
}
