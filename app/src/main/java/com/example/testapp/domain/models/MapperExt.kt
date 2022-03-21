package com.example.testapp.domain.models

import com.example.testapp.network.dto.UserAuthResponse
import com.example.testapp.network.dto.UserRegResponse
import org.jsoup.Jsoup

fun UserAuthResponse.toDomainAuthUser() =
    DomainAuthUser(
        status, id,
        message = htmlToText(message)
    )

fun UserRegResponse.toDomainSignupUser() =
    DomainSignupUser(
        userId,
        message = htmlToText(message), status
    )

fun htmlToText(html: String): String {
    return Jsoup.parse(html).text()
}