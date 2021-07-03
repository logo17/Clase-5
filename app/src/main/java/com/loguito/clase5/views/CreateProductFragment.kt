package com.loguito.clase5.views

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.loguito.clase5.R
import com.loguito.clase5.viewmodels.CreateProductViewModel

// TODO 2: Creamos los fragmentos para mostrar en el viewpager
class CreateProductFragment : Fragment(R.layout.fragment_create_product) {
    private lateinit var productNameEditText: TextInputEditText
    private lateinit var productQuantityEditText: TextInputEditText
    private lateinit var saveButton: Button

    private lateinit var viewModel: CreateProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(CreateProductViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productNameEditText = view.findViewById(R.id.nameEditText)
        productQuantityEditText = view.findViewById(R.id.quantityEditText)
        saveButton = view.findViewById(R.id.button)

        saveButton.setOnClickListener {
            viewModel.insert(productNameEditText.text.toString(), productQuantityEditText.text.toString().toInt())
        }
    }
}