package com.example.m_commerce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import com.google.android.material.snackbar.Snackbar;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

import android.view.View;
import android.widget.EditText;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import Model.Administrator;
import Model.Customer;
import Model.DatabaseHandler;
import Model.LoginModel;
import Model.Product;

public class MainActivity extends OrmLiteBaseActivity<DatabaseHandler> {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(MainActivity.class.getName(), "Window get started");
        setContentView(R.layout.activity_main);

    }






    public void LoginClickEvent(View view) throws SQLException {
        try{
            LoginModel login_model = new LoginModel(this.getHelper().getCustomerDao(), this.getHelper().getAdministratorDao());
            EditText UsernameEditText =  (EditText) findViewById(R.id.editTextText);

            EditText PasswordEditText =  (EditText) findViewById(R.id.editTextTextPassword);

            Customer customer = new Customer(-1, "", UsernameEditText.getText().toString(), PasswordEditText.getText().toString());
            Administrator admin = new Administrator(-1, "", UsernameEditText.getText().toString(), PasswordEditText.getText().toString());

            if( login_model.isCustomer(customer)){
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                int id = login_model.GetInfo(customer).getID();
                intent.putExtra("id", id);
                startActivity(intent);
            }else if(login_model.isAdmin(admin)){
                Intent intent = new Intent(getApplicationContext(), AdminDashboardActivity.class);
                int id = login_model.GetInfoAdmin(admin).getID();
                intent.putExtra("id", id);
                startActivity(intent);
            }else{
                Snackbar.make(findViewById(R.id.main), "لقد ادخلت معلومات خاطئة",
                        Snackbar.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Log.e("Ziad", e.getMessage());
        }


    }
}