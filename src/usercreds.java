import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class usercreds {
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;
    private String username;
    usercreds(){
        try {
            FileReader userReader = new FileReader(new File("C:\\Users\\david\\IdeaProjects\\sqlProjectForDB\\src\\username.txt"));
            StringBuilder x=new StringBuilder();
            int i;
            while ((i=userReader.read()) != -1){
                x.append(i);
                setUsername(x.toString());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            FileReader passReader = new FileReader(new File("C:\\Users\\david\\IdeaProjects\\sqlProjectForDB\\src\\password.txt"));
            StringBuilder x=new StringBuilder();
            int i;
            while ((i=passReader.read()) != -1){
                x.append(i);
                setPassword(x.toString());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }





    }



}
