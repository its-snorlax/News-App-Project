package com.juniorjainsahab.newsapp

import android.os.AsyncTask
import com.juniorjainsahab.newsapp.db.OnExecuteListener

class AsyncTask(
    private val callBack: () -> Unit,
    private val onExecuteListener: OnExecuteListener
) : AsyncTask<Void?, Void?, Int>() {
    override fun doInBackground(vararg params: Void?): Int? {
        callBack()
        return 0;
    }

    override fun onPostExecute(result: Int?) {
        onExecuteListener.onQuerySuccess()
    }
}

fun asyncTask(callBack: () -> Unit, listener: OnExecuteListener) {
    AsyncTask(callBack, listener).execute()
}