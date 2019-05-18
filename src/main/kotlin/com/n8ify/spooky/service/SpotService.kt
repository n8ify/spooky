package com.n8ify.spooky.service

import com.n8ify.spooky.dao.FIND_ALL_SPOT
import com.n8ify.spooky.dao.SpotDao
import com.n8ify.spooky.model.Spot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface SpotService {
    fun getAllSpots() : List<Spot>
}

@Service
class SpotServiceImpl : SpotService {

    @Autowired
    lateinit var spotDao: SpotDao

    override fun getAllSpots(): List<Spot> {
        return spotDao.querySpots(FIND_ALL_SPOT)
    }
}