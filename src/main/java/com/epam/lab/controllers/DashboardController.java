package com.epam.lab.controllers;

import com.epam.lab.constants.Constants;
import com.epam.lab.models.Comment;
import com.epam.lab.models.Dashboard;
import com.epam.lab.models.Task;
import com.epam.lab.models.User;
import com.epam.lab.services.CommentService;
import com.epam.lab.services.DashboardService;
import com.epam.lab.services.TaskService;
import com.epam.lab.services.UserService;
import com.epam.lab.util.StringConcat;
import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents dashboard controller.
 */
@Controller
public class DashboardController {

    /**
     * This field represents logger
     */
    private static final Logger LOGGER = LogManager.getLogger(DashboardController.class);

    /**
     * This field represents dashboard id
     */
    private static int dasboardId;

    /**
     * This field represents task id
     */
    private static int taskId;

    /**
     * This field represents dashboard's service
     */
    @Autowired
    private DashboardService dashboardService;

    /**
     * This field represents user's service
     */
    @Autowired
    private UserService userService;

    /**
     * This field represents task's service
     */
    @Autowired
    private TaskService taskService;

    /**
     * This field represents comments's service
     */
    @Autowired
    private CommentService commentService;

    /**
     * This method describes logic of opening dashboard
     * @return ModelAndView
     */
    @RequestMapping(value = "/dashboard")
    public ModelAndView openDashboard() {
        ModelAndView modelAndView = new ModelAndView();
        List<Dashboard> dashboards = new ArrayList<>();
        List<User> users = new ArrayList<>();

        try {
            dashboards = dashboardService.getDashboards();
            users = userService.getUsers(Constants.USER);
        } catch (SQLException e) {
            LOGGER.error(Constants.ERROR_OPEN_DASHBOARD, e);
            e.printStackTrace();
        }

        modelAndView.addObject(Constants.DASHBOARDS, dashboards);
        modelAndView.addObject(Constants.USERS, users);
        modelAndView.setViewName(Constants.DASHBOARD);
        return modelAndView;
    }

    /**
     * This method describes logic of adding new Dashboard
     * @param dashboard Dashboard in input
     * @param result BindingResult in input
     * @param request HttpServletRequest in input
     * @return ModelAndView
     */
    @RequestMapping(value = "/add_dashboard")
    public ModelAndView addDashboard(@ModelAttribute Dashboard dashboard, BindingResult result, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        String userName = request.getParameter(Constants.USERNAME);

        try {
            dashboard.setAuthor(userName);
            dashboardService.addDashboard(dashboard);
        } catch (SQLException e) {
            LOGGER.error(Constants.ERROR_ADD_DASHBOARD, e);
            e.printStackTrace();
        }

        modelAndView.setViewName(Constants.DASHBOARD_REDIRECT);
        return modelAndView;
    }

    /**
     * This method describes logic of deleting dashboard
     * @param id int in input
     * @param dashboard Dashboard in input
     * @param result BindingResult in input
     * @return ModelAndView
     */
    @RequestMapping(value = "/delete_dashboard{id}")
    public ModelAndView deleteDashboard(@PathVariable int id, @ModelAttribute Dashboard dashboard, BindingResult result) {

        ModelAndView modelAndView = new ModelAndView();
        try {
            dashboard.setId(id);
            dashboardService.deleteDashboard(dashboard);
        } catch (SQLException e) {
            LOGGER.error(Constants.ERROR_DELETE_DASHBOARD, e);
            e.printStackTrace();
        }

        modelAndView.setViewName(Constants.DASHBOARD_REDIRECT);
        return modelAndView;
    }

    /**
     * This method describes logic if viewing dashboard
     * @param id int in input
     * @return ModelAndView
     */
    @RequestMapping(value = "/view_dashboard{id}")
    public ModelAndView viewDashboard(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();

        dasboardId = id;
        List<User> users;
        List<Task> tasks;

        try {
            Dashboard dashboard = dashboardService.getDashboard(id);
            users = userService.getUsers(Constants.USER);
            tasks = taskService.getTasks(id);
            modelAndView.addObject(Constants.TASKS, tasks);
            modelAndView.addObject(Constants.USERS, users);
            modelAndView.addObject(Constants.DASHBOARD, dashboard);
        } catch (SQLException e) {
            LOGGER.error(Constants.ERROR_DISPLAY_DASHBOARD, e);
            e.printStackTrace();
        }

        modelAndView.setViewName(Constants.VIEW_DASHBOARD);
        return modelAndView;
    }

