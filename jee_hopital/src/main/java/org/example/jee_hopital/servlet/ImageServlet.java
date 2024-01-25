package org.example.jee_hopital.servlet;

import org.example.jee_hopital.entities.Patient;
import org.example.jee_hopital.services.PatientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jee_hopital.entities.Patient;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/imageServlet")
public class ImageServlet extends HttpServlet {
    private PatientService service;

    public void init() {

        service = new PatientService();

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Patient produit = service.findById(id);
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        if (produit.getImage() != null) {
            out.write(produit.getImage());
        } else {
            out.write(null);
        }
        out.close();
    }
}
