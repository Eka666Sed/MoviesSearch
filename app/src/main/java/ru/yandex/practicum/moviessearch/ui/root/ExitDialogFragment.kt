package ru.yandex.practicum.moviessearch.ui.root

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ExitDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Вы действительно хотите выйти из приложения?")
                .setPositiveButton("Да") { _, _ ->
                    activity?.finish()
                }
                .setNegativeButton("Нет") { _, _ ->
                    dialog?.dismiss()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
