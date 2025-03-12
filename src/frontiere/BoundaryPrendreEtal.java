package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur) == true) {
			System.out.println("Bonjour " + nomVendeur + " ,je vais regarder si je peux vous trouver un etal.");
			if (controlPrendreEtal.resteEtals() == true) {
				installerVendeur(nomVendeur);
			}
			else {
				System.out.println("D�sol�e " + nomVendeur + " ,je n'ai plus d'�tal qui ne soit pas d�j� occup�.");
			}
		}
		else {
			System.out.println("Je suis d�sol�e " + nomVendeur + " mais il faut �tre un habitant de notre village pour commercer ici.");
		}
		
		
	}

	private void installerVendeur(String nomVendeur) {
		int numeroEtal = -1;
		StringBuilder question = new StringBuilder();
		StringBuilder question2 = new StringBuilder();
		String produit;
		int nbProduit = 0;
		System.out.println("C'est parfait, il me resteun �tal pour vous !");
		System.out.println("Il me faudrait quelques renseignements :");
		question.append("Quel produit souhaitez-vous vendre ?");
		produit = Clavier.entrerChaine(question.toString());
		question2.append("Combien souhaitez-vous en vendre ?");
		nbProduit = Clavier.entrerEntier(question2.toString());
		numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur,produit,nbProduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est install� � l'�tal n�" + numeroEtal);
		}
	}
}
