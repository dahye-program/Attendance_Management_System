package com.example.myapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

public class MainActivity extends AppCompatActivity {
    // public static int status;
    Button managebtn;
    Button memberbtn;
    EditText edit;
    String myJSON;

    private static final String TAG_RESULTS="result";
    private static final String TAG_NAME="name";
    private static final String TAG_NUM="num";

    JSONArray hedgehogmembers=null;

    ArrayList<HashMap<String, String>>hedgehogList;

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //실행시켰을 때 제일 먼저 초기화되는 메소드
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        managebtn = (Button)findViewById(R.id.chosemanagebtn); 
        hedgehogList = new ArrayList<HashMap<String, String>>();
        getData("http://localhost/bringdata.php");

        protected void showList () {
            try {
                JSONObject jsonObj = new JSONObject(myJSON);
                hedgehogmembers = jsonObj.getJSONArray(TAG_RESULTS);

                for (int i = 0; i < hedgehogmembers.length(); i++) {
                    JSONObject c = hedgehogmembers.getJSONObject(i);
                    String name = c.getString(TAG_NAME);
                    String num = c.getString(TAG_NUM);

                    HashMap<String, String> hedgehog = new HashMap<String, String>();

                    hedgehog.put(TAG_NAME, name);
                    hedgehog.put(TAG_NUM, num);
                    hedgehogList.add(hedgehog);
                }
                ListAdapter adapter = new SimpleAdapter(MainActivity.this, hedgehogList, R.layout.list_item, new String[]{TAG_NAME, TAG_NUM}, new int[]{R.id.name, R.id.num});
                list.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void getData (String url){
            class GetDataJSON extends AsyncTask<String, Void, String> {
                @Override
                protected String dolnBackground(String... params) {
                    String uri = params[0];

                    BufferedReader bufferedReader = null;
                    try {
                        URL urI = new URL(uri);
                        HttpURLConnection con = (HttpConnection) url.openConnection();
                        StringBuilder sb = new StringBuilder();

                        bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                        String json;
                        while ((json = bufferedReader.readLine()) != null) {
                            sb.append(json + "\n");
                        }
                        return sb.toString().trim();
                    } catch (Exception e) {
                        return null;
                    }
                }

                @Override
                protected void onPostExecute(String result) {
                    myJSON = result;
                    showList();
                }
            }
            GetDataJSON g = new GetDataJSON();
            g.execute(url);
        }
    }
}