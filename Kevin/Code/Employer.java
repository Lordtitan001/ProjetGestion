package Kevin.Code;

public class Employer {
    private String nom;

    public Employer(){
        this.nom = "Kevin";
    }

    public Employer(String nom){
        this.nom = nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        Employer emp = (Employer)obj;

        if(emp.nom == this.nom)
            return true;

        return false;
    }
}
