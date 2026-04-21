package com.example.makersassignment.domain.home.usecase

import com.example.makersassignment.domain.home.repository.GalleryRepository
import javax.inject.Inject

class GetGalleryImageListUseCase @Inject constructor(
    private val repository: GalleryRepository
) {
    suspend operator fun invoke(page : Int, limit : Int) = repository.getGalleryImageList(page, limit)
}
