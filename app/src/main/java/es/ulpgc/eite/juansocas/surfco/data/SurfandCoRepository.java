package es.ulpgc.eite.juansocas.surfco.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.ulpgc.eite.juansocas.surfco.database.PicosDAO;
import es.ulpgc.eite.juansocas.surfco.database.SurfandCODatabase;
import es.ulpgc.eite.juansocas.surfco.database.UserDAO;
import es.ulpgc.eite.juansocas.surfco.database.User_PicosDAO;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;


public class SurfandCoRepository implements RepositoryContract{


    public static String TAG = SurfandCoRepository.class.getSimpleName();

    public static final String DB_FILE = "SurfCO.db";

    public static final String JSON_FILE = "usuarios.json";
    public static final String JSON_ROOT_Users = "usuarios";
    public static final String JSON_ROOT_Picos = "picoss";
    public static final String JSON_ROOT_intermedia = "User_Picos";

    private static SurfandCoRepository INSTANCE;

    private SurfandCODatabase database;
    private Context context;
    private boolean errorUser;
    private boolean errorPicos;
    private boolean errorIntermedia;

    public static RepositoryContract getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = new SurfandCoRepository(context);

        }
        return INSTANCE;

    }

    public SurfandCoRepository(Context context) {
        this.context = context;
        database = Room.databaseBuilder(context,SurfandCODatabase.class,DB_FILE).build();
    }



/*
    @Override
    public void loadTODO(final boolean clearFirst, final FetchUsersDataCallback callbackUsers, final FetchPicosDataCallback callbackPicos, final FetchIntermediaDataCallback callbackIntermedia){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if(clearFirst){
                    clarAllTables();
                }
                loadUsers(callbackUsers);
                loadPicos(callbackPicos);
                boolean errorIntermedia = false;
                if (getPicosDao().getAllPicos().size() == 0){
                    errorIntermedia =! loadIntermediaSURFandCOCatalogFromJSON(loadIntermediaJSONFromAsset());
                }
                if (callbackIntermedia != null){
                    callbackIntermedia.onIntermedaDataFetched(errorIntermedia);
                }
            }
        });
    }

 */

    @Override
    public void clarAllTables(){
        database.clearAllTables();
    }

    @Override
    public void loadUsers(boolean clearFirst, FetchUsersDataCallback callback) {

    }

    @Override
    public void loadPicos(boolean clearFirst, FetchPicosDataCallback callback) {

    }






    @Override
    public void loadTODO(final boolean clearFirst, final FetchUsersDataCallback callbackUsers, final FetchPicosDataCallback callbackPicos, final FetchIntermediaDataCallback callbackIntermedia){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if(clearFirst){
                    database.clearAllTables();
                }
                boolean errorUser = false;
                if (getUserDao().getUsers().size() == 0){
                    errorUser =! loadSURFandCOCatalogFromJSON(loadJSONFromAsset());
                }
                if (callbackUsers != null){
                    callbackUsers.onUsersDataFetched(errorUser);
                }
                boolean errorPicos = false;
                if (getPicosDao().getAllPicos().size() == 0){
                    errorPicos =! loadPicosSURFandCOCatalogFromJSON(loadPicosJSONFromAsset());
                }
                if (callbackPicos != null){
                    callbackPicos.onPicosDataFetched(errorPicos);
                }
                boolean errorIntermedia = false;
                if (getUser_PicosDao().getUser_Picos().size() == 0){
                    errorIntermedia =! loadIntermediaSURFandCOCatalogFromJSON(loadIntermediaJSONFromAsset());
                }
                if (callbackIntermedia != null){
                    callbackIntermedia.onIntermedaDataFetched(errorIntermedia);
                }
            }
        });
    }




/*
    @Override
    public void loadUsers(final boolean clearFirst, final FetchUsersDataCallback callback){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (clearFirst){
                    database.clearAllTables();
                }
                boolean error= false;
                if (getUserDao().getUsers().size() == 0){
                    error =! loadSURFandCOCatalogFromJSON(loadJSONFromAsset());
                }
                if (callback != null){
                    callback.onUsersDataFetched(error);
                }
            }
        });

    }

 */



/*
    public void insertUser(User user, final OnUserInserted callback){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                getUserDao().insertarUser(user);
                if (callback != null){
                    callback.onUserInserted(user);
                }
            }
        });

    }

 */

