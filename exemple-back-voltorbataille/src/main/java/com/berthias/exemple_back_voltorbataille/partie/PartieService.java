package com.berthias.exemple_back_voltorbataille.partie;

import com.berthias.exemple_back_voltorbataille.ext.GrilleApiService;
import com.berthias.exemple_back_voltorbataille.grille.Grille;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
@RequiredArgsConstructor
public class PartieService {

	private Partie partie;

	private final GrilleApiService grilleApiService;

	public Partie getPartie() {
		if (partie == null) {
			partie = new Partie();
		}
		return partie;
	}

	public void nouvellePartie() {
		partie = new Partie();
		partie.setNbPointsGagnes(0);

		nouveauPlateau(5, 5, 0);
	}

	public void clickOnCase(int x, int y) {
		if (!partie.isPerdue() && !partie.isGagnee()) {
			if (!partie.getCasesRevelees().get(x).get(y)) {
				int value = partie.getGrille().getPlateau().get(x).get(y);
				partie.getCasesRevelees().get(x).set(y, true);
				partie.verifyWinOrLose();
				if (partie.getNbPointsEnCours() == 0) {
					partie.setNbPointsEnCours(value);
				} else {
					partie.setNbPointsEnCours(partie.getNbPointsEnCours() * value);
				}
			}
		}
	}

	public void levelUp() {
		nouveauPlateau(5, 5, partie.getDifficulte() + 1);
	}

	private List<List<Boolean>> createNewCasesRevelees(int hauteur, int largeur) {
		List<List<Boolean>> casesRevelees = new ArrayList<>();
		for (int h = 0; h < hauteur; h++) {
			List<Boolean> ligne = new ArrayList<>();
			for (int l = 0; l < largeur; l++) {
				ligne.add(false);
			}
			casesRevelees.add(ligne);
		}
		return casesRevelees;
	}

	private void nouveauPlateau(int hauteur, int largeur, int difficulte) {
		partie.setGagnee(false);
		partie.setPerdue(false);
		partie.setDifficulte(difficulte);
		partie.setNbPointsGagnes(partie.getNbPointsGagnes() + partie.getNbPointsEnCours());

		Grille grille = grilleApiService.getGrille(hauteur, largeur, difficulte);
		partie.setGrille(grille);

		partie.setCasesRevelees(createNewCasesRevelees(hauteur, largeur));

		partie.setNbPointsEnCours(0);
	}
}
