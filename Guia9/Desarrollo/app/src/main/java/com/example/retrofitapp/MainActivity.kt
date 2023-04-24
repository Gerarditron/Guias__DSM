package com.example.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapp.databinding.ActivityMainBinding



class MainActivity : ComponentActivity(), SearchView.OnQueryTextListener {

    var binding: ActivityMainBinding? = null
    var dogAdapter: DogAdapter? = null
    var images: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        initRecyclerView()
        binding!!.searchDogs.setOnQueryTextListener(this as OnQueryTextListener)
    }

    private fun initRecyclerView(){
        dogAdapter = DogAdapter(images)
        binding!!.listDogs.layoutManager = LinearLayoutManager(this)
        binding!!.listDogs.adapter = dogAdapter
    }

    private fun searchByName(raza: String){
        val batch: Call<DogsResponse?>? = apiService.getDogsByBreed(raza)
        batch?.enqueue(object : Callback<DogsResponse?>{
            override fun onResponse(
                @Nullable call: Call<DogsResponse?>?,
                @Nullable response: Response<DogsResponse?>?
            ){
                if (response != null && response.body() != null){
                    val responseImage: List<String> = response.body()!!.getImages() as List<String>
                    images.clear()
                    images.addAll(responseImage)
                    dogAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(@Nullable call: Call<DogsResponse?>?,@Nullable t: Throwable?){
                if(t != null){
                    showError()
                }
            }
        })
    }

    private fun showError(){
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            if(!query.isEmpty()){
                searchByName(query.lowercase(Locale.getDefault()))
            }
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    private val apiService: ApiService
        private get() {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/breed/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)

        }




}
