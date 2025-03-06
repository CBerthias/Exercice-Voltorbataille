package com.berthias.exemple_back_voltorbataille.partie;

import com.berthias.exemple_back_voltorbataille.grille.Grille;
import lombok.Data;

@Data
public class PartieDto {
	private Grille grille;
	private int nbPointsEnCours;
	private int nbPointsGagnes;
	private int difficulte;
	private boolean gagnee;
	private boolean perdue;
}
