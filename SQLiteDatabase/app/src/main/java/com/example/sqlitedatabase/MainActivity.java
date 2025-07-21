package com.example.sqlitedatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etName,etPhoneN;
    Button buttonAdd,buttonUpdate;
    ListView listView;
    int ID = 0;
    ArrayList arrayListID = new ArrayList();
    MyDBHelper myDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etPhoneN = findViewById(R.id.editTextPhoneN);
        buttonAdd = findViewById(R.id.buttonADD);
        buttonUpdate = findViewById(R.id.buttonUPDATE);
        listView = findViewById(R.id.listView);

        myDBHelper = new MyDBHelper(this);

        buttonAdd.setVisibility(View.VISIBLE);
        buttonUpdate.setVisibility(View.INVISIBLE);
        loadList();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String phone = etPhoneN.getText().toString();

                if (name.length()>0 && phone.length()>0)
                {
                    if (myDBHelper.insertContact(name,phone))
                    {
                        Toast.makeText(MainActivity.this, "Added Succesfully", Toast.LENGTH_SHORT).show();
                        loadList();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please Enter Name&Phone Number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String phone = etPhoneN.getText().toString();

                if (myDBHelper.updateContact(ID,name,phone))
                {
                    Toast.makeText(MainActivity.this, "Updated Succesfully", Toast.LENGTH_SHORT).show();
                    loadList();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ID =Integer.parseInt(arrayListID.get(position).toString());

                buttonAdd.setVisibility(View.INVISIBLE);
                buttonUpdate.setVisibility(View.VISIBLE);

                ArrayList<String> arrayList = myDBHelper.getData(ID);

                etName.setText(arrayList.get(0));
                etPhoneN.setText(arrayList.get(1));
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ID = Integer.parseInt(arrayListID.get(position).toString());

                callDialog(ID);

                return true;
            }
        });
    }

    @SuppressLint("Range")
    public void loadList()
    {
        arrayListID = myDBHelper.getAllContactsId();

        ArrayList<String> arrayListName = new ArrayList<>();
        ArrayList<String> arrayListPhone = new ArrayList<>();

        Cursor cursor = myDBHelper.getAllData();
        cursor.moveToFirst();

        while (cursor.isAfterLast()== false)
        {
            arrayListName.add(cursor.getString(cursor.getColumnIndex(MyDBHelper.COLUMN_NAME)));
            arrayListPhone.add(cursor.getString(cursor.getColumnIndex(MyDBHelper.COLUMN_PHONE_NO)));
            cursor.moveToNext();
        }

        listView.setAdapter(new CustomAdapter(MainActivity.this,arrayListID,arrayListName,arrayListPhone));

        buttonAdd.setVisibility(View.VISIBLE);
        buttonUpdate.setVisibility(View.INVISIBLE);
        etName.setText("");
        etPhoneN.setText("");
    }

    public void callDialog(final int ID)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to delete this Contact?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (myDBHelper.deleteContact(ID))
                {
                    Toast.makeText(MainActivity.this, "Deleted Succesfully", Toast.LENGTH_SHORT).show();
                    loadList();
                }
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}