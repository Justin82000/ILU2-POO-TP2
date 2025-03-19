package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infoMarche = controlAfficherMarche.donnerInfoMarche();
		if (infoMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard");
		}
		else {
			System.out.println(nomAcheteur + " ,vous trouverez au marché :\n");
			for (int i = 0; i < infoMarche.length; i++) {
				String Vendeur = infoMarche[i];
				i++;
				String Quantite = infoMarche[i];
				i++;
				String Produit = infoMarche[i];
				i++;
				System.out.println("-" + Vendeur + " qui vend" + Quantite + " " + Produit);
			}
		}
	}
}
