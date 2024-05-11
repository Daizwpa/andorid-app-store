package Model;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.m_commerce.R;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public  class DatabaseHandler extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "Stock.db";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    // the DAO object we use to access the SimpleData table
    private Dao<Customer, Integer> CustomerDao = null;
    private RuntimeExceptionDao<Customer, Integer> CustomerRuntimeDao = null;


    private Dao<Product, Integer> ProductDao = null;
    private RuntimeExceptionDao<Product, Integer> ProductRuntimeDao = null;


    private Dao<Order, Integer> OrderDao = null;
    private RuntimeExceptionDao<Order, Integer> OrderRuntimeDao = null;


    private Dao<OrderDetails, Integer> OrderDetailsDao = null;

    private RuntimeExceptionDao<OrderDetails, Integer> OrderDetailsRuntimeDao = null;


    private Dao<Administrator, Integer> AdministratorDao = null;
    private RuntimeExceptionDao<Administrator, Integer> AdministratorRuntimeDao = null;


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHandler.class.getName(), "OnCreate table");
            TableUtils.createTable(connectionSource, Customer.class);
            TableUtils.createTable(connectionSource, Product.class);
            TableUtils.createTable(connectionSource, Order.class);
            TableUtils.createTable(connectionSource, OrderDetails.class);
            TableUtils.createTable(connectionSource, Administrator.class);

        } catch (SQLException e) {
            Log.e(DatabaseHandler.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
        seed();
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHandler.class.getName(), "onUpgrade table");
            TableUtils.dropTable(connectionSource, Customer.class, true);
            TableUtils.dropTable(connectionSource, Product.class, true);
            TableUtils.dropTable(connectionSource, Order.class, true);
            TableUtils.dropTable(connectionSource, OrderDetails.class, true);
            TableUtils.dropTable(connectionSource, Administrator.class, true);
            // after we drop the old databases, we create the new ones
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHandler.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }


    private void seed(){
        Log.i(DatabaseHandler.class.getName(), "Start The Initialization ");

        Collection<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Book 1", 10, 1000.00));
        products.add(new Product(1, "Book 2", 60, 500.00));
        products.add(new Product(1, "Book 3", 5, 700.00));
        products.add(new Product(1, "Book 4", 8, 700.00));
        products.add(new Product(1, "Phone 1", 2, 1000.00));
        products.add(new Product(1, "Phone 2", 20, 500.00));
        products.add(new Product(1, "Phone 3", 90, 700.00));
        products.add(new Product(1, "Phone 4", 1, 700.00));


        RuntimeExceptionDao<Product, Integer> dao = getProductRuntimeDao();

        dao.create(products);

        Collection<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(1, "Akram", "akram1", "123"));
        customers.add(new Customer(1, "Massaab", "M1", "123"));

        getCustomerRuntimeDao().create(customers);


        Administrator admin = new Administrator(1, "Mohammed", "admin", "admin");

        getAdministratorRuntimeDao().create(admin);


        Log.i(DatabaseHandler.class.getName(), "The Initialization completes successfully");

    }


    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        CustomerDao = null;
        CustomerRuntimeDao = null;
        ProductDao = null;
        ProductRuntimeDao = null;
        OrderDao = null;
        OrderRuntimeDao = null;
        OrderDetailsDao = null;
        OrderDetailsRuntimeDao = null;
        AdministratorDao = null;
        AdministratorRuntimeDao = null;
    }

    public RuntimeExceptionDao<OrderDetails, Integer> getOrderDetailsRuntimeDao() {
        if( OrderDetailsRuntimeDao == null){
            OrderDetailsRuntimeDao = getRuntimeExceptionDao(OrderDetails.class);
        }
        return OrderDetailsRuntimeDao;
    }

    public Dao<OrderDetails, Integer> getOrderDetailsDao() throws SQLException {
        if( OrderDetailsDao == null){
            OrderDetailsDao = getDao(OrderDetails.class);
        }
        return OrderDetailsDao;
    }

    public RuntimeExceptionDao<Order, Integer> getOrderRuntimeDao() {
        if(OrderRuntimeDao == null){
            OrderRuntimeDao = getRuntimeExceptionDao(Order.class);
        }
        return OrderRuntimeDao;
    }

    public Dao<Order, Integer> getOrderDao() throws SQLException {
        if(OrderDao == null){
            OrderDao = getDao(Order.class);
        }
        return OrderDao;
    }

    public RuntimeExceptionDao<Product, Integer> getProductRuntimeDao() {
        if(ProductRuntimeDao == null){
            ProductRuntimeDao = getRuntimeExceptionDao(Product.class);
        }
        return ProductRuntimeDao;
    }

    public Dao<Product, Integer> getProductDao() throws SQLException {
        if(ProductDao == null){
            ProductDao = getDao(Product.class);
        }
        return ProductDao;
    }

    public RuntimeExceptionDao<Customer, Integer> getCustomerRuntimeDao() {
        if(CustomerRuntimeDao == null){
            CustomerRuntimeDao = getRuntimeExceptionDao(Customer.class);
        }
        return CustomerRuntimeDao;
    }

    public Dao<Customer, Integer> getCustomerDao() throws SQLException {
        if(CustomerDao == null){
            CustomerDao =  getDao(Customer.class);
        }
        return CustomerDao;
    }


    public Dao<Administrator, Integer> getAdministratorDao() throws SQLException {
        if(AdministratorDao == null){
            AdministratorDao = getDao(Administrator.class);
        }
        return AdministratorDao;
    }



    public RuntimeExceptionDao<Administrator, Integer> getAdministratorRuntimeDao() {
        if(AdministratorRuntimeDao == null){
            AdministratorRuntimeDao = getRuntimeExceptionDao(Administrator.class) ;
        }
        return AdministratorRuntimeDao;
    }


}
