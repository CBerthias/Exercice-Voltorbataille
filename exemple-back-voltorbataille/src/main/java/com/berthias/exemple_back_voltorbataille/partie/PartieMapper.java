package com.berthias.exemple_back_voltorbataille.partie;

import com.berthias.exemple_back_voltorbataille.grille.Grille;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PartieMapper {
	default PartieDto partieToPartieDto(Partie partie) {
		PartieDto partieDto = new PartieDto();

		partieDto.setDifficulte(partie.getDifficulte());
		partieDto.setNbPointsEnCours(partie.getNbPointsEnCours());
		partieDto.setNbPointsGagnes(partie.getNbPointsGagnes());
		partieDto.setGagnee(partie.isGagnee());
		partieDto.setPerdue(partie.isPerdue());

		Grille grille = new Grille();
		if (partie.getGrille() != null) {
			List<List<Integer>> plateau = new ArrayList<>();
			for (int h = 0; h < partie.getGrille().getPlateau().size(); h++) {
				List<Integer> ligne = new ArrayList<>();
				for (int l = 0; l < partie.getGrille().getPlateau().get(h).size(); l++) {
					if (partie.getCasesRevelees().get(h).get(l)) {
						ligne.add(partie.getGrille().getPlateau().get(h).get(l));
					} else {
						ligne.add(-1);
					}
				}
				plateau.add(ligne);
			}
			grille.setPlateau(plateau);
			grille.setVerticalIndices(partie.getGrille().getVerticalIndices());
			grille.setHorizontalIndices(partie.getGrille().getHorizontalIndices());
		}

		partieDto.setGrille(grille);

		return partieDto;
	}
}
