package com.example.per2.intentslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SendMessageActivity extends AppCompatActivity {

    private Button buttonSendMessage;
    private Button buttonShare;
    private EditText editTextMessage;

    public static final String EXTRA_SENT_MESSAGE = "themessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        wireWidgets();


        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the text from the edittext
                String message = editTextMessage.getText().toString();
                //create an intent
                Intent intentSendMessage = new Intent(SendMessageActivity.this,ReceiveMessageActivity.class);
                //package te text into the intent
                intentSendMessage.putExtra(EXTRA_SENT_MESSAGE,message);
                //start the new activity
                startActivity(intentSendMessage);
            }
        });

        buttonShare.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //makes an intent with the desiired ation
                 Intent shareMessage = new Intent(Intent.ACTION_SEND);
                 //set the data type of the stuff in the action
                //can look up the tpe you need on the internet
                shareMessage.setType("text/plain");
                //put the extra with the message
                shareMessage.putExtra(EXTRA_SENT_MESSAGE,editTextMessage.getText().toString());
                //launch the activity
                startActivity(shareMessage);
            }
        });
    }



        private void wireWidgets () {
            buttonSendMessage = findViewById(R.id.button_sendMessage_enter);
            editTextMessage = findViewById(R.id.editText_sendMessage_msg);
            buttonShare = findViewById(R.id.button_sendMessage_share);

        }

}