

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

public class creareJSON {
    private static void create() {

        JSONObject obj1 = new JSONObject();
        obj1.put("username", "catalin");
        obj1.put("password", "botean");
        obj1.put("CNP","1234567891012");
        obj1.put("Adresa","Lugoj");
        obj1.put("Telefon","0712345678");

        JSONObject obj2 = new JSONObject();
        obj2.put("username", "ana");
        obj2.put("password", "maxim");

        JSONArray list = new JSONArray();
        list.add(obj1);
        list.add(obj2);

        try {
            FileWriter file = new FileWriter("src/customers.json");
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
    public static ArrayList<Student> getDriver(){
        JSONArray list= creareJSON.readFromFiles("src/main/resources/customers.json");
        ArrayList<Student> soferi=new ArrayList<Student>();
        Iterator<JSONObject> it=list.iterator();
        while(it.hasNext()) {
            JSONObject obj = it.next();
            String objInt = (String) obj.get("username");
            String objInt2 = (String) obj.get("password");

            Student s=new Student(objInt, objInt2);
            //s.setMasina((String)objInt.get("Masina"));
           // s.setCNP((String)objInt.get("CNP"));
           // s.setNumarInmatriculare((String)objInt.get("NumarInmatriculare"));
            soferi.add(s);
        }
        return soferi;
    }

    public static void uppdate(Student s)
    {
        ArrayList<Student> st= creareJSON.getDriver();
        st.add(s);
        Iterator<Student> it=st.iterator();
        JSONArray list = new JSONArray();

        while(it.hasNext())
        {
            Student stud=it.next();
            JSONObject obj2 = new JSONObject();
            obj2.put("username", stud.getUsername());
            obj2.put("password", stud.getPassword());
            list.add(obj2);
        }

        try {
            FileWriter file = new FileWriter("src/main/resources/customers.json");
            file.write(list.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String args[])
    {
        //creareJSON.create();
        //System.out.println(creareJSON.getDriver());
        //creareJSON.uppdate(new Student("aaa","ss"));

    }
}
