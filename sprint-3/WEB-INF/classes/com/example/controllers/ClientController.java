package com.example.controllers;

import com.example.annotation.AnnotationController;
import com.example.annotation.UrlMethod;

@AnnotationController(url = "/client")
public class ClientController {

    @UrlMethod(path = "/liste")
    public void getListe() {
        System.out.println("→ ClientController.getListe() exécutée !");
    }

    @UrlMethod(path = "/detail")
    public void getDetail() {
        System.out.println("→ ClientController.getDetail() exécutée !");
    }
}
