package com.example.pingtolk;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

/**
 * 채팅방 목록 화면
 */
public class ChatListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ChatRoomAdapter adapter;
    List<ChatRoom> roomList = new ArrayList<>();
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        recyclerView = findViewById(R.id.recyclerRoomList);

        adapter = new ChatRoomAdapter(this, roomList, new ChatRoomAdapter.OnRoomClickListener() {
            @Override
            public void onRoomClick(ChatRoom room) {
                Intent intent = new Intent(ChatListActivity.this, ChatActivity.class);
                intent.putExtra("familyCode", room.getCode());
                intent.putExtra("nickname", "손님");  // 필요 시 SharedPreferences로 대체 가능
                startActivity(intent);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();
        loadRooms();
    }

    private void loadRooms() {
        db.collection("rooms").get().addOnSuccessListener(snapshot -> {
            roomList.clear();
            for (DocumentSnapshot doc : snapshot.getDocuments()) {
                String code = doc.getId();
                String createdBy = doc.getString("created_by");
                roomList.add(new ChatRoom(code, createdBy != null ? createdBy : "알 수 없음"));
            }
            adapter.notifyDataSetChanged();
        });
    }
}
