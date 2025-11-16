package com.example.controllers;

import com.example.annotation.AnnotationController;
import com.example.annotation.UrlMethod;

@AnnotationController(url = "/client")
public class ClientController {

    @UrlMethod
    public String getListe() {
        String result = "Affichage pour tester test de ClientController.getListe() qui a une type de retour String";
        System.out.println("→ ClientController.getListe() exécutée !");
        return result;
    }

    // @UrlMethod(path = "/detail")
    public void getDetail() {
        System.out.println("→ ClientController.getDetail() exécutée !");
    }
}
