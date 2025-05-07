package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(1, "Починить крышу");

        String[] subtasks = {"Гвозди", "Молоток", "Пила"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Выход обновления",
                "Игра Вечность",
                "На следующей неделе"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldResponceSeveral() {
        SimpleTask simpleTask = new SimpleTask(1, "Починить крышу");

        String[] subtasks = {"Игра Вечность", "Молоток", "Пила"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Выход обновления",
                "Игра Вечность",
                "На следующей неделе"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search( "Игра Вечность");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldResponceZero() {
        SimpleTask simpleTask = new SimpleTask(1, "Починить крышу");

        String[] subtasks = {"Игра Вечность", "Молоток", "Пила"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Выход обновления",
                "Игра Вечность",
                "На следующей неделе"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search( "Ффторник");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldResponceOne() {
        SimpleTask simpleTask = new SimpleTask(1, "Починить крышу");

        String[] subtasks = {"Игра Вечность", "Молоток", "Пила"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Выход обновления",
                "Игра Вечность",
                "На следующей неделе"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search( "Починить крышу");
        Assertions.assertArrayEquals(expected, actual);
    }
}