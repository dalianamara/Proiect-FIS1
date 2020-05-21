import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

public class creareJSON2 {
    private static void create() {
        JSONObject obj1 = new JSONObject();
        obj1.put("user", "maxim99");
        obj1.put("nume", "Maxim Ana");
        obj1.put("email","maxim99@yahoo.com");
        obj1.put("parola","ana");
        obj1.put("telefon","0727651532");

        /*JSONObject obj2 = new JSONObject();
        obj2.put("user", "popescu");
        obj2.put("parola", "popescuioan");
        obj2.put("telefon","0723437856");
        obj2.put("nume","Popescu Ioan");
        obj2.put("email","popescuioan@gmial.com");*/

        JSONArray list = new JSONArray();
        list.add(obj1);
        //list.add(obj2);

        try {
            FileWriter file = new FileWriter("src/customers2.json");
            file.write(list.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }}
    public static JSONArray readFromFiles(String fileName){
        JSONParser parser=new JSONParser();
        JSONArray list=new JSONArray();
        try{
            Reader reader=new FileReader(fileName);
            list=(JSONArray)parser.parse(reader);
        }catch(IOException e){
            e.printStackTrace();
        }catch(ParseException e){
            e.printStackTrace();
        }
        return list;
    }


    public static ArrayList<StudentNou> getDriver(){
        JSONArray list= creareJSON.readFromFiles("src/main/resources/customers2.json");
        ArrayList<StudentNou> soferi=new ArrayList<StudentNou>();
        Iterator<JSONObject> it=list.iterator();
        while(it.hasNext()) {
            JSONObject obj = it.next();
            String objInt = (String) obj.get("user");
            String objInt2 = (String) obj.get("nume");
            String objInt3 = (String) obj.get("email");
            String objInt4 = (String) obj.get("parola");
            String objInt5 = (String) obj.get("telefon");


            StudentNou s=new StudentNou(objInt, objInt2, objInt3, objInt4, objInt5);
            soferi.add(s);
        }
        return soferi;
    }
    public static void uppdate(StudentNou s)
    {
        ArrayList<StudentNou> st= creareJSON2.getDriver();
        st.add(s);
        Iterator<StudentNou> it=st.iterator();
        JSONArray list = new JSONArray();

        while(it.hasNext())
        {
            StudentNou stud=it.next();
            JSONObject obj2 = new JSONObject();
            obj2.put("user", stud.getUser());
            obj2.put("parola", stud.getParola());
            obj2.put("nume", stud.getNume());
            obj2.put("email", stud.getEmail());
            obj2.put("telefon", stud.getTelefon());
            list.add(obj2);
        }

        try {
            FileWriter file = new FileWriter("src/main/resources/customers2.json");
            file.write(list.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String args[])
    {
        creareJSON2.create();
        //System.out.println(creareJSON.getDriver());
        //creareJSON.uppdate(new Student("aaa","ss"));

    }
}