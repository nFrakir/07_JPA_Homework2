package com.gmail.silverleaf.annn.servlets;

import com.gmail.silverleaf.annn.dbobjects.Dish;
import com.gmail.silverleaf.annn.dbutilities.DishController;
import com.gmail.silverleaf.annn.dbutilities.DishDAOJpaImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "IndexServlet", urlPatterns = "/")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String discountFilter = req.getParameter("discount");
        String weightFilter = req.getParameter("weight");
        List<Dish> dishes;
        DishController dc = new DishController(new DishDAOJpaImplementation());

        if (discountFilter != null) {
            dishes = dc.getDishesByDiscount(true);
        } else if (weightFilter != null) {
            dishes = dc.getDishesByWeight();
        } else {
            dishes = dc.getAllDishes();
        }

        req.setAttribute("dishes", dishes);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String add = req.getParameter("add");
        List<Dish> dishes;
        DishController dc = new DishController(new DishDAOJpaImplementation());

        if (add != null) {
            String title = req.getParameter("title");
            Double price = Double.valueOf(req.getParameter("price"));
            Double weight = Double.valueOf(req.getParameter("weight"));
            Boolean discount = (req.getParameter("discount") != null) ? true : false;
            dc.addDish(new Dish(title, price, weight, discount));
            dishes = dc.getAllDishes();
        } else {
            Double from = Double.valueOf(req.getParameter("from"));
            Double to = Double.valueOf(req.getParameter("to"));
            dishes = dc.getDishesByPrice(from, to);
        }
        req.setAttribute("dishes", dishes);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }
}
