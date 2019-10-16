package Kevin.Code;

public class Employer {
    private String nom;
    private String Id;
    private MyDay myDay = new MyDay();
    private int additionalShift = 0;

    public Employer(){
        this.nom = "Kevin";
        this.Id = "0";
    } 

    public Employer(String nom, String Id){
        this.nom = nom;
        this.Id = Id;
    }

    public Employer( String Id){
        this.nom = "new Employer";
        this.Id = Id;
    }

    public void newShift(){
        additionalShift ++;
    }

    public void removeShift(){
        additionalShift --;
    }

    /**
     * @return the additionalShift
     */
    public int getAdditionalShift() {
        return additionalShift;
    }

    /**
     * @param additionalShift the additionalShift to set
     */
    public void setAdditionalShift(int additionalShift) {
        this.additionalShift = additionalShift;
    }
    /**
     * @return the myDay
     */
    public MyDay getMyDay() {
        return myDay;
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
