package com.example.ebook_esenin_mart_2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.lifecycle.ViewModelProvider
import com.example.ebook_esenin_mart_2022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val viewModel = ViewModelProvider(this).get(ViewModel::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val messageFragment = MainFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, messageFragment)
            .commit()

        // "Шторка" - Содержание книги
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //выбор стихотворения по содержанию
        binding.navView.setNavigationItemSelectedListener {

            when (it.itemId) {

                // если нажимаем на кнопку 1 - открытваем первый стих
                R.id.miItem1 -> {
                    viewModel.onPageOne()
                }

                // если нажимаем на кнопку 2 - открытваем второй стих
                R.id.miItem2 -> {
                    viewModel.onPageTwo()
                }

                // если нажимаем на кнопку 3 - открытваем третий стих
                R.id.miItem3 -> {
                    viewModel.onPageThree()
                }
            }
            true
        }


    }

    // "Шторка" - Содержание книги
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}