    /**
     * This method describes logic of editing dashboard
     * @param id int in input
     * @param dashboard Dashboard in input
     * @param request HttpServletRequest in input
     * @return ModelAndView
     */

    @RequestMapping(value = "/edit_dashboard{id}")
    public ModelAndView editDashboard(@PathVariable int id, @ModelAttribute Dashboard dashboard, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        String username = request.getParameter(Constants.USERNAME);

        try {
            dashboard.setId(id);
            dashboard.setAuthor(username);
            dashboardService.editDashboard(dashboard);
        } catch (SQLException e) {
            LOGGER.error(Constants.ERROR_EDIT_DASHBOARD, e);
            e.printStackTrace();
        }

        StringConcat stringConcat = (str1, int1) -> str1 + int1;
        modelAndView.setViewName(stringConcat.sconcat(Constants.VIEW_DASHBOARD_REDIRECT, id));

        return modelAndView;
    }


    /**
     * This method describes logic of adding tasks
     * @param task Task in input
     * @param result BindingResult in input
     * @param request HttpServletRequest in input
     * @return ModelAndView
     */
    @RequestMapping(value = "/add_task")
    public ModelAndView addTask(@ModelAttribute Task task, BindingResult result, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String username = request.getParameter(Constants.USERNAME);

        try {
            task.setDashboardId(dasboardId);
            task.setAuthor(username);
            taskService.addTask(task);
        } catch (SQLException e) {
            LOGGER.error(Constants.ERROR_ADD_TASK, e);
            e.printStackTrace();
        }

        StringConcat stringConcat = (str1, int1) -> str1 + int1;
        modelAndView.setViewName(stringConcat.sconcat(Constants.VIEW_DASHBOARD_REDIRECT, dasboardId));
        return modelAndView;
    }

