package com.example.correctionproduit.servlet;

import com.example.correctionproduit.entities.Produit;
import com.example.correctionproduit.services.ProduitService;
import com.example.correctionproduit.utils.Definition;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@WebServlet("/")
public class ProduitServlet extends HttpServlet {

    private ProduitService service;


    public void init() {

        service = new ProduitService();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/details":
                    showProduct(request, response);
                    break;
                case "/update":
                    updateProduct(request, response);
                    break;
                case "/list":
                    listProduct(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        request.setAttribute("produits", service.findAll());
        request.getRequestDispatcher(Definition.VIEW_PATH+"produits.jsp").forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(Definition.VIEW_PATH+"form-produit.jsp");
        dispatcher.forward(request, response);
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        if(request.getParameter("id") != null) {
            int id = Integer.parseInt((request.getParameter("id")));
            Produit produit = service.findById(id);
            request.setAttribute("produit", produit);
            request.getRequestDispatcher(Definition.VIEW_PATH+"produit.jsp").forward(request,response);
        }
        else {
            request.setAttribute("produits", service.findAll());
            request.getRequestDispatcher(Definition.VIEW_PATH+"produits.jsp").forward(request,response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {


    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String marque = request.getParameter("marque");
        String reference = request.getParameter("reference");
        int stock = Integer.parseInt(request.getParameter("stock"));
        double prix = Double.parseDouble(request.getParameter("prix"));
        LocalDate dateAchat = LocalDate.parse(request.getParameter("dateAchat"));
        Produit produit = new Produit(marque, reference, Date.from(dateAchat.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), prix, stock);

        if(service.create(produit)) {
            response.sendRedirect("list");
        }else{
            response.sendRedirect(Definition.VIEW_PATH+"form-produit.jsp");
        }

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Produit produit = service.findById(id);
        if(produit != null){
            service.delete(produit);
        }
        response.sendRedirect("list");
    }

}
