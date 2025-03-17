package com.berthias.api_grille_voltorbataille.grille.model;

import lombok.Data;

@Data
public class Indice {
	private int nbBombes;
	private int nbPoints;

	public Indice(int nbBombes, int nbPoints) {
        this.nbBombes = nbBombes;
        this.nbPoints = nbPoints;
    }
}
