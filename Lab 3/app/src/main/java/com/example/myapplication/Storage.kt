package com.example.myapplication

class Storage {
    var id: Int = 0
    var text:String? =  null
    var font: Int = 0
    constructor(text: String, font:Int, id: Int) {
        this.text = text
        this.font = font
        this.id = id
    }
}