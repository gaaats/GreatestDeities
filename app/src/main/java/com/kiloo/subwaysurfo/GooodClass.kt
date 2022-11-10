package com.kiloo.subwaysurfo

import android.app.Application
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import java.util.*

class GooodClass : Application() {
    companion object {
        const val dfrrgtgjsoupCheck = "1v4b"
        var iiiiiiiiid: String? = "myID"
        var innnnnnnnstid: String? = "instID"
        const val SDK_KEYEEEEEEEE = "66937037872879065430"

        const val ONESIGNAL_APP_IDefrgttg54 = "61729041-56ea-44d0-a878-52e105122582"

        val oooooooooone = "http://greatest"
        val tvoooooooooooo = "deities.xyz/go.php?to=1&"


    }
    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_IDefrgttg54)
        Hawk.init(this).build()

        val trackerParamsfrgtg55gt = MyTracker.getTrackerParams()
        val frgttgtrackerConfig = MyTracker.getTrackerConfig()
        val frgttinstID = MyTracker.getInstanceId(this)
        frgttgtrackerConfig.isTrackingLaunchEnabled=true
        val frrrtg4tID = UUID.randomUUID().toString()
        trackerParamsfrgtg55gt.setCustomUserId(frrrtg4tID)
        Hawk.put(iiiiiiiiid, frrrtg4tID)
        Hawk.put(innnnnnnnstid, frgttinstID)
        MyTracker.initTracker(SDK_KEYEEEEEEEE, this)
    }
}
