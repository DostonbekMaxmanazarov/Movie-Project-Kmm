package uz.apexsoftuz.movieskmm.di

import uz.apexsoftuz.movieskmm.data.datasource.network.apiservice.MovieApiService
import uz.apexsoftuz.movieskmm.data.datasource.network.datasources.impl.MovieRemoteDataSourceImpl
import uz.apexsoftuz.movieskmm.data.repository.MovieRepositoryImpl
import uz.apexsoftuz.movieskmm.domain.repository.MovieRepository
import uz.apexsoftuz.movieskmm.domain.usecase.impl.GetMovieUseCaseImpl
import uz.apexsoftuz.movieskmm.domain.usecase.impl.GetMoviesUseCaseImpl
import uz.apexsoftuz.movieskmm.util.provideDispatcher
import org.koin.dsl.module
import uz.apexsoftuz.movieskmm.data.datasource.network.datasources.MovieRemoteDataSource
import uz.apexsoftuz.movieskmm.data.mapper.SingleMapper
import uz.apexsoftuz.movieskmm.data.mapper.impl.MovieRemoteToMovieMapper
import uz.apexsoftuz.movieskmm.data.model.response.MovieResponse
import uz.apexsoftuz.movieskmm.domain.model.Movie
import uz.apexsoftuz.movieskmm.domain.usecase.GetMovieUseCase
import uz.apexsoftuz.movieskmm.domain.usecase.GetMoviesUseCase

private val dataModule = module {
    single<MovieRemoteDataSource> { MovieRemoteDataSourceImpl(get(), get()) }
    single { MovieApiService() }

}

private val utilityModule = module {
    single { provideDispatcher() }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    factory<GetMovieUseCase> { GetMovieUseCaseImpl(get()) }
    factory<GetMoviesUseCase> { GetMoviesUseCaseImpl() }
}

private val mapperModule = module {
    factory<SingleMapper<MovieResponse, Movie>> { MovieRemoteToMovieMapper() }
}

private val sharedModules = listOf(domainModule, dataModule, utilityModule, mapperModule)

fun getSharedModules() = sharedModules












