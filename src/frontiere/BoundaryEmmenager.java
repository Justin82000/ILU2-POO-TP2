package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder question2 = new StringBuilder();
					question2.append("Bienvenue villageois" + nomVisiteur);
					question2.append("Quelle est votre force ?");
					int choixUtilisateur2 = -1;
					choixUtilisateur2 = Clavier.entrerEntier(question2.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur,choixUtilisateur2);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		StringBuilder question2 = new StringBuilder();
		StringBuilder question3 = new StringBuilder();
		int force = 0;
		int potionMin = 0;
		int potionMax = -1;
		question.append("Bienvenue Druide " + nomVisiteur);
		question.append(" Quelle est votre force ?");
		question2.append("Quelle est la force de potion la plus faible que vous produisez ?");
		question3.append("Quelle est la force de potion la plus forte que vous produisez ?");
		force = Clavier.entrerEntier(question.toString());
		while (potionMax < potionMin) {
			potionMin = Clavier.entrerEntier(question2.toString());
			potionMax = Clavier.entrerEntier(question3.toString());
			if (potionMax < potionMin) {
				System.out.println("Attention druide, vous vous etes tromp� entre le minimum et le maximum");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur,force,potionMin,potionMax);
	}
}
