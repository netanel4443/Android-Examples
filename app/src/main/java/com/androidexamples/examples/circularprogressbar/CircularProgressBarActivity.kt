package com.androidexamples.examples.circularprogressbar

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.androidexamples.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.circular_progressbar.*
import java.util.concurrent.TimeUnit

class CircularProgressBarActivity : AppCompatActivity() {

    private val TIME: Long = 60
    private var timeLeft: Long = TIME
    private var elapsedTime: Long = 0
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.circular_progressbar)
        startTimer(elapsedTime,timeLeft)

        pauseProgressBarBtn.setOnClickListener {
            pauseTimer()
        }

        resumeProgressBarBtn.setOnClickListener {
            resumeTimer()
        }
    }

    private fun startTimer(prevElapsedTime: Long, prevTimeLeft: Long) {
        compositeDisposable.add(interval(prevTimeLeft)
            .subscribeOn(io.reactivex.rxjava3.schedulers.Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ counter ->
                elapsedTime = prevElapsedTime + counter + 1 //counter starts from 0
                timeLeft = TIME - elapsedTime
                progressBar.progress = timeLeft.toInt()

            }) { Log.e("CircularProgressBarActivity", it.message) }
        )
    }

    private fun pauseTimer() {
        compositeDisposable.clear()
    }

    private fun resumeTimer() {
      startTimer(elapsedTime,timeLeft)
    }

    private fun interval(take: Long): Observable<Long> {
        return Observable.interval(1, TimeUnit.SECONDS)
            .take(take)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear() //prevent leaks
    }
}