package com.berthias.api_grille_voltorbataille.grille.dto;

import com.berthias.api_grille_voltorbataille.grille.model.Indice;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GrilleDto {
	private List<List<Integer>> plateau;
	private List<Indice> verticalIndices;
	private List<Indice> horizontalIndices;
}
