package org.vactor.cat

import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport


open class PropertyChangeAware {

    protected val changeSupport: PropertyChangeSupport by lazy { PropertyChangeSupport(this) }

    open fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    open fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Person(val name: String, age: Int) : PropertyChangeAware() {

    var age: Int = age
        set(value) {
            changeSupport.firePropertyChange("age", field, value)
            field = value
        }
}

fun main() {
    val p = Person("tony", 28)
    p.addPropertyChangeListener(object : PropertyChangeListener {
        override fun propertyChange(evt: PropertyChangeEvent?) {
            val newValue = evt?.newValue
            val oldValue = evt?.oldValue
            val propertyName = evt?.propertyName
            System.err.println("change: $propertyName, old=$oldValue,new=$newValue")
            p.removePropertyChangeListener(this)
        }
    })
    p.age = 32 // 会触发属性改变的回调监听
}