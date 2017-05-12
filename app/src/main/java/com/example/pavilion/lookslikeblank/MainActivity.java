package com.example.pavilion.lookslikeblank;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.pavilion.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Connect();
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user taps the Touch Me If You Dare button */
    public void TouchMe(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, TouchMeIfYouDare.class);
        startActivity(intent);
    }


    public void Connect(){
        Connector task = new Connector();
        task.execute();
    }

    private class Connector extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String response = "";
            String url = "jdbc:mysql://localhost/messageboard";
            String user = "root";
            String pass = "changeme";


            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con = DriverManager.getConnection(url, user, pass);
                // System.out.println("Database connection success");

                String result = "Database connection success\n";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from user");
                ResultSetMetaData rsmd = rs.getMetaData();

                while (rs.next()) {
                    result += rsmd.getColumnName(1) + ": " + rs.getInt(1) + "\n";
                    result += rsmd.getColumnName(2) + ": " + rs.getString(2) + "\n";
                    result += rsmd.getColumnName(3) + ": " + rs.getString(3) + "\n";
                }
                return result;
            } catch (Exception e) {
                Log.e("TMIYD", e.getMessage());
                return "connection failed";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            TextView tv = (TextView) findViewById(R.id.textView8);
            tv.setText(s);
        }
    }
}
