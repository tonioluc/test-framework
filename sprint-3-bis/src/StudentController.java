package com.example.controller;

import com.example.annotation.AnnotationController;
import com.example.annotation.UrlMethod;
import com.example.utils.ModelView;

@AnnotationController(url = "/student")
public class StudentController {

    @UrlMethod(path = "/{id}")
    public String infoEtudiant() {
        System.out.println("→ StudentController.infoEtudiant() exécutée !");
        return "infoEtudiant appelée";
    }
}