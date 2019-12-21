package Kevin.Code;
import GESTOT_Ressources.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Kevin.Code.Company;

public class Systeme{

    public void saveCompany(){

        Company com = new Company();

        try (FileOutputStream company = new FileOutputStream("company.bin")){
            ObjectOutputStream os = new ObjectOutputStream(company);
            os.writeObject(com);
            os.close();
            
        } catch (Exception e) {
            //handle exception
            e.printStackTrace();
        }

    }

    public Company restaureCompany(){
        
        try (FileInputStream company = new FileInputStream("company.bin")){
            ObjectInputStream is = new ObjectInputStream(company);
            
            Company com = (Company)is.readObject();
            is.close();

            return com;
            
        } catch (Exception e) {
            //handle exception
            e.printStackTrace();
        }
        return null;
    }
}