package com.ihorvitruk.telegramclient.data.repository

import android.content.Context
import android.util.Log
import org.drinkless.td.libcore.telegram.Client
import org.drinkless.td.libcore.telegram.TdApi

class SomeRepository(private val context: Context) {

    fun doSmthg() {

        val client = Client.create(null, null, null)

        val tdLibParams = TdApi.TdlibParameters()
        tdLibParams.apiId = 194277
        tdLibParams.apiHash = "242b6fd3119c8d65947ca6800452e794"
        tdLibParams.databaseDirectory = context.cacheDir.absolutePath
        tdLibParams.filesDirectory = context.filesDir.absolutePath
        tdLibParams.deviceModel = "Iphone 7"
        tdLibParams.systemVersion = "iOS"
        tdLibParams.systemLanguageCode = "uk"

        val setTdLibParams = TdApi.SetTdlibParameters(tdLibParams)
        client.send(setTdLibParams, {
            log(it)
            val setDatabaseEncryptionKey = TdApi.SetDatabaseEncryptionKey("12345".toByteArray())
            client.send(setDatabaseEncryptionKey, {
                log(it)
                val smsSender = TdApi.SetAuthenticationPhoneNumber(
                        "380969408509", true, false
                )

                client.send(smsSender, {
                    log(it)

                    val state = TdApi.GetAuthorizationState()
                    client.send(state, {
                        log(it)

                        val checkAuthCode = TdApi.CheckAuthenticationCode("12345", null, null)
                        client.send(checkAuthCode, {
                            log(it)

                            val logout = TdApi.LogOut()
                            client.send(logout, ::log)
                        })
                    })
                })
            })
        })

        /*client.close()*/
    }

    private fun log(obj: TdApi.Object) {
        Log.d("OBJ", obj.toString())
    }
}