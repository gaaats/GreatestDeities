-dontwarn com.onesignal.**

-keep class com.onesignal.ActivityLifecycleListenerCompat** {*;}


-keep class kotlinx.coroutines.**
-dontwarn kotlinx.coroutines.**

-keep class com.my.tracker.** { *; }
-dontwarn com.my.tracker.**
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient {
    com.google.android.gms.ads.identifier.AdvertisingIdClient$Info getAdvertisingIdInfo(android.content.Context);
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info {
    java.lang.String getId();
    boolean isLimitAdTrackingEnabled();
}
-keep class com.android.installreferrer.** { *; }
-keep class com.android.vending.billing.** { *; }
-keep class com.android.billingclient.api.** { *; }
#Lottie
-dontwarn com.airbnb.lottie.**
-keep class com.airbnb.lottie.** {*;}

