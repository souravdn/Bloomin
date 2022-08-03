package com.example.simplecalc;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Hashtable;

@RequiresApi(api = Build.VERSION_CODES.N)
public class TestDB {
    MainActivity activity;

    TestDB(MainActivity act) {
        super();
        activity = act;

        UserDB userDb = new UserDB(activity);
        boolean userInserted = userDb.insertUser("Raj", "raj23@gm.com", "88447878", "Male", "23/4/2004", "Kolkata", "raj1234", "rajPic.jpg", false);
        if (userInserted) {
            Hashtable<String, String> userDict = userDb.getUser(1);
            Log.i("userD:--", userDict.toString());
        }

        PlantDB plantDb = new PlantDB(activity);
        boolean plantInserted = plantDb.insertPlant("rose", "rose description", "sunlight", "20-25", "fertilize", "Rosa", "Roseline!!", "shrub", "outdoor", "plantPic.jpg", "low", "size", "repotting", "bloom", "nativeArea");
        if (plantInserted) {
            Hashtable plantDict = plantDb.getPlant(1);
            Log.i("PLANT:--", plantDict.toString());
            ArrayList<Hashtable<String, String>> plantDictArr = plantDb.getPlants("shrub","");
            plantDictArr.forEach((pd) -> Log.i("PLANTS:--", pd.toString()));
        }
    }
}
