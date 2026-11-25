# 🐍 Snake Game (Java)

A classic Snake Game developed using **Java Swing** and **AWT**. The player controls a snake that moves around the game board, eats apples, and grows longer. The game ends when the snake collides with itself or hits the wall.

## 📌 Features

- Classic Snake Game gameplay.
- Keyboard-based snake movement.
- Apple generation at random positions.
- Snake grows longer after eating an apple.
- Collision detection with walls and itself.
- Game Over screen.
- Restart the game using the Space key.
- Smooth game updates using Java Swing Timer.

## 🛠️ Technologies Used

- **Java** – Core programming language.
- **Java Swing** – GUI development.
- **Java AWT** – Graphics, colors, images, and keyboard events.
- **Timer** – Controls the game update interval.

## 📂 Project Structure

```text
Snake_Game/
│
└── src/
    └── snake_game/
        │
        ├── Board.java
        ├── SnakeGame.java
        │
        └── icons/
            ├── apple.png
            ├── dot.png
            └── head.png
```

## 🎮 Game Controls

| Key | Action |
|---|---|
| ⬆️ Up Arrow | Move Up |
| ⬇️ Down Arrow | Move Down |
| ⬅️ Left Arrow | Move Left |
| ➡️ Right Arrow | Move Right |
| Space | Restart Game |

## ⚙️ How to Run

### 1. Clone the Repository

```bash
git clone YOUR_REPOSITORY_URL
```

### 2. Open the Project

Open the project in your preferred Java IDE, such as:

- IntelliJ IDEA
- Eclipse
- Visual Studio Code

### 3. Check Resources

Make sure the following image files exist inside the `snake_game/icons/` directory:

- `apple.png`
- `dot.png`
- `head.png`

### 4. Run the Application

Run the `SnakeGame.java` file.

The game window will appear, and you can start playing using the arrow keys.

## 🧠 Concepts Practiced

This project demonstrates practical implementation of:

- Object-Oriented Programming (OOP).
- Java Swing components (`JFrame`, `JPanel`).
- Event Handling using `ActionListener`.
- Keyboard Events using `KeyAdapter`.
- Graphics rendering using `Graphics`.
- Arrays for managing snake body coordinates.
- Random number generation using `Math.random()`.
- Game loops using `javax.swing.Timer`.
- Collision detection.

## 👨‍💻 Author

**Abdur Rafay**

A Java practice project developed to improve programming skills and understand GUI development using Java Swing.

---

⭐ If you like this project, feel free to star the repository!