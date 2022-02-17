package com.example.projectdia.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectdia.di.DaggerAppComponent
import com.example.projectdia.model.DayLimaResponse
import com.example.projectdia.repository.AppRepository
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.lang.Error
import java.util.concurrent.ScheduledExecutorService
import javax.inject.Inject


    class DayLimaViewModel : ViewModel() {
        private val list = MutableLiveData<DayLimaResponse>()
        private val compositeDisposable = CompositeDisposable()
        private val isError = MutableLiveData<Boolean>()

        @Inject
        lateinit var repository: AppRepository

        init {
            DaggerAppComponent.create().injectDayLima(this)
        }

        fun getAllJob(){
            compositeDisposable.add(
                repository.getAllJob()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableSingleObserver<DayLimaResponse>(){
                        override fun onSuccess(t: DayLimaResponse) {
                            if(t.code == 200){
                                list.value = t
                            }else{
                                isError.value = true
                            }
                        }

                        override fun onError(e: Throwable) {
                            isError.value = true
                            if(e is HttpException){
                                val errorBody = (e as HttpException).response()?.errorBody()
                                val gson = Gson()
                                val error = gson.fromJson(
                                    errorBody?.string(),
                                    DayLimaResponse::class.java
                                )
                            }
                        }
                    })
            )
        }
        fun listResponse(): MutableLiveData<DayLimaResponse>{
            return list
        }
        fun getIsError(): MutableLiveData<Boolean>{
            return isError
        }

    }