public void insertUser(User user, final OnUsersUpdated callback){
    AsyncTask.execute(new Runnable() {
        @Override
        public void run() {
            getUserDao().insertarUser(user);
            List<User> usuarios = getUserDao().getUsers();
            if (callback != null){
                callback.onUsersUpdated(usuarios);
            }
        }
    });
}

    @Override
    public void getUsers1(GetUsersListCallback callback) {
    List<User> userList = new ArrayList<>();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<User> usuarios = getUserDao().getUsers();
                if (callback != null){
                    callback.setUsersList(usuarios);
                }
                Log.e(TAG,"esto si queee "+ usuarios.size());
                for(int i = 0; i<usuarios.size(); i++){
                    userList.add(i, usuarios.get(i));
                }
            }
        });
        Log.e(TAG,"WAPOOOO "+ userList.size());


    }

    public void getUsers( final OnUsergeted callback){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<User> usuarios = getUserDao().getUsers();
                if (callback != null){
                    callback.onUsergeted(usuarios);

                }
            }
        });
    }


    @Override
    public void getUsersList(final GetUsersListCallback callback) {
    AsyncTask.execute(new Runnable() {
        @Override
        public void run() {
            if(callback !=null){
                callback.setUsersList(getUserDao().getUsers());
            }
        }
    });

    }

    @Override
    public void getPicosList(final GetPicosListCallback callback) {
    AsyncTask.execute(new Runnable() {
        @Override
        public void run() {
            if (callback != null){
                callback.setPicosList(getPicosDao().getAllPicos());
            }
        }
    });

    }

    @Override
    public void getIntermediaList(final GetTABLAIntermediaListCallback callback) {
    AsyncTask.execute(new Runnable() {
        @Override
        public void run() {
            if (callback != null){
                callback.setUsers_picos(getUser_PicosDao().getUser_Picos());
            }
        }
    });

    }

    public void getgetAllPicos(final  OnPicosgetted callback){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<Picos> picos = getPicosDao().getAllPicos();
                if(callback !=null){
                    callback.onPicosgetted(picos);
                }
            }
        });
    }




    public void updateUser(final User user){


    }


    private UserDAO getUserDao(){
        return  database.userDAO();
    }

    private PicosDAO getPicosDao(){
        return database.picosDAO();
    }
    private User_PicosDAO getUser_PicosDao(){
        return database.user_picosDAO();
    }



    private boolean loadSURFandCOCatalogFromJSON(String json){
        Log.e(TAG,"loadSURFandCOCatalogFromJSON()");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_Users);

            if (jsonArray.length() > 0){
                final List<User> users = Arrays.asList(gson.fromJson(jsonArray.toString(), User[].class));

                for(User user : users){
                    getUserDao().insertarUser(user);


                }
                for(int i = 0; i<users.size(); i++){
                    Log.e(TAG, "Los Users son los siguientes con email: "+ users.get(i).getEmail() + " y de password " + users.get(i).getPassword());

                }
                return true;

            }
        }catch (JSONException error){
            Log.e(TAG, "error: " + error);
        }
        Log.e(TAG, "PASAAAA()");

        return false;
    }
    private boolean loadPicosSURFandCOCatalogFromJSON(String json){
        Log.e(TAG,"loadPicosSURFandCOCatalogFromJSON()");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_Picos);

            if (jsonArray.length() > 0){

                final List<Picos> picos = Arrays.asList(gson.fromJson(jsonArray.toString(), Picos[].class));

                for(Picos picos1 : picos){
                    getPicosDao().insertarPico(picos1);

                }
                for(int i = 0; i<picos.size(); i++){
                    Log.e(TAG, "Los Picos son los siguientes : "+ picos.get(i).getNombre());

                }
                Log.e(TAG, "PASAAAA()");
                return true;

            }
        }catch (JSONException error){
            Log.e(TAG, "error: " + error);
        }


        return false;
    }
    private boolean loadIntermediaSURFandCOCatalogFromJSON(String json){
        Log.e(TAG,"loadIntermediaSURFandCOCatalogFromJSON()");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT_intermedia);

            if (jsonArray.length() > 0){
                final List<User_Picos>user_picos = Arrays.asList(gson.fromJson(jsonArray.toString(), User_Picos[].class));

                for(User_Picos user_picos1 : user_picos){
                    getUser_PicosDao().insertarUser_picos(user_picos1);
                }
                for(int i = 0; i<user_picos.size(); i++){
                    Log.e(TAG, "Los User_Picos son los siguientes: "+ user_picos.get(i).getPicoId() + "   y relacion con users  " + user_picos.get(i).getUserId());

                }
                return true;

            }
        }catch (JSONException error){
            Log.e(TAG, "error: " + error);
        }

        return false;
    }


    private String loadJSONFromAsset(){
        Log.e(TAG, "loadJSONFromAsset()");

        String json = null;

        try {
            InputStream is = context.getAssets().open("usuarios.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException error) {
            Log.e(TAG, "error: " + error);
        }

        return json;

    }
    private String loadPicosJSONFromAsset(){
        Log.e(TAG, "loadPicosJSONFromAsset()");

        String json = null;

        try {
            InputStream is = context.getAssets().open("picoss.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException error) {
            Log.e(TAG, "error: " + error);
        }

        return json;

    }
    private String loadIntermediaJSONFromAsset(){
        Log.e(TAG, "loadJSONFromAsset()");

        String json = null;

        try {
            InputStream is = context.getAssets().open("User_Picos.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException error) {
            Log.e(TAG, "error: " + error);
        }

        return json;

    }



}
