package jp.techacademy.toshinori.suzuki.scheduleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Tony on 2017/06/08.
 */

public class MessageDetailActivity extends AppCompatActivity {

    private ListView mListView;
    private Message mMessage;
    private MessageListAdapter mAdapter;

    private DatabaseReference mMessageRef;

    public ChildEventListener mEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        mMessage = (Message) extras.get("message");

        setTitle(mMessage.getmMessageid());

        mListView = (ListView) findViewById(R.id.listView);
        mAdapter = new MessageListAdapter(this, mMessage);
        mListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        DatabaseReference dataBaseReference = FirebaseDatabase.getInstance().getReference();

    }
}
