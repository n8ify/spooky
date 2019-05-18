package com.n8ify.spooky.dao

import com.n8ify.spooky.model.Spot
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.lang.StringBuilder
import java.sql.ResultSet

const val FIND_ALL_SPOT = -1

interface SpotDao {

    fun querySpots(limit: Int? = FIND_ALL_SPOT): List<Spot>

}

@Repository
class SpotDaoImpl : BaseAbstractDao(), SpotDao {
    override fun querySpots(limit: Int?): List<Spot> {
        val sql: StringBuilder = StringBuilder()
        sql.append("SELECT * FROM spot")
        if (limit != FIND_ALL_SPOT) {
            sql.append(" LIMIT = ?")
            val params = arrayOf(limit)
            return jdbcTemplate?.query(sql.toString(), params, SpotRowMapper()) ?: run { return arrayListOf() }
        } else {
            return jdbcTemplate?.query(sql.toString(), SpotRowMapper()) ?: run { return arrayListOf() }
        }
    }
}

class SpotRowMapper : RowMapper<Spot> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Spot? {
        val id = rs.getInt("id")
        val tale = rs.getString("tale")
        val description = rs.getString("description")
        val remark = rs.getString("remark")
        val status = rs.getInt("status")
        val latitude = rs.getFloat("latitude")
        val longitude = rs.getFloat("longitude")
        val createTimeStamp = rs.getTimestamp("create_timestamp")
        return Spot(id, tale, description, remark, status, latitude, longitude, createTimeStamp)
    }
}