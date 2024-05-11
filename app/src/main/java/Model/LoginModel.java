package Model;

import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Observable;

public class LoginModel{

    private Dao<Customer, Integer> dao = null;
    private Dao<Administrator, Integer> adminDao = null;
    public  LoginModel(Dao<Customer, Integer> dao, Dao<Administrator, Integer> adminDao){
        this.dao = dao;
        this.adminDao = adminDao;
    }

    public boolean isCustomer(Customer customer){
        boolean ok = false;
        QueryBuilder<Customer, Integer> query_builder = null;

        try{
            query_builder = dao.queryBuilder();
            Customer retrieved_customer = query_builder.where()
                    .eq("Username", customer.Username)
                    .and()
                    .eq("Password", customer.Password)
                    .queryForFirst();

            if(retrieved_customer != null){
                ok = true;
            }

        }catch (Exception e){
            Log.e("SQLQuery", Objects.requireNonNull(e.getMessage()));
            ok = false;
        }

        return ok;
    }

    public boolean isAdmin(Administrator customer){
        boolean ok = false;
        QueryBuilder<Administrator, Integer> query_builder = null;

        try{
            query_builder = adminDao.queryBuilder();
            Administrator retrieved_customer = query_builder.where()
                    .eq("Username", customer.Username)
                    .and()
                    .eq("Password", customer.Password)
                    .queryForFirst();

            if(retrieved_customer != null){
                ok = true;
            }

        }catch (Exception e){
            Log.e("SQLQuery", Objects.requireNonNull(e.getMessage()));
            ok = false;
        }

        return ok;
    }


    public Customer GetInfo(Customer customer){
        QueryBuilder<Customer, Integer> query_builder = null;
        Customer retrieved_customer = null;
        try{
            query_builder = dao.queryBuilder();
            retrieved_customer = query_builder.where()
                    .eq("Username", customer.Username)
                    .and()
                    .eq("Password", customer.Password)
                    .queryForFirst();


        }catch (Exception e){
            Log.e("SQLQuery", Objects.requireNonNull(e.getMessage()));
            return null;
        }

        return retrieved_customer;
    }

    public Administrator GetInfoAdmin(Administrator admin){
        QueryBuilder<Administrator, Integer> query_builder = null;
        Administrator retrieved_customer = null;
        try{
            query_builder = adminDao.queryBuilder();
            retrieved_customer = query_builder.where()
                    .eq("Username", admin.Username)
                    .and()
                    .eq("Password", admin.Password)
                    .queryForFirst();


        }catch (Exception e){
            Log.e("SQLQuery", Objects.requireNonNull(e.getMessage()));
            return null;
        }

        return retrieved_customer;
    }


    public Customer GetInfoByID(Customer customer){
        QueryBuilder<Customer, Integer> query_builder = null;
        Customer retrieved_customer = null;
        try{
            query_builder = dao.queryBuilder();
            retrieved_customer = query_builder.where()
                    .eq("ID", customer.getID())
                    .queryForFirst();
        }catch (Exception e){
            Log.e("SQLQuery", Objects.requireNonNull(e.getMessage()));
            return null;
        }

        return retrieved_customer;
    }

    public Administrator GetInfoAdminByID(Administrator admin){
        QueryBuilder<Administrator, Integer> query_builder = null;
        Administrator retrieved_customer = null;
        try{
            query_builder = adminDao.queryBuilder();
            retrieved_customer = query_builder.where()
                    .eq("ID", admin.getID())
                    .queryForFirst();
        }catch (Exception e){
            Log.e("SQLQuery", Objects.requireNonNull(e.getMessage()));
            return null;
        }

        return retrieved_customer;
    }



}
