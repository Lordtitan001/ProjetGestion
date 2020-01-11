package GESTOT_Ressources;
import Kevin.Code.*;

public class Infirmier extends Employer {
	
	/*public Infirmier() {  
		Employer.nbWorkers++;
	    this.name="defaultName";
	    Id=setId();
	}*/
	
	public Infirmier(String name) {  
		super();
		Employer.nbWorkers++;
	    this.name=name;
	    Id=setId();
	    fonction=Employer.FONCTION_GENERAL;
	    
	}

}
