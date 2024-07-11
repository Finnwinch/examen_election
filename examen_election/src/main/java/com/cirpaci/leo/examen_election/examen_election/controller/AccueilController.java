package com.cirpaci.leo.examen_election.examen_election.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller class AccueilController {
    @GetMapping("") public String index() { return "index"; }
}
