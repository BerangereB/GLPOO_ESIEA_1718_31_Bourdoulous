package options;

import frames.OptionsJFrame;

public enum LANGUAGE {
	BACK("Back", "Retour"), 
	GENERATE_FRACTAL("Generate drawing with ", "Générer un dessin avec "), 
	REGENERATE("Regenerate","Regénérer"),
	GENERATE("Generate","Générer"),
	CANCEL("Cancel", "Annuler"),
	PLAY("Play", "Jouer"),
	LANGUE("Language :", "Langue :"),
	WELCOME(" WELCOME", "BIENVENUE"),
	FILE("File", "Fichier"),
	SAVE("Save","Sauvegarder"),
	QUIT("Quit","Quitter"),
	FN("Please enter the frame's name","Veuillez entrer le nom de l'image"),
	REINIT("Reinitialize the scale","Réinitialiser l'échelle"),
	RANDDRAW("Random draw","Tirage aléatoire"),
	SELECTEDDRAW("Personalized draw","Tirage personnalisé"),
	CSVDRAW("CSV draw","Tirage CSV"),
	FRACGEN("Fractale generator","Générateur de fractales"),
	CREDITS("Credits","Crédits"),
	GI("Graphic interface :","Interface graphique :"),
	FRACT("Fractales/Drawing :","Fractales/Dessins :"),
	TEST("Tests :","Tests :"),
	BONUS("Bonus/Puzzle :","Bonus/Puzzle"),
	STATS("Statistics :","Statistiques :"), 
	CHANGE_PUZZLE("Clic on this puzzle to have another one","Cliquer sur le puzzle  pour changer"), 
	MOY("Average value per ball :","Valeur moyenne par boule :"),
	NBPLUS("Most recurent numbers :","Nombres qui sortent le plus :"),
	NBMOINS("Less recurent numbers :","Nombres qui sortent le moins :"),
	MED("Median per ball :","Mediane par boule :"),
	VAR("Variance per ball :","Variance par boule :"),
	ECART("Ecart-type :","Ecart-type"), 
	STATS_TITLE("Stats","Stats par ordre de sortie"), 
	TOO_MANY_SLT("Too many rws selected. Must be under or equal to 3","Trop de lignes sélectionnées. Veuillez en choisir 3 ou moins"),
	MANUAL_CHOICE_ERROR("Please check that balls are between 1 and 50 and stars between 1 and 12. Check also that there are no duplicates",
			"Veuillez vérifier que les boules sont entre 1 et 50 et les étoiles entre 1 et 12. Vérifiez également qu'il ny a pas de doublons"), 
	MANUAL_CHOICE_EMPTY("Empty fields!","Champs vides!");
	
	
	private String english;
	
	private String french;

	private LANGUAGE(String english, String french) {
		this.english = english;
		this.french = french;
	}
	
	public String getEnglish() {
		return english;
	}
	
	public String getFrench() {
		return french;
	}
	
	public String getSelectedLanguage() {
		if(OptionsJFrame.languageSelected == 0) {
			return french;
		}
		else if(OptionsJFrame.languageSelected == 1) {
			return english;
		}
		else return null;
		
	}
}
