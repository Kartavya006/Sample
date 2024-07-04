package com.example.sample3

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sample3.ui.theme.Sample3Theme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        getData()
    }

    private fun getData() {
    val retrofit:Retrofit=Retrofit.Builder().baseUrl("https://dummy.restapiexample.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()
        val service:ApiService=retrofit.create(ApiService::class.java)
        val request = UserRequest(name = "test", salary = "123", age = "23")

        val call:Call<UserResponse> = service.createUser(request)

        call.enqueue(object : Callback<UserResponse>
        {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful)
                {
                Log.d("Response generated",response.body().toString())
                }
                else
                {
                    Log.e("Ice Cream","${response.code()}")
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("Ice Cream",t.message.toString()  )
            }
        })


    }
}
