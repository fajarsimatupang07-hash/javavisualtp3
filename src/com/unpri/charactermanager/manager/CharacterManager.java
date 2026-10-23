package com.unpri.charactermanager.manager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import java.util.ArrayList;
import java.util.List;

public class CharacterManager {
    private List<Character> characters;
    private static int totalCharacterCreated = 0;

    public CharacterManager() {
        this.characters = new ArrayList<>();
    }

    // A.2 & A.3: Add character dengan pencegahan duplikat nama
    public boolean addCharacter(Character c) {
        for (Character existing : characters) {
            if (existing.getName().equalsIgnoreCase(c.getName())) {
                System.out.println("Gagal: Karakter dengan nama '" + c.getName() + "' sudah ada!");
                return false;
            }
        }
        characters.add(c);
        totalCharacterCreated++;
        return true;
    }

    public Character findByName(String name) {
        for (Character c : characters) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public boolean removeCharacter(String name) {
        Character c = findByName(name);
        if (c != null) {
            characters.remove(c);
            return true;
        }
        return false;
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    // A.4: Defensive Copying (Mengembalikan salinan list, bukan aslinya)
    public List<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    // ==========================================
    // BAGIAN B: MINI-CHALLENGE
    // ==========================================
    
    // B.1: getAverageLevel() dengan pengaman edge case list kosong
    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (Character c : characters) {
            sum += c.getLevel();
        }
        return (double) sum / characters.size();
    }

    // B.2: findByType() mengembalikan ArrayList karakter sesuai tipe
    public List<Character> findByType(CharacterType type) {
        List<Character> result = new ArrayList<>();
        for (Character c : characters) {
            if (c.getType() == type) {
                result.add(c);
            }
        }
        return result;
    }

    // ==========================================
    // BAGIAN C: FITUR MANDIRI RANCANGAN SENDIRI
    // ==========================================
    
    /**
     * Mencari karakter dengan Attack Power paling tinggi di dalam manager.
     * @return Objek Character terkuat, atau null jika list kosong.
     */
    public Character findStrongest() {
        if (characters.isEmpty()) {
            return null;
        }
        Character strongest = characters.get(0);
        for (Character c : characters) {
            if (c.getAttackPower() > strongest.getAttackPower()) {
                strongest = c;
            }
        }
        return strongest;
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }
}