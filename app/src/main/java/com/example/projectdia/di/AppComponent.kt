package com.example.projectdia.di

import com.example.projectdia.viewmodel.DayLimaViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun injectDayLima(dayLimaViewModel: DayLimaViewModel)
}