package com.berthias.exemple_back_voltorbataille.partie;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PartieController {

	private final PartieService partieService;

	@GetMapping("/partie")
	Partie getPartie() {
		return partieService.getPartie();
	}
}
