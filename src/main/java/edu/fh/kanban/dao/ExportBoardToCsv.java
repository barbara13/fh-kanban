package edu.fh.kanban.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

import edu.fh.kanban.Kanban;
import edu.fh.kanban.data.Board;
import edu.fh.kanban.data.Card;
import edu.fh.kanban.data.Column;

public class ExportBoardToCsv {

    private XMLBoard xml;
    private ArrayList<Column> listSubColumns = new ArrayList<Column>();
    private ArrayList<Column> listMainColumns = new ArrayList<Column>();
    private ArrayList<Board> listBoard = new ArrayList<Board>();
    private ArrayList<Card> listCards = new ArrayList<Card>();

    public ExportBoardToCsv(String path) {
        xml = new XMLBoard();

        try {
            createCsv(path);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCsv(String filename) throws DocumentException, IOException {
        FileWriter fw = new FileWriter(filename);
        PrintWriter writer = new PrintWriter(fw);

        xml.loadXML(Kanban.xmlPath);
        listBoard = xml.readBoard();
        listMainColumns = xml.readMainColumns();
        listSubColumns = xml.readSubColumns();

        writer.print(listBoard.get(0).getName() + "\n ;");

        int spalten = ((listSubColumns.size() - 2) / 2);
        for (int i = 0; i < spalten; i++) {
            writer.print(listMainColumns.get(i).getName().toString());
            writer.print(";;");
        }
        writer.append("\n");

        for (int i = 0; i < listSubColumns.size(); i++) {
            writer.print(listSubColumns.get(i).getName().toString());
            writer.print(";");
        }
        writer.append("\n");

        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < listSubColumns.size(); i++) {
                listCards = xml.readCardsFromColumn(listSubColumns.get(i).getCo_id());
                if (k < listCards.size()) {
                    writer.print("CardID: " + listCards.get(k).getCa_id() + " Effort: " + listCards.get(k).getEffort() + " Value: " + listCards.get(k).getValue() + " Description: " + listCards.get(k).getDescription() + ";");
                } else {
                    writer.print(";");
                }
            }
            writer.append("\n");
        }

        writer.flush();
        fw.close();
        writer.close();
    }
}
