package uz.apexsoftuz.movieskmm.data.datasource.network.configuration

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import uz.apexsoftuz.movieskmm.util.NetworkConstants

private const val API_KEY = "118fc702db8a770e2f994c349ad28e63"

internal abstract class KtorConfiguration {
    val httpClient = HttpClient {
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "HTTP Ktor Client", message = message)
                }
            }
            level = LogLevel.BODY
        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }.also { Napier.base(DebugAntilog()) }


    suspend inline fun <reified T> createRequest(
        path: String,
        requestBody: Any? = null,
        httpMethod: HttpMethod = HttpMethod.Get,
        parameters: Array<Pair<String, Any>>? = null
    ): T {
        val response = httpClient.request {

            method = httpMethod

            url {
                takeFrom(NetworkConstants.BASE_URL)
                path("3", path)
                parameter(NetworkConstants.API_KEY, API_KEY)
                parameter(NetworkConstants.LANGUAGE, NetworkConstants.LANGUAGE_EN)
            }

            if (requestBody != null) {
                setBody(requestBody)
            }

            headers {
                append(NetworkConstants.ACCEPT, NetworkConstants.APPLICATION_JSON)
            }

            if (parameters != null) {
                Parameters.build {
                    parameters.forEach { param ->
                        parameter(param.first, param.second)
                    }
                }
            }
        }

        return response.body()
    }
}