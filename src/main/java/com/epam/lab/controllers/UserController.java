package com.epam.lab.controllers;

import com.epam.lab.constants.Constants;
import com.epam.lab.models.User;
import com.epam.lab.services.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.codec.digest.DigestUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * This class represents user controller.
 */
@Controller
public class UserController {

    /**
     * This field represents logger
     */
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    /**
     * This field represents dashboard's id
     */
    private static int dasboardId;

    /**
     * This field represents task's id
     */
    private static int taskId;

    /**
     * This field represents user's service
     */
    @Autowired
    private UserService userService;

    /**
     * This method describes logic of logging out from account
     * @param request HttpServletRequest in input
     * @param response HttpServletResponse in input
     * @return String
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return Constants.LOGING_REDIRECT;
    }

    /**
     * This method describes logic of logging in
     * @param error String in input
     * @param logout String in input
     * @return ModelAndView
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = Constants.ERROR, required = false) String error,
                                  @RequestParam(value = Constants.LOGOUT, required = false) String logout) {

        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
            modelAndView.addObject(Constants.ERROR, Constants.WRONG_DATA);
        }

        if (logout != null) {
            modelAndView.addObject(Constants.MSG, Constants.SUCCESS);
        }
        modelAndView.setViewName(Constants.LOGIN);
        return modelAndView;
    }

    /**
     * This method describes logic of getting an error in logging in
     * @param error String in input
     * @return ModelAndView
     */
    @RequestMapping(value = "/registr_page{error}")
    public ModelAndView openRegistration(@PathVariable String error) {
        ModelAndView modelAndView = new ModelAndView();
        if (error.equals(Constants.ERROR)) {
            modelAndView.addObject(Constants.ERROR, Constants.ALREADY_EXISTS);
        }
        modelAndView.setViewName(Constants.REGISTRATION);
        return modelAndView;
    }

    /**
     * This method describes logic of registration
     * @param user User in input
     * @param result BindingResult in input
     * @param request HttpServletRequest in input
     * @return ModelAndView
     */
    @RequestMapping(value = "/add_user")
    public ModelAndView registration(@ModelAttribute User user, BindingResult result, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String username = request.getParameter(Constants.LOGIN);
        String path = null;
        try {
            User login = userService.getUser(username);
            if (login != null) {
                path = Constants.FORWARD_REGISTR_PAGE + Constants.ALREADY_EXISTS;
            } else {
                String password = request.getParameter(Constants.PASSWORD);
                user.setPassword(DigestUtils.md5Hex(password));
                userService.addUser(user);
                path = Constants.REDIRECT_HELLO + username;
            }
        } catch (SQLException e) {
            LOGGER.error(Constants.ERROR, e);
            e.printStackTrace();
        }
        modelAndView.setViewName(path);
        return modelAndView;
    }

    /**
     * This method describes logic of hello page :)
     * @param username String in input
     * @return ModelAndView
     */
    @RequestMapping(value = "/hello{username}")
    public ModelAndView hello(@PathVariable String username) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(Constants.USERNAME, username);
        modelAndView.setViewName(Constants.HELLO);
        return modelAndView;
    }

    @ModelAttribute
    private User getUser() {
        return new User();
    }
}
