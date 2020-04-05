package com.andruid.magic.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andruid.magic.eezetensions.*
import com.andruid.magic.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            packageVersionTV.text = getString(R.string.package_version, this@MainActivity.getPackageVersion())
            deviceNameTV.text = getString(R.string.device_name, this@MainActivity.getUserDeviceName())
            appNameTV.text = getString(R.string.application_name, this@MainActivity.getApplicationName())

            hasInternetBtn.setOnClickListener {
                toast("Has internet = ${this@MainActivity.hasInternet()}")
            }
            mobileDataBtn.setOnClickListener {
                toast("Mobile data enabled = ${this@MainActivity.isMobileDataEnabled()}")
            }
            settingsBtn.setOnClickListener {
                startActivity(this@MainActivity.buildSettingsIntent())
            }
            tetherSettingsBtn.setOnClickListener {
                startActivity(buildTetherSettingsIntent())
            }
        }
    }
}