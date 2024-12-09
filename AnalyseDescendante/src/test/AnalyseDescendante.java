package test;

public class AnalyseDescendante {

	    private String texte;
	    private int position;

	    public ParseurDescendant(String texte) {
	        this.texte = texte;
	        this.position = 0;
	    }
	    public boolean parse() {
	        return S();
	    }
	    private boolean S() {
	        
	        if (position < texte.length() && texte.charAt(position) == 'c') {
	            
	            position++;
	            return true;
	        }
	        if (position < texte.length() && texte.charAt(position) == 'b') {
	            
	            if (S()) {
	                position++;
	                return true;
	            }
	        }
	        return false;
	    }

	    public static void main(String[] args) {
	        String texte1 = "cbb";
	        ParseurDescendant parseur1 = new ParseurDescendant(texte1);
	        if (parseur1.parse()) {
	            System.out.println("La chaîne '" + texte1 + "' est valide selon la grammaire.");
	        } else {
	            System.out.println("La chaîne '" + texte1 + "' n'est pas valide selon la grammaire.");
	        }

	        String texte2 = "cbbb";
	        ParseurDescendant parseur2 = new ParseurDescendant(texte2);
	        if (parseur2.parse()) {
	            System.out.println("La chaîne '" + texte2 + "' est valide selon la grammaire.");
	        } else {
	            System.out.println("La chaîne '" + texte2 + "' n'est pas valide selon la grammaire.");
	        }

	        String texte3 = "b";
	        ParseurDescendant parseur3 = new ParseurDescendant(texte3);
	        if (parseur3.parse()) {
	            System.out.println("La chaîne '" + texte3 + "' est valide selon la grammaire.");
	        } else {
	            System.out.println("La chaîne '" + texte3 + "' n'est pas valide selon la grammaire.");
	        }
	    }
	}


