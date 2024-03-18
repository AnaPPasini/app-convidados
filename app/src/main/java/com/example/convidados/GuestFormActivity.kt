package com.example.convidados

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.constants.DataBaseConstants
import com.example.convidados.databinding.ActivityGuestFormBinding
import com.example.convidados.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel
    private var guestId = 0

    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        binding.buttonSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true


        observe()
        loadData()



    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            val name = binding.editName.text.toString()
            val presence = binding.radioPresent.isChecked

            val model = GuestModel().apply {
                this.id = guestId
                this.name = name
                this.presence = presence
            }

            viewModel.save(model)

        }
    }

    private fun loadData(){
        val bundle = intent.extras
        if (bundle != null) {
            guestId = bundle.getInt(DataBaseConstants.GUEST.ID)
            viewModel.get(guestId)

        }
    }

    private fun observe(){
        viewModel.guest.observe(this, Observer {
                binding.editName.setText(it.name)
                if (it.presence){
                    binding.radioPresent.isChecked = true
                } else { binding.radioAbsent.isChecked = true}
            })
        viewModel.saveGuest.observe(this, Observer {
            if (it){
                if (guestId == 0){
                Toast.makeText(applicationContext, "Inserção com sucesso", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Atualização", Toast.LENGTH_SHORT).show()
                }
                finish()
            } else {
                Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
                }
        })
    }


    }




