package com.berthias.exemple_back_voltorbataille.partie;

import com.berthias.exemple_back_voltorbataille.grille.Grille;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Data
@NoArgsConstructor
public class Partie {
	private int nbPointsEnCours;
	private int nbPointsGagnes;
	private int difficulte;
	private Grille grille;
	private List<List<Boolean>> casesRevelees;
}
