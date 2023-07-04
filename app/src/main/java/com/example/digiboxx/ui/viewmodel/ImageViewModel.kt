package com.example.digiboxx.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digiboxx.data.local.ImageEntity
import com.example.digiboxx.domain.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(
    private val imageRepository: ImageRepository
) : ViewModel() {

    private val _images: MutableStateFlow<List<ImageEntity>> = MutableStateFlow(emptyList())
    val image = _images.asStateFlow()

    init {
        getAllImage()
    }

    private fun getAllImage() {
        imageRepository.getAllImage()
            .distinctUntilChanged()
            .onEach {
                _images.value = it
            }.launchIn(viewModelScope)
    }

    fun insertImage(photos : List<ImageEntity>){
        viewModelScope.launch {
            imageRepository.addImage(photos)
        }
    }
}