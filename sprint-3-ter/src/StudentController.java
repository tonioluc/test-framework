package com.example.controller;

import com.example.annotation.AnnotationController;
import com.example.annotation.UrlMethod;
import com.example.utils.ModelView;

@AnnotationController(url = "/student")
public class StudentController {

    @UrlMethod(path = "/{id}/note/{noteId}")
    public String infoEtudiant(Integer id,Integer note) {
        System.out.println("StudentController.infoEtudiant() called with id: " + id+", note: " + note);
        return "ID étudiant reçu = " + id+", note = " + note;
    }

}