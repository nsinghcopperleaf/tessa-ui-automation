package com.tessa.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.json.*;

public class Util {

    private String vaultAddress;
    private String vaultToken;

    public static void main(String[] args) {

        String sAddress= System.getenv("VAULT_ADDR");
        //String sAddress = "https://vault.copperleaf.cloud:8200/v1/secret/ce/selenium";
        String sToken = System.getenv("VAULT_TOKEN");

        //String sToken = "Cost-qa-testing-token";

        String password = null;

        try{
            URL url = new URL(sAddress);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-Vault-Token", sToken);


            conn.connect();
            int responsecode = conn.getResponseCode();
            if(responsecode == 200)
            {
                System.out.println("Get the vault password");
                //InputStream response = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));

                String output;
                StringBuffer response = new StringBuffer();
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                    response.append(output);


                }
                br.close();

                System.out.println(response.toString());

                JSONObject jsonObject = new JSONObject(response.toString());
                System.out.println("request_id: " + jsonObject.getString("request_id"));
                System.out.println("lease_id: " + jsonObject.getString("lease_id"));
                System.out.println("renewable: " + jsonObject.getBoolean("renewable"));

                JSONObject tokenObject = jsonObject.getJSONObject("data");

                password = tokenObject.getString("automation_admin_user");
                conn.disconnect();

                System.out.println("password:" + password);
            }

        }
        catch (Exception e)
        {
            e.getMessage();
        }

    }

    public Util()
    {
        //vaultAddress = System.getenv("VAULT_ADDR");
        vaultAddress = "https://vault.copperleaf.cloud:8200/v1/secret/ce/selenium";
        //vaultToken = System.getenv("VAULT_TOKEN");

        vaultToken = "Cost-qa-testing-token";

    }
    public String getVaultAddress()
    {
        return vaultAddress;
    }

    public String getVaultToken()
    {
        return vaultToken;
    }

    public String getPassword ()
    {
        String sPassword = null;
        try{
            URL url = new URL(vaultAddress);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-Vault-Token", vaultToken);


            conn.connect();
            int responsecode = conn.getResponseCode();
            if(responsecode == 200)
            {
                System.out.println("Get the vault password");
                //InputStream response = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));

                String output;
                StringBuffer response = new StringBuffer();
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                    response.append(output);


                }
                br.close();

                System.out.println(response.toString());

                JSONObject jsonObject = new JSONObject(response.toString());
                System.out.println("request_id: " + jsonObject.getString("request_id"));
                System.out.println("lease_id: " + jsonObject.getString("lease_id"));
                System.out.println("renewable: " + jsonObject.getBoolean("renewable"));

                JSONObject tokenObject = jsonObject.getJSONObject("data");

                sPassword = tokenObject.getString("automation_admin_user");
                conn.disconnect();

                System.out.println("password:" + sPassword);
            }

        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return sPassword;

    }


}
