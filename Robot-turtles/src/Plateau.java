
public class Plateau {
	
	char[][] plateau = new char[8][8];
	
	
	
	public void initialisationPlateau(int nbTortues) {
		for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[0].length; j++) {
                plateau[i][j] = ' ';
            }
        }
		// rajouter les tortues et les joyaux et les tuiles
		switch(nbTortues) {
		case 2:
			
			break;
			
		case 3:
			break;
			
		case 4:
			break;
		
		}
		
		
	}

}
