package tads.eaj.ufrn.segundaprovacontatos.ui.converters

import android.text.TextUtils
import androidx.databinding.InverseMethod

class DataBindingConverters {
    companion object {
        @InverseMethod("convertFloatToString")
        @JvmStatic
        fun convertStringToFloat(value: String): Float {
            if (TextUtils.isEmpty(value) || !TextUtils.isDigitsOnly(value)) {
                return 0f
            }
            return value.toFloat()
        }

        @JvmStatic
        fun convertFloatToString(value: Float?): String {
            return value?.toString() ?: ""
        }

        @InverseMethod("convertIntToString")
        @JvmStatic
        fun convertStringToInt(value: String): Int {
            if (TextUtils.isEmpty(value) || !TextUtils.isDigitsOnly(value)) {
                return 0
            }
            return value.toInt()
        }

        @JvmStatic
        fun convertIntToString(value: Int?): String {
            return value?.toString() ?: ""
        }
    }
}