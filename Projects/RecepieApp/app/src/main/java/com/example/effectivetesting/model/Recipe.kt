package com.example.effectivetesting.model

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

private const val ID_PREFIX = "id="
private const val TITLE_PREFIX = "title="


data class Recipe(val id: String, val title: String, val description: String) {

    object staticMethods {
        fun readFromStream(stream: InputStream): Recipe? {
            var id: String? = null
            var title: String? = null
            val descBuilder = StringBuilder()

            val reader = BufferedReader(InputStreamReader(stream))

            try {
                var line: String = reader.readLine()
                while (true) {
                    if (line.startsWith(ID_PREFIX)) {
                        id = line.substring(ID_PREFIX.length)
                        line = reader.readLine()
                        continue
                    }
                    if (line.startsWith(TITLE_PREFIX)) {
                        title = line.substring(TITLE_PREFIX.length)
                        line = reader.readLine()
                        continue
                    }
                    if (descBuilder.length > 0) {
                        descBuilder.append("\n")
                    }
                    descBuilder.append(line)
                    line = reader.readLine()
                }
            } catch (e: IOException) {
                return null
            }
        }
    }


}