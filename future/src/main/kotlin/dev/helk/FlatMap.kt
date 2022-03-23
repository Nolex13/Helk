package dev.helk

import java.util.concurrent.CompletableFuture

fun <T, S> CompletableFuture<T>.flatMap(callback: (result: T) -> CompletableFuture<S>): CompletableFuture<S> =
    this.thenCompose {
        callback(it)
    }