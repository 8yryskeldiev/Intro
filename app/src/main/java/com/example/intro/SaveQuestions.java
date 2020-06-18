package com.example.intro;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SaveQuestions {
    static  SharedPreferences sharedPreferences;
    static Activity activity;

    public SaveQuestions(Activity act){
        activity=act;
        sharedPreferences=act.getSharedPreferences( "setting" , Context.MODE_PRIVATE );
    }


public  static  void saveIsShown(){
    sharedPreferences.edit().putBoolean( "isShown", true ).apply();
}
    public  static boolean isShown(){
      return   sharedPreferences.getBoolean( "isShown", false );
    }
}