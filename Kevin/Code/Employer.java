package Kevin.Code;

public class Employer {
    private String nom;
    private String Id;

    public Employer(){
        this.nom = "Kevin";
        this.Id = this.nom;
    }

    public Employer(String nom, String Id){
        this.nom = nom;
        this.Id = Id;
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

    /**
     * @return the id
     */
    public String getId() {
        return Id;
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
