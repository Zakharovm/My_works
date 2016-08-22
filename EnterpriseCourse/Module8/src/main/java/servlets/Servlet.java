package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object o = session.getAttribute("allTasks");
        Map<String, Task> allTasks = (Map<String, Task>) session.getAttribute("allTasks");
        Set<String> completedTasks = new HashSet<>();

        String tasks[] = request.getParameterValues("task");


        if (o == null) {
            allTasks = initAllTasks();

        } else {
            if (tasks != null) {
                for (int i = 0; i < tasks.length; i++) {
                    completedTasks.add(tasks[i]);
                }
                allTasks = allTasks.entrySet().stream().filter(name -> !completedTasks.contains(name.getKey()))
                        .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
            }

        }

        session.setAttribute("allTasks", allTasks);
        dispatch(request, response);

    }

    private Map<String, Task> initAllTasks() {
        Map<String, Task> allTasks;
        allTasks = new HashMap<>();
        allTasks.put("Clean the room", new Task("Clean the kitchen", "Home cleaning"));
        allTasks.put("Learn about JSTL", new Task("Learn about JSTL", "Studies"));
        allTasks.put("Buy a TV", new Task("Buy a TV", "Purchase"));
        allTasks.put("Call to memory about CSS, HTML", new Task("Call to memory about CSS, HTML", "Studies"));
        return allTasks;
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("toDoList.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<String, Task> allTasks = (Map<String, Task>) session.getAttribute("allTasks");
        String taskName = request.getParameter("task_name");
        String taskCategory = request.getParameter("task_category");

        if (taskName != null) {
            allTasks.put(taskName, new Task(taskName, taskCategory));
        }
        session.setAttribute("allTasks", allTasks);
        dispatch(request, response);
    }
}
