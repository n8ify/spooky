package com.n8ify.spooky.service

import com.n8ify.spooky.dao.FIND_ALL_SPOT
import com.n8ify.spooky.dao.SpotDao
import com.n8ify.spooky.model.spot.Spot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface SpotService {
    fun getAllSpots() : List<Spot>
    fun deleteSpot(id : Int)
    fun insertSpot(spot : Spot)
    fun updateSpot(spot : Spot)
}

@Service
class SpotServiceImpl : SpotService {

    @Autowired
    lateinit var spotDao: SpotDao

    override fun getAllSpots(): List<Spot> {
        return spotDao.querySpots(FIND_ALL_SPOT)
    }

    override fun deleteSpot(id: Int) {
        spotDao.delete(id)
    }

    override fun insertSpot(spot: Spot) {
        spotDao.insert(spot)
    }

    override fun updateSpot(spot: Spot) {
        spotDao.update(spot)
    }
}