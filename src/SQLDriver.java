



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SQLDriver {

    public static void main(String[] args) {
        //implements endl in java
        final String endl = System.getProperty("line.separator");

        //creates an scanner object to get user imput
        Scanner input = new Scanner(System.in);

        SQLConnector db1 = new SQLConnector();

        Sqlmaker sqlmaker1 = new Sqlmaker();

        while(true){
            System.out.println("press one to insert press two to make a quarry");
             int flag=input.nextInt();
             restart:
            switch (flag){
                case 1 :
                {
                    int x=0;
                    System.out.println("press  1 to inset in to student, 2 to insert in to classes and, 3 to insert into teachers");
                    x=input.nextInt();
                    switch (x){
                        //inset into student
                        case 1 :
                        {



                            System.out.println("please enter lname");
                            String lname=input.nextLine();

                            input.nextLine();
                            System.out.println("please enter fname");
                            String fname = input.nextLine();

                            input.nextLine();
                            System.out.println("please enter standing");
                            String standing = input.nextLine();

                            System.out.println("please enter the amount of credits");
                            int cedits = input.nextInt();

                            System.out.println("please enter the amount owed");
                            float  amount_owed=input.nextFloat();


                          db1.stmtMaker(sqlmaker1.insertStudent(lname, fname, standing, cedits,amount_owed ),db1.c);


                        }
                        //insert into classes
                        case 2:
                            {
                            System.out.println("please enter the amount enrolled");
                            int amount_enrolled=input.nextInt();


                            System.out.println("please enter the teacher id");
                            int teacherid = input.nextInt();

                            System.out.println("please enter the emplid");
                            int emplid = input.nextInt();

                            db1.stmtMaker(sqlmaker1.insertClasses(amount_enrolled,teacherid,emplid),db1.c);
                        }
                        //insert into teachers
                        case 3:
                        {
                            System.out.println("plese enter the lname");
                            String lname = input.nextLine();

                            input.nextLine();
                            System.out.println("please enter the fname ");
                            String fname = input.nextLine();

                            input.nextLine();
                            System.out.println("please enter the salary");
                            float salary = input.nextFloat();

                            System.out.println("please enter the dept");
                            String dept = input.nextLine();

                            db1.stmtMaker(sqlmaker1.inserteacher(lname,fname,salary,dept),db1.c);
                        }
                        default:
                        {
                            System.out.println("error you didnt pick anything");

                        }
                    }

                }

                case 2 :
                {
                    System.out.println("press 1 to find student information, press 2 to find teacher information, press 3 to find class  information"+
                            endl+"press 4 to add to students amount owed and press five to subtract to students amount");
                    int x = input.nextInt();


                    switch (x)
                    {//find student informtion
                        case 1: {
                            ResultSet rs = null;
                            System.out.println("please enter the emplid");
                            int emplid = input.nextInt();
                            rs = db1.stmtMaker(sqlmaker1.findStudnetInfo(emplid), db1.c);
                            printStudentInformation(rs);

                        }

                        //find teacher information
                        case 2:
                        {
                            ResultSet rs = null;
                            System.out.println("please enter the teacherid");
                            int teacherid = input.nextInt();
                            rs =db1.stmtMaker(sqlmaker1.findTeacherInfo(teacherid),db1.c);
                            printTeacherInformation(rs);
                        }
                        //find class information
                        case 3:
                        {
                            ResultSet rs = null;
                            System.out.println("please enter the class number");
                            int classid = input.nextInt();
                            rs=db1.stmtMaker(sqlmaker1.findClassInformation(classid),db1.c);
                            printClassInformation(rs);
                        }
                        //add amount owed
                        case 4:
                        {
                            ResultSet rs = null;
                            System.out.println("please enter the emplid");
                            int emplid = input.nextInt();
                            System.out.println("please enter the amount owed");
                            float amount_owed = input.nextFloat();
                            rs = db1.stmtMaker(sqlmaker1.addToAmountOwed(emplid,amount_owed),db1.c);
                            printUpdatedOwed(rs);

                        }
                        //subtact amount owed
                        case 5:
                        {
                            ResultSet rs = null;
                            System.out.println("please enter the emplid");
                            int emplid = input.nextInt();
                            System.out.println("please enter the amount owed");
                            float amount_owed = input.nextFloat();
                            rs = db1.stmtMaker(sqlmaker1.subtractAmountOwed(emplid,amount_owed),db1.c);
                            printUpdatedOwed(rs);
                        }
                        default:
                            System.out.print("error please try again");

                } }

            }
        }








}
    public static void printStudentInformation(ResultSet rs){
            try {


                while (rs.next()){
                    //retiving data from result set
                    int emplid = rs.getInt("emplid");
                    String lname = rs.getString("lname");
                    String fname = rs.getString("fname");
                    String standing = rs.getString("standing");
                    int credits = rs.getInt("credits");
                    float amount_owed = rs.getFloat("amount_owed");

                    //printing results
                    System.out.print("emplid: "+emplid);
                    System.out.print(" lname: "+lname);
                    System.out.print(" fname: "+fname);
                    System.out.print(" standing: "+standing);
                    System.out.print(" credits: "+credits);
                    System.out.print(" amount_owed: "+credits);
                    System.out.println();



                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    public static void printTeacherInformation(ResultSet rs ){
        try {

            while (rs.next()){
                //retirive data from result ret
                String lname =rs.getString("lname");
                String fname = rs. getString("fname");
                float salary = rs.getFloat("salary");
                String dept = rs.getString("dept");
                int teacherid= rs.getInt("teacherid");

                //print results
                System.out.print("teacherid: "+teacherid);
                System.out.print(" lname: "+lname);
                System.out.print(" fname: "+fname);
                System.out.print(" salary: "+salary);
                System.out.print(" dept: "+dept);
                System.out.println();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void printClassInformation( ResultSet rs){
        try{
            while (rs.next()){
                //retieve data from result set
                int amount_enrolled = rs.getInt("amount_enrolled");
                int teacherid = rs.getInt("teacherid");
                int emplid = rs.getInt("emplid");
                int classid =rs.getInt("classid");

                //print data from result set
                System.out.print("classid: "+classid);
                System.out.print("teacher: "+teacherid);
                System.out.print("students: "+emplid);
                System.out.print("amount_enrolled: "+amount_enrolled);
                System.out.println();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void printUpdatedOwed(ResultSet rs){
        try {
            while (rs.next()){
                int emplid =rs.getInt("emplid");
                float amount_owed =rs.getFloat("amount_owed");

                System.out.print("emplid: "+emplid);
                System.out.print("updated amount owed: "+amount_owed);
                System.out.println();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    }






