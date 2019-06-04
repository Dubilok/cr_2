package ru.ivmiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.ivmiit.dao.UserDao;
import ru.ivmiit.forms.UserForm;
import ru.ivmiit.models.User;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("usersFromServer", userDao.findAll());
        return modelAndView;
    }

    /*@RequestMapping(path = "/users/{user-id}", method = RequestMethod.GET)
    public ModelAndView getUserById(@PathVariable("user-id") Integer userId) {
        User user = userDao.getById(userId);
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("usersFromServer", user);
        return modelAndView;
    }*/

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public String addUser(UserForm userForm) {
        User user = UserForm.from(userForm);
        userDao.save(user);
        return "redirect:/users";
    }

    @RequestMapping(path = "/delete/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userDao.delete(id);
        return "redirect:/users";
    }

    @RequestMapping(path = "/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDao.getById(id));
        return "update";
    }

    @RequestMapping(path = "/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userDao.update(user);
        return "redirect:/users";
    }

}