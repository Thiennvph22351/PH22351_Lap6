package com.example.ph22351_lap6

import android.content.Context
import android.widget.TextView
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class VolleyFn1 {
    var strJSON=""
    fun getAllData(context: Context, textview: TextView){
        var queue=Volley.newRequestQueue(context);
        val url="https://hungnttg.github.io/array_json_new.json";
        val  request = JsonArrayRequest(url, { response ->
             for (i in 0 until response.length()){
                 try {
                     val person=response.getJSONObject(i);
                     val id=person.getString("id");
                     val name=person.getString("name")
                     val email=person.getString("email")
                     //dua tat ca vao chuoi
                     strJSON +="Id: $id\n";
                     strJSON +="Name: $name\n";
                     strJSON +="Email: $email\n";
                 }catch (e: Exception){
                     e.printStackTrace();
                 }
                 textview.text=strJSON
             }
        }, {error -> textview.text=error.message})
        queue.add(request)
    }
}