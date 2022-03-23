package dev.helk

import java.util.concurrent.CompletableFuture

fun <T, S> CompletableFuture<T>.flatMap(callback: (result: T) -> S): CompletableFuture<S> =
    this.thenApply {
        callback(it)
    }