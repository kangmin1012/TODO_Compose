package kang.min.navigation

import kotlinx.serialization.Serializable

sealed interface Destination {
    @Serializable
    data object Todo : Destination
}

