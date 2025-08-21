package com.example.kotlinpractice

fun main() {
    println("Hello World!") // we don't add semicolon in Kotlin

    // ---------------- VARIABLES ----------------
    var name: String = "DK Bro"
    val age: Int = 22 //var age = 22 is also correct
    val height: Double = 5.9
    val isStudent: Boolean = true
    val grade: Char = 'A'
    val numbers = arrayOf(1, 2, 3, 4, 5)

    println("Hello, $name! You are $age years old.")
    println("Height = $height, Student = $isStudent, Grade = $grade")
    println("First number is ${numbers[0]}")

    // ---------------- WHEN ----------------
    val day = 2
    when (day) {
        1 -> println("Monday")
        2 -> println("Tuesday")
        3 -> println("Wednesday")
        else -> println("Another day")
    }

    // ---------------- FOR LOOPS ----------------
    println("\nFor loop with range (1..5):")
    for (i in 1..5) {
        print("$i ")
    }

    println("\n\nFor loop with until (1 until 5):")
    for (i in 1 until 5) {
        print("$i ")
    }

    println("\n\nFor loop with step (1..10 step 2):")
    for (i in 1..10 step 2) {
        print("$i ")
    }

    println("\n\nFor loop with downTo (5 downTo 1):")
    for (i in 5 downTo 1) {
        print("$i ")
    }

    println("\n\nFor loop over array elements:")
    for (n in numbers) {
        print("$n ")
    }

    println("\n\nFor loop with indices:")
    for (i in numbers.indices) {
        println("Index $i = ${numbers[i]}")
    }

    println("\nFor loop with withIndex:")
    for ((index, value) in numbers.withIndex()) {
        println("Index $index has value $value")
    }
}

