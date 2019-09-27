package com.example.ppr_vote.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ppr_vote.ImageHelper
import com.example.ppr_vote.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*

class BottomMenuFragment: BottomSheetDialogFragment() {

    private var rootViev: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootViev = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)

        return rootViev
    }

    override fun onStart() {
        super.onStart()
        Picasso.get().load(R.drawable.ic_user_logo)
            .transform(ImageHelper)
            .into(userLogo);
    }
}