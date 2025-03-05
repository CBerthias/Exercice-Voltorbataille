package com.berthias.exemple_back_voltorbataille.partie;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class PartieService {

	private Partie partie;

	public Partie getPartie() {
		if (partie == null) {
            partie = new Partie();
        }
        return partie;
	}
}
