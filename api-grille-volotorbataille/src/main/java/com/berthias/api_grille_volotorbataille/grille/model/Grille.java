package com.berthias.api_grille_volotorbataille.grille.model;

import lombok.Data;
import org.mapstruct.Mapper;

import java.util.List;

@Data
public class Grille {
	private List<List<Integer>> plateau;
	private List<Indice> verticalIndices;
	private List<Indice> horizontalIndices;
}
