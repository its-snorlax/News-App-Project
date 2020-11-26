package com.juniorjainsahab.newsapp

import android.os.AsyncTask

class AsyncTask(
    private val callBack: () -> Unit
) : AsyncTask<Void?, Void?, Int>() {
    override fun doInBackground(vararg params: Void?): Int {
        callBack()
        return 0;
    }
}

fun asyncTask(callBack: () -> Unit) {
    AsyncTask(callBack).execute()
}