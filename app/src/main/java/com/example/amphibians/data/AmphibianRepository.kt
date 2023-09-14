package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibianApiService

interface AmphibianRepository {
    suspend fun getAmphibian(): List<Amphibian>
}

class NetworkAmphibianRepository(
    private val amphibianApiService: AmphibianApiService
) : AmphibianRepository {
    override suspend fun getAmphibian(): List<Amphibian> = amphibianApiService.getAmphibian()
}