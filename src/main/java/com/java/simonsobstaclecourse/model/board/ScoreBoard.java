/*
 * ScoreBoard class for SimonsObstacleCourse application.
 * This class represents the scoreboard containing the top 10 players.
 * It provides methods for displaying, loading, saving, and updating the top player list.
 *
 * @author Abhishek Wadmare
 * @author Lakshay Narula
 */
package com.java.simonsobstaclecourse.model.board;

import com.java.simonsobstaclecourse.model.player.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The ScoreBoard class manages the top 10 players' scores in the SimonsObstacleCourse game.
 */
public class ScoreBoard {
    // List to store the top 10 players
    List<Player> top10Players;

    /**
     * Initializing the ScoreBoard by loading the top 10 players from the file.
     */
    public ScoreBoard() {
        top10Players = loadTop10Players();
        displayTop10Players(top10Players);
    }

    /**
     * Displaying the top 10 players and their scores.
     *
     * @param top10Players The list of top 10 players to be displayed.
     */
    public void displayTop10Players(List<Player> top10Players) {
        System.out.println("Top 10 Players:");
        for (Player player : top10Players) {
            System.out.println(player.getName() + " : " + player.getScore());
        }
        System.out.println();
    }

    /**
     * Loading the top 10 players from the "top10players.txt" file.
     *
     * @return The list of top 10 players loaded from the file.
     */
    public List<Player> loadTop10Players() {
        List<Player> top10Players = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("top10players.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0].trim();
                int score = Integer.parseInt(parts[1].trim());
                top10Players.add(new Player(name, score));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Creating a new file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return top10Players;
    }

    /**
     * Gets the list of top 10 players.
     *
     * @return The list of top 10 players.
     */
    public List<Player> getTop10Players() {
        return top10Players;
    }

    /**
     * Adds a new player to the top player list, sorts the list, and saves it to the file.
     *
     * @param newPlayer The new player to be added.
     */
    public void addPlayerToTopList(Player newPlayer) {
        top10Players.add(newPlayer);
        Collections.sort(top10Players, (p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));

        // Keep only the top 10 players
        if (top10Players.size() > 10) {
            top10Players.subList(10, top10Players.size()).clear();
        }
        saveTop10Players(top10Players);
    }

    /**
     * Saves the top 10 players to the "top10players.txt" file.
     *
     * @param top10Players The list of top 10 players to be saved.
     */
    public static void saveTop10Players(List<Player> top10Players) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("top10players.txt"))) {
            for (Player player : top10Players) {
                writer.write(player.getName() + ", " + player.getScore());
                writer.newLine();
            }
            System.out.println("Top 10 players saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
