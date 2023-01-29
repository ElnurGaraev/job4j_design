package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswer;

    public ConsoleChat(String path, String botAnswer) {
        this.path = path;
        this.botAnswer = botAnswer;
    }

    public void run() {
        boolean programOnOff = true;
        boolean botAnswerOnOff = true;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<String> answers = readPhrases();
        List<String> dialog = new ArrayList<>();
        while (programOnOff) {
            System.out.println("Введите команду");
            String str = scanner.nextLine();
            dialog.add(str);
            if (OUT.equals(str)) {
                programOnOff = false;
            }
            if (STOP.equals(str)) {
                botAnswerOnOff = false;
            }
            if (CONTINUE.equals(str)) {
                botAnswerOnOff = true;
                String rand = answers.get(random.nextInt(answers.size()));
                dialog.add(rand);
            }
        }
        saveLog(dialog);
    }

    private List<String> readPhrases() {
        List<String> listAnswer = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswer))) {
            while ((line = br.readLine()) != null) {
                listAnswer.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listAnswer;
    }

    private void saveLog(List<String> log) {
        try (FileWriter wr = new FileWriter(path, Charset.forName("UTF-8"), true)) {
            for (String str : log) {
                wr.write(str + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "C:\\projects\\job4j_design\\data\\dialog.txt";
        String botAnswer = "C:\\projects\\job4j_design\\data\\bot_answers.txt";
        ConsoleChat cc = new ConsoleChat(path, botAnswer);
        cc.run();
    }
}
