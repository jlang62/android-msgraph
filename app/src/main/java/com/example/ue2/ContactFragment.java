// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.

// <HomeSnippet>
package com.example.ue2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContactFragment extends Fragment {
    private static final String USER_NAME = "userName";

    private String mUserName;

    public ContactFragment() {

    }

    public static ContactFragment createInstance(String userName) {
        ContactFragment fragment = new ContactFragment();

        // Add the provided username to the fragment's arguments
        Bundle args = new Bundle();
        args.putString(USER_NAME, userName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUserName = getArguments().getString(USER_NAME);
        }
    }

    EditText editTextTo,editTextSubject,editTextMessage;
    Button send;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_contact, container,false);

        editTextTo=(EditText)view.findViewById(R.id.editText1);
        editTextSubject=(EditText)view.findViewById(R.id.editText2);
        editTextMessage=(EditText)view.findViewById(R.id.editText3);

        send=(Button)view.findViewById(R.id.button1);

        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                String to=editTextTo.getText().toString();
                String subject=editTextSubject.getText().toString();
                String message=editTextMessage.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
                Log.i("Send Email", "Email submitted");
            }

        });
        return view;
    }
}
// </HomeSnippet>
