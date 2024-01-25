package org.example.jee_hopital.servlet;


import org.example.jee_hopital.entities.User;
import org.example.jee_hopital.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name="user", value="/user")
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("isLogged") != null || session.getAttribute("isLogged").equals(false) ){
            session.removeAttribute("isLogged");
            session.removeAttribute("name");
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        if(email != null && password != null && name != null){
            User user1 = new User(email,name,password);
            if(userService.create(user1)){
                resp.sendRedirect("login.jsp");
            }else{
                resp.sendRedirect("register.jsp");
            }

        }else if(email != null && password != null){
            User user2 = new User(email,password);
            User user3 =  userService.getByEmailPassword(user2);
            if(user3 != null){
                HttpSession session = req.getSession();
                session.setAttribute("isLogged", true);
                session.setAttribute("name",user3.getName());
                resp.sendRedirect("list");
            }else{
                HttpSession session = req.getSession();
                session.setAttribute("loginError", "Identifiants invalides.");
                resp.sendRedirect("login.jsp");
            }

        }else{
            resp.sendRedirect("login.jsp");
        }



    }

}
