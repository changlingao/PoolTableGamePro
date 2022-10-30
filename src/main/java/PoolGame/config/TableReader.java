package PoolGame.config;

import PoolGame.GameManager;
import PoolGame.objects.Pocket;
import PoolGame.objects.Table;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Readers table section of JSON. */
public class TableReader implements Reader {
    /**
     * Parses the JSON file and builds the table.
     * 
     * @param path        The path to the JSON file.
     * @param gameManager The game manager.
     */
    public void parse(String path, GameManager gameManager) {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(path));

            // convert Object to JSONObject
            JSONObject jsonObject = (JSONObject) object;

            // reading the Table section:
            JSONObject jsonTable = (JSONObject) jsonObject.get("Table");

            // reading a value from the table section
            String tableColour = (String) jsonTable.get("colour");

            // reading a coordinate from the nested section within the table
            // note that the table x and y are of type Long (i.e. they are integers)
            Long tableX = (Long) ((JSONObject) jsonTable.get("size")).get("x");
            Long tableY = (Long) ((JSONObject) jsonTable.get("size")).get("y");

            // getting the friction level.
            // This is a double which should affect the rate at which the balls slow down
            Double tableFriction = (Double) jsonTable.get("friction");

            // Check friction level is between 0 and 1
            if (tableFriction >= 1 || tableFriction <= 0) {
                System.out.println("Friction must be between 0 and 1");
                System.exit(0);
            }

            Table table = new Table(tableColour, tableX, tableY, tableFriction);
            gameManager.setTable(table);

            // parse pockets
            JSONArray jsonPockets = (JSONArray) jsonTable.get("pockets");
            parsePockets(jsonPockets, table);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * parse the "pockets" section in config.json
     *
     * @param jsonPockets JSONArray of "pockets"
     * @param table set pockets in the table
     */
    private void parsePockets(JSONArray jsonPockets, Table table) {
        List<Pocket> pockets = new ArrayList<>();
        // reading from the array:
        for (Object obj : jsonPockets) {
            JSONObject jsonPocket = (JSONObject) obj;
            // parse the params of Pocket
            double x = (double) ((JSONObject) jsonPocket.get("position")).get("x");
            double y = (double) ((JSONObject) jsonPocket.get("position")).get("y");
            double radius = (double) jsonPocket.get("radius");

            Pocket pocket = new Pocket(x, y, radius);

            // Check pocket is within bounds
            if (x > table.getxLength()-10 || x < 10 || y > table.getyLength()-10 || y < 10) {
                System.out.println("Pocket position is outside the table");
                System.exit(0);
            }

            pockets.add(pocket);
        }
        table.setPockets(pockets);
    }
}
