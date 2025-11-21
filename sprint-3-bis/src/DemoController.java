package com.example.controllers;

import com.example.annotation.AnnotationController;
import com.example.annotation.UrlMethod;
import com.example.utils.ModelView;

import java.util.ArrayList;
import java.util.List;

@AnnotationController(url = "/demo")
public class DemoController {

    @UrlMethod(path = "/hello")
    public ModelView hello() {
        ModelView mv = new ModelView("demo.jsp");
        mv.addData("username", "Antonio");
        List<String> items = new ArrayList<>();
        items.add("Item A");
        items.add("Item B");
        mv.addData("items", items);
        return mv;
    }

    @UrlMethod(path = "/text")
    public String text() {
        System.out.println("DemoController.text() called");
        return "Hello from DemoController.text()";
    }
}
