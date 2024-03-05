package com.example.thenoughtyfoxtestapp.domain.repository

import com.example.thenoughtyfoxtestapp.domain.entity.PostModel

/**
 * repo used to fetch posts
 * @author Knurenko Bogdan 05.03.2024
 */
interface PostsRepository {
    suspend fun fetchPosts(): List<PostModel>
}