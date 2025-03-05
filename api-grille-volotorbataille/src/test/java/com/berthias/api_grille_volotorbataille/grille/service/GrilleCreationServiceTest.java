package com.berthias.api_grille_volotorbataille.grille.service;

import com.berthias.api_grille_volotorbataille.grille.model.Grille;
import com.berthias.api_grille_volotorbataille.grille.model.Indice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GrilleCreationServiceTest {

	@Spy
	GrilleCreationService grilleCreationService;

	public static Stream<Arguments> getRandomGrilleDimensions() {
		Random random = new Random();
		return Stream.of(
				Arguments.of(random.nextInt(1, 10), random.nextInt(1, 10)),
				Arguments.of(random.nextInt(1, 10), random.nextInt(1, 10)),
				Arguments.of(random.nextInt(1, 10), random.nextInt(1, 10))
		);
	}

	@ParameterizedTest
	@MethodSource("getRandomGrilleDimensions")
	void testShouldCreateGrilleWithCorrectDimensions(int nbLignes, int nbColonnes) {
		Grille grille = grilleCreationService.createGrille(nbLignes, nbColonnes, 0);
		assertThat(grille.getPlateau()).hasSize(nbLignes);
		assertThat(grille.getPlateau().getFirst()).hasSize(nbColonnes);
		assertThat(grille.getHorizontalIndices()).hasSize(nbColonnes);
		assertThat(grille.getVerticalIndices()).hasSize(nbLignes);
	}

	@Test
	void testIndicesShouldHaveRightValues() {
		List<Integer> ligne1 = List.of(1, 2, 3, 0, 0, 1);
		List<Integer> ligne2 = List.of(0, 1, 0, 0, 0, 2);
		List<Integer> ligne3 = List.of(1, 2, 3, 3, 0, 1);
		List<List<Integer>> plateau = List.of(ligne1, ligne2, ligne3);

		Indice indiceLigne1 = new Indice(2, 7);
		Indice indiceLigne2 = new Indice(4, 3);
		Indice indiceLigne3 = new Indice(1, 10);

		Indice indiceColonne1 = new Indice(1, 2);
		Indice indiceColonne2 = new Indice(0, 5);
		Indice indiceColonne3 = new Indice(1, 6);
		Indice indiceColonne4 = new Indice(2, 3);
		Indice indiceColonne5 = new Indice(3, 0);
		Indice indiceColonne6 = new Indice(0, 4);

		List<Indice> expectedVerticalIndices = List.of(indiceLigne1, indiceLigne2, indiceLigne3);
		List<Indice> expectedHorizontalIndices = List.of(indiceColonne1, indiceColonne2, indiceColonne3, indiceColonne4, indiceColonne5, indiceColonne6);

		when(grilleCreationService.creerPlateau(3, 6, 0)).thenReturn(plateau);

		Grille actualGrille = grilleCreationService.createGrille(3, 6, 0);

		assertThat(actualGrille.getVerticalIndices()).usingRecursiveComparison().isEqualTo(expectedVerticalIndices);
		assertThat(actualGrille.getHorizontalIndices()).usingRecursiveComparison().isEqualTo(expectedHorizontalIndices);
	}
}
