package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.MealMemoryStorage;
import ru.javawebinar.topjava.repository.Storage;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private static final int CALORIES_PER_DAY = 2000;
    private static final Storage storage = new MealMemoryStorage();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String idStr = req.getParameter("id");
        log.debug("POST to meals, id: {}", idStr);

        LocalDateTime date = LocalDateTime.parse(req.getParameter("date"));
        String description = req.getParameter("description");
        int calories = Integer.parseInt(req.getParameter("calories"));
        Meal meal = new Meal((idStr.isEmpty()) ? null : Integer.parseInt(idStr), date, description, calories);
        if (idStr.isEmpty()) {
            storage.save(meal);
        } else {
            storage.update(meal);
        }
        resp.sendRedirect("meals");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        log.debug("GET to meals, action: {}, id: {}", action, id);

        if (action == null) {
            request.setAttribute("meals", MealsUtil.filteredByStreams(storage.getAll(), LocalTime.MIN, LocalTime.MAX, CALORIES_PER_DAY));
            request.getRequestDispatcher("/meals.jsp").forward(request, response);
            return;
        }
        MealTo mealTo;
        switch (action) {
            case "edit":
                mealTo = MealsUtil.createTo(storage.get(Integer.parseInt(id)), false);
                break;
            case "add":
                mealTo = new MealTo(null, null, null, 0, false);
                break;
            case "delete":
                storage.delete(Integer.parseInt(id));
                response.sendRedirect("meals");
                return;
            default:
                throw new IllegalArgumentException(action + " not supported");
        }
        request.setAttribute("meal", mealTo);
        request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }
}
