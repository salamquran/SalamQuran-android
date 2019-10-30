package com.ermile.salamquran.Functions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class SaveManager extends ContextWrapper {

    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    public static final String SH_PREF_NAME = "ShPerfManager_Payamres";


    @SuppressLint("CommitPrefEdits")
    private SaveManager(Context context) {
        super(context);
        sharedPreferences = getSharedPreferences(SH_PREF_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public static SaveManager get(Context context) {
        return new SaveManager(context);
    }

    /** Ghari */
    public static final String qari_Link = "qariLink";
    public static final String qari_Name = "qariName";
    public static final String qari_Slug = "qariSlug";
    public static final String qari_Type = "qariType";
    public static final String qari_Index = "qariIndex";

    /** App Info */
    public static final String introIsChacked = "introIsChacked";

    public static final String appLanguage = "appLanguage";
    public static final String changeLanguageByUser = "changeLanguageByUser";

    public static final String hasNewVersion = "hasNewVersion";
    public static final String deprecatedVersion = "deprecatedVersion";

    public static final String apiKey = "apiKey";
    public static final String userCode = "userCode";
    public static final String zoneID = "zoneID";


    public void change_qari(String link , String name , String slug,String type,Integer index) {
        editor.putString(qari_Link, link);
        editor.putString(qari_Name, name);
        editor.putString(qari_Slug, slug);
        editor.putString(qari_Type, type);
        editor.putInt(qari_Index, index);
        editor.apply();
    }

    public void change_appLanguage(String Language) {
        editor.putString(appLanguage, Language);
        editor.apply();
    }
    public void change_infoLOGIN(String ApiKey,String UserCode,String ZoneID) {
        editor.putString(apiKey, ApiKey);
        editor.putString(userCode, UserCode);
        editor.putString(zoneID, ZoneID);
        editor.apply();
    }
    
    public void change_hasNewVersion(Boolean HasNewVersion) {
        editor.putBoolean(hasNewVersion, HasNewVersion);
        editor.apply();
    }
    @SuppressLint("NewApi")
    public void change_deprecatedVersion(Boolean Deprecated_Version) {
        editor.putBoolean(deprecatedVersion, Deprecated_Version);
        editor.apply();
    }

    public void change_intriOpen(Boolean IntroIsChacked) {
        editor.putBoolean(introIsChacked, IntroIsChacked);
        editor.apply();
    }

    public void change_LanguageByUser(Boolean ChangeLanguageByUser) {
        editor.putBoolean(changeLanguageByUser, ChangeLanguageByUser);
        editor.apply();
    }

    public Map<String, Integer> getInt_appINFO() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(introIsChacked, sharedPreferences.getInt(introIsChacked, 1021 ));
        return hashMap;
    }

    public Map<String, Boolean> getboolen_appINFO() {
        HashMap<String, Boolean> hashMap = new HashMap<>();
        hashMap.put(introIsChacked, sharedPreferences.getBoolean(introIsChacked, false ));
        hashMap.put(hasNewVersion, sharedPreferences.getBoolean(hasNewVersion, false ));
        hashMap.put(deprecatedVersion, sharedPreferences.getBoolean(deprecatedVersion, false ));

        hashMap.put(changeLanguageByUser, sharedPreferences.getBoolean(changeLanguageByUser, true ));
        return hashMap;
    }

    public Map<String, String> getstring_appINFO() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(qari_Link, sharedPreferences.getString(qari_Link, "https://dl.salamquran.com/ayat/parhizgar-murattal-48/" ));
        hashMap.put(qari_Name, sharedPreferences.getString(qari_Name, "پرهیزکار" ));
        hashMap.put(qari_Slug, sharedPreferences.getString(qari_Slug, "parhizgar" ));
        hashMap.put(qari_Type, sharedPreferences.getString(qari_Type, "ترتیل" ));
        hashMap.put(appLanguage, sharedPreferences.getString(appLanguage, null ));

        hashMap.put(apiKey, sharedPreferences.getString(apiKey, null ));
        hashMap.put(userCode, sharedPreferences.getString(userCode, null ));
        hashMap.put(zoneID, sharedPreferences.getString(zoneID, null ));
        return hashMap;
    }



}