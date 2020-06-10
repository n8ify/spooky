package com.n8ify.spooky.controller.rest

import com.n8ify.spooky.controller.rest._base.BaseAbstractController
import com.n8ify.spooky.model.spot.Spot
import com.n8ify.spooky.model.spot.SpotResponse
import com.n8ify.spooky.service.SpotService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/spot")
class SpotController : BaseAbstractController() {

    @Autowired
    lateinit var spotService: SpotService

    @PostMapping("")
    fun getSpots(): SpotResponse {
        return SpotResponse().apply {
            this.status = getSuccessResponseStatus()
            this.data = spotService.getAllSpots()
        }
    }

    @PostMapping("/delete")
    fun deleteSpot(@RequestBody spot: Spot) : SpotResponse {

        spotService.deleteSpot(spot.id)

        return SpotResponse().apply {
            this.status = getSuccessResponseStatus()
            this.data = spotService.getAllSpots()
        }
    }

    @PostMapping("/insert")
    fun insertSpot(@RequestBody spot: Spot) : SpotResponse{

        spotService.insertSpot(spot)

        return SpotResponse().apply {
            this.status = getSuccessResponseStatus()
            this.data = spotService.getAllSpots()
        }
    }

    @PostMapping("/update")
    fun updateSpot(@RequestBody spot: Spot) : SpotResponse{

        spotService.updateSpot(spot)

        return SpotResponse().apply {
            this.status = getSuccessResponseStatus()
            this.data = spotService.getAllSpots()
        }
    }


    @PostMapping("/updateStatus")
    fun updateSpotStatus(@RequestBody spot: Spot) : SpotResponse{

        spotService.updateSpotStatus(spot)

        return SpotResponse().apply {
            this.status = getSuccessResponseStatus()
            this.data = spotService.getAllSpots()
        }
    }

    @PostMapping("/toggle")
    fun toggle(@RequestBody spot: Spot) : SpotResponse{

        spotService.updateSpotStatus(spot)

        return SpotResponse().apply {
            this.status = getSuccessResponseStatus()
            this.data = spotService.getAllActiveSpots()
        }
    }
}