package com.thoughtworks.videorental.controllers;

import com.thoughtworks.videorental.Views;
import com.thoughtworks.videorental.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by srideep on 13/12/14.
 */
@Controller
public class HomeController {

    private final MovieRepository movieRepository;

    @Autowired
    public HomeController(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @RequestMapping(value="/",method = RequestMethod.GET)
    public ModelAndView home(Model model){
        return Views.HOME_PAGE.prepareView(movieRepository.selectAll());
    }


}
