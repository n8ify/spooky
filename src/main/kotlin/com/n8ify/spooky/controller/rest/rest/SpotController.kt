package com.n8ify.spooky.controller.rest.rest

import com.n8ify.spooky.model.Spot
import com.n8ify.spooky.service.SpotService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/spot")
class SpotController {

    @Autowired
    lateinit var spotService: SpotService

    @GetMapping("/")
    fun getSpots() : List<Spot> {
        return spotService.getAllSpots()
    }

}