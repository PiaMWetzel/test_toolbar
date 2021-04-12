package com.example.test_toolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

public class SecondActivity extends AppCompatActivity {

    private ListView listview;
    String title, age;
    private static String JSON_URL = "https://run.mocky.io/v3/6348000c-0392-41c8-bbf5-58c6012a72f8";
    ArrayList<HashMap<String, String>> friendsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        friendsList = new ArrayList<>();
        listview =findViewById(R.id.list_view);

        GetData getData = new GetData();
        getData.execute();
    }


    public void accessInfo(View view){

        Intent intent = new Intent(this, ThirdActivity.class);
        String un = ((TextView) view).getText().toString();
        intent.putExtra("user_name", un);
        startActivity(intent);

    }

    public class GetData extends AsyncTask<String, String, String>{


        @Override
        protected String doInBackground(String... strings) {
            String current = "";

            Log.d("pia", "hellooooooooooooo GETTING DATA");

            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try{
                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    Log.d("statuscode", urlConnection.getResponseMessage());

                    InputStream in = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(in);
                    int data = isr.read();

                    while (data != -1){
                        Log.d("dtap", "hello");
                        current += (char) data;
                        data = isr.read();
                    }


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    if (urlConnection != null)
                    {
                        urlConnection.disconnect();
                    }
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }

            Log.d("output", current + " kklkoo");
            return current;
        }


        @Override
        protected void onPostExecute(String s) {

            Log.d("pia", "kooooooooo TRYING TO DISPLAY");
            Log.d("pio", s + " Hello");
            try {
                Log.d("pio", "try blog");
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("Friends");
                for(int i = 0; i < jsonArray.length(); i++){
                    Log.d("pia", "kkkl");
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    title = jsonObject1.getString("name");
                    age = jsonObject1.getString("age");

                    //Hashmap
                    HashMap<String, String> friends = new HashMap<String, String>();
                    friends.put("name", title);
                    friends.put("age", age);

                    friendsList.add(friends);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            //Display results
            ListAdapter adapter = new SimpleAdapter(
                    SecondActivity.this,
                    friendsList,
                    R.layout.row_layout,
                    new String[] {"name", "age"},
                    new int[] {R.id.textView6, R.id.textView7});

            //list view - set adapter and make items clickable
            listview.setAdapter(adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Toast.makeText(SecondActivity.this, "hello", Toast.LENGTH_SHORT).show();
                    HashMap<String, String> myItem = (HashMap<String, String>) (parent.getItemAtPosition(position));
                    String myString = (String) myItem.get("name");
                    Log.d("clickalert", "You clicked me: " + Integer.toString(position) + " " + myString);

                    Intent intent = new Intent(view.getContext(), ThirdActivity.class);
                    intent.putExtra("username", myString);
                    startActivity(intent);

                }
            });
        }
    }
}