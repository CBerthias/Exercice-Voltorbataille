package com.berthias.api_grille_volotorbataille.grille.service;

import com.berthias.api_grille_volotorbataille.grille.model.Grille;
import com.berthias.api_grille_volotorbataille.grille.model.Indice;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
		List<Integer> probaList = createProbaList(difficulte);
		List<List<Integer>> plateau = new ArrayList<>();
		for (int ligne = 0; ligne < hauteur; ligne++) {
			List<Integer> lignePlateau = new ArrayList<>();
			for (int colonne = 0; colonne < largeur; colonne++) {
				Random random = new Random();
				int value = probaList.get(random.nextInt(probaList.size()));
				lignePlateau.add(value);
			}
			plateau.add(lignePlateau);
		}
		return plateau;
	}

	public List<Indice> creerVerticalIndices(List<List<Integer>> plateau) {
		List<Indice> indices = new ArrayList<>();
		for (List<Integer> ligne : plateau) {
			int nbBombes = 0;
			int nbPoints = 0;
			for (Integer value : ligne) {
				if (value == -1) {
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
				if (ligne.get(colonne) == -1) {
					nbBombes++;
				} else {
					nbPoints += ligne.get(colonne);
				}
			}
			indices.add(new Indice(nbBombes, nbPoints));
		}
		return indices;
	}

	public List<Integer> createProbaList(int difficulte) {
		List<Integer> probaList = new ArrayList<>();
		probaList.addAll(List.of(-1, 0, 1, 2, 3));
		for (int zero = 0; zero < difficulte; zero++) {
			probaList.add(0);
		}
		for (int un = 0; un < difficulte * 2; un++) {
			probaList.add(1);
		}
		for (int deux = 0; deux < difficulte * 3; deux++) {
			probaList.add(2);
		}
		for (int trois = 0; trois < difficulte * 4; trois++) {
			probaList.add(3);
			probaList.add(-1);
		}
		Collections.shuffle(probaList);
		return probaList;
	}

}
