package com.berthias.api_grille_voltorbataille.grille.model;

import com.berthias.api_grille_voltorbataille.grille.dto.GrilleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GrilleMapper {
	GrilleDto grilleToGrilleDto(Grille grille);
}
