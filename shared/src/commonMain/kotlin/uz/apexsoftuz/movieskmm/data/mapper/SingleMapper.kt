package uz.apexsoftuz.movieskmm.data.mapper

fun interface SingleMapper<T, R> {
    operator fun invoke(value: T): R
}