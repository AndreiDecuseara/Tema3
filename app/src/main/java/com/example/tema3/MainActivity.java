package com.example.tema3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    public  User item;
    public List<User> listItems = new ArrayList<>();
    private static final String URL_DATA =  "http://api.androidhive.info/contacts/";
    private ArrayList<String> mText = new ArrayList<>();
    private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQueue = Volley.newRequestQueue(this);

        jsonParse();



//        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response
//        String jsonStr = sh.makeServiceCall(URL_DATA);
//        Log.e(TAG, "------------------------------------------------Response from url: " + jsonStr);


//        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String s) {
//                try {
//
//                    JSONObject jsonObject = new JSONObject(s);
//                    JSONArray array = jsonObject.getJSONArray("");
//                    Toast.makeText(getBaseContext(), "cvcvcvcv",
//                            Toast.LENGTH_LONG).show();
//                    for(int i =0; i<array.length();i++){
//                        JSONObject o = array.getJSONObject(i);
//                        User item = new User(
//                                o.getInt("id"),
//                                o.getString("name"),
//                                o.getString("username"),
//                                o.getString("email")
//                        );
//                        listItems.add(item);
//
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });

//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);


//        List<User> users = MainActivity.myAppDatabase.userDao().getAll();
//        String info = "";
//        for(User usr:users){
//            int nota = usr.getMark();
//            String name = usr.getName();
//            int id = usr.getId();
//            info =  "Id :" + id + "\n" + "Nume: " + name + "\n" + "Nota = " + nota + "\n\n";
//            mText.add(info);
//        }

    }
    private void initRecycleView(){

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,listItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void jsonParse(){
        String url = "https://jsonplaceholder.typicode.com/users";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new  Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        int a = Integer.parseInt(obj.getString("id"));
                        String b = obj.getString("name");
                        String c = obj.getString("username");
                        String d = obj.getString("email");
                        User item = new User(a,b,c,d);
                        listItems.add(item);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                initRecycleView();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        mQueue.add(request);
    }
}
