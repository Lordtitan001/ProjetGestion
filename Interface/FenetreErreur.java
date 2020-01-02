package Interface;

import javax.swing.JOptionPane;

public class FenetreErreur extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String message;
	public final static int INFORMATION=0;
	public final static int PREVENTION=1;
	public final static int ERREUR=2;
	public FenetreErreur( String message) {
		super();
		this.message=message;
	}
	
	public  void afficher(int type) {
		if(type==INFORMATION) JOptionPane.showMessageDialog(null,message, "Information", JOptionPane.INFORMATION_MESSAGE);
		if(type==PREVENTION) JOptionPane.showMessageDialog(null, message, "Attention", JOptionPane.WARNING_MESSAGE);
		if(type==ERREUR) JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}
	
}
