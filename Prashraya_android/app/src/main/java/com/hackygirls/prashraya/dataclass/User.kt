package com.hackygirls.prashraya.dataclass

class User{

    var email: String? = null
    var pass: String? = null
    var name: String? = null
    var pho : String? = null
    var gender: String? = null
    var dob : String? = null
    var disease : String? = null
    var weight : String? = null
    var height : String? = null
    var symp: String? = null

    constructor(
        email:String,
        pass:String,
       name: String,
        pho : String,
         gender: String,
         dob : String,
         disease : String,
         weight : String,
         height : String,
         symp: String,

        )
    {
        this.email = email
        this.pass = pass
        this.name = name
        this.pho = pho
        this.gender = gender
        this.dob = dob
        this.disease= disease
        this.weight = weight
        this.height = height
        this.symp = symp


    }

}