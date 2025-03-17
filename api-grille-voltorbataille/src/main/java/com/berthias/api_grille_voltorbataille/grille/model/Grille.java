package com.berthias.api_grille_voltorbataille.grille.model;

import lombok.Data;

import java.util.List;

@Data
public class Grille {
	private List<List<Integer>> plateau;
	private List<Indice> verticalIndices;
	private List<Indice> horizontalIndices;
}
