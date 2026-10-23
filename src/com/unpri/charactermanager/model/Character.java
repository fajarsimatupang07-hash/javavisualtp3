package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // Constructor 1
    public Character(String name, CharacterType type) {
        this.name = name;
        this.type = type;
        this.level = 1;
        this.mana = 100;
        recalculateStats();
    }

    // Constructor 2
    public Character(String name, CharacterType type, int level, int mana) {
        this.name = name;
        this.type = type;
        this.level = level;
        setMana(mana);
        recalculateStats();
    }

    private void recalculateStats() {
        this.hitPoints = this.level * 100;
        this.attackPower = this.level * 15;
    }

    // Getter dan Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level harus minimal 1.");
        }
        this.level = level;
        recalculateStats();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh bernilai negatif!");
        }
        this.mana = mana;
    }

    public boolean isAlive() {
        return this.hitPoints > 0;
    }

    public void levelUp() {
        this.level++;
        recalculateStats();
    }

    // Bagian A.1: Override equals() berdasarkan nama karakter
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(name, character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("Character{name='%s', type=%s, level=%d, HP=%d, Attack=%d, Mana=%d, Alive=%b}",
                name, type, level, hitPoints, attackPower, mana, isAlive());
    }
}