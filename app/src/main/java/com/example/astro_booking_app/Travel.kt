package com.example.astro_booking_app

class Travel {

    var destination:String = ""
    var phone:String = ""
    var time_id:String = ""
    var date:String = ""

    constructor(destination: String, phone: String, time_id: String, date:String) {
        this.destination = destination
        this.phone = phone
        this.time_id = time_id
        this.date = date
    }
    constructor()
}