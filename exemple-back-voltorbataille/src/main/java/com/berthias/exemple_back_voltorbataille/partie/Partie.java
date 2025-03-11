package com.berthias.exemple_back_voltorbataille.partie;

import com.berthias.exemple_back_voltorbataille.grille.Grille;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@NoArgsConstructor
public class Partie {
    private int nbPointsEnCours;
    private int nbPointsGagnes;
    private int difficulte;
    private boolean gagnee;
    private boolean perdue;
    private Grille grille;
    private List<List<Boolean>> casesRevelees;
}
