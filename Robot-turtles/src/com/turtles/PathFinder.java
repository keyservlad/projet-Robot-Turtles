package com.turtles;

public class PathFinder {

	// si un chemin a été trouvé, renvoie true
	public static boolean isThereAPath(int[][] plateauTest, int Xtested, int Ytested) {

		// on regarde si la position finale a été atteinte
		if (plateauTest[Ytested][Xtested] == 9) {
			// System.out.println("chemin trouve");
			return true;
		}

		if (plateauTest[Ytested][Xtested] == 0) {
			plateauTest[Ytested][Xtested] = 2; // on note la position cherchée comme testée

			// on recherche maintenant dans les voisins de maniere recursive

			int dx = -1;
			int dy = 0;

			if (isThereAPath(plateauTest, Xtested + dx, Ytested + dy)) {
				return true;
			}

			dx = 1;
			dy = 0;

			if (isThereAPath(plateauTest, Xtested + dx, Ytested + dy)) {
				return true;
			}

			dx = 0;
			dy = -1;

			if (isThereAPath(plateauTest, Xtested + dx, Ytested + dy)) {
				return true;
			}

			dx = 0;
			dy = 1;

			if (isThereAPath(plateauTest, Xtested + dx, Ytested + dy)) {
				return true;
			}

		}

		return false;
	}

}
