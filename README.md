# Character Manager — TP3 (Java Visual SIH-6406)

Aplikasi **Character Manager** berbasis Java console yang dirancang untuk mengelola atribut karakter game RPG (seperti HP, Mana, Attack Power, dan Level) menggunakan prinsip-prinsip Object-Oriented Programming (OOP) yang kokoh.

## Fitur Utama
- Pengelolaan tipe karakter menggunakan `Enum` (`CharacterType`).
- Enkapsulasi penuh dengan atribut terproteksi (`private`) dan validasi input.
- Kalkulasi otomatis untuk *Hit Points* (HP) dan *Attack Power* berdasarkan level karakter.
- Pengecekan status hidup karakter via `isAlive()`.
- Validasi ketat pada manipulasi status (misal: *Mana* tidak boleh negatif).

## Struktur Project
```text
CharacterManager/
├── src/
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               ├── model/
│               │   ├── Character.java
│               │   └── CharacterType.java
│               └── Main.java
└── README.md