    /**
     * This method describes logic of deleting task
     * @param taskId int in input
     * @param task Task in input
     * @param result BindingResult in input
     * @return ModelAndView
     */
    @RequestMapping(value = "/delete_task{taskId}")
    public ModelAndView deleteTask(@PathVariable int taskId, @ModelAttribute Task task, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            task.setId(taskId);
            taskService.deleteTask(task);
        } catch (SQLException e) {
            LOGGER.error(Constants.ERROR_DELETE_TASK, e);
            e.printStackTrace();
        }
        StringConcat stringConcat = (str1, int1) -> str1 + int1;
        modelAndView.setViewName(stringConcat.sconcat(Constants.VIEW_DASHBOARD_REDIRECT, dasboardId));
        return modelAndView;
    }

    /**
     * This method describes logic of viewing tasks
     * @param id int in input
     * @return ModelAndView
     */
    @RequestMapping(value = "view_task{id}")
    public ModelAndView viewTask(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        taskId = id;
        List<User> users = new ArrayList<>();
        List<Comment> comments = new ArrayList<>();
        User user = null;
        Task task = null;

        try {
            user = userService.getUser(Constants.LOGIN_USER); //
            task = taskService.getTask(id);
            users = userService.getUsers(Constants.USER);
            comments = commentService.getComments(id);
        } catch (SQLException e) {
            LOGGER.error(Constants.ERROR_VIEW_TASK, e);
            e.printStackTrace();
        }

        modelAndView.addObject(Constants.USER_NAME, user);
        modelAndView.addObject(Constants.TASK, task);
        modelAndView.addObject(Constants.DASHBOARD_ID, dasboardId);
        modelAndView.addObject(Constants.USERS, users);
        modelAndView.addObject(Constants.COMMENTS, comments);
        modelAndView.setViewName(Constants.VIEW_TASK);
        return modelAndView;
    }

    /**
     * This method describes logic of editing tasks
     * @param taskId int in input
     * @param task Task in input
     * @param request HttpServletRequest in input
     * @return ModelAndView
     */
    @RequestMapping(value = "/edit_task{taskId}")
    public ModelAndView editTask(@PathVariable int taskId, @ModelAttribute Task task, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String username = request.getParameter(Constants.USERNAME);

        try {
            task.setDashboardId(dasboardId);
            task.setId(taskId);
            task.setAuthor(username);
            taskService.editTask(task);
        } catch (SQLException e) {
            LOGGER.error(Constants.ERROR_EDIT_TASK, e);
            e.printStackTrace();
        }

        StringConcat stringConcat = (str1, int1) -> str1 + int1;
        modelAndView.setViewName(stringConcat.sconcat(Constants.VIEW_TASK_REDIRECT, taskId));
        return modelAndView;
    }

    /**
     * This method describes logic of adding comment.
     * @param comment Comment in input
     * @param request HttpServletRequest in input
     * @return ModelAndView
     */
    @RequestMapping(value = "/add_comment")
    public ModelAndView addComment(@ModelAttribute Comment comment, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        String username = request.getParameter(Constants.USERNAME);
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_PATTERN);

        String date = format.format(new Date(System.currentTimeMillis()));

        try {
            comment.setTask_id(taskId);
            comment.setLogin(username);
            comment.setDate(date);
            commentService.addComment(comment);
        } catch (SQLException e) {
            LOGGER.error(Constants.ERROR_ADD_COMMENT, e);
            e.printStackTrace();
        }

        StringConcat stringConcat = (str1, int1) -> str1 + int1;
        modelAndView.setViewName(stringConcat.sconcat(Constants.VIEW_TASK_REDIRECT, taskId));
        return modelAndView;
    }

    /**
     * This method describes logic of deleting comment.
     * @param id int in input
     * @param comment Comment in input
     * @return ModelAndView
     */
    @RequestMapping(value = "/delete_comment{id}")
    public ModelAndView deleteComment(@PathVariable int id, @ModelAttribute Comment comment) {

        ModelAndView modelAndView = new ModelAndView();

        try {
            comment.setId(id);
            commentService.deleteComment(comment);
        } catch (SQLException e) {
            LOGGER.error(Constants.ERROR_DELETE_COMMENT, e);
        }

        StringConcat stringConcat = (str1, int1) -> str1 + int1;
        modelAndView.setViewName(stringConcat.sconcat(Constants.VIEW_TASK_REDIRECT, taskId));

        return modelAndView;
    }

    /**
     * This method describes logic of editing comment.
     * @param commentId int in input
     * @param request HttpServletRequest in input
     * @param comment Comment in input
     * @return ModelAndView
     */
    @RequestMapping(value = "/edit_comment{commentId}")
    public ModelAndView editComment(@PathVariable int commentId, HttpServletRequest request,
                                    @ModelAttribute Comment comment) {
        ModelAndView modelAndView = new ModelAndView();

        String login = request.getParameter(Constants.ED_LOGIN);
        String date = request.getParameter(Constants.ED_DATE);
        String text = request.getParameter(Constants.ED_TEXT_COMMENT);

        try {

            comment.setId(commentId);
            comment.setLogin(login);
            comment.setDate(date);
            comment.setTask_id(taskId);
            comment.setComment(text);
            commentService.editComment(comment);
        } catch (SQLException e) {
            LOGGER.error(Constants.ERROR_EDIT_COMMENT, e);
            e.printStackTrace();
        }

        StringConcat stringConcat = (str1, int1) -> str1 + int1;
        modelAndView.setViewName(stringConcat.sconcat(Constants.VIEW_TASK_REDIRECT, taskId));
        return modelAndView;
    }

    @ModelAttribute
    private Comment getComment() {
        return new Comment();
    }

    @ModelAttribute
    private Task getTask() {
        return new Task();
    }

    @ModelAttribute
    private Dashboard getDashboard() {
        return new Dashboard();
    }
}
