package br.com.fredericci.devoctans;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView index(@RequestParam(required = false, name = "name") String name) {


        ModelAndView view = new ModelAndView("home/index");


        String welcomeMessage = Optional.ofNullable(name)
                .map("Welcome "::concat)
                .orElse("");

        view.addObject("greetings", welcomeMessage);

        return view;
    }

}
