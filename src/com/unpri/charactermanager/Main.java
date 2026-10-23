package com.unpri.charactermanager;

import com.unpri.charactermanager.manager.CharacterManager;
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Inisialisasi CharacterManager dan data awal (Minimal 5 Karakter)
        CharacterManager manager = new CharacterManager();

        // 3 Karakter lama
        manager.addCharacter(new Character("Arthur", CharacterType.WARRIOR, 6, 100));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 5, 80));
        manager.addCharacter(new Character("Lancelot", CharacterType.WARRIOR, 4, 120));

        // 2 Karakter baru (Tambahan untuk memenuhi syarat minimal 5 karakter)
        manager.addCharacter(new Character("Shadow", CharacterType.ASSASSIN, 4, 90));
        manager.addCharacter(new Character("Eirwyn", CharacterType.ARCHER, 3, 110));

        // Menjalankan GUI Swing dengan aman di Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow window = new MainWindow(manager);
                window.setVisible(true);
            }
        });
    }
}