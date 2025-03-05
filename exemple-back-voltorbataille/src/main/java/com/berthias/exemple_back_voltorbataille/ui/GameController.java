package com.berthias.exemple_back_voltorbataille.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {
	@GetMapping("/play")
	String getPlayTemplate(Model model) {
		return "game-voltorbataille";
	}
}
