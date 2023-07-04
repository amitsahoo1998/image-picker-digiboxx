package com.example.digiboxx.ui.screens

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.digiboxx.R
import com.example.digiboxx.data.local.ImageEntity
import com.example.digiboxx.databinding.ActivityMainBinding
import com.example.digiboxx.ui.viewmodel.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var imageList : ArrayList<ImageEntity> = ArrayList()
    val viewModel : ImageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)



        binding.fab.setOnClickListener { view ->
            imagePicker.launch("image/*")
        }
    }

    private val imagePicker = registerForActivityResult(ActivityResultContracts.GetMultipleContents()){it->
        if (it.isNotEmpty()){
            for (i in it){
                imageList.add(ImageEntity(imageUri = i.toString()))
            }
            if (imageList.isNotEmpty()) {
                viewModel.insertImage(imageList)
            }
        }
    }





}