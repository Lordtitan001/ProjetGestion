package Controleur;
import Interface.*;
import Kevin.Code.*;
import Interface.AcceuilGUI;

import java.awt.event.*;

public abstract class AbsControleur implements ActionListener,MouseListener,KeyListener {

	
	/*
	 * les instances de la classe
	 * */
	protected FenetreHoraire feneHoraire;
	protected Company Gingras;
	protected AcceuilGUI acceuilGUI;
	
	public  AbsControleur(FenetreHoraire fene) {
		super();
		feneHoraire = fene;
	}

	public  AbsControleur(AcceuilGUI acceuilGUI) {
		this.acceuilGUI = acceuilGUI;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
