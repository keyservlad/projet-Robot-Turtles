package packopenclassrooms;

import java.util.Objects;

public class Ville {
 
	public static int nbreInstances = 0;
	protected static int nbreInstancesBis = 0;
	protected String nomVille;
	protected String nomPays;
	protected int nbreHabitants;
	protected char categorie;
 
  //Constructeur par défaut
  public Ville(){
    System.out.println("Création d'une ville !");  
    nbreInstances++;
    nbreInstancesBis++; 
    nomVille = "Inconnu";
    nomPays = "Inconnu";
    nbreHabitants = 0;
    this.setCategorie();
  }
 
  //Constructeur avec paramètres
  //J'ai ajouté un « p » en première lettre des paramètres.
  //Ce n'est pas une convention, mais ça peut être un bon moyen de les repérer.
  public Ville(String pNom, int pNbre, String pPays)
  {
    System.out.println("Création d'une ville avec des paramètres !");
    nbreInstances++;
    nbreInstancesBis++; 
    nomVille = pNom;
    nomPays = pPays;
    nbreHabitants = pNbre;
    this.setCategorie();
  }    
  
  
  public String getNom() {
	  return nomVille;
  }
  
  public String getNomPays() {
	  return nomPays;
  }
  
  public int getNbreHabitants() {
	  return nbreHabitants;
  }
  
  public char getCategorie() {
	  return categorie;
  }
  
  public static int getNombreInstancesBis()
  {
    return nbreInstancesBis;
  } 
  
  public void setNom(String pNom) {
	  nomVille = pNom;
  }
  
  public void setNomPays(String pPays) {
	  nomPays = pPays;
  }
  
  public void setNbreHabitants(int pNbreHabitants) {
	  nbreHabitants = pNbreHabitants;
	  this.setCategorie();
  }
  
  public void setCategorie() {
	  
	  int bornesSuperieures[] = {0, 1000, 10000, 100000, 500000, 1000000, 5000000, 10000000};
	  char categories[] = {'?', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

	  int i = 0;
	  while (i < bornesSuperieures.length && this.nbreHabitants > bornesSuperieures[i])
	      i++;

	  this.categorie = categories[i];	  
  }
  
  public String decrisToi(){
	    return "\t"+this.nomVille+" est une ville de "+this.nomPays+ ", elle comporte : "+this.nbreHabitants+" habitant(s) => elle est donc de catégorie : "+this.categorie;
	  }
  public String toString(){
	  return "\t"+this.nomVille+" est une ville de "+this.nomPays+", elle comporte : "+this.nbreHabitants+" => elle est donc de catégorie : "+this.categorie;
	  }

	  //Retourne une chaîne de caractères selon le résultat de la comparaison
  public String comparer(Ville v1){
	    String str = new String();

	    if (v1.getNbreHabitants() > this.nbreHabitants)
	      str = v1.getNom()+" est une ville plus peuplée que "+this.nomVille;
	     
	    else
	      str = this.nomVille+" est une ville plus peuplée que "+v1.getNom();
	     
	    return str;
	  }
  
  
  
  // redefinir hashcode et equals pour categoriser et gérer l'égalité des objets
  /*
  public int hashCode() {
	  //On définit un multiplication impair, de préférence un nombre premier
	  //Ceci afin de garantir l'unicité du résultat final
	  final int prime = 31;
	  //On définit un résultat qui sera renvoyé au final
	  int result = 1;
	  //On ajoute en eux la multiplication des attributs et du multiplicateur
	  result = prime * result + categorie;
	  result = prime * result + nbreHabitants;
	  //Lorsque vous devez gérer des hashcodes avec des objets dans le mode de calcul
	  //Vous devez vérifier si l'objet n'est pas null, sinon vous aurez une erreur
	  result = prime * result + ((nomPays == null) ? 0 : nomPays.hashCode());
	  result = prime * result + ((nomVille == null) ? 0 : nomVille.hashCode());
	  return result;
	}


	public boolean equals(Object obj) {
	  //On vérifie si les références d'objets sont identiques
	  if (this == obj)
	    return true;

	  //On vérifie si l'objet passé en paramètre est null
	  if (obj == null)
	    return false;

	  //On s'assure que les objets sont du même type, ici de type Ville
	  //La méthode getClass retourne un objet Class qui représente la classe de votre objet
	  //Nous verrons ça un peu plus tard...
	  if (getClass() != obj.getClass())
	    return false;

	  //Maintenant, on compare les attributs de nos objets
	  Ville other = (Ville) obj;
	  if (categorie != other.categorie)
	    return false;
	  if (nbreHabitants != other.nbreHabitants)
	    return false;
	  if (nomPays == null) {
	    if (other.nomPays != null)
	      return false;
	  }
	  else if (!nomPays.equals(other.nomPays))
	    return false;

	  if (nomVille == null) {
	    if (other.nomVille != null)
	      return false;
	  }
	  else if (!nomVille.equals(other.nomVille))
	    return false;
		
	  return true;
	}*/
  
  
  //methode plus simple avec java.util.objects
  public int hashCode() {
	  return Objects.hash(categorie, nbreHabitants, nomPays, nomVille);
	}
  
  public boolean equals(Object obj) {
	  //On vérifie si les références d'objets sont identiques
	  if (this == obj)
	    return true;

	  //On s'assure que les objets sont du même type, ici de type Ville
	  if (getClass() != obj.getClass())
	    return false;
		
	  //Maintenant, on compare les attributs de nos objets
	  Ville other = (Ville) obj;

	  return Objects.equals(other.getCategorie(), this.getCategorie()) &&
		 Objects.equals(other.getNom(), this.getNom()) &&
		 Objects.equals(other.getNbreHabitants(), this.getNbreHabitants()) &&
		 Objects.equals(other.getNomPays(), this.getNomPays());
	}
	
  
}