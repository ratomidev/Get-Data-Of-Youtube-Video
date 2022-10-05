  

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author MRtou
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
   public String id ;
   String viewCount ; 
   String likeCount ; 
   String commentCount ;
   public NewMain(String id){
       this.id = id ; 
   }
   
   public void takeInfo() throws IOException, ParseException{
       File file = new File("json.json");
       JSONParser  jsonparser=new JSONParser();
       file.createNewFile();
        String link="https://www.googleapis.com/youtube/v3/videos?part=statistics&id="+id+"&key=AIzaSyCltZQgiEE2Cm7TMSWqzRVNzxiU1FLR-XY";
       URL url = new URL(link);
       BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()) );
        String input ;
         FileWriter ff = new FileWriter(file.getAbsoluteFile());
        while((input=in.readLine())!=null)
            ff.write(input);
        ff.close(); 
        in.close();
        FileReader f = new FileReader("C:\\Users\\MRtou\\OneDrive\\Documents\\NetBeansProjects\\Myapp\\json.json");
         JSONObject jsonobject = (JSONObject) jsonparser.parse(f);
        /*njPLHfivy9o*/
        JSONArray a = (JSONArray)jsonobject.get("items");
        JSONObject b =(JSONObject) a.get(0);
        JSONObject c =(JSONObject) b.get("statistics");
               this.viewCount=(String) c.get("viewCount");
               this.likeCount= (String)c.get("likeCount");
            this.commentCount =(String) c.get("commentCount");
   }
   public String getViewCount(){
       return this.viewCount;
   }
   public String getLikeCount(){
       return this.likeCount;
   }
   public String getCommentCount(){
       return this.commentCount;
   }
    
    
    /*
    public static void main(String[] args) {
        //NewMain a = New main
        /*
        System.out.println("begin");
        String id ;
        String link ; 
        File file = new File("json.json");
        JSONParser  jsonparser=new JSONParser();
        file.createNewFile();
        Scanner obj = new Scanner(System.in);
        System.out.println("Saisir id de videos :");
       id = obj.nextLine();
        link="https://www.googleapis.com/youtube/v3/videos?part=statistics&id="+id+"&key=AIzaSyCltZQgiEE2Cm7TMSWqzRVNzxiU1FLR-XY";
        URL url = new URL(link);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()) );
        String input ;
         FileWriter ff = new FileWriter(file.getAbsoluteFile());
        while((input=in.readLine())!=null)
            ff.write(input);
        ff.close(); 
        in.close();
        
        FileReader f = new FileReader("C:\\Users\\MRtou\\OneDrive\\Documents\\NetBeansProjects\\Myapp\\json.json");
         JSONObject jsonobject = (JSONObject) jsonparser.parse(f);
        /*njPLHfivy9o*/
        /*
        JSONArray a = (JSONArray)jsonobject.get("items");
        JSONObject b =(JSONObject) a.get(0);
        JSONObject c =(JSONObject) b.get("statistics");
                System.out.println(c.get("viewCount"));
            
    
    }
   }
    */
    

}
