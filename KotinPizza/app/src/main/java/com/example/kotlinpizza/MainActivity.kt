package com.example.kotlinpizza


import android.content.res.Configuration
import android.os.Bundle


import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.kotinpizza.R
import com.example.kotlinpizza.fragments.PizzaDetailFragment
import com.example.kotlinpizza.fragments.PizzaMenuFragment

class MainActivity : AppCompatActivity(), PizzaMenuFragment.OnItemSelectedListener {
  protected override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    Log.d("MainActivity", getResources().getConfiguration().orientation.toString())

    // When Apps Runs First Type
    // saveInstanceState Will Be mull
    if (savedInstanceState == null) {
      // Instance of first fragment
      val firstFragment = PizzaMenuFragment()

      // Add Fragment to FrameLayout (flContainer), using FragmentManager
      val ft: FragmentTransaction =
        getSupportFragmentManager().beginTransaction() // begin  FragmentTransaction
      ft.add(R.id.flContainer, firstFragment) // add    Fragment
      ft.commit() // commit FragmentTransaction
    }
    if (getResources().getConfiguration().orientation === Configuration.ORIENTATION_LANDSCAPE) {
      val secondFragment = PizzaDetailFragment()
      val firstFragment = PizzaMenuFragment()

      val args = Bundle()
      args.putInt("position", 0)
      secondFragment.setArguments(args) // (1) Communicate with Fragment using Bundle
      val ft2: FragmentTransaction =
        getSupportFragmentManager().beginTransaction() // begin  FragmentTransaction
      ft2.add(R.id.flContainer2, secondFragment)
      ft2.replace(R.id.flContainer,firstFragment)  //bugfix

      // add    Fragment
      ft2.commit() // commit FragmentTransaction
    }
  }

  override fun onPizzaItemSelected(position: Int) {
    Toast.makeText(this, "Called By Fragment A: position - $position", Toast.LENGTH_SHORT)
      .show()

    // Load Pizza Detail Fragment
    val secondFragment = PizzaDetailFragment()
    val firstFragment = PizzaMenuFragment()
    val args = Bundle()
    args.putInt("position", position)
    secondFragment.setArguments(args) // (1) Communicate with Fragment using Bundle
    if (getResources().getConfiguration().orientation === Configuration.ORIENTATION_LANDSCAPE) {
      getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.flContainer2, secondFragment)
        .replace(R.id.flContainer, firstFragment)  //bugfix


        // replace flContainer
        //.addToBackStack(null)
        .commit()
    } else { // PORTRAIT Orientation
      getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.flContainer, secondFragment) // replace flContainer
        .addToBackStack(null)
        .commit()
    }
  }
}