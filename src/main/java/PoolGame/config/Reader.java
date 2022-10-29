package PoolGame.config;

import PoolGame.GameManager;

/** Interface for readers for sections of JSON. */
public interface Reader {
    /**
     * Parses the config file.
     * 
     * @param args The path to the JSON file.
     * @param gameManager The game manager.
     */
    public void parse(String args, GameManager gameManager);
}
