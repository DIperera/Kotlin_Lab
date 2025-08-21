fun main() {
    val numbers = FloatArray(4)

    // Take 4 float inputs
    println("Enter 4 float values:")
    for (i in numbers.indices) {
        print("Value ${i + 1}: ")
        numbers[i] = readln().toFloat()
    }

    // Call function
    val cubes = getCubes(numbers)

    // Print results
    println("\nCube values (using arr.indices):")
    for (i in numbers.indices) {
        println("Cube of ${numbers[i]} = ${cubes[i]}")
    }
}

fun getCubes(arr: FloatArray): FloatArray {
    val result = FloatArray(arr.size)
    for (i in arr.indices) {
        result[i] = arr[i] * arr[i] * arr[i]
    }
    return result
}

