package com.epam.rd.autocode.factory.marvel;

import com.epam.rd.autocode.factory.Character;
import com.epam.rd.autocode.factory.EpicCrisis;
import com.epam.rd.autocode.factory.Plot;

public class MarvelPlot implements Plot {
    private Character[] heroes;
    private EpicCrisis epicCrisis;
    private Character villain;

    public MarvelPlot(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        this.heroes = heroes;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
    }

    @Override
    public String toString() {
        if (heroes.length == 1) {
            return epicCrisis.name() + " threatens the world. But brave " + heroes[0].name() + " on guard. So, no way that intrigues of " + villain.name() + " overcome the willpower of inflexible heroes";
        } else if (heroes.length == 6) {
            return epicCrisis.name() + " threatens the world. But brave " + heroes[0].name() + ", brave " + heroes[1].name() + ", brave " + heroes[2].name() + ", brave " + heroes[3].name() + ", brave " + heroes[4].name() + ", brave " + heroes[5].name() + " on guard. So, no way that intrigues of " + villain.name() + " overcome the willpower of inflexible heroes";
        } else if (heroes.length == 5) {
            return epicCrisis.name() + " threatens the world. But brave " + heroes[0].name() + ", brave " + heroes[1].name() + ", brave " + heroes[2].name() + ", brave " + heroes[3].name() + ", brave " + heroes[4].name() + " on guard. So, no way that intrigues of " + villain.name() + " overcome the willpower of inflexible heroes";
        } else return null;
    }
}
