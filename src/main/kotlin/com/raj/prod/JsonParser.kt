package com.raj.prod
import com.google.gson.GsonBuilder
import java.io.File

//Represent the structure of a Postman collection using data classes.
data class Request(val name: String? = null)
data class Item(val name: String? = null, val request: Request? = null, val item: List<Item>? = null)
data class PostmanCollection(val item: List<Item>)
/**
 * Parse a Postman collection (JSON format, v2.1)
 * Extract all values associated with the "name" key
 * Write the extracted values to a file, one per line
 */
fun main() {
    println("Use https://codebeautify.org/file-diff to find the difference between the output of this program and other source")

    //Load the collection: Read the JSON file into a PostmanCollection object.
    val gson = GsonBuilder().setPrettyPrinting().create()
    val collectionFile = File("src\\main\\resources\\postman_collection.json")
    val outputFile = File("names.txt")

    val collection = gson.fromJson(collectionFile.readText(), PostmanCollection::class.java)
    val names = mutableListOf<String>()

    //Extract names: Recursively traverse the collection to find "name" values and store them in a list.
    //Also, the name should be added only if the first letter is uppercase
    fun extractNames(items: List<Item>)  {
        items.forEach {
            item ->
            item.name?.takeIf { it.first().isUpperCase() }?.let { names.add(it) }
            item.request?.name?.takeIf { it.first().isUpperCase() }?.let { names.add(it) }
            item.item?.let { extractNames(it) }
        }
    }
    //call extractNames
    extractNames(collection.item)
    //the list should be sorted ascending
    val sortedNames = names.distinct().sorted()
    //Write names to file
    outputFile.writeText(sortedNames.joinToString("\n"))
}