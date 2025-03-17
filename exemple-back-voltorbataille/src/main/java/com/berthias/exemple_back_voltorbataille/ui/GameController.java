package com.berthias.exemple_back_voltorbataille.ui;

import com.berthias.exemple_back_voltorbataille.partie.PartieController;
import com.berthias.exemple_back_voltorbataille.partie.PartieDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class GameController {

	private final PartieController partieController;

	@GetMapping()
	String getPlayTemplate(Model model) {
		PartieDto partie = partieController.getPartie();
		model.addAttribute("partie", partie);
		return "game-voltorbataille";
	}

	@GetMapping("/new-partie")
	String getPartie(Model model) {
		partieController.nouvellePartie();
		return getPlayTemplate(model);
	}

	@GetMapping("/click-on-case")
	String clickOnCase(@RequestParam int x, @RequestParam int y, Model model) {
		partieController.clickOnCase(x, y);
		return getPlayTemplate(model);
	}

	@GetMapping("/niveau-suivant")
	String passerNiveauSuivant(Model model) {
		partieController.levelUp();
		return getPlayTemplate(model);
	}

	@GetMapping("/error")
	String getError(Model model) {
		return "error";
	}

	@GetMapping("/login")
	String login() {
		return "login";
	}
}
