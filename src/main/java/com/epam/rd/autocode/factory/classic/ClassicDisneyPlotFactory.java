package com.epam.rd.autocode.factory.classic;

import com.epam.rd.autocode.factory.Character;
import com.epam.rd.autocode.factory.Plot;
import com.epam.rd.autocode.factory.PlotFactory;

public class ClassicDisneyPlotFactory implements PlotFactory {
    private Character hero;
    private Character beloved;
    private Character villain;

    public ClassicDisneyPlotFactory(Character hero, Character beloved, Character villain) {
        this.hero = hero;
        this.beloved = beloved;
        this.villain = villain;
    }

    @Override
    public Plot plot() {
        return new ClassicDisneyPlot(hero, beloved, villain);
    }
}
