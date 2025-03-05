package com.berthias.api_grille_volotorbataille.grille.service;

import com.berthias.api_grille_volotorbataille.grille.constants.GrilleConstants;
import com.berthias.api_grille_volotorbataille.grille.model.Grille;
import com.berthias.api_grille_volotorbataille.grille.model.Indice;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@NoArgsConstructor
public class GrilleCreationService {

	public Grille createGrille(int hauteur, int largeur, int difficulte) {
		Grille grille = new Grille();
		List<List<Integer>> plateau = creerPlateau(hauteur, largeur, difficulte);
		List<Indice> verticalIndices = creerVerticalIndices(plateau);
		List<Indice> horizontalIndices = creerHorizontalIndices(plateau);
		grille.setPlateau(plateau);
		grille.setVerticalIndices(verticalIndices);
		grille.setHorizontalIndices(horizontalIndices);
		return grille;
	}

	public List<List<Integer>> creerPlateau(int hauteur, int largeur, int difficulte) {
		List<List<Integer>> plateau = createBasePlateau(hauteur, largeur);
		int nbTour = 0;
		while (nbTour < 1000000 && getPointsTotaux(plateau) < GrilleConstants.POINTS_DIFFICULTE_BASE * Math.pow(2, difficulte)) {
			Random random = new Random();
			int x = random.nextInt(hauteur);
			int y = random.nextInt(largeur);
			plateau.get(x).set(y, random.nextInt(2, 4));
			nbTour++;
		}
		return plateau;
	}

	public List<Indice> creerVerticalIndices(List<List<Integer>> plateau) {
		List<Indice> indices = new ArrayList<>();
		for (List<Integer> ligne : plateau) {
			int nbBombes = 0;
			int nbPoints = 0;
			for (Integer value : ligne) {
				if (value == 0) {
					nbBombes++;
				} else {
					nbPoints += value;
				}
			}
			indices.add(new Indice(nbBombes, nbPoints));
		}
		return indices;
	}

	public List<Indice> creerHorizontalIndices(List<List<Integer>> plateau) {
		List<Indice> indices = new ArrayList<>();
		for (int colonne = 0; colonne < plateau.getFirst().size(); colonne++) {
			int nbBombes = 0;
			int nbPoints = 0;
			for (List<Integer> ligne : plateau) {
				if (ligne.get(colonne) == 0) {
					nbBombes++;
				} else {
					nbPoints += ligne.get(colonne);
				}
			}
			indices.add(new Indice(nbBombes, nbPoints));
		}
		return indices;
	}

	private List<List<Integer>> createBasePlateau(int hauteur, int largeur) {
		List<List<Integer>> plateau = new ArrayList<>();
		for (int ligne = 0; ligne < hauteur; ligne++) {
			List<Integer> lignePlateau = new ArrayList<>();
			for (int colonne = 0; colonne < largeur; colonne++) {
				Random random = new Random();
				int value = random.nextInt(0, 2);
				lignePlateau.add(value);
			}
			plateau.add(lignePlateau);
		}
		return plateau;
	}

	private int getPointsTotaux(List<List<Integer>> plateau) {
		int pointsTotaux = 1;
		for (List<Integer> ligne : plateau) {
			for (Integer value : ligne) {
				if (value > 0) {
					pointsTotaux *= value;
				}
			}
		}
		return pointsTotaux;
	}

}
