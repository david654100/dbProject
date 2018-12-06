/**
 * @author david benzaquen
 */
public class Sqlmaker {
    /**
     * his function turns the parameters to a insert into student using sql
     * @param lname student last name
     * @param fname student first name
     * @param standing  student standing
     * @param credits amount of credits
     * @param amount_owed amount the student owed
     * @return a string of the sql quarry
     */
    public String insertStudent(String lname, String fname, String standing, int credits, float amount_owed) {
        StringBuilder sql = new StringBuilder("INSERT INTO STUDENTS (lname, fname, standing, gpa, credits, amount_owed) values ( ");
        sql.append(lname);
        sql.append(", ");
        sql.append(fname);
        sql.append(", ");
        sql.append(standing);
        sql.append(", ");
        sql.append(credits);
        sql.append(", ");
        sql.append(amount_owed);
        sql.append(");");


        return sql.toString();
    }

    /**
     * this function turns the parameters to a insert into student using sql
     * @param lname students last name
     * @param fname students first name
     * @param standing students standing
     * @param credits amount of credits
     * @return a string of the sql quarry
     */
    public String insertStudent (String lname, String fname, String standing, int credits) {
        StringBuilder sql = new StringBuilder("INSERT INTO STUDENTS (lname, fname, standing, gpa, credits) values ( ");
        sql.append(lname);
        sql.append(", ");
        sql.append(fname);
        sql.append(", ");
        sql.append(standing);
        sql.append(", ");
        sql.append(credits);
        sql.append(");");

        return sql.toString();
    }

    /**
     * this function creates the sql quarry for insert into teacher
     * @param lname teachers last name
     * @param fname teachers first name
     * @param salary teachers salary
     * @param dept teachers dept
     * @return a string of the quarry
     */
    public String inserteacher(String lname, String fname, float salary, String dept) {
        StringBuilder sql = new StringBuilder( "INSERT INTO TEACHERS (lname, fname, salary, dept) values (");

        sql.append(lname);
        sql.append(", ");
        sql.append(fname);
        sql.append(", ");
        sql.append(salary);
        sql.append(", ");
        sql.append(dept);
        sql.append(");");

        return sql.toString();

    }

    /**
     * this function creates the sql quarry for insert into teacher
     * @param lname teachers last name
     * @param fname teachers first name
     * @param salary teachers salary
     * @return a string of the quarry
     */
    public String inserteacher(String lname, String fname, float salary ) {
        StringBuilder sql = new StringBuilder("INSERT INTO TEACHERS (lname, fname, salary, dept) values (");

        sql.append(lname);
        sql.append(", ");
        sql.append(fname);
        sql.append(", ");
        sql.append(salary);
        sql.append(");");
        return sql.toString();

    }

    /**
     * this functions the string for the insert into classes  quarry
     * @param amount_enrolled this is the amount of students enrolled into the class
     * @param teacherid this is the teacher id number
     * @param emplid this the the emplid of the
     * @return a string of the quarry
     */
    public  String insertClasses(int amount_enrolled, int teacherid,int emplid ){
        StringBuilder sql = new StringBuilder("insert into classes (amount_enrolled, teacherid ,emplid) values (");
        sql.append(amount_enrolled);
        sql.append(", ");
        sql.append(teacherid);
        sql.append(", ");
        sql.append(emplid);
        sql.append(");");
        return sql.toString();

    }

    /**
     * creates a quarry to find a students information
     * @param emplid student emplid
     * @return the string of the quarry
     */
    public String findStudnetInfo( int emplid) {

        StringBuilder sql = new StringBuilder("SELECT * FROM students WHERE emplid =");
        sql.append(emplid);
        sql.append(";");

        return sql.toString();
    }

    /**
     * this method creates a quarry to find all information for a teacher with the given teacherid
     * @param teacherid teacher id
     * @return the quarry in the form of a string
     */
    public  String findTeacherInfo(int teacherid){
        StringBuilder sql = new StringBuilder("SELECT * from teachers WHERE teachers = ");
        sql.append(teacherid);
        sql.append(";");

        return sql.toString();
    }

    /**
     * this method creates a quarry to find all information for a teacher with the given teacherid
     * @param classid class id
     * @return the quarry in the form of a string
     */
    public  String findClassInformation(int classid){
        StringBuilder sql = new StringBuilder("SELECT * from classes WHERE classid =");
        sql.append(classid);
        sql.append(";");
        return sql.toString();

    }

    /**
     *   creates the quarry to adds amount to amount owed
     * @param emplid students emplid number
     * @param amount_owed amount to be added
     * @return string of the sql quarry
     */
    public String addToAmountOwed(int emplid, float amount_owed){
        StringBuilder sql = new StringBuilder("UPDATE students SET amount_owed= amount_owed + ");
        sql.append(amount_owed);
        sql.append("WHERE emplid=");
        sql.append(emplid);
        sql.append(";");
        return sql.toString();

    }

    /**
     *creates the quarry to adds amount to amount owed
     * @param emplid student emplid number
     * @param amount_owed amount to be subtracted
     * @return string of the sql quarry
     */
    public String subtractAmountOwed (int emplid, float amount_owed){
        StringBuilder sql = new StringBuilder("UPDATE students SET amount_owed= amount_owed - ");
        sql.append(amount_owed);
        sql.append("WHERE emplid=");
        sql.append(emplid);
        sql.append(";");
        return sql.toString();

    }





}