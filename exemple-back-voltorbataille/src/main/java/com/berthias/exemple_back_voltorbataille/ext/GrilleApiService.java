package com.berthias.exemple_back_voltorbataille.ext;

import com.berthias.exemple_back_voltorbataille.grille.Grille;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GrilleApiService {

	@Value("${grilleApi.url}")
	private String grilleApiUrl;

	public Grille getGrille(int hauteur, int largeur, int difficulte) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(grilleApiUrl + "/grille" + "?hauteur=" + hauteur + "&largeur=" + largeur + "&difficulte=" + difficulte, Grille.class);
	}
}
