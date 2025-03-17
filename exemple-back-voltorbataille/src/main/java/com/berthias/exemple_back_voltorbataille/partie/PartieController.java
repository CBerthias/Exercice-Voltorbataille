package com.berthias.exemple_back_voltorbataille.partie;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PartieController {

	private final PartieService partieService;
	private final PartieMapper partieMapper;

	@GetMapping("/partie")
	public PartieDto getPartie() {
		Partie partie = partieService.getPartie();
		return partieMapper.partieToPartieDto(partie);
	}

	@PostMapping("/partie")
	public void nouvellePartie() {
		partieService.nouvellePartie();
	}

	@PostMapping("partie/click-on-case")
	public void clickOnCase(@RequestParam int x, @RequestParam int y) {
		partieService.clickOnCase(x, y);
	}

	@PostMapping("/level-up")
	public void levelUp() {
		partieService.levelUp();
	}
}
