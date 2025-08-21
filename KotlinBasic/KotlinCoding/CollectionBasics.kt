package com.example.kotlinpractice

fun main(){
    // immutable list
    val lfamilyIM = listOf("father", "mother", "sister")

    println(lfamilyIM[0])  // father

    for (i in lfamilyIM) {
        print("$i ")  // father mother sister
    }

    println(lfamilyIM.size)  // 3


    // mutable list
    val lfamilyM = mutableListOf("father", "mother")
    lfamilyM.add("brother")

    lfamilyM.remove("father")

    println("\n" + lfamilyM[0])  // mother

    for (i in lfamilyM) {
        print("$i ")  // mother brother
    }
    println()

    //immutable set
    val sfamilyIM = setOf("father","mother","mother","mother","brother","brother","sister")

    for(i in sfamilyIM){
        print("$i ") //father mother brother sister
    }
    println()

    //mutable set
    val sfamilyM = mutableSetOf("father","mother","mother","mother","brother","brother","sister")

    sfamilyM.add("grandmother")
    sfamilyM.remove(element = "sister")

    for(i in sfamilyM){
        print("$i ") //father mother brother grandmother
    }
    println()

    //immutable map
    val gradeIM = mapOf("stu1" to "A", "stu2" to "B", "stu3" to "A")

    println(gradeIM["stu1"])  //A
    println("All students : ${gradeIM.keys}")
    //All students : [stu1, stu2, stu3]
    println("All grades : ${gradeIM.values}")
    //All grades : [A, B, A]

    //mutable map
    val gradeM = mutableMapOf("stu1" to "A", "stu2" to "B", "stu3" to "A")

    gradeM.remove(key = "stu1")
    gradeM["stu4"] = "C"

    println("All students : ${gradeM.keys}")
    //All students : [stu2, stu3, stu4]
    println("All grades : ${gradeM.values}")
    //All grades : [B, A, C]

}
