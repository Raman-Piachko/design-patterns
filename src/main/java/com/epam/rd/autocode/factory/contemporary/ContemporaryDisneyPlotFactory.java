package com.epam.rd.autocode.factory.contemporary;

import com.epam.rd.autocode.factory.Character;
import com.epam.rd.autocode.factory.EpicCrisis;
import com.epam.rd.autocode.factory.Plot;
import com.epam.rd.autocode.factory.PlotFactory;

public class ContemporaryDisneyPlotFactory implements PlotFactory {
    private Character hero;
    private EpicCrisis epicCrisis;
    private Character funnyFriend;

    public ContemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        this.hero = hero;
        this.epicCrisis = epicCrisis;
        this.funnyFriend = funnyFriend;
    }

    @Override
    public Plot plot() {
        return new ContemporaryDisneyPlot(hero, epicCrisis, funnyFriend);
    }
}
