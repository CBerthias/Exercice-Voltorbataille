package com.berthias.api_grille_volotorbataille.grille.controller;

import com.berthias.api_grille_volotorbataille.grille.dto.GrilleDto;
import com.berthias.api_grille_volotorbataille.grille.model.Grille;
import com.berthias.api_grille_volotorbataille.grille.model.GrilleMapper;
import com.berthias.api_grille_volotorbataille.grille.service.GrilleCreationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreationGrilleController {

	private final GrilleCreationService grilleCreationService;
	private final GrilleMapper grilleMapper;

	@GetMapping("/grille")
	public GrilleDto getGrille(@RequestParam(value = "hauteur", defaultValue = "5") int hauteur,
							   @RequestParam(value = "largeur", defaultValue = "5") int largeur,
							   @RequestParam(value = "difficulte", defaultValue = "0") int difficulte) {
		Grille grille = grilleCreationService.createGrille(hauteur, largeur, difficulte);
		return grilleMapper.grilleToGrilleDto(grille);
	}
}
