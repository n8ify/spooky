package com.n8ify.spooky.model.spot

import com.google.gson.annotations.Expose
import org.springframework.format.annotation.DateTimeFormat
import java.sql.Timestamp
import java.time.LocalDateTime

data class Spot(val id : Int, val tale : String, val description : String?, val remark : String?, val status : Int, val latitude : Float, val longitude : Float, @DateTimeFormat(pattern = "E d, MMM yyyy h:mm:ss a") val createTimestamp: Timestamp? = Timestamp.valueOf(LocalDateTime.now()))