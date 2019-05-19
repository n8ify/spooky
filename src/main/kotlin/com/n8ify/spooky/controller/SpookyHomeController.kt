package com.n8ify.spooky.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class SpookyHomeController {

    @GetMapping("")
    fun index() : String {
        return "index"
    }
}