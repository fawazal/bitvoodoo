package net.falhosh.kotlinbitvoodoo.model

data class ServiceResponseObject (
    val key: String?,
    val url: String?
        ) {
    constructor(url: String) : this("ticket url", url)
}