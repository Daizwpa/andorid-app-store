package com.example.m_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import Model.Customer;
import Model.DatabaseHandler;
import Model.LoginModel;
import Model.Product;

public class DashboardActivity extends OrmLiteBaseActivity<DatabaseHandler> {

    int id = 0;
    LoginModel login = null;

    Customer customer = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            assert bundle != null;
            id = bundle.getInt("id");

            login = new LoginModel(this.getHelper().getCustomerDao(), null);
            customer = login.GetInfoByID(new Customer(id, "", "", ""));

            setContentView(R.layout.activity_dashboard);

            TextView textViewname = (TextView) findViewById(R.id.textView3);
            textViewname.setText(customer.getName());

            ListView listView = (ListView) findViewById(R.id.listView1);
            List<Product> listProduct = GetListOfProduct();
            ArrayList<String> listProductName = new ArrayList<String>();
            for (int i = 0; i < listProduct.size(); i++) {
                listProductName.add("Article:" + listProduct.get(i).getName() +"\n Price:"+ listProduct.get(i).getPrice() + "DA");
            }
            String[] s = listProductName.toArray(new String[0]);
            ArrayAdapter adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, s);
            listView.setAdapter(adapter);
            System.out.println("ok");
        } catch (Exception e) {
            Log.e("Ziad", e.getMessage());
        }


    }


    private List<Product> GetListOfProduct() {
        Dao<Product, Integer> productDao = null;
        List<Product> products = null;
        try {
            productDao = this.getHelper().getProductDao();
             products = productDao.queryForAll();


        } catch (Exception e) {
            Log.e("Ziad", Objects.requireNonNull(e.getMessage()));

        }
        return products;
    }
}
