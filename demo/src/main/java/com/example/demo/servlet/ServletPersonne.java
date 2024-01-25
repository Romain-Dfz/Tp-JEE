package com.example.demo.servlet;

import com.example.demo.model.Voiture;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="voiture", value = "/voiture")
public class ServletVoiture extends HttpServlet {


    private List<Voiture> personneList;
    @Override
    public void init() throws ServletException {
        personneList = new ArrayList<>();
        Voiture voiture = null;
        personneList.add(voiture);
        Voiture voiture1 = null;
        personneList.add(voiture1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("marque");
        String prenom = req.getParameter("model");
        Voiture voiture = new Voiture(nom,prenom);
        JPopupMenu voitureList = null;
        voitureList.add((Action) voiture);
        req.setAttribute("voitures",voitureList);
        req.getRequestDispatcher("personne-list.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.sendRedirect("personne-form.jsp");
    }
}
