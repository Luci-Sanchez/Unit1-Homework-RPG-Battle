package Main;

import classes.Character;
import classes.Party;
import classes.Warrior;
import classes.Wizard;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.*;
import java.util.*;



import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {


//        //// export falta ese json pasarlo a csv
//        Party newParty = new Party("creadaParty");
//
//        Warrior warrior = new Warrior("pepito", 10, 14, 41);
//        Wizard wizard = new Wizard("pepito", 10, 14, 41);
//
//        newParty.getCharacters().add(warrior);
//        newParty.getCharacters().add(wizard);
//
//        FileWriter writter = new FileWriter(newParty.getPartyName()+".json", true);
//
//        Gson gson_pretty = new GsonBuilder().setPrettyPrinting().create();
//        Gson gson = new Gson();
//        writter.write(gson.toJson(newParty.getCharacters()));
//
//        writter.close();


        ///import

//        try {
//            // create Gson instance
//            Gson gson = new Gson();
//
//            // create a reader
//            Reader reader = Files.newBufferedReader(Paths.get("creadaParty.json"));
//
//            // convert JSON string to User object
////            Character[] character = gson.fromJson(reader, Character[].class);
//
//            Object character = gson.fromJson(reader, Object.class);
//
//            var objToWArr = (Warrior) character;
//
//            // print user object
//            System.out.println(objToWArr.getStamina());
//
//            // close reader
//            reader.close();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

        //startGame();

    }


}
