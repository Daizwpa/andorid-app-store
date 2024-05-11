package com.example.m_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

import Model.Administrator;
import Model.DatabaseHandler;
import Model.LoginModel;

public class AdminDashboardActivity extends OrmLiteBaseActivity<DatabaseHandler> {

    int id = 0;
    LoginModel login = null;

    Administrator administrator = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            assert bundle != null;
            id = bundle.getInt("id");

            login = new LoginModel(this.getHelper().getCustomerDao(), this.getHelper().getAdministratorDao());
            administrator = login.GetInfoAdminByID(new Administrator(id, "", "", ""));

            setContentView(R.layout.activity_admin_dashboard);

            TextView textViewname = (TextView) findViewById(R.id.textViewname1);
            textViewname.setText(administrator.getName());
/*
            ListView listView = (ListView) findViewById(R.id.listView1);
            List<Product> listProduct = GetListOfProduct();
            ArrayList<String> listProductName = new ArrayList<String>();
            for (int i = 0; i < listProduct.size(); i++) {
                listProductName.add("Article:" + listProduct.get(i).getName() +"\n Price:"+ listProduct.get(i).getPrice() + "DA");
            }
            String[] s = listProductName.toArray(new String[0]);
            ArrayAdapter adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, s);
            listView.setAdapter(adapter);
            System.out.println("ok");*/
        } catch (Exception e) {
            Log.e("Ziad", e.getMessage());
        }

    }
}