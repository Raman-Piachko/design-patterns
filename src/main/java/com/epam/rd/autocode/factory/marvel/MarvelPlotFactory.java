package com.epam.rd.autocode.factory.marvel;

import com.epam.rd.autocode.factory.Character;
import com.epam.rd.autocode.factory.EpicCrisis;
import com.epam.rd.autocode.factory.Plot;
import com.epam.rd.autocode.factory.PlotFactory;

public class MarvelPlotFactory implements PlotFactory {
    private Character[] heroes;
    private EpicCrisis epicCrisis;
    private Character villain;

    public MarvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        this.heroes = heroes;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
    }

    @Override
    public Plot plot() {
        return new MarvelPlot(heroes, epicCrisis, villain);
    }
}
