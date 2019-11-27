package packopenclassrooms;

public class Main {
	
	public static void main(String[] args)
	  {
		
		/*
		Ville[] tableau = new Ville[6];
	    String[] tab = {"Marseille", "lille", "caen", "lyon", "paris", "nantes"};
	    int[] tab2 = {123456, 78456, 654987, 75832165, 1594, 213};

	    for(int i = 0; i < 6; i++){
	      if (i <3){
	        Ville V = new Ville(tab[i], tab2[i], "france");
	        tableau[i] = V;
	      }
	                
	      else{
	        Capitale C = new Capitale(tab[i], tab2[i], "france", "la tour Eiffel");
	        tableau[i] = C;
	      }
	    }
	                 
	    //Il ne nous reste plus qu'à décrire tout notre tableau !
	    for(Object v : tableau){
	      System.out.println(((Ville)v).decrisToi()+"\n");
	    }
	    */
		
		
	    //Les méthodes d'un chien 
	    Chien c = new Chien("Gris bleuté", 20);
	    c.boire();
	    c.manger();
	    c.deplacement();
	    c.crier();
	    System.out.println(c.toString());
				
	    System.out.println("--------------------------------------------");
	    //Les méthodes de l'interface
	    c.faireCalin();
	    c.faireLeBeau();
	    c.faireLechouille();
			
	    System.out.println("--------------------------------------------");
	    //Utilisons le polymorphisme de notre interface
	    Rintintin r = new Chien();
	    r.faireLeBeau();
	    r.faireCalin();
	    r.faireLechouille();
		
	  } 

}
