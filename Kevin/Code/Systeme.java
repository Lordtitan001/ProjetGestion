package Kevin.Code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Kevin.Code.Company;

public class Systeme {

    public static void saveCompany() {

        Company com = new Company();

        try (FileOutputStream company = new FileOutputStream("company.bin")) {
            ObjectOutputStream os = new ObjectOutputStream(company);
            os.writeObject(com);
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(com.getWorkers());
    }

    public static Company restaureCompany() {

        try (FileInputStream company = new FileInputStream("company.bin")) {
            ObjectInputStream is = new ObjectInputStream(company);

            Company com = (Company) is.readObject();
            is.close();

            System.out.println(com.getCompanyname());
            System.out.println(com.getWorkers());
            System.out.println(com.getManager().getName());
            System.out.println(com.getNomEmployerNode().getAutoComplete());
            return com;

        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }
}