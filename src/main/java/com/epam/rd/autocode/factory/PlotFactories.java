package com.epam.rd.autocode.factory;

import com.epam.rd.autocode.factory.classic.ClassicDisneyPlotFactory;
import com.epam.rd.autocode.factory.contemporary.ContemporaryDisneyPlotFactory;
import com.epam.rd.autocode.factory.marvel.MarvelPlotFactory;

public class PlotFactories {

    public PlotFactory classicDisneyPlotFactory(Character hero, Character beloved, Character villain) {
        return new ClassicDisneyPlotFactory(hero, beloved, villain);
    }

    public PlotFactory contemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        return new ContemporaryDisneyPlotFactory(hero, epicCrisis, funnyFriend);
    }

    public PlotFactory marvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        return new MarvelPlotFactory(heroes, epicCrisis, villain);
    }
}
