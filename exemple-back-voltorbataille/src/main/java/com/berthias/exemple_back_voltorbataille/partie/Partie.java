package com.berthias.exemple_back_voltorbataille.partie;

import com.berthias.exemple_back_voltorbataille.grille.Grille;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Partie {
	private int nbPointsEnCours;
	private int nbPointsGagnes;
	private int difficulte;
	private boolean gagnee;
	private boolean perdue;
	private Grille grille;
	private List<List<Boolean>> casesRevelees;

	public void verifyWinOrLose() {
		List<List<Integer>> plateau = grille.getPlateau();
		gagnee = true;
		perdue = false;
		int l = 0;
		int c = 0;
		while (!perdue && (l < plateau.size() && c < plateau.get(l).size())) {
			int value = plateau.get(l).get(c);
			if (value == 0 && casesRevelees.get(l).get(c)) {
				gagnee = false;
				perdue = true;
			}
			if ((value == 2 || value == 3) && !casesRevelees.get(l).get(c)) {
				gagnee = false;
			}
			c++;
			if (c == plateau.get(l).size()) {
				c = 0;
				l++;
			}
		}
	}
}
