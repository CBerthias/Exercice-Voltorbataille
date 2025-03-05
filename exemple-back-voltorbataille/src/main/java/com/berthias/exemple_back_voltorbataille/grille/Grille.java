package com.berthias.exemple_back_voltorbataille.grille;

import lombok.Data;

import java.util.List;

@Data
public class Grille {
	private List<List<Integer>> plateau;
	private List<Indice> verticalIndices;
	private List<Indice> horizontalIndices;
}
