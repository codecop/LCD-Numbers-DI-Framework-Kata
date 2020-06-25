package org.codecop.lcdnumbers

import dagger.Component

@Component(modules = [RuntimeEnvironmentModule::class, LcdDisplayModule::class])
interface MainComponent {
    fun main(): Main
}