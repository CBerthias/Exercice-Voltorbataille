package com.berthias.api_grille_volotorbataille.grille.model;

import com.berthias.api_grille_volotorbataille.grille.dto.GrilleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GrilleMapper {
	GrilleDto grilleToGrilleDto(Grille grille);
}
