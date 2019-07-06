package me.aluceps.practicedeeplink

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.net.Uri
import java.io.Serializable
import java.util.*

class MainViewModel : BaseObservable() {
    @get:Bindable
    var from: LaunchBy = LaunchBy.NO_ENTRY
        set(value) {
            field = value
            notifyPropertyChanged(BR.from)
        }

    @get:Bindable
    var uri: Uri = Uri.EMPTY
        set(value) {
            field = value
            notifyPropertyChanged(BR.uri)
        }

    @get:Bindable
    var datetime: Date = Date()
        set(value) {
            field = value
            notifyPropertyChanged(BR.datetime)
        }
}

enum class LaunchBy : Serializable {
    NO_ENTRY,
    ON_CREATE,
    ON_NEW_INTENT,
}
