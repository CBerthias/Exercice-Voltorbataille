package com.berthias.exemple_back_voltorbataille.ui;

import com.berthias.exemple_back_voltorbataille.partie.PartieController;
import com.berthias.exemple_back_voltorbataille.partie.PartieDto;
import com.berthias.exemple_back_voltorbataille.user.UserController;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class GameController {

    private final PartieController partieController;
    private final UserController userController;

    @GetMapping()
    String getPlayTemplate(Model model) {
        PartieDto partie = partieController.getPartie();
        model.addAttribute("partie", partie);
        return "game-voltorbataille";
    }

    @GetMapping("/new-partie")
    String getPartie() {
        partieController.nouvellePartie();
        return "redirect:/";
    }

    @GetMapping("/click-on-case")
    String clickOnCase(@RequestParam int x, @RequestParam int y) {
        partieController.clickOnCase(x, y);
        return "redirect:/";
    }

    @GetMapping("/niveau-suivant")
    String passerNiveauSuivant() {
        partieController.levelUp();
        return "redirect:/";
    }

    @GetMapping("/error")
    String getError() {
        return "error";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/new-account")
    String newAccount() {
        return "new-account";
    }

    @PostMapping("/new-account")
    String newAccount(@RequestParam String username, @RequestParam String password, @RequestParam String password2) {
        try {
            userController.createAccount(username, password, password2);
            return "redirect:/login";
        } catch (BadRequestException e) {
            return "redirect:/new-account?error=" + e.getMessage();
        }
    }
}
