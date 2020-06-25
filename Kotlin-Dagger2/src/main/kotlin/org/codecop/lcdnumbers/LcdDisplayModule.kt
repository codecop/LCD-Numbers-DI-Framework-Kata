package org.codecop.lcdnumbers

import dagger.Module
import dagger.Provides

@Module
class LcdDisplayModule {
    @Provides
    fun provideCommandLineArguments(args: Array<String>) = CommandLineArguments(args)
    
    @Provides
    fun bindDigitFactory(impl: DigitFactoryImpl): DigitFactory = impl

    @Provides
    fun bindDigitPrinter(impl: DigitPrinterImpl): DigitPrinter = impl

    @Provides
    fun bindDigitScaler(impl: DigitScalerImpl): DigitScaler = impl

    @Provides
    fun bindDigitsSplitter(impl: DigitsSplitterImpl): DigitsSplitter = impl

    @Provides
    fun bindLcdDisplay(impl: LcdDisplayImpl): LcdDisplay = impl

    @Provides
    fun bindNumeralSystem(impl: NumeralSystemImpl): NumeralSystem = impl

    @Provides
    fun bindPatterns(impl: PatternsImpl): Patterns = impl

    @Provides
    fun bindScalingRepeater(impl: ScalingRepeaterImpl): ScalingRepeater = impl

    @Provides
    fun bindZipper(impl: ZipperImpl): Zipper = impl
    
    @Provides
    fun provideNumeralSystemImpl() = NumeralSystemImpl(10)
}