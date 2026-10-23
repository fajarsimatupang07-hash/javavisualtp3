package com.unpri.charactermanager.view;

import com.unpri.charactermanager.manager.CharacterManager;
import com.unpri.charactermanager.model.Character;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {
    private CharacterManager characterManager;
    private JPanel listPanel;
    private JLabel lblAverageLevel;

    public MainWindow(CharacterManager characterManager) {
        super("Character Manager - Sprint #3 (TP8)");
        this.characterManager = characterManager;

        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Judul Atas
        JLabel lblTitle = new JLabel("Daftar Karakter RPG (Dynamic View)", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 15));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(lblTitle, BorderLayout.NORTH);

        // Panel Tengah (Loop Dinamis Karakter)
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JScrollPane scrollPane = new JScrollPane(listPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Panel Bawah (Statistik Rata-rata Level)
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        lblAverageLevel = new JLabel();
        lblAverageLevel.setFont(new Font("Arial", Font.BOLD, 12));
        bottomPanel.add(lblAverageLevel, BorderLayout.WEST);

        add(bottomPanel, BorderLayout.SOUTH);

        // Muat data awal ke UI
        refreshCharacterList();
    }

    // Method untuk menampilkan data secara dinamis via loop (Bagian A poin 3)
    public void refreshCharacterList() {
        listPanel.removeAll();

        List<Character> characters = characterManager.getAllCharacters();

        if (characters.isEmpty()) {
            JLabel emptyLabel = new JLabel("Belum ada karakter yang terdaftar.");
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            listPanel.add(emptyLabel);
        } else {
            for (Character c : characters) {
                JPanel card = new JPanel(new GridLayout(2, 1));
                card.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(5, 5, 5, 5),
                    BorderFactory.createLineBorder(Color.GRAY, 1, true)
                ));
                card.setBackground(new Color(245, 245, 250));
                card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

                JLabel lblInfo = new JLabel("  Nama: " + c.getName() + " | Tipe: " + c.getType() + " | Level: " + c.getLevel());
                lblInfo.setFont(new Font("Arial", Font.BOLD, 12));

                JLabel lblStats = new JLabel("  HP: " + c.getHitPoints() + " | Attack: " + c.getAttackPower() + " | Mana: " + c.getMana());
                lblStats.setFont(new Font("Arial", Font.PLAIN, 11));
                lblStats.setForeground(new Color(100, 100, 100));

                card.add(lblInfo);
                card.add(lblStats);
                listPanel.add(card);
                listPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            }
        }

        updateStatistics();
        listPanel.revalidate();
        listPanel.repaint();
    }

    // Mini-Challenge: Statistik Rata-rata Level (Bagian B poin 2)
    private void updateStatistics() {
        double avgLevel = characterManager.getAverageLevel();
        lblAverageLevel.setText(String.format(" Rata-rata Level Karakter: %.2f (Total: %d Karakter)", 
            avgLevel, characterManager.getAllCharacters().size()));
    }
}