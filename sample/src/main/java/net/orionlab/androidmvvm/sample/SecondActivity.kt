package net.orionlab.androidmvvm.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.orionlab.androidmvvm.sample.view.FirstCommunicationFragment
import net.orionlab.androidmvvm.sample.view.SecondCommunicationFragment

class SecondActivity : AppCompatActivity(), CommunicationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onResume() {
        super.onResume()
        val firstContainer = supportFragmentManager.findFragmentById(R.id.firstCommunicationContainer)
        if (firstContainer == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.firstCommunicationContainer, FirstCommunicationFragment(), null)
                .commit()
        }

        val secondContainer = supportFragmentManager.findFragmentById(R.id.secondCommunicationContainer)
        if (secondContainer == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.secondCommunicationContainer, SecondCommunicationFragment(), null)
                .commit()
        }
    }

    override fun onStop() {
        val firstContainer = supportFragmentManager.findFragmentById(R.id.firstCommunicationContainer)
        if (firstContainer != null) {
            supportFragmentManager.beginTransaction().remove(firstContainer).commit()
        }
        val secondContainer = supportFragmentManager.findFragmentById(R.id.secondCommunicationContainer)
        if (secondContainer != null) {
            supportFragmentManager.beginTransaction().remove(secondContainer).commit()
        }
        super.onStop()
    }

    override fun onCommunication(value: String) {
        val firstContainer = supportFragmentManager.findFragmentById(R.id.firstCommunicationContainer)
        val secondContainer = supportFragmentManager.findFragmentById(R.id.secondCommunicationContainer)
        if (firstContainer is CommunicationListener) {
            firstContainer.onCommunication(value)
        }
        if (secondContainer is CommunicationListener) {
            secondContainer.onCommunication(value)
        }
    }
}
